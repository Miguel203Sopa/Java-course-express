
public class Subcadenas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String cadena1= "Hola mundo";
		System.out.println();
		
		
		String subcadena1 = cadena1.substring(0,4);
		System.out.println("subcadena1= "+subcadena1);
		var subcadena2 =cadena1.substring(5);
		
		
		
		//Busqueda de subcadenas
		//indexOf - Devuelve el indice de la primera aparicion de la subcadena
		String cadena2;
		cadena2 ="Webi Wabo";
		
		//subcadena a buscar
		int sub2cad1, sub2cad2;
		sub2cad1 = cadena2.indexOf("Wabo");
		System.out.println("indice= "+sub2cad1);
		
		//lastIndexOf devuelve el indice de la ultima aparicion de la subcadena
		sub2cad2 =cadena2.lastIndexOf("Webi");
		System.out.println("indicel= "+sub2cad2);
		
		var CC= new StringBuilder();
		CC.append("hola").append(" como ").append("te va?");
		CC.toString();
		System.out.println(CC);
		
		var SB= new StringBuffer();
		SB.append("OZYMANDIAS");
		SB.toString();
		System.out.println(SB);
		
		String.join("La ","Historia ","Se ","Eleva");
		
		//caracteres especiales
		// \n - imprime salto de linea
		// \t - tabulador de texto
		// \' agrega comillas simples a una cadena
		// \" - agrega comilla doble a una cadena
		// \\ - agrega una barra invertida a una cadena
		
		
		
		
		
		
		
		
	}

}
