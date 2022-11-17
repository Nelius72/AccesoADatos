import java.io.File;

public class Ejercicio2Parametros {
    public static void main(String[] args) {

        File fichero = new File(args [0]);//Si queremos indicar por argumentos. Indicamos ubicacion de archivo

        if(!fichero.exists()){
            System.out.println("El fichero indicado no existe");
        }else{
            if(!fichero.isFile()){
                System.out.println("El fichero seleccionado "+args[0]+" es un directorio");
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
