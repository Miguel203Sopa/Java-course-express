package ProyectosAvanzados;

public interface Traductor {
	
	void traducir(); //abstracto

	
	default void iniciarTraductor() {
		System.out.println("iniciando traductor");
	}
	
}

class Ingles implements Traductor{
	public void traducir(){
		System.out.println("traduciendo jajaj");
	}
}

class PruebaTraductor{
	public static void main(String[] args) {
		Traductor ingles = new Ingles();
		ingles.traducir();
	}
}