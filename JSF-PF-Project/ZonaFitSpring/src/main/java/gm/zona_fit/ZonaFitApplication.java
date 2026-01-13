package gm.zona_fit;
import java.util.List;
import java.util.Scanner;
import gm.zona_fit.servicio.IClienteServicio;
import gm.zona_fit.modelo.Cliente;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
public class ZonaFitApplication implements CommandLineRunner {

	@Autowired
	private IClienteServicio clienteServicio;

	private static final Logger logger = LoggerFactory.getLogger(ZonaFitApplication.class);

	String nl= System.lineSeparator();

	public static void main(String[] args) {

		logger.info("Iniciando la aplicación");
		//fabrica de spring
		SpringApplication.run(ZonaFitApplication.class, args);

		logger.info("aplicacion finalizada");
	}
	@Override
	public void run(String... args) throws Exception {

		zonaFitApp();
	}

	private void zonaFitApp(){

		var salir = false;
		Scanner console = new Scanner(System.in);
			while(!salir){
				var opcion = mostrarMenu(console);
				salir = ejecutarOpciones(console,opcion);
				logger.info(nl);
			}
		}
	private int mostrarMenu(Scanner console){

		logger.info("""  
		*** Zona Fit Gym Application ***
			1. Listar Clientes
			2. Buscar Clientes
			3. Agregar Cliente
			4. Modificar Cliente
			5. Eliminar Cliente
			6. Salir del Menu
			Elige una opcion\s""");
		var opcion = Integer.parseInt(console.nextLine());
		return opcion;
	}

	private boolean ejecutarOpciones(Scanner console, int opcion){
		var salir = false;
		switch (opcion){
			case 1:
				logger.info(nl+"Listado Clientes"+nl);
				List<Cliente> clientes = clienteServicio.listarClientes();
				clientes.forEach(cliente -> logger.info(cliente.toString() ));
				break;
			case 2:
				logger.info(nl+"Buscar Cliente por ID"+nl);
				var idCliente = Integer.parseInt(console.nextLine());
				Cliente cliente = clienteServicio.buscarClientePorId(idCliente);
				if(cliente != null){
					logger.info("Cliente encontrado: "+cliente+nl);
				}else{
					logger.info("Cliente no encontrado "+cliente+nl);
				}

				break;
			case 3:
				logger.info("Agregar Cliente----------");
				logger.info("Nombre: ");
				var nombre = console.nextLine();
				logger.info("Apellido: ");
				var apellido = console.nextLine();
				logger.info("Membresia: ");
				var membresia = Integer.parseInt(console.nextLine());

				var clienteA = new Cliente();
				clienteA.setNombre(nombre);
				clienteA.setApellido(apellido);
				clienteA.setMembresia(membresia);
				clienteServicio.guardarCliente(clienteA);
				logger.info("Cliente agregado "+clienteA+nl);


				break;
			case 4:
				logger.info("---Modificar Cliente---");
				logger.info("idCliente");
				var idClienteM =Integer.parseInt(console.nextLine());
				Cliente clienteM = clienteServicio.buscarClientePorId(idClienteM);
			    if(clienteM != null ){
					logger.info("Nombre: ");
					var nombreM = console.nextLine();
					logger.info("Apellido: ");
					var apellidoM = console.nextLine();
					logger.info("Membresia: ");
					var membresiaM = Integer.parseInt(console.nextLine());
					clienteM.setNombre(nombreM);
					clienteM.setApellido(apellidoM);
					clienteM.setMembresia(membresiaM);
					clienteServicio.guardarCliente(clienteM);
					logger.info("Cliente modificado: "+clienteM+nl);
				}else{
					logger.info("Cliente no encontrado ");
				}
				break;
			case 5:
				logger.info("---Eliminar Cliente ---");
				logger.info("Id Cliente: ");
				var idClienteE=Integer.parseInt(console.nextLine());
				var clienteE = clienteServicio.buscarClientePorId(idClienteE);
				if(clienteE != null){
					clienteServicio.eliminarCliente(clienteE);
					logger.info("El cliente fue eliminado");
				}else{logger.info("Cliente no encontrado para eliminar");}
				break;
			case 6:
				logger.info("que le vaya bien");
				salir = !salir;

				break;
			default:
				logger.info("Elija una opcion existente");
				break;

		}
		return salir;
	}
}
