package ProyectosAvanzados;
import java.util.Set;
import java.util.TreeSet;

public class Sets {

	public static void main(String[] args) {
		
		Set<String> conjunto = new TreeSet<String>();
		conjunto.add("Carlos");
		//conjunto.add("Carlos");
		conjunto.add("Victor");
		conjunto.add("Charlos");
		
		conjunto.remove("Charlos");
		System.out.println("\nNuevos Elementos del Set");
		conjunto.forEach(System.out::println);
		
	}

}
