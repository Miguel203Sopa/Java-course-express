
public class RetoSumaInclinada {

	public static void main(String[] args) {
	
		
		var sumaMatriz = new int[][] {
			{100,200,300},
			{400,500,600},
			{700,800,900}
		};
		int SUMA = 0;
		
		for( var ren =0; ren < sumaMatriz.length;ren++){
			for(var col =0;col<sumaMatriz[ren].length;col++) {
				if( ren == col ) {
					SUMA += sumaMatriz[ren][col];
				}else {
					continue;
				}
				
			}
		}
		
		System.out.println("La suma de los valores en diagonal es "+SUMA);
		
	}
	

}
