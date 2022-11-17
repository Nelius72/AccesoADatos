import java.io.File;
import java.util.Scanner;

public class Ejercicio1 {
    //1. Realiza un programa que muestre los ficheros y/o directorios de un
    //directorio que se pasará al programa desde la línea de comandos al
    //ejecutarlo. Se visualizará cuántos archivos hay en total, el nombre
    //de cada archivo y si es fichero o directorio.
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in); //Si queremos indicar por terminal
        System.out.println("Introduce la ruta del archivo: ");
        String teclad = teclado.nextLine();
        File fichero = new File(teclad);

        if(!fichero.exists()){
            System.out.println("El fichero indicado no existe");
        }else{
            if(!fichero.isFile()){
                System.out.println("El fichero seleccionado es un directorio");
                String[] contenido = fichero.list(); //Devuelve un array de nombres
                File[] info = fichero.listFiles(); //Nos devuelve un array de objetos File vinculados a cada uno de los elementos
                System.out.println("El directorio contiene "+ contenido.length+ " archivos");

                for(int i=0;i< contenido.length;i++){
                    if(info[i].isDirectory()){
                        System.out.println(contenido[i]+" es un directorio");
                    }else{
                        System.out.println((contenido[i]+" es un fichero"));
                    }
                }

            }else{
                System.out.println("El fichero seleccionado no es un directorio, por favor introduzca un directorio");
            }
        }
    }
}
