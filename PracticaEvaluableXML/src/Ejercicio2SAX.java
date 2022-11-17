import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;


public class Ejercicio2SAX { //https://decodigo.com/java-leer-xml-con-sax-parser
    /*Crea un programa que mediante SAX obtenga de la página
     https://www.aemet.es/documentos_d/eltiempo/prediccion/avisos/rss/CAP_AFAE_wah_RSS.xml
     el título de las noticias y la fecha.*/
    public static void main(String[] args) throws IOException, SAXException {

        XMLReader procesadorXML = XMLReaderFactory.createXMLReader();//Generamos procesador para leer XML
        GestionContenido gestor = new GestionContenido(); //Objeto GestionContenido que enlaza con la otra clase
        procesadorXML.setContentHandler(gestor);
        InputSource fileXML = new InputSource("https://www.aemet.es/documentos_d/eltiempo/prediccion/avisos/rss/CAP_AFAE_wah_RSS.xml");
        procesadorXML.parse(fileXML);

    }

    static class GestionContenido extends DefaultHandler { //Clase
        public GestionContenido() {
            super();
        }

        boolean titulo = false, fecha = false, item = false;


        public void startElement(String uri, String nombre, String nombreC, Attributes atts) {//Método para iniciar elemento

            if (nombre.equals("item")) { //Si el nombre de la etiqueta es "item", el booleano item se pone en true
                item = true;
            }
            if (nombre.equals("title") && item) {//Si el nombre es título y además item está en true, significa que ha encontrado una etiqueta estando dentro del item
                titulo = true;
            }
            if (nombre.equals("pubDate") && item) {
                fecha = true;
            }
        }

        public void characters(char[] ch, int inicio, int longitud) {//Almacenamos los datos
            if (titulo) { //Si título está true, almaceno en el string el contenido de la etiqueta
                String car = new String(ch, inicio, longitud);
                System.out.println("Título: "+car);
                titulo=false;
            }
            if (fecha) {
                String car = new String(ch, inicio, longitud);
                System.out.println("Fecha: "+car+ "\n");
                fecha=false;
            }
        }

        public void endElement(String uri, String nombre, String nombreC) {//Indicamos cierre de la etiqueta de elemento
            if (nombre.equals("item")) {
                item = false;
            }
        }
    }
}




