package gm.zona_fit.zona_fit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.ILoggerFactory;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import gm.zona_fit.zona_fit.repositorio.*;
import gm.zona_fit.zona_fit.Modelo.*;
import gm.zona_fit.zona_fit.servicio.*;
import java.util.Scanner;
import java.util.List;

@SpringBootApplication
public class ZonaFitApplication implements CommandLineRunner {

	@Autowired
	private IClienteServicio clienteServicio;
	
	private static final Logger logger = LoggerFactory.getLogger(ZonaFitApplication.class); 
	
	String nl = System.lineSeparator();
	
	public static void main(String[] args) {
		logger.info("Iniciando la aplicacion");
		//levantar la fabrica de spring, esta onda es necesaria
		SpringApplication.run(ZonaFitApplication.class, args);
		logger.info("Finalizando la aplicacion");
		
	}
	
	public void run(String... args) throws Exception{
		//el nuevo metodo main
		logger.info("*** Aplicacion Zona Fit ***");
		zonaFitApp();
	}
	
	private void zonaFitApp() {
		logger.info(nl+"--- Aplicacion Zona Fit (GYM) ---");
		Boolean salir = false;
		Scanner console = new Scanner(System.in);
		while(!salir) {
			var opcion = mostrarMenu(console);
			salir = ejecutarOpciones(console, opcion);
			logger.info(nl);
		}
		
	}
	
	private int mostrarMenu(Scanner console) {
		
		logger.info(""" 
				1. Listar Clientes
				2. Buscar Clientes
				3. Agregar Clientes
				4. Modificar Clientes
				5. Eliminar Clientes
				6. Salir de la Aplicacion
				Elige una opcion: \s""");
		
		
		return Integer.parseInt(console.nextLine());
		
	}
	
	private Boolean ejecutarOpciones(Scanner console, int opcion) {
		
		
		switch(opcion) {
		case 1:
			logger.info(nl+"---listado de Clientes --- "+nl);
			List<Cliente> clientes = clienteServicio.listarClientes();
			clientes.forEach(cliente ->logger.info(cliente.toString()));
			
		
			break;
		case 2:
			logger.info(nl +"--- Buscar Cliente por Id ---"+nl);
			var idCliente = Integer.parseInt(console.nextLine());
			Cliente client =clienteServicio.buscarClientePorId(idCliente);
			
			if(client != null) {
				logger.info("Cliente encontrado "+client+nl);
				
			}else {
				logger.info("Cliente NO encontrado "+client+nl);

			}
			
			break;
		case 3:
			logger.info("--- Agregar Estudiante ---"+nl);
			
			
			break;
		case 4:
			
			
			break;
		case 5:
			break;
		case 6:
			
			return true;
			
		default:
			
			break;
		}
		
		
		
		return false;
	}
	
	

}
