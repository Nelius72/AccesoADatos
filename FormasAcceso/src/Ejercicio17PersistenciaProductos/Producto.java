package Ejercicio17PersistenciaProductos;

import java.io.Serializable;
public class Producto implements Serializable{


	


/**
	 * 
	 */
private static final long serialVersionUID = 7313885629408477712L;
public int id;
public String descripcion;
public int unidades;
public double precio;
public Producto(int id,String descripcion,int unidades,double precio) { 
	this.id = id; 
	this.descripcion = descripcion;
	this.unidades=unidades;
	this.precio=precio;
	
}

public void setDes(String descripcion){this.descripcion = descripcion;} 
public void setId(int id) {this.id = id;}
public void setUnidades(int unidades) {this.unidades = unidades;}
public void setPrecio(int precio) {this.id = precio;}
public String getDes(){return this.descripcion;}
public int getId(){return this.id;}	
public int getUnidades(){return this.unidades;}	
public double getPrecio(){return this.precio;}	


public String toString(){
return "Id: "+id+ " descripci�n: "+descripcion+ " unidades: "+unidades+ " precio: "+precio;
}

}

