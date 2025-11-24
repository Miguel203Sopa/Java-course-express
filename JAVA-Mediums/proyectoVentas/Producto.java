package proyectoVentas;

public class Producto {

	private final int idProducto;
	private String nombre;
	private double precio;
	private static int contadorProductos;
	
	public Producto(String nombre, double precio ){
		this.idProducto = ++Producto.contadorProductos;
		this.nombre = nombre;
		this.precio = precio;
	}
	
	public int getIdProducto() {
		return idProducto;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public double getPrecio() {
		return this.precio;
	}
	
	public void setPrecio(double precio ) {
		this.precio =precio;
	}
	
	public String toString() {
		return "Producto{"+
				"idProducto: "+this.idProducto+","+
				"nombre: "+this.nombre+","+
				"precio: "+this.precio+
				"}";
	}
	
	
	public static void main(String[] args) {
	}

}
