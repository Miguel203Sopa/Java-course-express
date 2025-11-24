package proyectoVentas;

public class PruebaVentas {

	
	public static void main(String[] args) {
		System.out.println("Sistema de ventas");
		var producto1 = new Producto("Zapato",25.00);
		var producto2 = new Producto("Camisa",15.00);
		System.out.println(producto1);
		
		
		Orden orden1 = new Orden();
		orden1.agregarProducto(producto1);
		orden1.agregarProducto(producto2);
		orden1.mostrarOrden();
		
		var orden2 = new Orden();
		orden2.agregarProducto(producto2);
		orden2.agregarProducto(new Producto("chanclas",10));
		orden2.mostrarOrden();
		
		
	}
}
