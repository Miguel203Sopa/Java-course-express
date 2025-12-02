package ProyectoSnacks;
import java.io.Serializable;
public class Snack implements Serializable {

	
	private int idSnack;
	private String nombre;
	private double precio;
	private static int contadorSnacks=0;
	
	public Snack(){
		this.idSnack = ++this.contadorSnacks;
	}
	
	public Snack(String nombre, double precio) 
	{
		this(); //esto llama al consttuctor vacio 
		//debe ser la primera llamada del constructor
		this.nombre = nombre;
		this.precio = precio;
		
	}
	
	public static int getContadorSnacks() {
		return contadorSnacks;
	}
	
	public int getIdSnack() {
		return this.idSnack;
	}
	
	public void setIdSnack(int idSnack) {
		this.idSnack = idSnack;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre= nombre;
	}
	
	public double getPrecio() {
		return this.precio;
	}
	
	public void setPrecio(double precio) {
		this.precio= precio;
		
	}
	
	
	@Override 
	public String toString() {
		return "Snack{"+
				"idSnack: "+this.idSnack+" "+
				"nombre: "+this.nombre +" "+
				"precio: "+this.precio+"}";
	}
	
	
	
	public static void main(String[] args) {
		

	}

}
