package Ejercicio15Productos;

import java.io.*;

public class EscribeProducto {
    public static void main(String[] args) throws IOException {
        Product product;
        File fichero= new File("FicheroProductos.dat");
        FileOutputStream salida= new FileOutputStream(fichero);
        ObjectOutputStream salidaObjeto= new ObjectOutputStream(salida);

        String productos [] = {"Puntilla","Martillo","Pala","Cubo"};
        int cantidad [] = {125,7,14,78};
        double precio [] = {0.25,9.95,13,3.75};

        for(int i=0;i< productos.length;i++){
            product = new Product(productos[i],cantidad[i],precio[i]);
            salidaObjeto.writeObject(product);
        }
        salidaObjeto.close();
    }
}
