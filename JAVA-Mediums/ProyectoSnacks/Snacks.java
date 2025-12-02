package ProyectoSnacks;
import java.util.ArrayList;
import java.util.List;

public class Snacks {

	private static final List<Snack> snacks;
	
	
	//bloque estatico inicializador
	
	
	static {
		snacks =  new ArrayList();
		snacks.add(new Snack("papas",70));
		snacks.add(new Snack("Refresco",50));
		snacks.add(new Snack("Pancho",120));
	}
	
	public static void agregarSnack(Snack snack) {
		snacks.add(snack);
	}
	
	public static void mostrarSnacks() {
		var inventarioSnacks="";
		for (var snack:snacks) {
			inventarioSnacks += snack.toString() + "\n";
		}
		System.out.println("--------Snacks-en-el-inventario---------");
		System.out.println(inventarioSnacks);
	}
	
	
	public static List<Snack> getSnacks(){
		return snacks;
	}
	public static void main(String[] args) {
		

	}

}
