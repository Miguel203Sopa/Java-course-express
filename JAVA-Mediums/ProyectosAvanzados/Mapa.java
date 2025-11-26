package ProyectosAvanzados;
import java.util.HashMap;
import java.util.Map;
public class Mapa {

	public static void main(String[] args) {
		Map<String,String> persona = new HashMap<>();
		//llave, valor asociado
		
		//es un diccionario
		//pero escrito de forma distinto
		//probablemente convertible a JSON
		persona.put("Nombre", "Diego");
		persona.put("Apellido", "Carranza");
		persona.put("edad", "32");
		//no se pueden duplicar campos
			
		
		//.entrySet() -> esto llama al campo y al dato al mismo tiempo
		//como imprimir diccionarios o sacar sus datos 
		persona.entrySet().forEach(System.out::println);
		
		//cuando escribes un campo de nuevo
		//solo estas sobreescribiendo la info
		//por lo tanto el volver a llamar un campo
		//lo modifica mas no lo duplica
		persona.put("edad", "22");
		persona.entrySet().forEach(System.out::println);
		persona.forEach( (llave,valor)->{
			System.out.println(llave+" "+valor);
		} );
		//de esta manera tambien podemos revisar de manera automatica
		//los campos esto gracias a las funciones lambda
		
	}

}
