package Ejercicio18_19;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class gestor {

    public static void main(String[] args) {

    }
public void escribirFicheroAleatorio(int idmetido,int depart,int salario, String apellido) throws IOException {
        File fichero = new File("AleatorioEmple.dat");
//declara el fichero de acceso aleatorio
        RandomAccessFile file = new RandomAccessFile(fichero, "rw");
//arrays con los datos


        StringBuffer buffer = null;//buffer para almacenar apellido


            file.writeInt(idmetido); //uso i+1 para identificar empleado
            buffer= new StringBuffer(apellido);
            buffer.setLength(10);//Crea un string con 10 huecos
            file.writeChars(buffer.toString());
            file.writeInt(depart); //insertar departamento
            file.writeDouble(salario);//insertar salario
            file.close(); //cerrar fichero
        }


    public boolean comprobarID(int idmetido) throws IOException {

            File fichero = new File("AleatorioEmple.dat");
            RandomAccessFile file = new RandomAccessFile(fichero, "r"); //declara el fichero de acceso aleatorio
            int id, posicion;
            posicion = 0; //para situarnos al principio
            do{ //recorro el fichero
                file.seek(posicion); //nos posicionamos en posicion
                id = file.readInt(); // obtengo id de empleado
                if (id==idmetido){
                    System.out.println("El id  ya existe");
                    file.close();//cerrar fichero
                    return true;
                }else{
                    file.close();
                    return false;
                }

            } while(file.getFilePointer() != file.length());


    }
}
