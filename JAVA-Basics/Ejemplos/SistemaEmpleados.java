

package Ejemplos;
import java.util.Scanner;

public class SistemaEmpleados {

	public static void main(String[] args) {
		
		//esta webada
		Scanner consola= new Scanner(System.in);
		
		String nombre;
		int edad;
		float salario;
		System.out.println("Escriba su nombre");
		nombre = consola.nextLine();
		System.out.println("Escriba su edad");
		edad = Integer.parseInt(consola.nextLine());
		System.out.println("Escriva su salario");
		salario = Float.parseFloat(consola.nextLine());
		
		System.out.println("el empleado es "+nombre+" su edad es "+edad+" y su salario es "+salario );
	
		
		
	}

}
