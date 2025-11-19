import java.util.Scanner;
public class RetoTienda {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		String nombre, opcionVista;
		int dias;
		Boolean Vista;
		double sinVista, conVista, costoHotel;
		sinVista = 150.50;
		conVista = 190.50;
		
		Scanner console = new Scanner(System.in);
		
		
		System.out.println("Hotel Green dolphin");
		System.out.println("Escribe tu nombre");
		nombre = console.nextLine();
		
		System.out.println("Escribe los dias de tu estadia en el hotel");
		dias = Integer.parseInt(console.nextLine());
		
		System.out.println("Quiere una habitacion con vista al mar? (si/no)");
		opcionVista = console.nextLine();
		
		System.out.println(opcionVista);
		
		//siempre usa .equals para comparar textos
		//en es especial equalsIgnoreCase es lo mismo que el anterior pero ignora mayusculas y minusculas 
		// == solo sirve para comparar referencias de memoria
		
		if(opcionVista.equalsIgnoreCase("si") || opcionVista.equalsIgnoreCase("s")  ) {
			costoHotel = dias*conVista;
			System.out.println("El cliente "+nombre+" el costo total de su estancia de"+dias+"dias en el hotel sera de "+costoHotel);
			
		}else if(opcionVista.equalsIgnoreCase("no") || opcionVista.equalsIgnoreCase("n") ){
			
			costoHotel =dias*sinVista;
			System.out.println("El cliente "+nombre+" el costo total de su estancia de"+dias+"dias en el hotel sera de "+costoHotel);
			
		}
		
	}
		
		
		
		
	

	}


