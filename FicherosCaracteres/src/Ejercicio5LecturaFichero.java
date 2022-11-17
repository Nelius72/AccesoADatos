import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
/*Ejercicio 5. Programa que lee y visualiza el contenido de un archivo que le indicamos por linea
de comandos.
 */

public class Ejercicio5LecturaFichero {
    public static void main(String[] args) throws IOException {

        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce la ruta del archivo: ");
        String teclad = teclado.nextLine();
        File fichero = new File(teclad);
        BufferedReader lector= new BufferedReader(new FileReader(fichero));
       // FileReader lector= new FileReader(fichero);//Creamos flujo de entrada al fichero
        // int i;
        String linea;
        while((/*i*/linea= lector.readLine/*sinLine*/()) !=null/*-1*/) //Mientras que haya contenido en el archivo me muestras los caracteres
        System.out.println(linea);

        lector.close();
    }

}
