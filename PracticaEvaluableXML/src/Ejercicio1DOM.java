import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;

public class Ejercicio1DOM { //http://jmoral.es/blog/xml-dom
    /*Escribe un programa con la ayuda de DOM para que a partir del fichero peliculas.xml,
     se muestre correctamente: el título de la película, año, director y los nombres de los actores principales.*/

    public static void main(String[] args) {

        File file = new File("peliculas.xml");//Indicamos la existencia de archivo xml(cargamos nuestro xml)


        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance(); //Creamos el document builder para poder parsear
            DocumentBuilder builder = factory.newDocumentBuilder();                //y poder trabajar con el documento xml que le indicamos
            Document document = builder.parse(new File("peliculas.xml")); //Indicamos nuestro xml
            document.getDocumentElement().normalize();// Elimina nodos vacíos y combina adyacentes en caso de que los hubiera

            System.out.printf("Elemento raiz: %s %n", document.getDocumentElement().getNodeName()); //getDocumentElement = Accede al nodo raíz del documento

            //Cramos una lista con todos los nodos pelicula. 4 en este caso
            NodeList peliculas = document.getElementsByTagName("Pelicula");
            System.out.printf("Nodos Pelicula a recorrer: %d %n", peliculas.getLength());

            //Recorremos la lista
            for (int i = 0; i < peliculas.getLength(); i ++) { //Recorremos la lista de peliculas
                Node peli = peliculas.item(i); //Obtenemos un nodo <pelicula>
                if (peli.getNodeType() == Node.ELEMENT_NODE) {//tipo de nodo elemento
                    //Obtenemos los elementos del nodo
                    Element elemento = (Element) peli;
                    System.out.printf("Título: %s %n", elemento.getElementsByTagName("Titulo").item(0).getTextContent());
                    System.out.printf("Fecha: %s %n", elemento.getElementsByTagName("Fecha").item(0).getTextContent());
                    System.out.printf("Director: %s %n", elemento.getElementsByTagName("Director").item(0).getTextContent());
                    System.out.printf("Actores: %s %n", elemento.getElementsByTagName("Actores").item(0).getTextContent());

                }
            }
        } catch (Exception e)
        {e.printStackTrace();}

    }
}


