
public class funcionesLetsGo {
	
	//si la funcion no va a
	//regresar valores entonces se 
	//escribe la palabra "void"
	
	//   nombre(parametro){argumento}
	static void funIntro(String mensaje) {
		System.out.println(mensaje);
	} 
	
	static void suma(double a, double b) 
	{
		System.out.println("la suma de los valores es: "+(a+b));
		
	}
	
	
	static void funRecursiva(int numero) {
		
		if (numero ==1) {
			System.out.print(numero+" ");
		}else {
			
			funRecursiva(numero-1);
			System.out.println(numero + " ");
		}
	}
	


	public static void main(String[] args) {
		
		funIntro("hello that");
		suma(2,3);
		funRecursiva(5); //
	}

	
	//funciones recursivas
	
	// 1. se debe llamar asi misma en su ejecucion
	// 2. debe avanzar hacia un caso base para evitar ciclos infinitos
	// 3. 
}
