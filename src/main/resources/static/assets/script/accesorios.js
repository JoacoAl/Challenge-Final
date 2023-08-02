window.addEventListener("scroll", function() {
    const navbar = document.getElementById("navbar");
    const scrollPosition = window.scrollY;
    const navbarHeight = navbar.offsetHeight;
    const headerHeight = 200; 

    const opacity = Math.min(1, scrollPosition / (headerHeight - navbarHeight));
    if (scrollPosition > headerHeight) {
        navbar.classList.add("top-nav");
        navbar.classList.remove("navbar-interno_home")
      } else {
        navbar.classList.remove("top-nav");
        navbar.classList.add("navbar-interno_home")
      }
    navbar.style.backgroundColor = `rgba(0, 0, 0, ${opacity})`;
  });
  const myModal = document.getElementById('exampleModal');
const myInput = myModal.querySelector('.modal-body input');

myModal.addEventListener('shown.bs.modal', () => {
  myInput.focus();
});
const {createApp} = Vue

createApp({
  data() {
    return {
        productos: [],
        accesorios: [],

        accesoriosFiltrados: [],
        
        filtroAccesorios: [],

        checkedCheckbox: [],

        seleccionadas: [],

        categoriasAccesorios: [],

        productoSeleccionado: {},

        cantidadProductosCarrito: this.getCantidadProductosCarrito(),
        cantidadEscogida: 1,
        descripcionMaxLength : 50,
        descripcionCompleta: false
      
    };
  },
  created(){
     this.traerProductosAccesorios();
     this.seleccionadas = JSON.parse(localStorage.getItem("seleccionadas")) ?? [];
  },
  methods: {
    traerProductosAccesorios(){
      axios
      .get('/api/productos')
      .then(response =>{
        this.productos = response.data.filter(productos => productos.activo == true)

        this.format = new Intl.NumberFormat('en-US', {
          style: 'currency',
          currency: 'USD',
      });

        //ACCESORIOS
        this.accesorios = this.productos.filter(producto => producto.categoria == "ACCESORIOS");
        let marcas = this.accesorios.map( accesorio => accesorio.subCategoria)
            const categorias = [...new Set(marcas)]
            this.accesoriosFiltrados = categorias
            console.log(this.accesorios);
            console.log(this.accesoriosFiltrados);
      })
      .catch(exception => {
        console.log(exception);
      })
    },

    toggleSeleccion(id) {
      console.log(this.productos);
      const producto = this.productos.find((e) => e.id == id);
      swal({
        title: "Agregar al carrito",
        text: `Ingrese la cantidad que desea agregar (Stock disponible: ${producto.cantidad})`,
        content: {
          element: "input",
          attributes: {
            type: "number",
            min: 1,
            max: producto.cantidad,
          },
        },
        buttons: {
          cancel: true,
          confirm: "Agregar",
        },
      }).then((value) => {
        if (value) {
          const cantidad = parseInt(value);
          if (cantidad > 0 && cantidad <= producto.cantidad) {
            const item = this.seleccionadas.find((e) => e.id == id);
            if (item) {
              item.cantidad += cantidad;
            } else {
              this.seleccionadas.push({
                ...producto,
                cantidad,
              });
            }
            this.cantidadProductosCarrito += cantidad;
            const jsonProductos = JSON.stringify(this.cantidadProductosCarrito)
            localStorage.setItem("cantidadProductosCarrito", jsonProductos);

            const json = JSON.stringify(this.seleccionadas);
            localStorage.setItem("seleccionadas", json);
            swal("Success", "Producto agregado al carrito", "success");
          } else {
            swal("Error", "Cantidad inválida", "error");
          }
        }
      });
    },
    comprarEnElModal(id) {
      const producto = this.productos.find((e) => e.id == id);
      const cantidad = parseInt(this.cantidadEscogida);

      if (cantidad > 0 && cantidad <= producto.cantidad) {
        const item = this.seleccionadas.find((e) => e.id == id);
        if (item) {
          item.cantidad += cantidad;
        } else {
          this.seleccionadas.push({
            ...producto,
            cantidad,
          });
        }

        this.cantidadProductosCarrito += cantidad;
        const jsonProductos = JSON.stringify(this.cantidadProductosCarrito);
        localStorage.setItem("cantidadProductosCarrito", jsonProductos);

        const json = JSON.stringify(this.seleccionadas);
        localStorage.setItem("seleccionadas", json);

        swal("Success", "Producto agregado al carrito", "success");
      } else {
        swal("Error", "Cantidad inválida", "error");
      }
    },
    // Verificar si hay productos en el carrito
    getCantidadProductosCarrito() {
      const storedCantidadProductosCarrito = localStorage.getItem("cantidadProductosCarrito");
      if (storedCantidadProductosCarrito) {
        return parseInt(storedCantidadProductosCarrito);
      }
      return 0; // Valor predeterminado si no se encuentra en el LocalStorage
    },
    mostrarModal(producto) {
      if (producto) {
        this.productoSeleccionado = producto;
      }
    },
    toggleDescripcion() {
      if (this.descripcionMaxLength === 50) {
        this.descripcionMaxLength = this.productoSeleccionado.descripcion.length;
      } else {
        this.descripcionMaxLength = 50;
      }
    },
    toggleDescripcionCompleta() {
      this.descripcionCompleta = !this.descripcionCompleta;
    },
  },
  computed: {
    filtroBusquedaAccesorios() {
      if (this.checkedCheckbox.length != 0) {
        this.filtroAccesorios = this.accesorios.filter(accesorio => this.checkedCheckbox.includes(accesorio.subCategoria));
        console.log(this.filtroAccesorios)
      } else {
        this.filtroAccesorios = this.accesorios;
      }
    },
    descripcionReducida() {
      if (this.productoSeleccionado && this.productoSeleccionado.descripcion) {
        if (this.descripcionCompleta) {
          return this.productoSeleccionado.descripcion;
        } else {
          if (this.productoSeleccionado.descripcion.length > this.descripcionMaxLength) {
            let producto = this.productoSeleccionado.descripcion.slice(0, this.descripcionMaxLength) + "...";
            return producto;
          } else {
            return this.productoSeleccionado.descripcion;
          }
        }
      }
      return '';
    },
}
}).mount("#app")