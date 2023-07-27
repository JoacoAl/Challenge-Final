const {createApp} = Vue;

const app = createApp({
    data(){
        return{
            nombre:"",
            descripcion: "",
            precio:"",
            categoria: "",
            stock: null,
            file: "",
        }
    },
    created(){

    },
    mounted() {
        new Cleave('#amount', {
          numeral: true,
          numeralThousandsGroupStyle: 'thousand',
          prefix: '$'
        });
      },
    methods:{
        createdProduct(){

        }
    },
    computed:{

    },
})
app.mount("#app")

// this.precio = document.querySelector('#precio').value;

// // Elimina los caracteres no numéricos
// this.precio = this.precio.replace(/[^0-9]/g, '');

// // Convierte la cadena a un número
// this.precio = parseInt(this.precio);