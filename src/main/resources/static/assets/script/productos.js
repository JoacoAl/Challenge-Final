window.addEventListener("scroll", function() {
    const navbar = document.getElementById("navbar");
    const scrollPosition = window.scrollY;
    const navbarHeight = navbar.offsetHeight;
    const headerHeight = 300; 

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

const {createApp} = Vue;

const app = createApp({
  data() {
    return {
      productos: [],
      seleccionadas: [],
    };
  },
  created(){
    this.getProductos()
  },
  methods: {
    // metodo para traer todo los productos
    getProductos(){
      axios.get("/api/productos")
      .then(res => {
          this.productos = res.data
          console.log(this.productos)
      })
      .catch(error => {
          alert("no se agrego")
      });
  },

  toggleSeleccion(id) {
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
          const json = JSON.stringify(this.seleccionadas);
          localStorage.setItem("seleccionadas", json);
          swal("Success", "Producto agregado al carrito", "success");
        } else {
          swal("Error", "Cantidad inválida", "error");
        }
      }
    });
  },
  
  },
})

app.mount("#app")





