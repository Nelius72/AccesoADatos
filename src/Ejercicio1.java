import java.io.File;
import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) {
        //1. Realiza un programa que muestre los ficheros y/o directorios de un
        //directorio que se pasará al programa desde la línea de comandos al
        //ejecutarlo. Se visualizará cuántos archivos hay en total, el nombre
        //de cada archivo y si es fichero o directorio.

        System.out.println("Introduce la Ruta");

        Scanner teclado = new Scanner(System.in);
        File f = new File(teclado.nextLine());

        if (f.exists()) {
            System.out.println("Existe esa carpeta");
        }
        String[] nombres = f.list();
        File[] archivos=f.listFiles(); //Te guarda en un array el número de files que hay en esa dirección
        System.out.println("Hay "+nombres.length+ " archivos");

        for (int i = 0; i < nombres.length; i++) {
            String name = nombres[i];
            if(archivos[i].isDirectory()){
                System.out.println(name+" es un directorio/carpeta");
            }else{
                System.out.println(name + " es un archivo");
            }
        }

    }
}