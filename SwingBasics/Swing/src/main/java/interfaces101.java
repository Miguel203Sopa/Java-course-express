import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class interfaces101 extends JFrame{

	private JFrame frame;
	private JPanel panel1 = new JPanel();
	private JTextField CampoText1;
	private JTextField CampoText2;
	private JTextField CampoText3;
	private JTable table;
	private JLabel LabelPrueba;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					interfaces101 window = new interfaces101();
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
	public interfaces101() {
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setContentPane(panel1);
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("New label");
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		LabelPrueba = new JLabel("New label");
		LabelPrueba.setBounds(93, 38, 46, 14);
		panel_1.add(LabelPrueba);
		
		CampoText1 = new JTextField();
		CampoText1.addKeyListener(new KeyAdapter() {
			  @Override
			public void keyTyped(KeyEvent e) {
				  super.keyTyped(e);
				  replicarTexto();
			}
		});
		CampoText1.addActionListener(e ->{
			//replicarTexto();
		});
		
		
		
		//componentes
		
		CampoText1.setBounds(148, 35, 86, 20);
		panel_1.add(CampoText1);
		CampoText1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(93, 72, 46, 14);
		panel_1.add(lblNewLabel_2);
		
		CampoText2 = new JTextField();
		CampoText2.setBounds(148, 69, 86, 20);
		panel_1.add(CampoText2);
		CampoText2.setColumns(10);
		
		CampoText3 = new JTextField();
		CampoText3.setBounds(148, 111, 86, 20);
		panel_1.add(CampoText3);
		CampoText3.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(93, 114, 46, 14);
		panel_1.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(335, 203, 89, 23);
		panel_1.add(btnNewButton);
		
		table = new JTable();
		table.setBounds(354, 86, 1, 1);
		panel_1.add(table);
	}
	
	private void replicarTexto() {
		String Texto = this.CampoText1.getText();
		this.LabelPrueba.setText(Texto);
		
		
	}
	
}
