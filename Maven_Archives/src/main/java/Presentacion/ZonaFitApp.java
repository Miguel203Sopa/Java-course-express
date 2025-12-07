package Presentacion;
import java.util.Scanner;
import Modelo.ClienteDAO;
import Modelo.IClienteDAO;
import Modelo.Cliente;
import Modelo.Conexion;

public class ZonaFitApp {

	public static void main(String[] args) {
		zonaFitApp();

	}
	private static void zonaFitApp() {
		var salir = false;
		var consola = new Scanner(System.in);
		var clienteDao = new ClienteDAO();
		while(!salir) {
			
			try {
				int opcion = mostrarMenu(consola);
				salir=ejecutarOpciones(consola, opcion,clienteDao);
				
			}catch(Exception e) {
				System.out.println("error de conexion" + e.getMessage());
			}
			
		}
		
	}
	
	
	private static int mostrarMenu(Scanner consola) {
		System.out.println("--Zona Fit (GYM)"
				+"1. Listar Cliente"
				+" 2. Buscar Cliente"
				+" 3. Agregar Cliente"
				+" 4. Modificar Cliente"
				+" 5. Eliminar Cliente"
				+" 6. Salir"
				+" Elija una opcion"
				);
		return Integer.parseInt(consola.nextLine());
	}
	
	private static boolean ejecutarOpciones(Scanner consola, int opcion, IClienteDAO clienteDao){
		
		var salir = false;
		switch (opcion) {
		case 1:  
			System.out.println("--- Listado de clientes ---");
			var clientes = clienteDao.listarClientes();
			clientes.forEach(System.out::println);
			break;
		case 2:
			System.out.println("Introduce el id del cliente a buscar");
			int idCliente = Integer.parseInt(consola.nextLine());
			var cliente = new Cliente(idCliente);
			var encontrado = clienteDao.buscarClientePorId(cliente);
			if(encontrado) {
				System.out.println("Cliente encontrado "+cliente);
			}else {
				System.out.println("Cliente NO ENCONTRADO"+cliente);
			}
			
			break;
		case 3:
			System.out.println("----Agregar cliente----");
			System.out.print("Nombre: ");
			String nombre = consola.nextLine();
			System.out.print("Apellido: ");
			String apellido = consola.nextLine();
			System.out.println("Membresia: ");
			var membresia= Integer.parseInt(consola.nextLine());
			var cliente1 = new Cliente(nombre,apellido,membresia);
			var agregado = clienteDao.agregarCliente(cliente1);
			if(agregado) {
				System.out.println("Cliente agregado: "+cliente1);
			}else {
				System.out.println("El cliente no se pudo agregar"+cliente1);
			}
			break;
			
		case 4:
			System.out.println("---Modificar Cliente---");
			System.out.println("Id de Cliente");
			int idClienteM = Integer.parseInt(consola.nextLine());
			System.out.println("Nombre: ");
			String nombreM = consola.nextLine();
			System.out.println("Apellido:");
			String apellidoM = consola.nextLine();
			System.out.println("Membresia");
			var membresiaM = Integer.parseInt(consola.nextLine());
			var clienteM = new Cliente(idClienteM,nombreM,apellidoM,membresiaM);
			var modificado = clienteDao.modificarCliente(clienteM);
			if(modificado) {
				System.out.println("Cliente modificado: "+clienteM);
			}else {
				System.out.println("El cliente no se pudo modificar"+clienteM);
			}
			
			
			
			break;
			
			
		case 5:
			System.out.println("Eliminar cliente");
			System.out.println("Id cliente: ");
			var idClienteE = Integer.parseInt(consola.nextLine());
			var clienteE = new Cliente(idClienteE);
			var eliminado = clienteDao.eliminarCliente(clienteE);
			
			if(eliminado) {
				System.out.println("Cliente eliminado: "+clienteE);
			}else {
				System.out.println("El cliente no se pudo eliminado"+clienteE);
			}
			break;
		
		case 6:
			System.out.println("hasta pronto");
			salir = true;
			
		}
		
		
		
		
		return salir;
	}

}
