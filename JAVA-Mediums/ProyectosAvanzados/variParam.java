package ProyectosAvanzados;

public class variParam {

	
	public static void Comida(String comida, int...precios) {
		
		System.out.println("Comida: "+comida);
		for(int i=0; i<precios.length;i++) {
			System.out.println("precio de la comida: "+precios[i]);
		}
	}
	
	public static void main(String[] args) {
		Comida("Taco",3,5,1,7,0,9);

	}

}
