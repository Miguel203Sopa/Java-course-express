import java.util.Scanner;
public class ArraysWe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner console = new Scanner(System.in);
		//arreglos sintaxis
		int[] Notas =new int[2];
		int[] Calificaciones = {2,3,4};
		
		Notas[0] =2;
		
		
		
		//MATRICES AAAA
		
		var matriz = new int[2][3];
		matriz [0][0]=100;
		
		var matrizEjemploWe= new int[][] {
		//    0   1   2
			{100,200,300}, //0 -> 0,0  0,1  0,2
			{255,144,133}, //1 -> 1,0  1,1  1,2
			{333,123,244}  //2 -> 2,0  2,1  2,2
		};
		
		//int filas,columnas;
		//filas = matrizEjemploWe[0].length;
		
		for( var ren =0; ren < matrizEjemploWe.length;ren++){
			for(var col =0;col< matrizEjemploWe[ren].length;col++) {
				System.out.println("valor["+ren+"]["+col+"]= "+matrizEjemploWe[ren][col]);
			}
		}
		
		//introducir valores en la matriz
		int filas,columnas;
		System.out.println("Escriba las filas que tendra la matriz");
		filas = Integer.parseInt(console.nextLine());
		System.out.println("Escriba las columnas que tendra la matriz");
		columnas = Integer.parseInt(console.nextLine());
		
		var matrizHecha= new int[filas][columnas];
		for( var ren =0; ren < filas;ren++){
			for(var col =0;col<columnas;col++) {
				System.out.println("Escriba el valor["+ren+"]["+col+"]:");
				matrizHecha[ren][col]= Integer.parseInt(console.nextLine());
				
			}
		}
		
		
		
		
		
		
	}

}
