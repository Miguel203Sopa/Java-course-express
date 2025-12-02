package archivos;
import java.io.BufferedReader;
import java.io.File; //input-output
import java.io.PrintWriter;
import java.nio.file.Files;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.nio.file.Paths;
public class leerTodo {

	public static void main(String[] args) {
		var nombreArchivo ="mi_archivo.txt";
		try {
			List<String> lineas = Files.readAllLines(Paths.get(nombreArchivo));
			System.out.println("contenido del archivo");
			for (String linea: lineas) {
				System.out.println(linea);
			}
		}catch(Exception e) {
			System.out.println("Error al leer archivo "+e.getMessage());
			e.printStackTrace();
		}finally {
			
		}
	}

}
