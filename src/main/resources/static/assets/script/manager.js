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
            this.precio = document.querySelector('#precio').value;

            this.precio = this.precio.replace(/[^0-9]/g, '');

            this.precio = parseInt(this.precio);

            const formDatas = new URLSearchParams();
            formDatas.append('nombre', this.nombre);  
            formDatas.append('descripcion', this.descripcion); 
            formDatas.append('precio', this.precio);  
            formDatas.append('categoria', this.categoria); 
            formDatas.append('stock', this.stock);  
            formDatas.append('file', this.file);  
            axios.post('/api/clients/current/cards', formDatas, {
              headers: {
                'Content-Type': 'application/x-www-form-urlencoded'
              }
            })
            .then(res =>{

            })
            .catch(error => {

            });
        }
    },
    computed:{

    },
})
app.mount("#app")

