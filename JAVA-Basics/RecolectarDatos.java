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
		System.out.println("Escribe un numero entero: ");
		int enteroST =Integer.parseInt(consola.nextLine());
		System.out.println("Escribe un numero decimal: ");
		double dobleST= Double.parseDouble(consola.nextLine());
		System.out.println("Escribe otro numero decimal: ");
		float floteST= Float.parseFloat(consola.nextLine());
		System.out.println("Escribe un booleano: ");
		boolean BoolST= Boolean.parseBoolean(consola.nextLine());
		
		
		
		
		
		
		
	}
}
