package ProyectoSnacks;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
public class MaquinaSnacks {

	public static void main(String[] args) {
		maquinaSnacks();

	}
	
	public static void maquinaSnacks() {
		var salir = false;
		Scanner console = new Scanner(System.in);
		List<Snack> productos = new ArrayList();
		System.out.println("*** Maquina de Snacks ***");
		Snacks.mostrarSnacks(); //mostrar inventario de snacks 
		while(!salir) {
			try {
				var opcion = mostrarMenu(console);
				salir = ejecutarOpciones(opcion ,console ,productos);
				
			}catch(Exception e) 
			{
				System.out.println("Ocurrio un error "+ e.getMessage());
			}
			finally {
				System.out.println();
			}
		}
	}
	
	
	private static int mostrarMenu(Scanner console) {
		System.out.println(""" 
				Menu:
				1.Comprar Snack
				2.Mostrar Ticket
				3.Agregar Nuevo Snack
				4.Saltar
				Elige una opcion:\s""");
		return Integer.parseInt(console.nextLine());
	}
	
	private static boolean ejecutarOpciones(int opcion, Scanner consola, List<Snack> productos ) {
		var salir = false;
		switch(opcion) 
		{
		case 1 -> comprarSnack(consola, productos);
		case 2 -> mostrarTicket(productos);
		case 3 -> agregarSnack(consola);
		case 4 -> salir = true;
		}
		return salir;
		
	}
	private static void comprarSnack(Scanner consola, List<Snack> productos) {
		System.out.println("Que snack quieres ?");
		var idSnack = Integer.parseInt(consola.nextLine());
		var snackEncontrado = false;
		for(var snack: Snacks.getSnacks()) 
		{
			if(idSnack == snack.getIdSnack()) {
				
				productos.add(snack);
				System.out.println("Ok, Snack agregado "+snack);
				snackEncontrado = true; 
				break;
				
			}
		}
		if(!snackEncontrado) {
			System.out.println("id de snack no encontrado"); 
			
		}
	}
	
	private static void mostrarTicket(List<Snack> productos) {
		var ticket = "*** Ticket de Venta ***";
		var total = 0.0;
		for(var producto:productos) {
			ticket += "\n\t-"+producto.getNombre()+ "- $"+producto.getPrecio();
			total += producto.getPrecio();
			
		}
		ticket +=  "\n\tTotal -> $"+total;
		System.out.println(ticket);
	}
	private static void agregarSnack (Scanner consola) {
		System.out.println("Escriba el nombre del snack");
		var nombre = consola.nextLine();
		System.out.println("Precio del snack");
		var precio=Double.parseDouble(consola.nextLine());
		Snacks.agregarSnack(new Snack(nombre,precio));
		System.out.println("Tu Snack se ha agregado correctamente");
		Snacks.mostrarSnacks();
		
		
	}
	
}
   