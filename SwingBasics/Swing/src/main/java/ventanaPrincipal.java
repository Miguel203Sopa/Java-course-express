import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;

public class ventanaPrincipal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		    JFrame ventana = new JFrame("Mi primera ventana");
	        ventana.setSize(400, 300);
	        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        ventana.setLayout(null);

	        JLabel label = new JLabel("Hola desde Swing");
	        label.setBounds(20, 20, 200, 30);
	        ventana.add(label);

	        JButton boton = new JButton("Click aquí");
	        boton.setBounds(20, 60, 120, 30);
	        ventana.add(boton);

	        ventana.setVisible(true);
	}

}
