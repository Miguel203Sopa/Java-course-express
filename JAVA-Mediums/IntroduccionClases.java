import java.util.Scanner;
public class IntroduccionClases {
	
	
//atributos:
	String nombre;
	String apellido;
	
	
	void mostrarPersona() {
		
		var variableLocal = "wee";
		
		System.out.println("su nombre es "+nombre);
		System.out.println("su apellido es "+apellido);
	}
	
	public static void main(String[] args) {
		
		IntroduccionClases Objeto1 = new IntroduccionClases();
		var Objeto2 = new IntroduccionClases();
		Scanner console = new Scanner(System.in);
		
		Objeto1.nombre = "charlos";
		Objeto1.apellido="acosta";
		Objeto1.mostrarPersona();
		
		Objeto2.nombre = "Duck";
		Objeto2.apellido="Tape";
		Objeto2.mostrarPersona();
		
		
		
		
		
		// TODO Auto-generated method stub	
		//atributos: caracteristicas de objetos
		//metodos:acciones que pueden realizar los objetos
		//una clase se compone de metodos y atributos
		
	}

}
