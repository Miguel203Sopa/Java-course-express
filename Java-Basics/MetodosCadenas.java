/**
 * 
 */

/**
 * 
 */
public class MetodosCadenas {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//largo de cadenas
		String cadena1, cadena2, cadena3, cadena4, cadena5;
		int longitud;
		cadena1= "   Sopiencio   ";
		longitud = cadena1.length();
		
		System.out.println("la cantidad de caracteres de la cadena es "+longitud);
		
		//reemplazo de cadenas
		cadena2 = cadena1.replace('o','a');
		System.out.println("la nueva cadena es "+cadena2);
		
		//mayusculas
		cadena3 = cadena1.replace('o','a').toUpperCase();
		System.out.println("la nueva cadena es "+cadena3);
		
		//minusculas
		cadena4=  cadena1.replace('o','a').toLowerCase();
		System.out.println("la nueva cadena es "+cadena4);
		
		
		//elimina espacios
		cadena5 = cadena1.replace('o','a').trim();//esto solo elimina los espacios al inicio y al final
		System.out.println("la nueva cadena es "+cadena5);
		
		
		//formateo de cadenas 
		
		String nombreF = "Mateooooooo";
		var edadF = 34;
		var salario = 2199.22;
		// El argumento de la derecha se sustituira donde esta %s
		var mensaje = String.format("Nombre: %s, edad: %s", nombreF, edadF); 
		
		
		
		
	}

}
