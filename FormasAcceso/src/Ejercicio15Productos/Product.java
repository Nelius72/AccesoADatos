package Ejercicio15Productos;

import java.io.Serializable;

public class Product implements Serializable {
    private String nombre;
    private int unidades;
    private double precio;

    public Product(String nombre, int unidades, double precio) {
        this.nombre = nombre;
        this.unidades = unidades;
        this.precio = precio;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }


}
