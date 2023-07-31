window.addEventListener("scroll", function() {
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

const {createApp} = Vue

createApp({
  data() {
    return {
        productos: [],
        tabacos: [],
        accesorios: [],
        cultivo: [],
        tabacosFiltrados: [],
        cultivoFiltrado: [],
        filtroTabacos: [],
        filtroCultivo: [],
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

        this.format = new Intl.NumberFormat('en-US', {
          style: 'currency',
          currency: 'USD',
      });

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
        this.accesorios = this.productos.filter(producto => producto.categoria == "ACCESORIOS")
        console.log(this.accesorios);
      })
      .catch(exception => {
        console.log(exception);
      })
    }
  },
  computed: {
    filtroBusqueda (){
        if(this.checkedCheckbox.length != 0){
          this.filtroCultivo = this.cultivo.filter( producto => this.checkedCheckbox.includes(producto.subCategoria) || this.checkedCheckbox.length == 0)
          this.filtroTabacos = this.tabacos.filter(tabaco => this.checkedCheckbox.includes(tabaco.marca) || this.checkedCheckbox.length == 0)
        }else{
          this.filtroCultivo = this.cultivo;
          this.filtroTabacos = this.tabacos;
          this.traerProductos();
        }
        
    },
    
}
}).mount("#app")





