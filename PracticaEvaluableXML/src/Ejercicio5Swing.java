import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.event.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class Ejercicio5Swing {
    /*Crea una aplicación que sea capaz de importar un fichero XML con información de un catálogo de películas
    (título, fecha, genero y  sinopsis). Diseña la GUI para que se pueda visualizar toda la información de
    cada una de las películas importadas*/

    public static void main (String[] args) {
        JFrame frame = new JFrame ("Películas");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add (new MyPanel());
        frame.pack();
        frame.setVisible (true);
    }

}
 class MyPanel extends JPanel { //Clase
    static ArrayList <Element> arrayListPeliculas= new ArrayList();//Arraylist para almacenar los elementos xml
    private JTextField txTitulo;
    private JTextField txFecha;
    private JTextField txGenero;
    private JTextArea txSinopsis;
    private JLabel lbtitulo;
    private JLabel lbFecha;
    private JLabel lbGenero;
    private JLabel jcomp8;
    private JButton btImportar;
    private JComboBox cbBox;

    public MyPanel() {
        //construct preComponents
        String[] cbBoxItems = {};

        //construct components
        txTitulo = new JTextField (5);
        txFecha = new JTextField (5);
        txGenero = new JTextField (5);
        txSinopsis = new JTextArea (5, 5);
        lbtitulo = new JLabel ("Titulo");
        lbFecha = new JLabel ("Fecha");
        lbGenero = new JLabel ("Género");
        jcomp8 = new JLabel ("Sinopsis");
        btImportar = new JButton ("Importar");
        cbBox = new JComboBox (cbBoxItems);

        btImportar.addActionListener(e -> { //Cuando se pulsa el botón se abre una ventana para elegir el archivo
            JFileChooser chooser = new JFileChooser();
            if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                File f = chooser.getSelectedFile();
                leerXML(f);
            }
        });
        cbBox.addActionListener(e -> { //Cada vez que selecciono un elemento del combobox me muestra su información
            muestraTexto();
        });
        //adjust size and set layout
        setPreferredSize (new Dimension (452, 312));
        setLayout (null);

        //add components
        add (txTitulo);
        add (txFecha);
        add (txGenero);
        add (txSinopsis);
        add (lbtitulo);
        add (lbFecha);
        add (lbGenero);
        add (jcomp8);
        add (btImportar);
        add (cbBox);

        //set component bounds (only needed by Absolute Positioning)
        txTitulo.setBounds (120, 50, 200, 25);
        txFecha.setBounds (120, 75, 200, 25);
        txGenero.setBounds (120, 100, 200, 25);
        txSinopsis.setBounds (120, 125, 200, 135);
        lbtitulo.setBounds (40, 50, 100, 25);
        lbFecha.setBounds (40, 75, 100, 25);
        lbGenero.setBounds (40, 95, 100, 25);
        jcomp8.setBounds (40, 125, 100, 25);
        btImportar.setBounds (170, 270, 100, 25);
        cbBox.setBounds (330, 100, 100, 25);
    }

     private void muestraTexto() { //Mostramos contenido
        Element e = arrayListPeliculas.get(cbBox.getSelectedIndex());//Element e va a ser el elemento de pelicula que seleccionamos en el combobox
        txTitulo.setText(e.getElementsByTagName("Titulo").item(0).getTextContent());//Indicamos el valor a mostrar en cada txtfield
        txFecha.setText(e.getElementsByTagName("Fecha").item(0).getTextContent());
        txGenero.setText(e.getElementsByTagName("Genero").item(0).getTextContent());
        txSinopsis.setText(e.getElementsByTagName("sinopsis").item(0).getTextContent());

     }

     private void leerXML(File f) {
         try {
             DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance(); //Creamos el document builder para poder parsear
             DocumentBuilder builder = factory.newDocumentBuilder();                //y poder trabajar con el documento xml que le indicamos
             Document document = builder.parse(f); //Indicamos nuestro xml
             document.getDocumentElement().normalize();// Elimina nodos vacíos y combina adyacentes en caso de que los hubiera

             System.out.printf("Elemento raiz: %s %n", document.getDocumentElement().getNodeName()); //getDocumentElement = Accede al nodo raíz del documento

             //Cramos una lista con todos los nodos pelicula. 4 en este caso
             NodeList peliculas = document.getElementsByTagName("Pelicula");
             System.out.printf("Nodos Pelicula a recorrer: %d %n", peliculas.getLength());

             //Recorremos la lista
             arrayListPeliculas.clear();//Limpiamos array list para el caso que elijamos otro xml
             cbBox.removeAllItems();
             for (int i = 0; i < peliculas.getLength(); i ++) { //Recorremos la lista de peliculas
                 Node peli = peliculas.item(i); //Obtenemos un nodo <pelicula>
                 if (peli.getNodeType() == Node.ELEMENT_NODE) {//tipo de nodo elemento
                     //Obtenemos los elementos del nodo
                     Element elemento = (Element) peli;
                     arrayListPeliculas.add(elemento);
                     cbBox.addItem(elemento.getElementsByTagName("Titulo").item(0).getTextContent());//Añadimos al combo el titulo de las peliculas
                 }
             }
         } catch (Exception e)
         {e.printStackTrace();}
     }
 }