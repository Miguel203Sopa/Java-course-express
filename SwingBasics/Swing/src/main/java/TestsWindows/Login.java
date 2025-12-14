package TestsWindows;
import com.formdev.flatlaf.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;

public class Login {

	private JFrame frame;
	private JTextField userText;
	private JPasswordField passText;
	JPanel panel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		FlatDarculaLaf.setup();
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel Titulo = new JLabel("LOGIN");
		Titulo.setBounds(193, 44, 39, 15);
		Titulo.setFont(new Font("Times New Roman", Font.BOLD, 12));
		panel.add(Titulo);
		
		JLabel userLabel = new JLabel("Usuario:");
		userLabel.setBounds(68, 77, 75, 14);
		panel.add(userLabel);
		
		JLabel passLabel = new JLabel("Contraseña:");
		passLabel.setBounds(68, 128, 91, 14);
		panel.add(passLabel);
		
		userText = new JTextField();
		userText.setBounds(169, 74, 172, 21);
		userText.setColumns(10);
		panel.add(userText);
		
		JButton btnSend = new JButton("Enviar");
		btnSend.addActionListener(e-> {
			validar();
		});
		btnSend.setBounds(361, 227, 63, 23);
		panel.add(btnSend);
		
		passText = new JPasswordField();
		passText.setBounds(169, 125, 172, 20);
		panel.add(passText);
	}
	
	private void validar() {
		String usuario = this.userText.getText();
		String password = this.passText.getPassword().toString();
		
		if( "root".equals(usuario) && "12345".equals(password)) {
			mostrarMensaje("Datos correctos, bienvenido");
			
		}else if("root".equals(usuario)){
			mostrarMensaje("Contraseña incorrecta");
			
		}else if("12345".equals(password)){
			mostrarMensaje("Nombre incorrecto ");
		}else {
			mostrarMensaje("Datos erroneos, reviselos");
		}
		
		
		
	}
	
	private void mostrarMensaje(String Mensaje) {
		JOptionPane.showMessageDialog(frame,Mensaje);
	}
}
