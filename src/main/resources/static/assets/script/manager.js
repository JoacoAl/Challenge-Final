
const {createApp} = Vue;

const app = createApp({
    data(){
        return{
            nombre:"",
            descripcion: "",
            precio:"",
            categoria: "",
            cantidad: null,
            productos: [],
            clientes: [],
            // formulario
            nombreCliente: "",
            apellido: "",
            email: "",
            telefono: "",
            edad: null,
            contraseña: "",
            direccion: "",
            searchInput: "",
        }
    },
    created(){
        this.getProductos()
        this.getClientes()
    },
    computed:{
        filtrarPorTitulo() {
            this.productosFiltrados = this.productos.filter((e) =>
              e.nombre.toLowerCase().includes(this.searchInput.toLowerCase())
            );
          },
    },
    methods:{
        filtrarPorTitulo() {
        return this.productos.filter((e) =>
          e.nombre.toLowerCase().includes(this.searchInput.toLowerCase())
        );
      },
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
        createdProduct() {
            const fileInput = document.querySelector('input[type="file"]');
            const file = fileInput.files[0];
            const formData = new FormData();
            formData.append('file', file);
            formData.append('UPLOADCARE_PUB_KEY', 'fddd46a83c06481cde62');
            formData.append('UPLOADCARE_STORE', '1');

            axios({
                url: 'https://upload.uploadcare.com/base/',
                method: 'POST',
                headers: {
                    'Content-Type': 'multipart/form-data'
                },
                data: formData
            })
            .then(res => {
                // The UUID of the uploaded file is in res.data.file
                // You can use this UUID to construct the file URL
                const fileUUID = res.data.file;
                const fileURL = `https://ucarecdn.com/${fileUUID}/`;

                // Save the file URL to your database
                const data = {
                    nombre: this.nombre,
                    descripcion: this.descripcion,
                    precio: this.precio,
                    categoria: this.categoria,
                    cantidad: this.cantidad,
                    img: fileURL
                };

                axios.post('/api/productos/agregar', data, {
                    headers: {
                        'Content-Type': 'application/json'
                    }
                })
                .then(res => {
                    alert("se agrego")
                })
                .catch(error => {
                    alert("no se agrego")
                });
            })
            .catch(err => {
                console.error(err);
            });
        }

        ,
        deleteProduct(id){
            axios.delete(`api/borrar/${id}`)
            .then(res=> {
                alert("se borro")
            })
            .catch(error => {
                alert("no se borro")
            });
        },

        getClientes(){
            axios.get("http://localhost:8080/api/clientes")
            .then(res=>{
                this.clientes = res.data
                console.log(this.clientes)
            })
            .catch(error => {
                alert("no se borro")
            });
        },
        register(){
            const data = {
                nombre: this.nombreCliente,
                apellido: this.apellido,
                email: this.email,
                direccion: this.direccion ,
                contraseña: this.contraseña,
                telefono: this.telefono,
                edad: this.edad,

            };
            axios.post("http://localhost:8080/api/clientes", data,{
                headers: {
                    'Content-Type': 'application/json'
                }
            })
            .then(res=>{
                window.location.href = "/assets/pages/manager.html"
            })
            .catch(err => alert(err))
        },

    },
})
app.mount("#app")
