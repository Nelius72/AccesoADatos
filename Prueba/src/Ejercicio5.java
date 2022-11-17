import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio5 {
    public static void main(String[] args) throws IOException {
        //5. Crea un fichero con un editor de textos y realiza un programa que lea que
        //visualice su contenido. Modifica el programa para que acepte cualquier fichero
        //que se envíe desde la línea de comandos.
        System.out.println("Introduce la ruta del archivo: ");
        Scanner teclado = new Scanner(System.in);
        FileReader texto= new FileReader(teclado.nextLine());
        int valor=texto.read();
        while(valor!=-1) { //-1 Hace referencia el final del fichero. Mientras que no llegue al final sigue leyendo.
            System.out.print((char) valor);
            valor = texto.read();
        }
        texto.close();
    }
}
