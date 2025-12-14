package TestsWindows;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.TextArea;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JTree;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JTextArea;
import javax.swing.JPasswordField;

public class Test1 {

	private JFrame frame;
	private JTextField textField_4;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test1 window = new Test1();
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
	public Test1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panelRegistro = new JPanel();
		frame.getContentPane().add(panelRegistro, BorderLayout.EAST);
		
		JTree tree = new JTree();
		panelRegistro.add(tree);
		
		JPanel panelMiscelaneo = new JPanel();
		frame.getContentPane().add(panelMiscelaneo, BorderLayout.WEST);
		
		Box horizontalBox = Box.createHorizontalBox();
		panelMiscelaneo.add(horizontalBox);
		
		Box verticalBox_4 = Box.createVerticalBox();
		horizontalBox.add(verticalBox_4);
		
		Box verticalBox_5 = Box.createVerticalBox();
		verticalBox_4.add(verticalBox_5);
		
		JLabel lblNewLabel_1_2 = new JLabel("New label");
		verticalBox_5.add(lblNewLabel_1_2);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		verticalBox_5.add(textField_4);
		
		Box verticalBox_1_2 = Box.createVerticalBox();
		verticalBox_4.add(verticalBox_1_2);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		verticalBox_1_2.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		verticalBox_1_2.add(textField);
		
		JButton btnNewButton = new JButton("New button");
		verticalBox_4.add(btnNewButton);
		
		Box verticalBox = Box.createVerticalBox();
		horizontalBox.add(verticalBox);
		
		JLabel lblNewLabel = new JLabel("New label");
		verticalBox.add(lblNewLabel);
		
		textField_1 = new JTextField();
		verticalBox.add(textField_1);
		textField_1.setColumns(10);
		
		JPanel panelDocumentos = new JPanel();
		frame.getContentPane().add(panelDocumentos, BorderLayout.CENTER);
		
		Box verticalBox_1 = Box.createVerticalBox();
		panelDocumentos.add(verticalBox_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		verticalBox_1.add(lblNewLabel_2);
		
		JTextArea textArea = new JTextArea();
		verticalBox_1.add(textArea);
		
		passwordField = new JPasswordField();
		verticalBox_1.add(passwordField);
		
		JButton btnEnvio1 = new JButton("New button");
		panelDocumentos.add(btnEnvio1);
		
		JLabel tituloGeneral = new JLabel("Prueba 1 usando Swing");
		frame.getContentPane().add(tituloGeneral, BorderLayout.NORTH);
	}

}
