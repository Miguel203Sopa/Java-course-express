package archivos;
import java.io.BufferedReader;
import java.io.File; //input-output
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;
public class leerArchivo {

	public static void main(String[] args) {
		//leer el archivo 
		var nombreArchivo = "mi_archivo.txt";
		var archivo = new File(nombreArchivo);
		try {
			System.out.println("contenido del archivo: ");
			
			var entrada = new BufferedReader(new FileReader(archivo));
			var linea = entrada.readLine();
			while (linea != null) {
				System.out.println(linea);
				linea = entrada.readLine();
			}
		}catch(Exception e) {
			System.out.println("Error al leer archivo: "+e);
		}

	}

}
