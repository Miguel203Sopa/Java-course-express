package ejemplosM;

public class Aritmetica {
	
	
	//sobrecarga de constructores es tener dos o mas constructores
	
	public Aritmetica(int valorA, int valorB) {
		System.out.println("llamando constructor");
		this.valorA =valorA;
		this.valorB= valorB;
	} //constructor permite llamar la clase tiene que llamarse igual que la clase
	
	public Aritmetica () {}
	//las sobrecargas nos permite inicializar una clase de distintas maneras
	
	
	
	
	int valorA;
	int valorB;
	
	void suma() {
		var result= this.valorA+this.valorB;
		System.out.println("la suma es "+result);
	}
	
	void resta() {
		var result= this.valorA - this.valorB;
		System.out.println("la resta es "+result);
	}

	//this se usa para referenciar propiedades de la clase dentro de la clase para no confundirlas  con otras variables  o parametros
	//en la clase
	public static void main(String[] args) {
		
		Aritmetica opera1 = new Aritmetica(5,4);
		Aritmetica opera2 = new Aritmetica(3,2);
		Aritmetica opera3 = new Aritmetica();
		//opera1.valorA =2;
		//opera1.valorB =3;
		opera1.suma();
		opera1.resta();

		//opera2.valorA=5;
		//opera2.valorB=4;
		opera2.suma();
		opera2.resta();
		System.out.println("direccion de memoria "+opera1);
	

	}

}
