package com.example.challengefinal.growshop;

import com.example.challengefinal.growshop.Repositorios.*;
import com.example.challengefinal.growshop.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class GrowshopApplication {

    public static void main(String[] args) {
        SpringApplication.run(GrowshopApplication.class, args);
    }

    @Autowired
    PasswordEncoder codificadorDeContraseña;

    @Bean
    public CommandLineRunner initData(ClienteRepositorio clienteRepositorio, ProductoRepositorio productoRepositorio, OrdenRepositorio ordenRepositorio, PagoRepositorio pagoRepositorio, OrdenProductoRepositorio ordenProductoRepositorio) {
        return (args) -> {


            Cliente clientePrueba = new Cliente("Joaquin", "Altamonte", "joaquin.altamonte@gmail.com", codificadorDeContraseña.encode("1234"), "BBB 111", "111111111"  , 18);
            Cliente clientePrueba2 = new Cliente("Eduardo", "Oriolani", "eduoriolani@gmail.com", codificadorDeContraseña.encode("1234"), "BBB 111","22222222222" , 26);
            Cliente clientePrueba3 = new Cliente("Nicolas", "Gonzales", "nicogonzales@gmail.com", codificadorDeContraseña.encode("1234"), "AAA 222", "3333333333333", 19);
            Cliente clienteAdmin = new Cliente("Admin", "Admin", "admin-gozogrowshop@gmail.com", codificadorDeContraseña.encode("1234"), "AAA 222", "44444444444", 19);


            Producto producto1 = new Producto("Encendedor","Bic", "Encendedor de plastico BIC", 250, Categoria.ACCESORIOS,"Encendedores","https://mayoristasoto.com/4503-medium_default/encendedor-bic-maxi-1u.jpg", 40, true ,"ARS");
            Producto producto2 = new Producto("Pica","Lion Rolling Circus", "Picador rolling circus", 330, Categoria.ACCESORIOS,"Picadores","https://yenex.com.ar/wp-content/uploads/2021/12/Picador-metalico-de-3-partes-Amsterdam-LION-ROLLING-CIRCUS.jpg", 6, true ,"ARS");
            Producto producto3 = new Producto("Liyo","OCB", "Liyos de celulosa", 125, Categoria.ACCESORIOS,"Sedas","https://i0.wp.com/cogolloshermanos.com/wp-content/uploads/2021/06/sedas-ocb.jpg?fit=640%2C640&ssl=1", 20, true ,"ARS");

            ////////// TABACOS //////////
            Producto cerritoOriginal = new Producto("Tabaco Cerrito Original 40gr","Cerrito", "Tabaco Cerrito es un blend de diferentes variedades de tabaco virginia. Se caracteriza mayormente por una humedad perfecta para poder manipularlo de manera más sencilla y un sabor y aroma muy equilibrados.", 1250, Categoria.TABACO,"Tabaco","https://parainfernalia.com.ar/wp-content/uploads/2019/04/tabaco-cerrito-original-45gr-growshop.png", 25, true ,"ARS");
            Producto cerritoChocolate = new Producto("Tabaco Cerrito Chocolate 40gr","Cerrito", "Tabaco Cerrito es un blend de diferentes variedades de tabaco virginia. Se caracteriza mayormente por una humedad perfecta para poder manipularlo de manera más sencilla y un sabor y aroma muy equilibrados.", 1250, Categoria.TABACO,"Tabaco","https://d3ugyf2ht6aenh.cloudfront.net/stores/001/554/958/products/cerrito-chocolate1-b42ab29d37b991c65616844242553765-480-0.webp", 12, true  ,"ARS");
            Producto cerritoVainilla = new Producto("Tabaco Cerrito Vainilla 40gr","Cerrito", "Tabaco Cerrito es un blend de diferentes variedades de tabaco virginia. Se caracteriza mayormente por una humedad perfecta para poder manipularlo de manera más sencilla y un sabor y aroma muy equilibrados.", 1250, Categoria.TABACO,"Tabaco","https://parainfernalia.com.ar/wp-content/uploads/2020/02/tabaco-cerrito-vainilla-venta.jpg", 15, true ,"ARS");
            Producto vanHaasenVainilla = new Producto("Tabaco Van Haasen Vainilla 20gr","Van Haasen", "Tabaco Van Häasen original es un blend de variedades virginia. Es un tabaco de intensidad suave, roma y sabor equilibrado y con la humedad perfecta para poder armar cigarrillos.", 1000, Categoria.TABACO,"Tabaco", "https://parainfernalia.com.ar/wp-content/uploads/2021/09/van-haasen-vai-distribuidor-pi-1.jpg", 15, true ,"ARS");
            Producto vanHaasenVirginia = new Producto("Tabaco Van Haasen Virginia 20gr","Van Haasen", "Tabaco Van Häasen original es un blend de variedades virginia. Es un tabaco de intensidad suave, roma y sabor equilibrado y con la humedad perfecta para poder armar cigarrillos.", 1000, Categoria.TABACO,"Tabaco", "https://vanhaasen.info/images/producto/tabaco04.png", 9, true ,"ARS");
            Producto moroMango = new Producto("Tabaco Moro mango x30gr", "Moro", "Tabaco Moro mango para armar cigarrillos saborizados. Los tabacos de Moro se caracterizan por ser frescos y por tener un cuerpo muy agradable a la boca. En este caso la variedad de mango presenta un sabor muy equilibrado que se fusiona a la perfección con el sabor natural del tabaco, además, tiene un aroma dulce.", 1700, Categoria.TABACO,"Tabaco", "https://d3ugyf2ht6aenh.cloudfront.net/stores/001/625/546/products/diseno-sin-titulo-581-4c8d5a1db61cbc353516369890460588-640-0.png", 24, true ,"ARS");
            Producto moroVainilla = new Producto("Tabaco Moro vainilla x30gr", "Moro", "Tabaco Moro mango para armar cigarrillos saborizados. Los tabacos de Moro se caracterizan por ser frescos y por tener un cuerpo muy agradable a la boca. En este caso la variedad de mango presenta un sabor muy equilibrado que se fusiona a la perfección con el sabor natural del tabaco, además, tiene un aroma dulce.", 1700, Categoria.TABACO,"Tabaco", "https://d22fxaf9t8d39k.cloudfront.net/3e0cd51fe809e0deae557fbf9d863414c6145e859983c6f1bc65bcf0cd575f39117579.png", 15, true ,"ARS");
            Producto moroGreen = new Producto("Tabaco Moro Green Virginia x 30gr", "Moro", "Tabaco Moro mango para armar cigarrillos saborizados. Los tabacos de Moro se caracterizan por ser frescos y por tener un cuerpo muy agradable a la boca. En este caso la variedad de mango presenta un sabor muy equilibrado que se fusiona a la perfección con el sabor natural del tabaco, además, tiene un aroma dulce.", 1700, Categoria.TABACO,"Tabaco", "https://bybimportados.com.ar/wp-content/uploads/2019/11/moro-virginia.png", 21,  true ,"ARS");
            Producto lasHojas = new Producto("Tabaco Las Hojas x50gr", "Las Hojas", "Tabaco Las hojas es un tabaco natural de intensidad intermedia ideal para quienes gustan del clásico tabaco rubio. Todas las variedades de Las Hojas están hechas con la máxima calidad en la selección del tabaco, por eso es uno de los mejores del mercado. En este caso, su paquete por 50gr. Permita que puedas disfrutar por mucho más tiempo de su sabor.", 700, Categoria.TABACO,"Tabaco","https://parainfernalia.com.ar/wp-content/uploads/2017/04/TABACO-LAS-HOJAS-30gr-PI-ARGENTINA.png", 10, true ,"ARS");
            Producto lasHojasNatural = new Producto("Tabaco Las Hojas Natural x30gr", "Las Hojas", "Tabaco Las hojas Natural es un tabaco producido sin utilizar ningún tipo de químico o aditivo durante su proceso. Con una intensidad intermedia, esta variedad de tabaco Las Hojas es de un sabor muy agradable para quienes prefieren cigarrillos más suaves, además está empacado especialmente para que mantenga la frescura y humedad necesaria.", 1300, Categoria.TABACO,"Tabaco","https://parainfernalia.com.ar/wp-content/uploads/2017/04/TABACO-LAS-HOJAS-30gr-PI-ARGENTINA.png", 5, true ,"ARS");
            Producto lasHojasUva = new Producto("Tabaco Las Hojas Uva x30gr", "Las Hojas", "Tabaco Las hojas de uva es un tabaco con un sabor y aroma fresco a uva muy recomendado para quienes gustan de tabacos suaves. Esta variedad de tabaco Las Hojas, al igual que todas las demás, es totalmente natural ya que no se utiliza ningún tipo de químico ni aditivo durante su proceso, eso hace que el sabor al tabaco natural se sienta mucho más y se combine a la perfección con la uva.", 1300, Categoria.TABACO,"Tabaco", "https://i0.wp.com/tabaqueriahorus.com/wp-content/uploads/2021/02/HOJAS-UVA.png?fit=600%2C600&ssl=1", 12, true ,"ARS");

            productoRepositorio.save(cerritoOriginal);
            productoRepositorio.save(cerritoVainilla);
            productoRepositorio.save(cerritoChocolate);
            productoRepositorio.save(vanHaasenVainilla);
            productoRepositorio.save(vanHaasenVirginia);
            productoRepositorio.save(moroMango);
            productoRepositorio.save(moroVainilla);
            productoRepositorio.save(moroGreen);
            productoRepositorio.save(lasHojas);
            productoRepositorio.save(lasHojasNatural);
            productoRepositorio.save(lasHojasUva);

            ////////// CULTIVO //////////
            //Carpas//
            Producto carpaCultivArg = new Producto("Carpa Eco 60x60x160", "CultivArg", "Modelo: ECO 60x60x160\n" +
                    "\n" +
                    "El clásico indoor. El más requerido de nuestros modelos. Ideal tanto para cultivadores expertos como novatos. Medida discreta pero rendidora.\n" +
                    "\n" +
                    "Ancho 60 cm\n" +
                    "Profundidad 60 cm\n" +
                    "Altura 160 cm\n" +
                    "Superficie utilizable 80 cm2\n" +
                    "Tamaño: 80 x 80 x 180 cm\n" +
                    "Mylar 480D 98% Reflex\n" +
                    "Estructura de la carpa: Tubos de metal de 17 mm", 45000, Categoria.CULTIVO,"Carpas","https://http2.mlstatic.com/D_NQ_NP_891863-MLA46478777620_062021-O.webp", 3, true ,"ARS");
            Producto premiumCultivArg = new Producto("Carpa Eco 80x80x180", "CultivArg", "Modelo: ECO 80x80x180\n" +
                    "\n" +
                    "El clásico indoor. El más requerido de nuestros modelos. Ideal tanto para cultivadores expertos como novatos. Medida discreta pero rendidora.\n" +
                    "\n" +
                    "Ancho 80 cm\n" +
                    "Profundidad 80 cm\n" +
                    "Altura 180 cm\n" +
                    "Superficie utilizable 80 cm2\n" +
                    "Tamaño: 80 x 80 x 180 cm\n" +
                    "Mylar 480D 98% Reflex\n" +
                    "Estructura de la carpa: Tubos de metal de 17 mm", 71000, Categoria.CULTIVO,"Carpas","https://http2.mlstatic.com/D_NQ_NP_843282-MLA44395719319_122020-O.webp", 2, true ,"ARS");
            Producto highPro1 = new Producto("Carpa Pro Box 80x80x160", "Garden Highpro","Indoor de excelente calidad, ideal para cultivo en espacios amplios y para una producción individual de gran rendimiento.\n" +
                    "\n" +
                    "Dimensiones: 80 x 80 x 160 cm.\n" +
                    "\n" +
                    "Material interior: película reflectante mylar de primera calidad.\n" +
                    "\n" +
                    "Material exterior: lona negra impermeable con mayor densidad de tela\n" +
                    "\n" +
                    "Conductos de aire de doble capa: Obtenga aire dentro y fuera de su carpa sin que se filtre la luz gracias a la capa adicional que se agrega a todos los puertos de conductos de aire.\n" +
                    "\n" +
                    "El revestimiento impermeable y la barrera de luz en la cremallera contienen tanto luz como derrames.\n" +
                    "\n" +
                    "Los tiradores de cremallera son de metal\n" +
                    "\n" +
                    "Escape: 2 de 13.5 cm. Uno lateral inferior y el otro en la parte superior (techo) para escape de aire fácil y estable (el puerto se ajusta para adaptarse a conductos y equipos de menor diámetro)\n" +
                    "\n" +
                    "Ventana rejilla trasera inferior de 25 x 12.5 cm", 66500, Categoria.CULTIVO,"Carpas", "https://http2.mlstatic.com/D_NQ_NP_903434-MLA70421174515_072023-O.webp", 1, true ,"ARS");
            Producto highPro2 = new Producto("Carpa Pro Box 120x120x200", "Garden Highpro","Carpa 120x120\n" +
                    "\n" +
                    "*Características:\n" +
                    "120 x 120 x 200 cm\n" +
                    "Tejido fuerte y resistente Nylon 420D\n" +
                    "Estructura\n" +
                    "patentada, fuerte y estable Reflectividad mylar premium 97%\n" +
                    "\n" +
                    "Especificaciones técnicas:\n" +
                    "• Carpa Probox suiza 120 x 120 x 200 cm.\n" +
                    "• Posee mylar 420D, 100% aprueba de luz.\n" +
                    "• Doble cierre reforzado.\n" +
                    "• Estructura sólida, varillas y base doble.\n" +
                    "• Tubos de refrigeración incorporados.\n" +
                    "• Caja cerrada." ,86000, Categoria.CULTIVO,"Carpas","https://http2.mlstatic.com/D_NQ_NP_903434-MLA70421174515_072023-O.webp", 2, true  ,"ARS");
            Producto vidaCultiva1 = new Producto("Carpa Vida Cultiva 80x80x160", "Vida Cultiva", "DESCRIPCIÓN DEL PRODUCTO\n" +
                    "\n" +
                    "- Bloqueo total de filtracion de luz, incluye tres capas de tela que bloquean casi al 100% la filtracion de luz para que sus plantas puedan aprovechar el maximo de luz.\n" +
                    "Ademas, la tela mylar reflactaria con forma diamantada refleja al 98% la luz del interior.\n" +
                    "\n" +
                    "- Tela exterior Oxford 600D extra gruesa a prueba de rasgaduras, ademas cuenta con doble cierre y costura reforzada.\n" +
                    "\n" +
                    "- Esquineros de plastico resforzado con estructura metalica extra rigida.\n" +
                    "\n" +
                    "- Mangas: cuenta con 5 mangas dobles para ventilacion/cableado, 1 x 8”/ 1 x 4” / 3 x 6”, ademas cuenta con una ventana de ventilacion con mosquitero.\n" +
                    "\n" +
                    "- Bandeja impermeable removible para una limpieza mas comoda.\n" +
                    "\n" +
                    "- Super rapida de instalar.\n" +
                    "\n" +
                    "- Capacidad de macetas:\n" +
                    "SUSTRATO: 6 macetas de 11L\n" +
                    "HIDROPONIA: 2 baldes de 25L", 57500, Categoria.CULTIVO,"Carpas","https://http2.mlstatic.com/D_NQ_NP_863829-MLA53765721026_022023-O.webp", 1, true ,"ARS");
            Producto vidaCultiva2 = new Producto("Carpa Vida Cultiva 120x120x200", "Vida Cultiva", "DESCRIPCIÓN DEL PRODUCTO\n" +
                    "\n" +
                    "- Bloqueo total de filtración de luz, incluye tres capas de tela que bloquean casi al 100% la filtración de luz para que sus plantas puedan aprovechar el máximo de luz.\n" +
                    "Además, la tela mylar reflactaria con forma diamantada refleja al 98% la luz del interior.\n" +
                    "\n" +
                    "- Tela exterior Oxford 600D extra gruesa a prueba de rasgaduras, además cuenta con doble cierre y costura reforzada.\n" +
                    "\n" +
                    "- Esquineros de plástico reforzado con estructura metálica extra rígida.\n" +
                    "\n" +
                    "- Mangas: cuenta con 7 mangas dobles para ventilación/cableado, 5 x 8”/ 2 x 4” ,además cuenta con 2 ventana de ventilación con mosquitero y 1 ventana grande para ventilar y poder observar.\n" +
                    "\n" +
                    "- Bandeja impermeable removible para una limpieza mas cómoda.\n" +
                    "\n" +
                    "- Super rápida de instalar.\n" +
                    "\n" +
                    "- Capacidad macetas:\n" +
                    "SUSTRATO: 12 macetas de 11L\n" +
                    "HIDROPONIA: 4 baldes de 25L\n" +
                    "\n" +
                    "Incluye:\n" +
                    "- Carpa\n" +
                    "- Caños\n" +
                    "- Esquinero\n" +
                    "- Bandeja Removible\n" +
                    "- Cintas para luces", 78000, Categoria.CULTIVO,"Carpas","https://http2.mlstatic.com/D_NQ_NP_950916-MLA54983861584_042023-O.webp", 1, true ,"ARS");
            //Sustratos//
            Producto growMix80 = new Producto("Sustrato GrowMix 80lt","GrowMix", "ustrato Profesional Grow Mix MULTIPRO Fertilizado x 80lts - Terrafertil\n" +
                    "\n" +
                    "\n" +
                    "#Caracteristicas/Beneficios:\n" +
                    "\n" +
                    ".Sustrato especialmente desarrollado para el cultivo indoor.\n" +
                    ".Sustrato que puede ser utilizado en una amplia gama de cultivos, horticolas, florales, etc\n" +
                    ".Ideal para su uso en semilleros, bandejas decultivo/plugs de siembra\n" +
                    "\n" +
                    "\n" +
                    "#Composición química:\n" +
                    "\n" +
                    "pH:5,0 - 5,8 (corregido)*\n" +
                    "C.E: 0,20 - 0,60 ds/m*\n" +
                    "Humedad: 55 - 65%\n" +
                    "**M.O: 80 - 85%\n" +
                    "**Cenizas: 20 - 15%\n" +
                    "**Valores referidos a materia seca.\n" +
                    "\n" +
                    "\n" +
                    "#Características físicas:\n" +
                    "\n" +
                    "Densidad Sustrato Seca: 140-180 Kg/m3\n" +
                    "Densidad de Partícula: 1600 Kg/m3\n" +
                    "Porosidad total: 80-85%\n" +
                    "Capacidad de retención de agua: 60%\n" +
                    "Porosidad de aire: 20-25%\n" +
                    "Agua fácilmente disponible: 30-35%\n" +
                    "\n" +
                    "\n" +
                    "#Componentes:\n" +
                    "\n" +
                    ". Turba de musgo Sphagnum de fibras medias\n" +
                    ". Compost de corteza\n" +
                    ". Perlita\n" +
                    ". Cal calcita\n" +
                    ". Cal dolomita\n" +
                    ". Agentes humectantes.\n" +
                    "\n" +
                    "(N) 200-270 (P) 15-40 (K) 200-300\n", 6900, Categoria.CULTIVO,"Sustratos","https://http2.mlstatic.com/D_NQ_NP_768961-MLA47845752128_102021-O.webp", 10, true ,"ARS");
            Producto growMix20 = new Producto("Sustrato GrowMix 20lt","GrowMix", "SUSTRATO PROFESIONAL GROW MIXTA DE 20 LITROS TERRAFERTIL\n" +
                    "Composición química:\n" +
                    "pH:5.2 - 5.8 (corregido)*\n" +
                    "C.E: 0,30 - 0,45 ds/m*\n" +
                    "Humedad: 55 - 65%\n" +
                    "**M.O: 85 - 90%\n" +
                    "**Cenizas: 15 - 10%\n" +
                    "**Valores referidos a materia seca.\n" +
                    "Características físicas:\n" +
                    "Densidad Sustrato Seca: 175-200 Kg/m3\n" +
                    "Densidad de Partícula: 1600 Kg/m3\n" +
                    "Porosidad total: 80-85%\n" +
                    "Capacidad de retención de agua: 60%\n" +
                    "Porosidad de aire: 20-25%\n" +
                    "Agua fácilmente disponible: 30-35%\n" +
                    "Componentes:\n" +
                    "Turba de musgo Sphagnum de fibras medias\n" +
                    ".Compost de corteza\n" +
                    ".Perlita\n" +
                    ".Vermiculita\n" +
                    ".Cal calcita\n" +
                    ".Cal dolomita\n" +
                    ".Agentes humectantes\n" +
                    ".Fertilizantes\n" +
                    "(N) 100-200 (P) 80-110 (K) 120-200 (Ca) 75-100 (Mg) 20-45\n" +
                    "Vivero Plantas Al Natural", 2500, Categoria.CULTIVO,"Sustratos","https://http2.mlstatic.com/D_NQ_NP_875199-MLA44685606693_012021-O.webp", 3, true ,"ARS");
            Producto terraFertil = new Producto( "Sustrato Huertas Terrafertil X 50 L", "Terrafertil", "Huertas\n" +
                    "Desarrollo rápido de raíces.\n" +
                    "Sustrato ideal para semillado y transplante de hortalizas\n" +
                    "ComponentesBeneficios:\n" +
                    "Sustrato formulado a partir de compost y turbas seleccionadas para contenedores medianos y grandes.\n" +
                    "\n" +
                    "ComponentesComposición química:\n" +
                    "Cada 100 g. (con su humedad natural)\n" +
                    "Humedad: 40 - 50%\n" +
                    "Ceniza tal cual: 55 - 45%\n" +
                    "pH: 5.5 - 5.8 M.O.: 45 - 55% C/N: 30 - 35 C:E: 0.26 - 0.35 mmhos /cm.\n" +
                    "\n" +
                    "Componentes:\n" +
                    "Turba de Musgo Shagnum de fibras finas y medias, Compost de Poda Urbana, Perlita, Dolomita, Fertilizantes", 4200, Categoria.CULTIVO, "Sustratos","https://http2.mlstatic.com/D_NQ_NP_823510-MLA44135856596_112020-O.webp", 4, true ,"ARS");
            Producto cultivatePremium = new Producto("Sustrato Cultivate Premium 80Lts", "Cultivate", "Composición:\n" +
                    "-Trichodermas y Micorrizas.\n" +
                    "- Humus de lombriz de alta calidad.\n" +
                    "-Mix de turbas sphagnum fueguinas.\n" +
                    "-Compost de hojas.\n" +
                    "-Perlita, y vermiculita.\n" +
                    "\n" +
                    "Favorece los primeros pasos de crecimiento y brinda alimento durante toda esta etapa, ya que, está enriquecido con humus de primera calidad y microorganismos benéficos para el desarrollo de las raíces.\n" +
                    "Contribuye con el buen desarrollo de nuestras plantas.\n" +
                    "Es aireado y tiene una gran capacidad de retención de líquidos.\n" +
                    "Contiene los nutrientes que la planta consumirá en los primeros meses de vida.", 5600, Categoria.CULTIVO, "Sustratos","https://http2.mlstatic.com/D_NQ_NP_774215-MLA51560073338_092022-O.webp", 4, true ,"ARS");
            //Fertilizantes//
            Producto namasteOroNegro = new Producto("Oro Negro Namasté","Namasté", "ORO NEGRO - NAMASTE\n" +
                    "\n" +
                    "500 cc\n" +
                    "\n" +
                    "PRINCIPALES BENEFICIOS:\n" +
                    "\n" +
                    "Estimula el crecimiento vegetal por una producción elevada de biomasa\n" +
                    "Aumenta el rendimiento y mejora la calidad de las plantas\n" +
                    "Estimula la producción de enzimas de las plantas\n" +
                    "Mejora le estructura del suelo y la capacidad de retención de agua\n" +
                    "Aumenta y estimula la actividad microbiológica de los suelos\n" +
                    "Aumenta la capacidad del intercambio catiónico (CIC)\n" +
                    "Mejora la eficacia de los fertilizantes y reduce las pérdidas de nutrientes,\n" +
                    "especialmente la lixiviación de nitrato\n" +
                    "Favorece el crecimiento de las raíces\n" +
                    "Aumenta la permeabilidad de las membranas celulares de las raíces y la absorción de los nutrientes\n" +
                    "Actúa como quelato natural para los micro elementos en suelos alcalinos y aumenta la disponibilidad para las plantas\n" +
                    "Reduce los perjuicios por sequía y estrés causado por la aplicación de pesticidas\n" +
                    "Aumenta la germinación de semillas\n" +
                    "Reduce los residuos de herbicidas y de sustancias tóxicas en el suelo\n" +
                    "\n" +
                    "VENTAJAS:\n" +
                    "Fácil de usar, concentrado, ecológico y económico.\n" +
                    "\n" +
                    "RECOMENDACIONES DE USO:\n" +
                    "Para plantas en Exterior se puede emplear hasta entrada la 2da. semana de la aparición de las primeras flores.\n" +
                    "Se puede aplicar de manera foliar, intercalando con los riegos. No mezclar este producto en el mismo riego con otros productos.", 4250, Categoria.CULTIVO,"Fertilizantes","https://http2.mlstatic.com/D_NQ_NP_808297-MLA70696536868_072023-O.webp", 34, true ,"ARS");
            Producto namasteFloraBooster = new Producto("Flora Booster Namasté","Namasté", "FLORA BOOSTER\n" +
                    "\n" +
                    "Potenciador de producción. Aplicar durante el período de floración completo hasta dos semanas antes de la cosecha. Producto de alta calidad y pureza, elaborado con grandes niveles de Fosforo y Potasio. Asegura el 20% de incremento en engorde de cogollos, generación de resina y producción final de cosecha.\n" +
                    "\n" +
                    "COMPOSICIÓN\n" +
                    "\n" +
                    "-Fósforo: Elemento usado, por la planta, para formar nuevas raíces, frutos y flores. También la vuelve menos propensa a sufrir enfermedades.\n" +
                    "\n" +
                    "-Potasio: Acelera el crecimiento de las plantas. Las beneficia con tallos más fuertes que la vuelve más resistente a enfermedades.\n" +
                    "\n" +
                    "-Ascophylym Nodossum: Alga marina que contiene fosforo, nitrógeno, potasio y minerales como el zinc. Es un potenciador de la hormona de crecimiento de la planta que facilita la absorción de fosforo y potasio.\n" +
                    "\n" +
                    "-Aminoácidos: Es un bio-estimulante natural. Mejora la asimilación de nutrientes y protege a la planta de distintas fuentes de estrés que podrían afectarla.\n" +
                    "\n" +
                    "ANÁLISIS NUTRICIONAL\n" +
                    "FÓSFORO 9%\n" +
                    "POTASIO 18%\n" +
                    "OTROS MICROELEMENTOS 1%\n" +
                    "\n" +
                    "RECOMENDACIONES DE USO\n" +
                    "\n" +
                    "-No mezclar este producto, en el mismo riego, con otros productos.\n" +
                    "-Para plantas de interior usar 1 vez por semana. (4 aplicaciones en toda la floración)\n" +
                    "-La primera aplicación puede ser con rociador. El resto con riego.\n" +
                    "-En plantas de exterior empezar a aplicar desde la aparición de las primeras flores.\n" +
                    "-Para plantas de floración larga, en exterior, se recomienda su uso cada 15 días.\n" +
                    "-Las plantas que se encuentren en macetas deberán lavar las raíces. Realizar el proceso de lavado 2 semanas antes de cosechar, con el triple\n" +
                    "del agua usada habitualmente en el riego.", 4250, Categoria.CULTIVO,"Fertilizantes","https://http2.mlstatic.com/D_NQ_NP_756652-MLA51811963886_102022-O.webp", 21, true ,"ARS");
            Producto namasteTricoMas = new Producto("Trico+ Namasté","Namasté", "*Caraceterísticas:\n" +
                    "NAMASTE TRICO +, es el resultado de la mezcla de varios nutrientes escenciales para la planta, vitales en la etapa de desarrollo y crecimiento de la misma..\n" +
                    "\n" +
                    "TRICO + PROMETE:\n" +
                    "Un Fertilzante que actua como aditivo natural a base de melazas deshidratadas para incrementar la producción de Tricomas, mejorar el aroma de la flor, y aumentar el peso final de la producción.\n" +
                    "\n" +
                    "VENTAJAS:\n" +
                    "Fácil de usar, de fácil aplicación, al ser en polvo se diluye muy fácilmente, es fácil de medir y administrar.\n" +
                    "\n" +
                    "COMPOSICIÓN:\n" +
                    "Melaza de caña \"blackstrap\" deshidratada, extracto de Yucca, Zeolita y Levadura.\n" +
                    "\n" +
                    "TRICO + PROMETE: Acompañar el crecimiento y las primeras etapas de floración de las plantas. Ideal para acompañar dietas orgánicas de Guanos, Humus, y buenos sustratos.\n" +
                    "\n" +
                    "ANALISIS NUTRICIONAL\n" +
                    "- Fósforo 1%\n" +
                    "- Calcio 7%\n" +
                    "- Azucares totales 55%\n" +
                    "- vitaminas B y aminoácidos\n" +
                    "\n" +
                    "MODO DE APLICACION:\n" +
                    "EN RIEGO: Diluir 1 gr por Lt/agua, dejar reposar unas horas y regar lentamente la tierra. Durante toda la floración, 1 aplicación semanal es suficiente. Se puede aplicar de forma Foliar, con un rociador, hasta la cuarta semana de floración. (no superar las 3 aplicaciones foliares) EN TIERRA: Mezclar 1 gr por cada 2/Lt de tierra, al preparar la mezcla para floración.", 3100, Categoria.CULTIVO,"Fertilizantes","https://http2.mlstatic.com/D_NQ_NP_987952-MLA52250769295_112022-O.webp", 40, true ,"ARS");
            Producto namasteDetox = new Producto("Detox 600ml Namaste", "Namasté", "Namaste Detox Lavador de raíces natural\n" +
                    "Quita el excedente de nutrientes en la planta para aumentar calidad y sabor finales de las flores cosechadas.\n" +
                    "En todo medio de cultivo: coco, hidro o sustrato; los fertilizantes tanto orgánicos como minerales dejan algunos restos en suelo y raíces. Es importante que la planta procese todos los nutrientes que ya ha absorbido y aún permanecen en ella.\n" +
                    "\n" +
                    "Limpiar el excedente de nutrientes del suelo y raíces, durante las últimas 2 semanas previas a la cosecha, garantiza flores con aroma y sabor propios de su genética.\n" +
                    "Caso contrario no sentiremos el aroma propio de la flor y sí sabor a los excedentes, no barridos, de productos que hayamos usado para nutrirla previamente.", 3100, Categoria.CULTIVO, "Fertilizantes","https://http2.mlstatic.com/D_NQ_NP_846910-MLA47966602467_102021-O.webp", 9, true ,"ARS");
            Producto topCropVeg = new Producto("Top Veg Top Crop Crecimiento 250 Ml", "Top Crop", "Fertilizante líquido completo rico en ácidos húmicos y fúlvicos así como en macro y micronutrientes solubles en agua.\n" +
                    "Promueve el crecimiento, refuerza las defensas frente a enfermedades y estrés, regula el balance del pH del suelo e incrementa el contenido en clorofila mejorando la eficiencia fotosintética de las plantas\n" +
                    "Mejora la estructura del suelo así como su capacidad de retención de humedad y fertilizantes.\n" +
                    "\n" +
                    "Usos y aplicaciones:\n" +
                    "\n" +
                    "Diluir a razón de 2-4ml por cada litro de agua una vez por semana.", 2000, Categoria.CULTIVO, "Fertilizantes","https://http2.mlstatic.com/D_NQ_NP_620058-MLA50007181073_052022-O.webp", 2, true ,"ARS");
            Producto topCropFlora = new Producto("Top Bloom 250ML Floracion", "Top Crop", "Es un fertilizante de floración rico en fósforo y potasio para desarrollar flores gruesas y compactas, además estimula el comienzo de la floración. Está formulado con ácidos húmicos de elevada actividad natural orgánica. Su rápida absorción lo convierte en ideal por sus resultados casi inmediatos y su alto contenido en nutrientes hace innecesario el aporte adicional de P-K(fósforo y potasio).", 2400, Categoria.CULTIVO, "Fertilizantes","https://http2.mlstatic.com/D_NQ_NP_807007-MLA47805387058_102021-O.webp", 10, true ,"ARS");
            //Macetas//
            Producto happyRoots = new Producto("Maceta Reforzada Geotextil 60 Litros", "Happy Roots","Antidesgarro - Protección UV (Resiste la exposición solar)\n" +
                    "Apto exterior e interior\n" +
                    "Mejor oxigenación para tus raíces\n" +
                    "Autopoda, evita estrangulamientos de las raíces\n" +
                    "\n" +
                    "Ideales para huertas y todo tipo de cultivo\n" +
                    "\n" +
                    "Macetas Reforzadas de 1 a 400 litros\n" +
                    "Jardines verticales\n" +
                    "Huertas Rectangulares y circulares", 1800, Categoria.CULTIVO, "Macetas","https://http2.mlstatic.com/D_NQ_NP_716977-MLA52575590539_112022-O.webp", 5, true ,"ARS");
            Producto happyRoots2 = new Producto("Maceta Reforzada Geotextil 150litros", "Happy Roots", "Antidesgarro - Protección UV (Resiste la exposición solar)\n" +
                    "Apto exterior e interior\n" +
                    "Mejor oxigenación para tus raíces\n" +
                    "Autopoda, evita estrangulamientos de las raíces\n" +
                    "\n" +
                    "Ideales para huertas y todo tipo de cultivo\n" +
                    "\n" +
                    "Macetas Reforzadas de 1 a 400 litros\n" +
                    "Jardines verticales\n" +
                    "Huertas Rectangulares y circulares\n" +
                    "\n" +
                    "Todo tipo de trabajos a medida", 2800, Categoria.CULTIVO, "Macetas","https://http2.mlstatic.com/D_NQ_NP_716977-MLA52575590539_112022-O.webp", 2, true ,"ARS");
            Producto happyRoots3 = new Producto("Maceta Reforzada Tela Geotextil 3Litros", "Happy Roots", "Antidesgarro - Protección UV (Resiste la exposición solar)\n" +
                    "Apto exterior e interior\n" +
                    "Mejor oxigenación para tus raíces\n" +
                    "Autopoda, evita estrangulamientos de las raíces\n" +
                    "\n" +
                    "Ideales para huertas y todo tipo de cultivo\n" +
                    "\n" +
                    "Macetas Reforzadas de 1 a 400 litros\n" +
                    "Jardines verticales\n" +
                    "Huertas Rectangulares y circulares\n" +
                    "\n" +
                    "Todo tipo de trabajos a medida", 600, Categoria.CULTIVO,"Macetas","https://http2.mlstatic.com/D_NQ_NP_700885-MLA45346695549_032021-O.webp", 25,true ,"ARS");
            Producto madRocket = new Producto("Maceta Mad Rocket 5l Autopoda Indoor", "Mad Rocket", "Su diseño único de gran altura nos permite formar una raíz madre fuerte.\n" +
                    "Las ventanas de auto poda radicular aérea hacen que las raíces se dirijan hacia ellas.\n" +
                    "Esto provoca que la punta deje de crecer, para desarrollar brazos y seguir colonizando el sustrato.\n" +
                    "\n" +
                    "Los guiadores de raíces hacen que las MAD ROCKET sean únicas en desarrollo de raíces.\n" +
                    "\n" +
                    "- Diseño exclusivo de gran altura y elevadas del suelo para buena circulación de aire y evitar el calentamiento.\n" +
                    "- Excelente drenaje.\n" +
                    "- Total colonización del pan de raíces.\n" +
                    "- Garantiza mayor producción de una maceta del mismo caudal y acelerar el crecimiento de la misma.\n" +
                    "- Todos los modelos son tanto para indoor como para exterior.", 1200, Categoria.CULTIVO, "Macetas","https://http2.mlstatic.com/D_NQ_NP_634389-MLA51889125435_102022-O.webp", 11, true ,"ARS");
            Producto madRocket2 = new Producto("Maceta Mad Rocket 16 Litros", "Mad Rocket", "Las MAD ROCKET cuentan con guiadores que llevan a las raíces hacia las ventanas de auto-poda radicular aérea que provocan que en la punta de las raíces se genere un callo para hacer que de esta misma raíz nazcan nuevos brazos y así estimular el desarrollo radicular colonizando todo el pan de sustrato.\n" +
                    "La estimulación continua de raíces hace que tengamos una planta grande sana, fuerte y productiva que es lo que buscan nuestros clientes.\n" +
                    "Diseño exclusivo de gran altura y elevadas del suelo para buena circulación de aire y evitar el calentamiento.\n" +
                    "\n" +
                    "- Excelente drenaje.\n" +
                    "- Total colonización del pan de raíces.\n" +
                    "- Garantiza mayor producción de una maceta del mismo caudal y acelerar el crecimiento de la misma.\n" +
                    "- Todos los modelos son tanto para indoor como para exterior.\n" +
                    "- Cuenta con todos los modelos Mad Rocket: 5L, 10L, 16L y 25L.", 2100,Categoria.CULTIVO, "Macetas","https://http2.mlstatic.com/D_NQ_NP_634389-MLA51889125435_102022-O.webp", 19, true ,"ARS" );
            //Herramientas//
            Producto kitJardineria = new Producto("Kit Jardineria 8 Piezas", "Tramontina", "// INCLUYE //\n" +
                    "\n" +
                    "• 1 cuchara ancha\n" +
                    "• 1 rastrillo 3 dientes\n" +
                    "• 1 horquilla 4 dientes\n" +
                    "• 1 cuchara ancha plástica\n" +
                    "• 1 horquilla 3 dientes\n" +
                    "• 1 tijera de podar\n" +
                    "• 1 par de guantes\n" +
                    "• 1 cinturón", 15000, Categoria.CULTIVO, "Herramientas","https://http2.mlstatic.com/D_NQ_NP_736800-MLA49646543972_042022-O.webp", 3, true ,"ARS");
            Producto kitJardineria2 = new Producto("Kit Para Jardin Tramontina","Tramontina","Kit para jardin Tramontina Mango de Madera\n" +
                    "- Pala ancha (ancha Largo 27 cms - Ancho 8,8 cms)\n" +
                    "- Pala angosta (Largo 28,5 cms - Ancho 5,6 cms)\n" +
                    "- Rastrillo 3 dientes (Largo 22 cms - Ancho 7,8 cms)\n" +
                    "\n" +
                    "- Las herramientas son fabricadas en acero carbono especial de alta calidad.\n" +
                    "- Reciben pintura electrostática a polvo, que tiene mejor presentación visual y mayor protección contra la oxidación.\n" +
                    "- Los mangos de estas herramientas, además de tener excelente resistencia, son producidos con madera de origen renovable.",2400,Categoria.CULTIVO,"Herramientas","https://http2.mlstatic.com/D_NQ_NP_856124-MLA47661520259_092021-O.webp",1,true ,"ARS");
            Producto poleas = new Producto("Poleas Panel De Cultivo Indoor 68 Kg.", "Bellavita", "*Características:\n" +
                    "Ideales para colgar reflectores, filtros de carbón y otros accesorios.\n" +
                    "La unidad se compone de un sistema de 2 ganchos unidos por una cuerda trenzada y una polea de seguridad.\n" +
                    "La polea, que está unida a uno de los ganchos, bloquea la cuerda constantemente y solo la deja correr, cuando pulsamos una palanquita.\n" +
                    "De este modo, un gancho permanece fijo en un extremo de la cuerda y el otro gancho junto con la polea, lo puedes deslizar a lo largo de la cuerda dándole la distancia deseada.\n" +
                    "Es muy práctico, rápido y sencillo.\n" +
                    "1 metro de largo y capacidad máxima 68 Kg.", 4100, Categoria.CULTIVO, "Herramientas","https://http2.mlstatic.com/D_NQ_NP_790267-MLA54988105824_052023-O.webp", 14, true ,"ARS");
            Producto poleas1 = new Producto("Poleas Bellavita Plástico Resistente 5 Kgs Indoor","Bellavita","", 2700, Categoria.CULTIVO, "Herramientas","https://http2.mlstatic.com/D_NQ_NP_780200-MLA69443257523_052023-O.webp", 2, true ,"ARS");
            //Insecticidas//

            productoRepositorio.save(carpaCultivArg);
            productoRepositorio.save(premiumCultivArg);
            productoRepositorio.save(highPro1);
            productoRepositorio.save(highPro2);
            productoRepositorio.save(vidaCultiva1);
            productoRepositorio.save(vidaCultiva2);
            productoRepositorio.save(growMix80);
            productoRepositorio.save(growMix20);
            productoRepositorio.save(terraFertil);
            productoRepositorio.save(cultivatePremium);
            productoRepositorio.save(namasteOroNegro);
            productoRepositorio.save(namasteFloraBooster);
            productoRepositorio.save(namasteTricoMas);
            productoRepositorio.save(namasteDetox);
            productoRepositorio.save(topCropVeg);
            productoRepositorio.save(topCropFlora);
            productoRepositorio.save(happyRoots);
            productoRepositorio.save(happyRoots2);
            productoRepositorio.save(happyRoots3);
            productoRepositorio.save(madRocket);
            productoRepositorio.save(madRocket2);
            productoRepositorio.save(kitJardineria);
            productoRepositorio.save(kitJardineria2);
            productoRepositorio.save(poleas);
            productoRepositorio.save(poleas1);

            ///////// ACCESORIOS ////////


            clienteRepositorio.save(clientePrueba);
            clienteRepositorio.save(clientePrueba2);
            clienteRepositorio.save(clientePrueba3);
            clienteRepositorio.save(clienteAdmin);

            productoRepositorio.save(producto1);
            productoRepositorio.save(producto2);
            productoRepositorio.save(producto3);


            Orden orden = new Orden("acz123456789", LocalDateTime.now());
            Orden orden2 = new Orden("bca3333311", LocalDateTime.now());

            ordenRepositorio.save(orden);
            ordenRepositorio.save(orden2);


            clientePrueba.añadirOrdenes(orden);
            clientePrueba2.añadirOrdenes(orden2);
            clienteRepositorio.save(clientePrueba);
            clienteRepositorio.save(clientePrueba2);


            Pago pago = new Pago(TipoDePago.CREDITO, 2000, LocalDateTime.now());
            Pago pago2 = new Pago(TipoDePago.DEBITO, 5000, LocalDateTime.now());

            pagoRepositorio.save(pago);
            pagoRepositorio.save(pago2);

            orden.setPago(pago);
            orden2.setPago(pago2);
            ordenRepositorio.save(orden);
            ordenRepositorio.save(orden2);

            OrdenProducto ordenProducto = new OrdenProducto(750, 3, producto1.getNombre());
            OrdenProducto ordenProducto2 = new OrdenProducto(660, 2, producto2.getNombre());
            ordenProductoRepositorio.save(ordenProducto);
            ordenProductoRepositorio.save(ordenProducto2);


            producto1.añadirOrdenProducto(ordenProducto);
            orden.añadirOrdenProducto(ordenProducto);

            producto2.añadirOrdenProducto(ordenProducto2);
            orden2.añadirOrdenProducto(ordenProducto2);

            productoRepositorio.save(producto1);
            productoRepositorio.save(producto2);


            ordenRepositorio.save(orden);
            ordenRepositorio.save(orden2);


            ordenProductoRepositorio.save(ordenProducto);
            ordenProductoRepositorio.save(ordenProducto2);


        };

    }
}
