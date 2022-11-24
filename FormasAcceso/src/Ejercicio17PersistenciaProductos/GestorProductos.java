package Ejercicio17PersistenciaProductos;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class GestorProductos {
	

    
public static void main(String[] args) throws IOException {
	GestorProductos gp = new GestorProductos();
	gp.EscribeFichero("productos.dat");
	gp.LeerFichero("productos.dat");
}
    
        
        

public void EscribeFichero(String fich) throws FileNotFoundException, IOException
{ObjectOutputStream obj;	
Producto producto;

//Writing. comprobamos si el fichero existe o no
File fich1=new File("productos.dat");
if(!fich1.exists()) {
   obj = new ObjectOutputStream (new FileOutputStream(fich1));
} else {
	obj = new MiObjectOutputStream(new FileOutputStream(fich1,true));
}
//A�adimos nuevos datosa la Agenda
for (int i=1;i<5;i++) {
	producto=new Producto(i,"des"+i,i+3,i+10.0);
obj.writeObject(producto);
}
obj.close();
    
}

public void LeerFichero(String fichero)   {
	ObjectInputStream ois =null;
    Producto aux;
    try
    {
        // Se crea un ObjectInputStream
        ois = new ObjectInputStream(new FileInputStream(fichero));
        
        // Se lee el primer objeto
        aux = (Producto)ois.readObject();
        
        // Mientras haya objetos
        while (true)
        { System.out.println(aux);
        aux = (Producto) ois.readObject();
        }
         
    }
    catch (EOFException e1)
    {
     	System.out.println ("Fin de fichero");
    }
    catch (IOException e3)
    {
        e3.getMessage();
    }
    catch (Exception e2)
    {
        e2.printStackTrace();
    }
    finally {
    	try {
			ois.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
}
