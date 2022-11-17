import java.io.*;
import java.util.Scanner;

public class Ejercicio8DosArchivos {
    /*8. Escribir un método que reciba por parámetro dos rutas correspondientes a un archivo de origen
     y otro de destino y que copie el archivo origen en la ubicación destino. La ruta destino puede
      consistir en un directorio o un archivo. En el primer caso, el archivo se copiará al directorio
       especificado manteniendo su nombre. En el segundo, se tomará como nombre del archivo copia el que especifique su ruta.
     */
    public static void main(String[] args) throws IOException {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce la ruta del archivo Origen: ");
        String origen = teclado.nextLine();
        File fichero1 = new File(origen);
        System.out.println("Introduce la ruta del archivo Destino: ");
        String destino = teclado.nextLine();
        File fichero2= new File(destino);

        copiarArchivo(fichero1,fichero2);
    }
    public static void copiarArchivo(File origen, File destino) throws IOException {
        if(!origen.isFile()){
            System.out.println("El archivo de origen NO es un fichero");
        }
        FileReader lector=new FileReader(origen);//Flujo de lectura para archivo de origen
        int i;
        if(destino.isDirectory()){
            FileWriter copia=new FileWriter(destino.getAbsolutePath()+"\\"+origen.getName());//Asignamos ruta de la copia dentro del directorio
            while((i= lector.read()) != -1){
                copia.write(i);
            }
           copia.close();
        }else{
            if(destino.exists()){
                System.out.println("El archivo de destino ya existe");
            }else{
                FileWriter escritor=new FileWriter(destino);
                while((i= lector.read())!=-1){
                    escritor.write(i);
                }
                escritor.close();
            }
        }
    lector.close();
    }
}
