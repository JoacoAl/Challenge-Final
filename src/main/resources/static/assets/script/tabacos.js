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
<<<<<<< HEAD
const {createApp} = Vue
=======

window.addEventListener("load", function () {
  this.document.getElementById("container-loader").classList.toggle("container-loader2")
})

const { createApp } = Vue
>>>>>>> 0994ecfdc7736a6fdd434df7a46c01b6795ec452

createApp({
  data() {
    return {
        productos: [],

<<<<<<< HEAD
        tabacos: [],

        tabacosFiltrados: [],
        
        filtroTabacos: [],

        checkedCheckbox: [],
        seleccionadas: [],
        tabacosFiltrados: [],

        productoSeleccionado: {},
        cantidadProductosCarrito: this.getCantidadProductosCarrito(),
        cantidadEscogida: 1,
        descripcionMaxLength : 50,
        descripcionCompleta: false
    };
  },
  created(){
     this.traerProductosTabacos();
     this.seleccionadas = JSON.parse(localStorage.getItem("seleccionadas")) ?? [];
=======
      tabacos: [],
      accesorios: [],
      cultivo: [],

      tabacosFiltrados: [],
      cultivoFiltrado: [],
      accesoriosFiltrados: [],

      filtroTabacos: [],
      filtroCultivo: [],
      filtroAccesorios: [],

      checkedCheckbox: [],
      seleccionadas: [],
      tabacosFiltrados: [],
      categoriasCultivo: [],
      categoriasAccesorios: [],

      productoSeleccionado: {},
      logged: false,
      cliente: []
    };
  },
  created() {
    axios.get("/api/cliente/actual")
      .then(response => {
        this.logged = true;
        this.cliente = response.data

      })
      .catch(err => console.log(err))
    this.traerProductosTabacos();
    this.traerProductosCultivo();
    this.traerProductosAccesorios();
    this.seleccionadas = JSON.parse(localStorage.getItem("seleccionadas")) ?? [];
    this.traerProductosTabacos();
>>>>>>> 0994ecfdc7736a6fdd434df7a46c01b6795ec452
  },

  methods: {
<<<<<<< HEAD
    traerProductosTabacos(){
      axios
      .get('/api/productos')
      .then(response =>{
        this.productos = response.data.filter(productos => productos.activo == true)
=======
    logout() {
      axios.post("/api/logout")
        .then(response => {

          window.location.href = "/index.html";
        })
    },
    traerProductosTabacos() {
      axios
        .get('/api/productos')
        .then(response => {
          this.productos = response.data.filter(productos => productos.activo == true)
>>>>>>> 0994ecfdc7736a6fdd434df7a46c01b6795ec452

        this.format = new Intl.NumberFormat('en-US', {
          style: 'currency',
          currency: 'USD',
      });

        //TABACOS
        this.tabacos = this.productos.filter(producto => producto.categoria == "TABACO");
        let marcas = this.tabacos.map( tabaco => tabaco.marca)
            const categorias = [...new Set(marcas)]
            this.tabacosFiltrados = categorias
            console.log(this.tabacos);
      })
      .catch(exception => {
        console.log(exception);
      })
    },

<<<<<<< HEAD
=======
    traerProductosCultivo() {
      axios
        .get('/api/productos')
        .then(response => {
          this.productos = response.data

          this.format = new Intl.NumberFormat('en-US', {
            style: 'currency',
            currency: 'USD',
          });
          //CULTIVO
          this.cultivo = this.productos.filter(producto => producto.categoria == "CULTIVO")
          console.log(this.cultivo);
          let categoriasDeCultivo = this.cultivo.map(el => el.subCategoria)
          const catCultivos = [...new Set(categoriasDeCultivo)]
          this.categoriasCultivo = catCultivos;
          console.log(this.categoriasCultivo)
        })
        .catch(exception => {
          console.log(exception);
        })
    },

    traerProductosAccesorios() {
      axios
        .get('/api/productos')
        .then(response => {
          this.productos = response.data

          this.format = new Intl.NumberFormat('en-US', {
            style: 'currency',
            currency: 'USD',
          });
          //ACCESORIOS
          this.accesorios = this.productos.filter(producto => producto.categoria == "ACCESORIOS")
          console.log(this.accesorios);
          let categoriasDeAccesorios = this.accesorios.map(el => el.subCategoria)
          const catAccesorios = [...new Set(categoriasDeAccesorios)]
          this.categoriasAccesorios = catAccesorios;
          console.log(this.categoriasAccesorios)
        })
        .catch(exception => {
          console.log(exception);
        })
    },
    // localstorage
>>>>>>> 0994ecfdc7736a6fdd434df7a46c01b6795ec452
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
<<<<<<< HEAD
    toggleDescripcion() {
      if (this.descripcionMaxLength === 50) {
        this.descripcionMaxLength = this.productoSeleccionado.descripcion.length;
=======

  },
  computed: {
    filtroBusquedaCultivo() {
      if (this.checkedCheckbox.length != 0) {
        this.filtroCultivo = this.cultivo.filter(producto => this.checkedCheckbox.includes(producto.subCategoria))
        console.log(this.filtroCultivo)
>>>>>>> 0994ecfdc7736a6fdd434df7a46c01b6795ec452
      } else {
        this.descripcionMaxLength = 50;
      }
    },
<<<<<<< HEAD
    toggleDescripcionCompleta() {
      this.descripcionCompleta = !this.descripcionCompleta;
    },
    
  },
  computed: {

=======
>>>>>>> 0994ecfdc7736a6fdd434df7a46c01b6795ec452
    filtroBusquedaTabacos() {
      if (this.checkedCheckbox.length != 0) {
        this.filtroTabacos = this.tabacos.filter(tabaco => this.checkedCheckbox.includes(tabaco.marca));
        console.log(this.filtroTabacos)
      } else {
        this.filtroTabacos = this.tabacos;
      }
    },
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