package gm.zona_fit.zona_fit.servicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import gm.zona_fit.zona_fit.Modelo.Cliente;
import gm.zona_fit.zona_fit.repositorio.ClienteRepositorio;


import java.util.List;

@Service
public class ClienteServicio implements IClienteServicio {
	
	@Autowired
	private ClienteRepositorio clienteRepositorio;
	
	
	
	
	@Override
	public List<Cliente> listarClientes(){
		List<Cliente> clientes = clienteRepositorio.findAll();
		
		return clientes;
	}
	@Override
	public Cliente buscarClientePorId(Integer idCliente) {
		Cliente cliente = clienteRepositorio.findById(idCliente).orElse(null);
		return cliente;
	}
	@Override
	public void guardarCliente(Cliente cliente) {
		clienteRepositorio.save(cliente);
		
	}
	@Override
	public void eliminarCliente(Cliente cliente) {
		clienteRepositorio.delete(cliente);
	}
}
