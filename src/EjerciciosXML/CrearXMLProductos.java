package EjerciciosXML;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class CrearXMLProductos {

    public static void main(String[] args) throws IOException {
        File fichero = new File("productos.dat");
        RandomAccessFile file = new RandomAccessFile(fichero, "r");

        int id,unidades,precio;
        char apellido[] = new char[10], aux;


    }
}
