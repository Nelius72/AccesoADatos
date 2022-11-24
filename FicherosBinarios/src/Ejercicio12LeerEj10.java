import java.io.*;

public class Ejercicio12LeerEj10 {
    /*Programa Java que lee el contenido del fichero creado en el ejercicio 10
     y lo muestra por pantalla.*/

    public static void main(String[] args) throws IOException {

        DataInputStream lector=new DataInputStream(new FileInputStream("matriz.dat"));
        int filas,columnas,f,c;
        try{
            filas= lector.readInt();
            columnas= lector.readInt();
            for(f=0;f<filas;f++){
                for(c=0;c<columnas;c++){
                    System.out.println(lector.readDouble());
                }
            }
        }catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (EOFException e) {
            System.out.println("Fin de fichero");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


    }
}
