import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ejercicio6CienNumeros {
/* Ejercicio 6 Programa que escribe los 100 primeros numeros en un archivo numNaturales.txt
y luego se visualiza su contenido
 */
    public static void main(String[] args) throws IOException {

        File f = new File("numNaturales.txt");
        FileWriter writer = new FileWriter(f);//Indico flujo de escritura

        for (int i = 0; i < 101; i++) {
            writer.write(i);//Escribo en el documento
        }
        writer.close();

        FileReader reader = new FileReader("numNaturales.txt");//Indico flujo lectura
        int i;//Posicion del lector
        while ((i = reader.read()) != -1) {
            System.out.println(i);
        }
        reader.close();
    }
}
