import java.io.*;
import java.util.Scanner;

public class Ejercicio9 {
    public static void main(String[] args) throws IOException {
        //9. Programa que lee enteros por teclado y los escribe en el fichero binario “datos.dat”.

        System.out.println("Introduce el número entero: ");
        Scanner teclado=new Scanner(System.in);

        File fichero=new File("datos.dat"); //Indicamos el archivo que vamos a crear
        FileOutputStream f = new FileOutputStream(fichero);//Con esto se indica el archivo donde se guardaran los datos primitivos.
        DataOutputStream d= new DataOutputStream(f);//Con esto se escribe los datos en binario.

        d.writeInt(teclado.nextInt());
    }
}
