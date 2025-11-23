package Herencia;

public class Animal {
	
	Animal(){}
	
	
	protected void comer() {
		System.out.println("Hartarse");
	}
	
	protected void dormir() {
		System.out.println("Petatiarse");
	}

}
//sobreescritura de metodos
class Perro extends Animal{
	public void hacerSonido(){
		System.out.println("Woof");
		//vivan las onomatopeyas
		
	}
	@Override 
	protected void dormir() {System.out.println("duermo 15 hrs al dia");} 
	//ahora perro llamara este metodo
	// en vez del heredado
	
	
}

class PruebaAnimal{
	public static void main(String[] args) {
		System.out.println("Ejemplo de Herencia");
		System.out.println("clase padre, Animal");
		var animal1 = new Animal(); //clase padre
		var perro1 = new Perro();
		
		//clase padre
		animal1.comer();
		animal1.dormir();
		System.out.println("clase Hija, Perro");
		//clase Hija
		perro1.comer();
		perro1.dormir();
		perro1.hacerSonido();
		
		
	}
}
