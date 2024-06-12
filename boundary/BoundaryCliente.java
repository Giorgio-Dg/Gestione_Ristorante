package boundary;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.ControllerCliente;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JScrollBar;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;

public class BoundaryCliente extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BoundaryCliente frame = new BoundaryCliente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame..
	 */
	public BoundaryCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome Piatto");
		lblNewLabel.setBounds(41, 14, 99, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblQuantita = new JLabel("Quantita'");
		lblQuantita.setBounds(306, 14, 90, 14);
		contentPane.add(lblQuantita);
		
		textField = new JTextField();
		textField.setBounds(287, 39, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		ArrayList<String> menu = ControllerCliente.VisualizzaMenu();
		
		JLabel lblNewLabel_1 = new JLabel(menu.get(0));
		lblNewLabel_1.setBounds(41, 42, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel(menu.get(1));
		lblNewLabel_1_1.setBounds(41, 67, 46, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel(menu.get(2));
		lblNewLabel_1_2.setBounds(41, 92, 46, 14);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel(menu.get(3));
		lblNewLabel_1_3.setBounds(41, 117, 46, 14);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel(menu.get(4));
		lblNewLabel_1_4.setBounds(41, 142, 46, 14);
		contentPane.add(lblNewLabel_1_4);
		
		textField_1 = new JTextField();
		textField_1.setBounds(287, 64, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(287, 89, 86, 20);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(287, 114, 86, 20);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(287, 142, 86, 20);
		contentPane.add(textField_4);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(183, 190, 190, 14);
		contentPane.add(lblNewLabel_2);
		lblNewLabel_2.setVisible(false);
		
		JLabel lblNewLabel_3 = new JLabel("ID Cliente");
		lblNewLabel_3.setBounds(34, 200, 86, 14);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("Effettua Ordine");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ArrayList<String> piatti = new ArrayList<String>();
				ArrayList<Integer> qta = new ArrayList<Integer>();
				
				if(!(textField.getText().equals(""))) {
					piatti.add(menu.get(0));
					qta.add(Integer.parseInt(textField.getText()));
				}
				if(!(textField_1.getText().equals(""))) {
					piatti.add(menu.get(1));
					qta.add(Integer.parseInt(textField_1.getText()));
				}
				if(!(textField_2.getText().equals(""))) {
					piatti.add(menu.get(2));
					qta.add(Integer.parseInt(textField_2.getText()));
				}
				if(!(textField_3.getText().equals(""))) {
					piatti.add(menu.get(3));
					qta.add(Integer.parseInt(textField_3.getText()));
				}
				if(!(textField_4.getText().equals(""))) {
					piatti.add(menu.get(4));
					qta.add(Integer.parseInt(textField_4.getText()));
				}
				
				if(piatti.isEmpty()) {
					lblNewLabel_2.setForeground(Color.RED);
					lblNewLabel_2.setText("Nessun piatto selezionato");
					lblNewLabel_2.setVisible(true);
				}
				else {
					//Integer idcliente = Integer.parseInt(lblNewLabel_3.getText());
					String op= ControllerCliente.EffettuaOrdine(1/*idcliente*/, piatti, qta);
					lblNewLabel_2.setText(op);
					lblNewLabel_2.setVisible(true);
				}
			}
		});
		btnNewButton.setBounds(198, 215, 175, 23);
		contentPane.add(btnNewButton);
		
		textField_5 = new JTextField();
		textField_5.setBounds(34, 216, 86, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
	}
}
