package ProyectosAvanzados;

public class ClaseAbstracta {

	
	public static void main(String[] args) {
		//FiguraGeometrica figuraGeometrica = new FiguraGeometrica();
		FiguraGeometrica figura = new Rectangulo();
		figura.dibujar();
	}

}

abstract class FiguraGeometrica{
	public abstract void dibujar();
	//no se puede instanciar
}

class Rectangulo extends FiguraGeometrica{
	 @Override
	public void dibujar() {
		System.out.println("Yo dibujo un rectangulo");
	}
}
