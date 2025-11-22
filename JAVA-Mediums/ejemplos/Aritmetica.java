package ejemplos;

public class Aritmetica {
	
	int valorA;
	int valorB;
	
	void suma() {
		var result= valorA + valorB;
		System.out.println("la suma es "+result);
	}
	
	void resta() {
		var result= valorA - valorB;
		System.out.println("la resta es "+result);
	}

	public static void main(String[] args) {
		
		Aritmetica opera1 = new Aritmetica();
		Aritmetica opera2 = new Aritmetica();
		
		opera1.valorA =2;
		opera1.valorB =3;
		opera1.suma();
		opera1.resta();

		opera2.valorA=5;
		opera2.valorB=4;
		opera2.suma();
		opera2.resta();

	}

}
