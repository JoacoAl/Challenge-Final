const {createApp} = Vue

createApp({
    data(){
        return{
            datos:{
            email: "",
            nombre: "",
            apellido: "",
            telefono: "",
            direccion: "",
        }
        }
    },
    created() {
       
        axios.get('/api/clientes/{id}')
            .then(response => {
                this.datos = response.data;
                console.log(this.datos)
            })
            .catch(error => {
                console.error(error);
            });
    },
    methods: {
        editarPerfil() {
           
            axios.path('/api/cliente/actual/editar', this.datos)
                .then(response => {
                    console.log('Perfil del cliente actualizado:', response.data);
                    alert('¡Perfil actualizado correctamente!');
                })
                .catch(error => {
                    console.error(error);
                    alert('Hubo un error al actualizar el perfil del cliente.');
                });
        },
    },
});