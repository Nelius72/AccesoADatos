import java.io.*;
import java.util.Scanner;

public class Ejercicio9LeeEscribeBinario {

    /*9. Programa que lee enteros por teclado y los escribe en el fichero binario “datos.dat”.*/

    public static void main(String[] args) throws IOException {

        File fichero = new File("datos.dat");
        DataOutputStream escribe= new DataOutputStream(new FileOutputStream(fichero));
        Scanner teclado = new Scanner(System.in);
        System.out.print("Introduce número entero. -1 para acabar: ");
        int numeros = teclado.nextInt();

        while (numeros != -1){
            escribe.writeInt(numeros);
            System.out.print("Introduce número entero. -1 para acabar: ");
            numeros = teclado.nextInt();
        }

        escribe.close();

    }
}