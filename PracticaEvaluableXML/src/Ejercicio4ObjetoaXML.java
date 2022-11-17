import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.ArrayList;

public class Ejercicio4ObjetoaXML {
   /* Escribe un programa para leer los datos de las cotizaciones grabadas mediante serialización en el ejercicio nº 5 de la práctica anterior y grabarlas en un documento cotizaciones.xml con el siguiente formato para cada empresa:
        <Empresas>
            <empresa>
                <nombre>nombre</nombre>
                <fecha>fecha</fecha>
                <hora>hora</hora>
                <cotizacion>cotizacion</cotizacion>
            </empresa>
        <Empresas>*/

    public static void main(String[] args) throws ParserConfigurationException {
    ArrayList<Cotizacion> empresas = new ArrayList<>(); //Array list para almacenar las cotizaciones de las empresas
        try{
        File f =new File("cotizaciones.dat");
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));//Indicamos flujo de entrada de objeto, indicando el archivo
        while(true){//Mientras que haya contenido
            Cotizacion c =(Cotizacion) ois.readObject();//Cada vez que encuentra un objeto cotizacion me lo devuelve
            empresas.add(c);//Almacenamos en el arraylist

        }
    }catch (Exception ex){
            System.out.println("Fin de Fichero");
    }

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();////Creamos el document builder para poder parsear
        DocumentBuilder builder = factory.newDocumentBuilder();
        DOMImplementation implementation = builder.getDOMImplementation();//Provee metodos para usar DOM
        Document documento = implementation.createDocument(null, "Empresas", null);

        for (int i = 0; i < empresas.size(); i++) { //Recorremos el array de objetos
            Element raiz = documento.createElement("empresa");
            documento.getDocumentElement().appendChild(raiz);//Incorporamos los nuevos elementos al raíz.


            creaElemento("nombre", empresas.get(i).nombre, raiz, documento); // Nombre
            creaElemento("fecha", empresas.get(i).fecha, raiz, documento); // Fecha
            creaElemento("hora", empresas.get(i).hora, raiz, documento); // Hora
            creaElemento("valor", empresas.get(i).valor, raiz, documento); // Cotización
        }

        try (FileOutputStream salida = new FileOutputStream("cotizaciones.xml")) { //Vamos a generar el xml
            escribeXml(documento, salida);
        } catch (IOException | TransformerException e) {
            e.printStackTrace();
        }

    }

    static void creaElemento(String dato, String valor, Element raiz, Document document) {
        Element nuevoElemento = document.createElement(dato); //Creamos un elemento cuyo nombre es el "dato" que le indicamos
        Text contenido = document.createTextNode(valor); // Indicamos el valor del elemento (contenido) Ej,Nombre,fecha...
        raiz.appendChild(nuevoElemento); // Pegamos el elemento hijo a la raiz
        nuevoElemento.appendChild(contenido); // Pegamos el valor
    }

    private static void escribeXml(Document doc, OutputStream output) throws TransformerException {

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(output);

        transformer.transform(source, result);

    }
}
