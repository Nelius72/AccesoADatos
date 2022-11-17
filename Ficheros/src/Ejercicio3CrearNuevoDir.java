import java.io.File;
import java.io.IOException;

public class Ejercicio3CrearNuevoDir {
    public static void main(String[] args) throws IOException {
        File f = new File("NUEVODIR");
        File fichero1 = new File (f,"Fichero1.txt");
        File fichero2 = new File (f, "Fichero2.txt");
        File fichero3 = new File (f,"Fichero3.txt");
        f.mkdir();//CREAMOS EL DIRECTORIO

        if(fichero1.createNewFile()){ //CREAMOS EL FICHERO1 Y COMPRUEBA SI SE HA CREADO ANTERIORMENTE

            System.out.println("Fichero1 creado correctamente");

        }else{
            System.out.println("Fichero1 no creado, fichero existente");
        }

        if(fichero2.createNewFile()){ //CREAMOS EL FICHERO2 Y COMPROBAMOS SU EXISTENCIA

            System.out.println("Fichero2 creado correctamente");

        }else{
            System.out.println("Fichero2 no creado, fichero existente");
        }

       if(fichero1.renameTo(new File(f,"Fichero1Renombrado.txt"))){//RENOMBRAMOS EL FICHERO
            System.out.println("El fichero1 ha sido renombrado con exito");
        }else{
           System.out.println("El fichero no se ha podido renombrar");
       }
       if(fichero3.delete()){ //ELIMINAMOS FICHERO
           System.out.println("El fichero3 ha sido eliminado correctamente");
       }

    }
}
