package retosM;

//clase object practica
public class retoPersona {
	
	private String nombre;
	private String apellido;
	// los atributos estaticos podemos asignarles
	//un valor de un solo 
	private static int contadorPersonas = 0;
	private int idPersona;
	
	retoPersona(){}
	
	retoPersona(String nombre, String apellido) {
		this.nombre=nombre;
		this.apellido=apellido;
		//this.contadorPersonas++;
		this.idPersona = ++retoPersona.contadorPersonas;
	}
	@Override
	public String toString() 
	{
		return "su Id es "+this.idPersona+" Nombre: "+this.nombre+" apellido: "+apellido;
	}
	

	
	void mostrarPersona() {
		System.out.println(this.nombre);
		System.out.println(this.apellido);
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
	
	public int getIdPersona() {
		return this.idPersona;
	}
	
	

	public static void main(String[] args) {
		System.out.println("creacion de clase y objetos persona");
		var objeto1 = new retoPersona("layla","acosta");
		var objeto2 = new retoPersona("carlos","Hernandez");
		var objeto3 = new retoPersona("Samuel","Luz");
		
		//System.out.println(objeto1.toString());
		System.out.println(objeto1);
		System.out.println(objeto2);
		System.out.println(objeto3);
		System.out.println(retoPersona.contadorPersonas);
		
		

	}

}
