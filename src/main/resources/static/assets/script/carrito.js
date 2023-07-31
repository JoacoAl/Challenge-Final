const {createApp} = Vue;

const app = createApp ({
    data(){
        return{
            seleccionadas: [],
            totalCompra: 0,
            totalProductos: 0,
        }
    },
    created(){
      this.seleccionadas = JSON.parse(localStorage.getItem("seleccionadas")) ?? [];
      console.log(this.seleccionadas)
  
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
            'Authorization': 'Bearer APP_USR-3626152189977637-073022-e75fb2a65955a5c01e55f56a337d3081-1436732273'
        },
        body: JSON.stringify({
          items
      })
      
    })
    .then(response => response.json())
    .then(data => {
        // Aquí puedes obtener el ID de la preferencia de pago
        const preferenceId = data.id;
  
        // Inicia el proceso de pago con el ID de la preferencia de pago
        const mp = new MercadoPago('APP_USR-fbe4eb89-8e2f-405f-8c92-cfd93b2a4fc2', {
          locale: 'es-AR'
        });
  
        // Agrega el botón de pago a tu página
        const checkout = mp.checkout({
          preference: {
              id: preferenceId
          },
          render: {
              container: '.mercadopago', // Indica dónde se mostrará el botón de pago
              label: 'Pagar', // Cambia el texto del botón de pago (opcional)
          }
        });
    });
  },
  
    methods:{
        deleteCompras() {
            localStorage.removeItem("seleccionadas");
            this.seleccionadas = [];
          },
          redirection(){
            return window.location.href = "/assets/pages/accesorios.html"
          },
          redirectionPay(){
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
        }
        
    },
    computed:{
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
    },
})
app.mount("#app")

