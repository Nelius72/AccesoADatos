import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Ejercicio18LeerArchAleatorio {
    public static void main(String[] args) throws IOException {
        File fichero = new File("AleatorioEmple.dat");
        RandomAccessFile file = new RandomAccessFile(fichero, "r"); //declara el fichero de acceso aleatorio
        int id, dep, posicion;
        Double salario;
        char apellido[]=new char[10], aux;
        posicion = 0; //para situarnos al principio
        do{ //recorro el fichero
            file.seek(posicion); //nos posicionamos en posicion
            id = file.readInt(); // obtengo id de empleado
            for (int i=0;i<10;i++) {
                aux=file.readChar();
                apellido[i]=aux;
            }
            String apellidos=new String(apellido);
            dep = file.readInt(); //obtengo dep
            salario = file.readDouble(); //obtengo salario
            if(id >0)
                System.out.printf("ID: %s, Apellido: %s, Departamento: %d, Salario: %.2f %n",id,apellidos,dep,salario);
            posicion= posicion + 36; //me posiciono para el sig empleado, cada empleado ocupa 36 bytes
        } while(file.getFilePointer() != file.length());
        file.close(); //cerrar fichero
    }
}
