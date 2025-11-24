package Herencia;

public class Animal {
	
	Animal(){}
	
	
	protected void comer() {
		System.out.println("Hartarse");
	}
	
	protected void dormir() {
		System.out.println("Petatiarse");
	}
	
	protected void Ruido() {
		System.out.println("AHHHHH");
	}

}
//sobreescritura de metodos
class Perro extends Animal{
	public void hacerSonido(){
		System.out.println("Woof");
		//vivan las onomatopeyas
		
	}
	@Override 
	protected void dormir() {
		System.out.println("duermo 15 hrs al dia");
		super.dormir();
	//ahora perro llamara este metodo
	// en vez del heredado
		}
	
	protected void Ruido() {
		System.out.println("WOOOOOOOOOFFFFFFFF");
	}

}

class Gato extends Animal{
	
	protected void Ruido() {
		System.out.println("MIAUUUUUUUU");
	}

}



class PruebaAnimal{
	
	//metodo polimorfico
	static void imprimirSonido(Animal animal) {
		animal.Ruido();
	}
	
	
	
	
	public static void main(String[] args) {
		System.out.println("Ejemplo de Herencia");
		System.out.println("clase padre, Animal");
		var animal1 = new Animal(); //clase padre
		var perro1 = new Perro();
		var gato1 = new Gato();
		//clase padre
		animal1.comer();
		animal1.dormir();
		System.out.println("clase Hija, Perro");
		//clase Hija
		perro1.comer();
		perro1.dormir();
		perro1.hacerSonido();
		
		
		System.out.println("Ejemplo de polimorfismo");
		imprimirSonido(animal1);
		imprimirSonido(perro1);
		imprimirSonido(gato1);
		
	}
	
	
}