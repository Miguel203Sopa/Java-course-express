
public class Encapsulamiento {
	
	private int operando1;
	private int operando2;
	
	
	Encapsulamiento(){}
	
	Encapsulamiento(int operando1, int operando2) {
		this.operando1=operando1;
		this.operando2=operando2;
	}
	
	void multiplicacion() {
		System.out.println("multiplicacion: "+(operando1*operando2));
	}
	
	void division() {
		Double result =(double)(operando1/operando2);
		System.out.println("multiplicacion: "+result);
	}
	
	public int getOperando1() {
		return this.operando1;
	}
	
	public void setOperando1(int operando1) {
		this.operando1 = operando1;
	}
	
	public int getOperando2() {
		return this.operando2;
	}
	
	public void setOperando2(int operando2) {
		this.operando2 = operando2;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
