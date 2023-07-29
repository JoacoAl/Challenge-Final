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


            Cliente clientePrueba = new Cliente("Joaquin", "Altamonte", "joaquin.altamonte@gmail.com", "ABC 123", "123456789", codificadorDeContraseña.encode("1234"), 18);
            Cliente clientePrueba2 = new Cliente("Eduardo", "Oriolani", "eduoriolani@gmail.com", "CBA 123", "111111111", codificadorDeContraseña.encode("1234"), 26);
            Cliente clientePrueba3 = new Cliente("Nicolas", "Gonzales", "nicogonzales@gmail.com", "BBB 111", "222222222", codificadorDeContraseña.encode("1234"), 19);
            Cliente clienteAdmin = new Cliente("Admin", "Admin", "admin-gozogrowshop@gmail.com", "CCC 333", "333333333", codificadorDeContraseña.encode("1234"), 19);


            Producto producto1 = new Producto("Encendedor","Bic", "Encendedor de plastico BIC", 250, Categoria.ACCESORIOS, 40, true);
            Producto producto2 = new Producto("Pica","Lion Rolling Circus", "Picador rolling circus", 330, Categoria.ACCESORIOS, 6, true);
            Producto producto3 = new Producto("Liyo","OCB", "Liyos de celulosa", 125, Categoria.ACCESORIOS, 20, true);

            ////////// TABACOS //////////
            Producto cerritoOriginal = new Producto("Tabaco Cerrito Original 40gr","Cerrito", "Tabaco Cerrito es un blend de diferentes variedades de tabaco virginia. Se caracteriza mayormente por una humedad perfecta para poder manipularlo de manera más sencilla y un sabor y aroma muy equilibrados.", 1250, Categoria.TABACO, 25, true);
            Producto cerritoChocolate = new Producto("Tabaco Cerrito Chocolate 40gr","Cerrito", "Tabaco Cerrito es un blend de diferentes variedades de tabaco virginia. Se caracteriza mayormente por una humedad perfecta para poder manipularlo de manera más sencilla y un sabor y aroma muy equilibrados.", 1250, Categoria.TABACO, 12, true );
            Producto cerritoVainilla = new Producto("Tabaco Cerrito Vainilla 40gr","Cerrito", "Tabaco Cerrito es un blend de diferentes variedades de tabaco virginia. Se caracteriza mayormente por una humedad perfecta para poder manipularlo de manera más sencilla y un sabor y aroma muy equilibrados.", 1250, Categoria.TABACO, 15, true);
            Producto vanHaasenVanilla = new Producto("Tabaco Van Haasen Vainilla 20gr","Van Haasen", "Tabaco Van Häasen original es un blend de variedades virginia. Es un tabaco de intensidad suave, roma y sabor equilibrado y con la humedad perfecta para poder armar cigarrillos.", 1000, Categoria.TABACO, 15, true);
            Producto vanHaasenVirginia = new Producto("Tabaco Van Haasen Virginia 20gr","Van Haasen", "Tabaco Van Häasen original es un blend de variedades virginia. Es un tabaco de intensidad suave, roma y sabor equilibrado y con la humedad perfecta para poder armar cigarrillos.", 1000, Categoria.TABACO, 9, true);
            Producto moroMango = new Producto("Tabaco Moro mango x30gr", "Moro", "Tabaco Moro mango para armar cigarrillos saborizados. Los tabacos de Moro se caracterizan por ser frescos y por tener un cuerpo muy agradable a la boca. En este caso la variedad de mango presenta un sabor muy equilibrado que se fusiona a la perfección con el sabor natural del tabaco, además, tiene un aroma dulce.", 1700, Categoria.TABACO, 24, true);
            Producto moroVainilla = new Producto("Tabaco Moro vainilla x30gr", "Moro", "Tabaco Moro mango para armar cigarrillos saborizados. Los tabacos de Moro se caracterizan por ser frescos y por tener un cuerpo muy agradable a la boca. En este caso la variedad de mango presenta un sabor muy equilibrado que se fusiona a la perfección con el sabor natural del tabaco, además, tiene un aroma dulce.", 1700, Categoria.TABACO, 15, true);
            Producto moroGreen = new Producto("Tabaco Moro Green Virginia x 30gr", "Moro", "Tabaco Moro mango para armar cigarrillos saborizados. Los tabacos de Moro se caracterizan por ser frescos y por tener un cuerpo muy agradable a la boca. En este caso la variedad de mango presenta un sabor muy equilibrado que se fusiona a la perfección con el sabor natural del tabaco, además, tiene un aroma dulce.", 1700, Categoria.TABACO, 21,  true);
            Producto lasHojas = new Producto("Tabaco Las Hojas x50gr", "Las Hojas", "Tabaco Las hojas es un tabaco natural de intensidad intermedia ideal para quienes gustan del clásico tabaco rubio. Todas las variedades de Las Hojas están hechas con la máxima calidad en la selección del tabaco, por eso es uno de los mejores del mercado. En este caso, su paquete por 50gr. Permita que puedas disfrutar por mucho más tiempo de su sabor.", 700, Categoria.TABACO, 10, true);
            Producto lasHojasNatural = new Producto("Tabaco Las Hojas Natural x30gr", "Las Hojas", "Tabaco Las hojas Natural es un tabaco producido sin utilizar ningún tipo de químico o aditivo durante su proceso. Con una intensidad intermedia, esta variedad de tabaco Las Hojas es de un sabor muy agradable para quienes prefieren cigarrillos más suaves, además está empacado especialmente para que mantenga la frescura y humedad necesaria.", 1300, Categoria.TABACO, 5, true);
            Producto lasHojasUva = new Producto("Tabaco Las Hojas Uva x30gr", "Las Hojas", "Tabaco Las hojas de uva es un tabaco con un sabor y aroma fresco a uva muy recomendado para quienes gustan de tabacos suaves. Esta variedad de tabaco Las Hojas, al igual que todas las demás, es totalmente natural ya que no se utiliza ningún tipo de químico ni aditivo durante su proceso, eso hace que el sabor al tabaco natural se sienta mucho más y se combine a la perfección con la uva.", 1300, Categoria.TABACO, 12, true);

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
                    "Estructura de la carpa: Tubos de metal de 17 mm", 45000, Categoria.CULTIVO, 3, true);
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
                    "Estructura de la carpa: Tubos de metal de 17 mm", 71000, Categoria.CULTIVO, 2, true);
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
                    "Ventana rejilla trasera inferior de 25 x 12.5 cm", 66500, Categoria.CULTIVO, 1, true);
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
                    "• Caja cerrada." ,86000, Categoria.CULTIVO, 2, true );
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
                    "HIDROPONIA: 2 baldes de 25L", 57500, Categoria.CULTIVO, 1, true);
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
                    "- Cintas para luces", 78000, Categoria.CULTIVO, 1, true);
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
                    "(N) 200-270 (P) 15-40 (K) 200-300\n", 6900, Categoria.CULTIVO, 10, true);
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
                    "Vivero Plantas Al Natural", 2500, Categoria.CULTIVO, 3, true);
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
                    "Se puede aplicar de manera foliar, intercalando con los riegos. No mezclar este producto en el mismo riego con otros productos.", 4250, Categoria.CULTIVO, 34, true);
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
                    "del agua usada habitualmente en el riego.", 4250, Categoria.CULTIVO, 21, true);
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
                    "EN RIEGO: Diluir 1 gr por Lt/agua, dejar reposar unas horas y regar lentamente la tierra. Durante toda la floración, 1 aplicación semanal es suficiente. Se puede aplicar de forma Foliar, con un rociador, hasta la cuarta semana de floración. (no superar las 3 aplicaciones foliares) EN TIERRA: Mezclar 1 gr por cada 2/Lt de tierra, al preparar la mezcla para floración.", 3100, Categoria.CULTIVO, 40, true);
            //Macetas//
            //Regaderas//
            //Herramientas//
            //Insecticidas//
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
