import java.util.Random;

public class NumAleatorios {

	public static void main(String[] args) {
		
	Random Alea = new Random();
	
	var numero = Alea.nextInt(10); //numero aleatorio entre 0y9
	System.out.println("el numero es "+numero);
	
	var num = numero+Alea.nextInt(10);
	System.out.println("la suma de dos numeros aleatorios es"+num);
	
	var numF = Alea.nextFloat(4.5f);
	System.out.println("el numero flotante es "+numF);
	
	

	}

}
