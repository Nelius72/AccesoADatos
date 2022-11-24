import java.io.*;

public class Ejercicio11LeeEj9 {
    /*11. Programa que lee el contenido del fichero creado en el ejercicio 9.
    Utilizaremos un bucle infinito para leer los datos. Cuando se llega al final
    del fichero se lanza la excepción EOFException que se utiliza para salir del bucle while.
     */

    public static void main(String[] args) throws IOException {
        DataInputStream leer = new DataInputStream(new FileInputStream("datos.dat"));
        try {
            int i;
            while (true) {
                i = leer.readInt();
                System.out.print(i + "-");
            }
        }catch(EOFException Ex){

        }

    }
}
