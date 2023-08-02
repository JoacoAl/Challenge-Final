<<<<<<< HEAD
<<<<<<< HEAD
window.addEventListener("scroll", function() {
=======
window.addEventListener("scroll", function () {
>>>>>>> 620eb18e5a0f47f763ee1362ed7c7f3eb920ef97
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

<<<<<<< HEAD
const {createApp} = Vue;
=======
window.addEventListener("load", function () {
  this.document.getElementById("container-loader").classList.toggle("container-loader2")
})
>>>>>>> 0994ecfdc7736a6fdd434df7a46c01b6795ec452
=======
window.addEventListener("load", function () {
  this.document.getElementById("container-loader").classList.toggle("container-loader2")
})




const { createApp } = Vue;
>>>>>>> 620eb18e5a0f47f763ee1362ed7c7f3eb920ef97

const app = createApp({
  data() {
    return {
      seleccionadas: [],
      totalCompra: 0,
      totalProductos: 0,
      logged: false,
      cliente: []
    }
  },
  created() {
    this.format = new Intl.NumberFormat('en-US', {
      style: 'currency',
      currency: 'USD',
    });

<<<<<<< HEAD
<<<<<<< HEAD
      this.seleccionadas = JSON.parse(localStorage.getItem("seleccionadas")) ?? [];
              // Detecta si el usuario ha sido redirigido desde la página de pago
              if (window.location.search.includes('payment_id')) {
                // El usuario ha sido redirigido desde la página de pago
                // Muestra un mensaje de éxito y borra el carrito
                this.generarOrdenPago();
                alert('¡Tu compra ha sido exitosa!');
                this.deleteCompras();
            }
  },
  
    methods:{
      redirectToPayment() {
        const items = this.seleccionadas.map(producto => ({
            title: producto.nombre,
            description: producto.descripcion,
            quantity: producto.cantidad,
            currency_id: 'ARS',
            unit_price: producto.precio
        }));
    
        // Crea la preferencia de pago con los items dinámicos
        fetch('https://api.mercadopago.com/checkout/preferences', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
                'Authorization': 'Bearer TEST-1559251038431848-073110-e6100fab33c28279e8189aa2c02b7bbf-63764321'
            },
            body: JSON.stringify({
                items,
                back_urls: {
                    success: `http://localhost:8080/assets/pages/carrito.html`
                }
            })
=======
=======
>>>>>>> 620eb18e5a0f47f763ee1362ed7c7f3eb920ef97
    this.seleccionadas = JSON.parse(localStorage.getItem("seleccionadas")) ?? [];
    // Detecta si el usuario ha sido redirigido desde la página de pago
    if (window.location.search.includes('payment_id')) {
      // El usuario ha sido redirigido desde la página de pago
      // Muestra un mensaje de éxito y borra el carrito
      this.generarOrdenPago();
      Swal.fire({
        title: '¡Pago exitoso!',
        icon: 'success'
      });
      this.deleteCompras();
    }
  },

  methods: {
    redirectToPayment() {
      const items = this.seleccionadas.map(producto => ({
        title: producto.nombre,
        description: producto.descripcion,
        quantity: producto.cantidad,
        currency_id: 'ARS',
        unit_price: producto.precio
      }));

      // Crea la preferencia de pago con los items dinámicos
      fetch('https://api.mercadopago.com/checkout/preferences', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
          'Authorization': 'Bearer TEST-1559251038431848-073110-e6100fab33c28279e8189aa2c02b7bbf-63764321'
        },
        body: JSON.stringify({
          items,
          back_urls: {
            success: `http://localhost:8080/assets/pages/carrito.html`
          }
<<<<<<< HEAD
>>>>>>> 0994ecfdc7736a6fdd434df7a46c01b6795ec452
=======
>>>>>>> 620eb18e5a0f47f763ee1362ed7c7f3eb920ef97
        })
      })
        .then(response => response.json())
        .then(data => {
<<<<<<< HEAD
<<<<<<< HEAD
            // Aquí puedes obtener el ID y la URL de la preferencia de pago
            const preferenceId = data.id;
            const preferenceUrl = data.init_point;
    
            // Redirige al usuario a la página de pago
            window.location.href = preferenceUrl;
        })
        .then(() => {
            // Aquí puedes llamar al método generarOrdenPago para crear la orden de compra
            
        });
    },
    
=======
=======
>>>>>>> 620eb18e5a0f47f763ee1362ed7c7f3eb920ef97
          // Aquí puedes obtener el ID y la URL de la preferencia de pago
          const preferenceId = data.id;
          const preferenceUrl = data.init_point;

          // Redirige al usuario a la página de pago
          window.location.href = preferenceUrl;
        })
        .then(() => {
          // Aquí puedes llamar al método generarOrdenPago para crear la orden de compra

        });
    },

<<<<<<< HEAD
>>>>>>> 0994ecfdc7736a6fdd434df7a46c01b6795ec452
=======

>>>>>>> 620eb18e5a0f47f763ee1362ed7c7f3eb920ef97
    generarOrdenPago() {
      const items = this.seleccionadas.map(producto => ({
        id: producto.id,
        totalProductos: producto.cantidad,
        total: producto.precio,
        nombre: producto.nombre
      }));
      axios.post('/api/crear/orden', items, {
        headers: {
<<<<<<< HEAD
<<<<<<< HEAD
            'Content-Type': 'application/json'
=======
          'Content-Type': 'application/json'
>>>>>>> 620eb18e5a0f47f763ee1362ed7c7f3eb920ef97
        }
      })
        .then(response => {
          console.log(response)
        })
        .catch(error => {
          console.log(error.response)
<<<<<<< HEAD
=======
          'Content-Type': 'application/json'
        }
      })
        .then(response => {
          console.log(items)
        })
        .catch(error => {
          alert("no")
>>>>>>> 0994ecfdc7736a6fdd434df7a46c01b6795ec452
=======
>>>>>>> 620eb18e5a0f47f763ee1362ed7c7f3eb920ef97
        });
    },

    deleteCompras() {
      localStorage.removeItem("seleccionadas");
      this.seleccionadas = [];
    },
    redirection() {
      return window.location.href = "/assets/pages/accesorios.html"
    },
    redirectionPay() {
      return window.location.href = "/assets/pages/accesorios.html"//especificar ruta de pago
    },
    async descartarProducto(id) {
      const result = await Swal.fire({
        title: '¿Estás seguro de que quieres descartar este producto?',
        icon: 'warning',
        showCancelButton: true,
        confirmButtonText: 'Sí',
        cancelButtonText: 'No'
      });

      if (result.isConfirmed) {
        this.elementos = JSON.parse(localStorage.getItem('seleccionadas'));
        this.elementosFiltrados = this.elementos.filter(elemento => elemento.id !== id);
        this.json = JSON.stringify(this.elementosFiltrados);
        localStorage.setItem('seleccionadas', this.json);

        await Swal.fire({
          title: '¡Producto descartado!',
          icon: 'success'
        });

        window.location.href = "/assets/pages/carrito.html";
      }
    },
  },
  computed: {
    resultado() {
      this.totalCompra = this.seleccionadas.reduce(
        (total, articulo) => total + articulo.precio * articulo.cantidad,
        0
      );
      const json = JSON.stringify(this.totalCompra);
      localStorage.setItem("resultado", json);
    },
    cantidad() {
      this.totalProductos = this.seleccionadas.reduce(
        (total, articulo) => total + articulo.cantidad,
        0
      );
      const json = JSON.stringify(this.totalProductos);
      localStorage.setItem("cantidad", json);
    },
    redirection() {
      return window.location.href = "/assets/pages/accesorios.html"
    },
    redirectionPay() {
      return window.location.href = "/assets/pages/accesorios.html"//especificar ruta de pago
    },
    crearOrden() {
      this.ordenProducto = this.seleccionadas.map(producto => ({
        nombre: producto.nombre,
        cantidadDeProductos: producto.cantidad,
        precioUnitario: producto.precio
      }))
      axios
        .post('/api/ordenes/crear-orden', this.ordenProducto, { headers: { 'content-type': 'application/json' } })
        .then(response => {
          console.log(response.data);
          this.fetch();
        })
        .catch(error => {
          console.log(error.response);
        })
    },
    async descartarProducto(id) {
      const result = await Swal.fire({
        title: '¿Estás seguro de que quieres descartar este producto?',
        icon: 'warning',
        showCancelButton: true,
        confirmButtonText: 'Sí',
        cancelButtonText: 'No'
      });

      if (result.isConfirmed) {
        this.elementos = JSON.parse(localStorage.getItem('seleccionadas'));
        this.elementosFiltrados = this.elementos.filter(elemento => elemento.id !== id);
        this.json = JSON.stringify(this.elementosFiltrados);
        localStorage.setItem('seleccionadas', this.json);

        await Swal.fire({
          title: '¡Producto descartado!',
          icon: 'success'
        });

        window.location.href = "/assets/pages/carrito.html";
      }
    },

    modificarCantidad(id) {
      let producto = this.seleccionadas.filter(producto => {
        producto.id = id
      })

    }
  }
});


app.mount("#app")