
public class retoEmailGeneradorBasic {

	public static void main(String[] args) {
		
		String Nombre,Empresa,Dominio;
		Nombre = "Jose Miguel Vega Guevara";
		Empresa= "Universidad Don Bosco";
		Dominio= "com sv";
		
		String ep1,ep2,ep3;
		ep1 = Nombre.replace(' ','.').toLowerCase();
		ep2 = Empresa.strip().replace(' ','.').toLowerCase();
		ep3 = Dominio.replace(' ','.').toLowerCase();
		String email = ep1+"@"+ep2+"."+ep3;
		System.out.println(email);
		//.strip() elimina los espacios en blanco

	}

}
