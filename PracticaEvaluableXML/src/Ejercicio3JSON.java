import org.json.JSONObject;
import org.json.XML;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class Ejercicio3JSON {
    //Escribe un programa para obtener una representación de la información anterior en formato JSON.

    public static void main(String[] args) throws IOException {
       URL web= new URL("https://www.aemet.es/documentos_d/eltiempo/prediccion/avisos/rss/CAP_AFAE_wah_RSS.xml");//Indicamos url
       InputStream is= web.openStream();//Indico el flujo de entrada como web y que lo pueda leer
       int caracter = 0;
       StringBuilder sb = new StringBuilder();
       while ((caracter = is.read())!= -1){ //Lee el documento desde la posicion 0 hasta que no haya nada, y devuelve -1
           sb.append((char)caracter); //Añadimos al stringbuilder el caracter (previo casteo, ya que es un int y devuelve un valor numerico por cada caracter),
       }
       String xml = sb.toString(); //Creamos un string y le asignamos el valor del string builder
       JSONObject json= XML.toJSONObject(xml);//Conversión a JSon
       String salida = json.toString(4); //Añadimos el valor de json al string de salida
       System.out.println(salida);

    }
}
