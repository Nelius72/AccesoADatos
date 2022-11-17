package Ejercicio16;

import java.io.File;
import java.io.Serializable;

public class Agenda implements Serializable {
    //a) Tenemos una clase Agenda con nombre, apellidos y teléfono.
    // Realizar un programa para almacenar datos de manera persistente en “agenda.dat”.
    // Comprobar que se ha realizado bien, realizando una lectura de los
    //mismos.
    //b) Modificar el programa para que en las siguientes ejecuciones los datos se añadan al fichero
    // (es decir, si existe el fichero no se sobreescribirá).

    public String nombre;
    public String apellidos;
    public Integer telefono;

    public Agenda(String nombre, String apellidos, Integer telefono) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }
}
