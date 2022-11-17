import java.io.FileWriter;
import java.io.IOException;

public class Ejercicio6 {
    public static void main(String[] args) throws IOException {
        //6. Escribe un programa que escriba los 100 primeros números naturales en un
        // archivo numNaturales.txt. Después visualiza el contenido del archivo.

        FileWriter fw=new FileWriter("C:\\Users\\mañana\\Documents\\Acceso a Datos\\TEMA1\\100numeros.txt");
        String cadenanum= ""; //Se crea cadena vacía
        //Bucle para que genere los 100 primeros numeros naturales.
        for(int i=1;i<101;i++){
            cadenanum=cadenanum+ " " + String.valueOf(i);
        }
        fw.write(cadenanum);
        fw.close();
    }
}
