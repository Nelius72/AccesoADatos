package EjerciciosXML;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;

public class CrearProductosXML {

    //Codigo, descripcion, unidades, precio

    public static void main(String[] args) throws IOException {

        //Lectura documento
        producto pro;
        File fichero = new File("productos.dat");
        FileInputStream filein = new FileInputStream(fichero);
        ObjectInputStream datalS = new ObjectInputStream(filein);

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
            Document doc = implementation.createDocument(null, "Productos", null);
            doc.setXmlVersion("1.0");

            try {
                while (true) {
                    pro = (producto) datalS.readObject();

                    Element raiz = doc.createElement("Producto"); // nodo producto
                    doc.getDocumentElement().appendChild(raiz);

                    // ID
                    CrearElemento("id", Integer.toString(pro.getCodigo()), raiz, doc);
                    // Descripcion
                    CrearElemento("descripcion", pro.getDescripcion().trim(), raiz, doc);
                    // Unidades
                    CrearElemento("unidades", Integer.toString(pro.getUnidades()), raiz, doc);
                    // Precio
                    CrearElemento("precio", Double.toString(pro.getPrecio()), raiz, doc);
                }
            } catch (IOException | ClassNotFoundException eo) {
                System.out.println("Archivo XML creado.");
            }

            // Escribimos el xml
            Source source = new DOMSource(doc);
            Result result = new StreamResult(new java.io.File("productos.xml"));
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source, result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void CrearElemento(String datoproducto, String valor, Element raiz, Document document) {
        Element elem = document.createElement(datoproducto);
        Text text = document.createTextNode(valor); // damos valor
        raiz.appendChild(elem); // pegamos el elemento hijo a la raiz
        elem.appendChild(text); // pegamos el valor
    }
}//fin de la clase
