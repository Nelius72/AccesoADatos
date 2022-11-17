import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ejercicio7VeintePrimos {
    public static void main(String[] args) throws IOException {

        FileWriter writer= new FileWriter("numprimos.txt");
        int contador=0;
        for(int i=1;contador<20;i++){
            if(esPrimo(i)){
                writer.write(i);
                contador++;
            }
        }
        writer.close();

        FileReader lector= new FileReader("numprimos.txt");
        int i;
        while((i= lector.read())!=-1){
            System.out.println(i);
        }
        lector.close();
    }
    public static boolean esPrimo(int numero){
        int contador = 2;
        boolean primo=true;
        if (numero%2==0 && numero!=2)
            primo=false;
        else
            while ((primo) && (contador!=numero)){
                if (numero % contador == 0)
                    primo = false;
                contador++;
            }
        return primo;
    }
}
