window.addEventListener("scroll", function () {
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
const { createApp } = Vue;

const app = createApp({
    data() {
        return {
            correoDTO: {
                remitente: "",
                comentario: "",
                asunto: ""
            },
            error1: "",
            logged: false,
        }
    },
    created() {
        axios.get("/api/cliente/actual")
            .then(response => {
                this.logged = true;
                this.cliente = response.data

            })
            .catch(err => console.log(err))

    },
    methods: {
        crearCorreo() {
            if (this.correoDTO.remitente.length === 0 || this.correoDTO.comentario.length === 0 || this.correoDTO.asunto.length === 0) {
                Swal.fire({
                    icon: 'error',
                    title: 'Por favor ingrese los datos faltantes!'
                });
            }
            else {
                let correoDTO = {
                    remitente: this.correoDTO.remitente,
                    comentario: this.correoDTO.comentario,
                    asunto: this.correoDTO.asunto
                }
                axios.post('/api/enviarEmail', correoDTO)
                    .then(res =>
                        console.log(res),
                        Swal.fire({
                            icon: 'success',
                            title: 'El correo se envio exitosamente',
                            timer: 3000
                        }),
                        setTimeout(() => {
                            location.reload()
                        }, 3500)
                    ).catch(error => {
                        console.log(error);
                    })
            }
        }
    }
})
app.mount('#app')