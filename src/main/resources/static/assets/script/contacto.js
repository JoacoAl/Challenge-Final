const {createApp} = Vue;

const app = createApp({
    data(){
        return{
            correoDTO:{
                remitente: "",
                comentario:""
            }
        }
    },
    created(){
 
    },
    methods:{
        crearCorreo(){
            let correoDTO={
                remitente : this.correoDTO.remitente,
                comentario : this.correoDTO.comentario
            }
            axios.post('/api/enviarEmail', correoDTO)
            .then(res=>
                console.log(res),
                alert("Correo enviado correctamente")
                ).catch(err =>
                    console.log(err))
        }
    }
})
app.mount('#app')