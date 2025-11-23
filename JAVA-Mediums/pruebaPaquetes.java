public class pruebaPaquetes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ejemplosM.Aritmetica operacion = new ejemplosM.Aritmetica();
		operacion.valorA= 2;
		operacion.valorB=3;
		operacion.suma();
		operacion.resta();
		
		Encapsulamiento Lata =new Encapsulamiento(5,7);
		System.out.println("op1: "+Lata.getOperando1());
		System.out.println("op2: "+Lata.getOperando2());
		Lata.setOperando1(2);
		Lata.setOperando2(10);
		System.out.println("op1: "+Lata.getOperando1());
		System.out.println("op2: "+Lata.getOperando2());
		

	}

}
