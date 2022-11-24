package Ejercicio15Productos;

import java.io.*;

public class LeeProducto {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Product prod; //Defino variable producto
        File fichero= new File("FicheroProductos.dat"); //Declaro el fichero
        FileInputStream entrada = new FileInputStream(fichero);
        ObjectInputStream entradaObjeto = new ObjectInputStream(entrada);

        try{


        while(true){
            prod= (Product) entradaObjeto.readObject();
            System.out.println("Producto: "+prod.getNombre()+"\n"+"Cantidad: "+prod.getUnidades()+"\n"+"Precio: "+prod.getPrecio()+"\n");

        }
        }catch (EOFException Alfa){
            System.out.println("FIN DE LECTURA");
        }
    }
}
