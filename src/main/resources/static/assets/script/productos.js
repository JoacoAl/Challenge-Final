window.addEventListener("scroll", function() {
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

const {createApp} = Vue

createApp({
  data() {
    return {
        productos: [],
        tabacos: [],
        accesorios: [],
        cultivo: [],
        tabacosFiltrados: [],
        categoriasCultivo: [],
        checkedCheckbox: []
    };
  },
  created(){
    this.traerProductos();
  },
  methods: {
    traerProductos(){
      axios
      .get('/api/productos')
      .then(response =>{
        this.productos = response.data

        //TABACOS
        this.tabacos = this.productos.filter(producto => producto.categoria == "TABACO");
        console.log(this.tabacos);
        let marcas = this.tabacos.map( tabaco => tabaco.marca)
            const categorias = [...new Set(marcas)]
            this.tabacosFiltrados = categorias

        //CULTIVO
        this.cultivo = this.productos.filter(producto => producto.categoria == "CULTIVO")
        console.log(this.cultivo);
        let categoriasDeCultivo = this.cultivo.map(el => el.subCategoria)
            const catCultivos = [...new Set(categoriasDeCultivo)]
            this.categoriasCultivo = catCultivos;


        //ACCESORIOS
      })
      .catch(exception => {
        console.log(exception);
      })
    }
  },
  computed: {
    filtroBusqueda (){
        this.cultivo = this.cultivo.filter( producto => this.checkedCheckbox.includes(producto.subCategoria) || this.checkedCheckbox.length == 0)
        
    },
    
}
}).mount("#app")





