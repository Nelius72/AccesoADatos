package PrácticaEvaluable1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio1ContarVocales {
    //Escribe un programa que cuente  el número de vocales de cada fichero de texto
    // que se pasa como parámetro (pueden ser varios: "file1.txt file3.txt file2.txt").
    // En la salida estándar se escribirá el nombre de cada fichero, junto al número de vocales del mismo.
    //De ocurrir un error al intentar leer alguno de los ficheros, se debe imprimir
    // un mensaje para ese archivo, pero se deben procesar todos los ficheros restantes.


    public static void main(String[] args) {
        for (String arg : args) { //Bucle que recorre el "array args"
            try {
                String base = "";
                char vocales[] = {'a', 'á', 'e', 'é', 'i', 'í', 'o', 'ó', 'u', 'ú'};
                File f = new File(arg); //Indica la existencia de un archivo
                FileReader texto = new FileReader(f); //Indica operación de lectura

                int valor = texto.read();//Coloca el puntero en comienzo del archivo

                while (valor != -1) { //-1 Hace referencia el final del fichero. Mientras que no llegue al final sigue leyendo.
                    base += (char) valor + "";
                    valor = texto.read(); //Hace que vaya avanzando el puntero en el archivo y cuando llega al final da -1
                    // y sale del bucle
                }
                texto.close();
                int cont = 0;
                for (int i = 0; i < base.length(); i++) {//Bucle que recorre el fichero
                    for (int y = 0; y < vocales.length; y++) { //Bucle para sacar las vocales
                        if (base.toLowerCase().charAt(i) == vocales[y]) {
                            cont++;
                        }
                    }

                }
                System.out.println("El fichero " + arg + " contiene " + cont + " vocales");


            } catch (FileNotFoundException f) {
                System.out.println("El archivo no existe");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}