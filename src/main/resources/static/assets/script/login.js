const {createApp} = Vue

createApp({
    data(){
        return{
            registro: false,
            email: "",
            contraseña: "",
            nombre: "",
            apellido: "",
            telefono: "",
            direccion: "",
        }
    },
    computed(){

    },
    methods: {
        ingreso() { 
            axios.post('/api/login','email=' + this.email + '&contraseña=' + this.contraseña ,{headers:{'content-type':'application/x-www-form-urlencoded'}})
                .then(response => {
                  console.log(response);
                  Swal.fire(
                    'Login exitoso!',
                    'Ahora podés realizar compras.',
                    'success'
                  ).then(() => {
                    window.location.href = "/assets/tabacos.html";
                  });
                })
                .catch(error => {
                    console.log(error.response);
                    Swal.fire(
                    'Login falló, intente nuevamente!',
                    error.response.data,
                    'error'
                  );
                  this.email = "";
                  this.password = "";
                });
        },
        mostrarRegistro(){
            this.registro = true
        },
        mostrarLogin(){
            this.registro = false
        }
        

    }
}).mount("#app")