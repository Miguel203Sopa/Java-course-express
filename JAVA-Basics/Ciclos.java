import java.util.Scanner;

public class Ciclos {

	public static void main(String[] args) {
		
		Scanner console = new Scanner(System.in);
		var contador = 1;
		while (contador <= 5) {
			
			System.out.println("su numero es "+contador);		
			contador++;
		}
		
		
		while(contador <= 20) {
			if(contador % 2== 0) {
				System.out.println("el numero par es "+contador);
				
			}
			contador++;
		}
		
		
		//ciclo do while
		
		//me complique un poco pero en resumen esto hace que cualquier numero que escribas tienda hacia "a"
		//independientemente del numero "i"
		// un do while ejecuta primero el codigo y crea el ciclo while posteriormente solo si se cumple la condicion
		
		int i,a;
		System.out.println("Escriba el limite que le pondra numero:");
		a = Integer.parseInt(console.nextLine());
		System.out.println("Escriba un numero cualquiera");
		i = Integer.parseInt(console.nextLine());
		do {
			
			if(i>=-a && i < 0) {
				System.out.println("saliendo de los negativos, su numero es"+i);
				i++;
			}else if(i>=0 && i<=a) {
				System.out.println("lleguemos al " +a+ " compañero, su numero es "+i);
				i++;
			}else if (i>a) {
				
				while (i>a) {   
					System.out.println("volveremos al camino correcto tardara pero llegaremos tu numero es "+i);
					i--;}
			}else if(i<-a) {
				while(i<-a) {
					System.out.println("saldremos de este agujero juntos, tu numero es "+i);
					i++;
				}
				
			}else {
				System.out.println("Valor invalido lo siento busca otro camino este no es el correcto ");
			}
			
	
		}while(i>=-a && i<=a);

		
		//ciclo for en java
		
		for(int cont= 0;cont<10;i++) 
		{
			
			
		}
	}

}
