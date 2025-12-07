package Modelo;

public class Cliente {

	private int id;
	private String nombre;
	private String apellido;
	private int membresia;
	
	
	public Cliente(){
		
	}
	
	
	public Cliente(int id){
		this.id = id;
	
	}
	
	public Cliente(String nombre, String apellido, int membresia) 
	{
		this.nombre = nombre;
		this.apellido = apellido;
		this.membresia = membresia;
		
	}
	
	public Cliente(int id, String nombre, String apellido, int membresia) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.membresia = membresia;
	}
	
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	
	public String getNombre() {
		return this.nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellido() {
		return this.apellido;
	}
	
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public int getMembresia() {
		return this.membresia ;
	}
	
	public void setMembresia(int membresia) {
		this.membresia = membresia;
	}
	
	@Override 
	public String toString() 
	{
		return "Cliente{"+
		"id: "+id+" "+
		",nombre: "+nombre+ " "+
		",apellido: "+apellido+ " "+
		",membresia: "+membresia+ "}";
	}
	
	public static void main(String[] args) {
	
	}

}

