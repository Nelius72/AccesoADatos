package Ejercicio18_19;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class LeerRegistro {
    public static void main(String[] args) throws IOException {
        File fichero = new File("AleatorioEmple.dat");
        RandomAccessFile file = new RandomAccessFile(fichero, "r");
        int id, dep, posicion;
        Double salario;
        char apellido[] = new char[10], aux;
        int registro=5;
        posicion = (registro -1 ) * 36;
        if(posicion >= file.length() )
            System.out.printf("ID: %d, NO EXISTE EMPLEADO...",registro);
        else{
            file.seek(posicion); //nos posicionamos
            id=file.readInt(); // obtengo id de empleado
            for (int i = 0; i < apellido.length; i++) {
                aux = file.readChar();//recorro uno a uno los caracteres del apellido
                apellido[i] = aux; //los voy guardando en el array
            }
            String apellidoS= new String(apellido);//convierto a String el array
            dep=file.readInt();//obtengo dep
            salario=file.readDouble(); //obtengo salario
            System.out.println("ID: "+registro+", Apellido: "+apellidoS.trim()+", Departamento: "+dep + ", Salario: " +
                    salario);
        }
        file.close(); //cerrar fichero
    }
}
