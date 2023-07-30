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