package Ejercicio16;

import java.io.*;

public class LeerAgenda {
    public static void main(String[] args) throws IOException {
        Agenda agenda; //defino la variable agenda
        File fichero = new File("agenda.dat");
        FileInputStream filein = new FileInputStream(fichero);//conecta el flujo de bytes al flujo de datos
        ObjectInputStream datalS = new ObjectInputStream(filein);
        try {
        while (true) {
            agenda= (Agenda) datalS.readObject();//lectura del fichero
            System.out.printf("Nombre: " + agenda.getNombre() + "%nApellidos: "+ agenda.getApellidos()+ "%nTelefono: " + agenda.getTelefono()+"\n");
        }
        }catch (IOException | ClassNotFoundException eo) {
            System.out.println("FIN DE LECTURA.");
        }
        datalS.close();
    }
}
