import java.util.Scanner;



public class RecolectarDatos {
	
	public static void main(String[] args) {
		//clase Scanner
		
		Scanner consola = new Scanner(System.in);
		System.out.println("Escribe algo: ");
		String respuesta = consola.nextLine();
		//.nextLine(); pide texto
		//.nextInt(); pide numeros enteros
		//.nextBoolean(); pide Booleanos
		//.nextDouble(); pide doubles
	//lo mas recomendable es usar nextLine() y de ahi convertirlo
		
		//conversion de datos
		
		
		//Integer.parseInt(); convierte texto a entero
		int enteroST =Integer.parseInt(consola.nextLine());
		
		
		
		
	}
}
