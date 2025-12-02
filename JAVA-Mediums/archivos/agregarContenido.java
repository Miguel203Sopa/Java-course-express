package archivos;
import java.io.BufferedReader;
import java.io.File; //input-output
import java.io.PrintWriter;
import java.nio.file.Files;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.nio.file.Paths;

public class agregarContenido {

	public static void main(String[] args) {
		boolean anexar = false;
		var nombreArchivo = "mi_archivo.txt";
		var archivo = new File(nombreArchivo);
		
		try {
			anexar = archivo.exists();
			var salida = new PrintWriter(new FileWriter(archivo,anexar));
			var nuevoContenido = "\nNuevo\nContenido";
			salida.println(nuevoContenido);
			salida.close(); //guarda la informacion de un archivo
			System.out.println("se agrego contenido al archivo");
			
		}catch(Exception e) 
		{System.out.println("Codigo de error ");
		e.printStackTrace();}		
				

	}

}
