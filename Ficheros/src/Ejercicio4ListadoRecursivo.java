import java.io.File;
import java.util.Scanner;

public class Ejercicio4ListadoRecursivo {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce la ruta del archivo: ");
        String teclad = teclado.nextLine();
        File directorio = new File(teclad);
        listarElementos(directorio,"-->");
    }
    public static void listarElementos(File direct, String separador){
        File[] almacen= direct.listFiles();

        for(int i=0;i< almacen.length;i++){
            System.out.println(separador+almacen[i].getName());

            if(almacen[i].isDirectory()){
                String newSeparador;
                newSeparador=separador+"**";
                listarElementos(almacen[i],newSeparador);
            }
        }
    }
}
