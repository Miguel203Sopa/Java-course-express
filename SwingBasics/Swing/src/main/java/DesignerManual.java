import java.awt.BorderLayout;
import com.formdev.flatlaf.*;
import javax.swing.*;


public class DesignerManual extends JFrame{

	private JPanel panel1 = new JPanel();
	
	public DesignerManual() {
		inicializarForma();
	} 
	
	private void inicializarForma() {
		setContentPane(panel1);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600,400);//setSize (ancho, alto)
		setLocationRelativeTo(null);
	}
	
	public static void main(String[] args) {
		FlatDarculaLaf.setup(); //pone modo oscuro
		
		
		DesignerManual DS = new DesignerManual();
		DS.setVisible(true);
		
		JLabel lblNewLabel = new JLabel("Hola mundo");
		DS.getContentPane().add(lblNewLabel, BorderLayout.SOUTH);
		

	}

}
