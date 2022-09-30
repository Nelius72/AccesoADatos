package Ejercicio16;

import java.io.*;

public class Ejercicio16 {
    public static void main(String[] args) throws IOException {
        Agenda agenda;

        File fichero = new File("agenda.dat"); //Creo el archivo
        //FileOutputStream fileout = new FileOutputStream(fichero,true);  //Indico que voy a escribir en el archivo
        ObjectOutputStream dataOS; //Escribo un objeto en el archivo. Si no esta creado lo crea
        //y si existe lo sobreescribe
        if(!fichero.exists()){ //Si el archivo no existe crea uno nuevo
            FileOutputStream fileout=new FileOutputStream(fichero);
            dataOS = new ObjectOutputStream(fileout);
        }
        else { //Si el archivo no existe crea un nuevo archivo con el nuevo metodo para quitar la cabecera
            dataOS = new MiObjectOutputStream(new FileOutputStream(fichero,true));
        }

        String nombre [] = {"Analia","Luis Miguel", "Alicia", "Roberto", "Manuel"};
        String apellidos [] = {"Romero", "Martín", "Lozano", "Pérez", "García"};
        int telefono [] = {1,2,3,4,5};

        for (int i=0;i<apellidos.length; i++){ //recorro los arrays
            agenda= new Agenda(nombre [i],apellidos[i],telefono [i]);
            dataOS.writeObject(agenda); //escribo la persona en el fichero
        }
        dataOS.close(); //cerrar stream de salida
    }
}

