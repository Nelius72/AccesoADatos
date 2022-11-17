import java.io.*;
import java.util.Scanner;

public class Ejercicio9LeeEscribeBinario {

    /*9. Programa que lee enteros por teclado y los escribe en el fichero binario “datos.dat”.*/

    public static void main(String[] args) throws IOException {

        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce números enteros a almacenar: ");
        int numeros = teclado.nextInt();
        File fichero = new File("datos.dat");
        DataOutputStream escribe= new DataOutputStream(new FileOutputStream(fichero));
        escribe.writeInt(numeros);
        escribe.close();

        DataInputStream lectura= new DataInputStream(new FileInputStream(fichero));

        System.out.println("Numero almacenado: "+lectura.readInt());

        lectura.close();


    }
}
