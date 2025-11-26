package ProyectosAvanzados;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;


public class Colecciones {

	public static void main(String[] args) {
		
		List miLista = new ArrayList();
		miLista.add(2); 
		//una lista puede contener cualquier tipo de archivo
		
		
		//aunque podemos definir un tipo de dato concreto
	
		List<String> Semana = new ArrayList<String>();
		Semana.add("Lunes");
		Semana.add("Martes");
		Semana.add("Miercoles");
		Semana.add("Jueves");
		Semana.add("Viernes");
		Semana.add("Sabado");
		Semana.add("Domingo");
		Semana.add("Jueves");
		//la Lista puede agarrar datos repetidos
		
		
		
		//Genericos
		//el tipo Object es general para datos en general
//		for(String elemento: Semana) {
//			System.out.println("dia de la semana: "+elemento);
//		}
		
		
		//Funciones lambda (funcion anonima de un codigo muy compacto)
		//tambien conocido como programacion funcional
		
//		Semana.forEach(elemento -> {
//			System.out.println("Elemento "+elemento);
//		} );
		//esto se puede recortar mucho mas
		Semana.forEach(System.out::println);
		
		List<String> nombres = Arrays.asList("Pedro","super","alexo");
		nombres.forEach(System.out::println);
		
		
		
		
	}

}
