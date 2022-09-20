import java.io.File;
import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
    //2. Realiza un programa que muestre información sobre un fichero o
        //directorio que pasa como parámetro.

        System.out.println("Introduzca la ruta del archivo: " );
        Scanner teclado = new Scanner(System.in);
        File f = new File(teclado.nextLine()); //Creamos el file, que va a ser la ruta que le pasamos por el teclado

        System.out.println("El nombre del archivo es: "+f.getName());

        if (f.exists()){
            System.out.println("El archivo existe");
        }
        else{
            System.out.println("El archivo no existe");
        }
        if(f.isFile()){
            System.out.println("El File "+f.getName()+" es un archivo.");
        }
        else{System.out.println("El File "+f.getName()+" no es un archivo.");

        }
    }
}
