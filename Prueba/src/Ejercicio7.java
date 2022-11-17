import java.io.FileWriter;
import java.io.IOException;

public class Ejercicio7 {
    public static void main(String[] args) throws IOException {
        //7.Realiza un programa que escriba los primeros 20 números primos en un fichero
        //de nombre numprimos.txt. Después visualiza el contenido del archivo. Se creará el
        //método EsPrimo().

        FileWriter fw = new FileWriter("C:\\Users\\mañana\\Documents\\Acceso a Datos\\TEMA1\\20primos.txt");

        int cont = 0;
        int numero = 2;

        do{
            if(esPrimo(numero)){
                fw.write(String.valueOf(numero)+" ");
                cont++;
            }numero++;
        }while (cont!=20);
        fw.close();
    }
    public static boolean esPrimo (int num){
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
