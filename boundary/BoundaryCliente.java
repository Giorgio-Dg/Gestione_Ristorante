package boundary;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.ControllerCliente;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JScrollBar;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class BoundaryCliente extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
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
	 * Create the frame.
	 */
	public BoundaryCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Effettua Ordine");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//ControllerCliente.EffettuaOrdine(idcliente, piatti, qta);
			}
		});
		btnNewButton.setBounds(140, 215, 175, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Nome Piatto");
		lblNewLabel.setBounds(50, 14, 90, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblQuantita = new JLabel("Quantita'");
		lblQuantita.setBounds(306, 14, 90, 14);
		contentPane.add(lblQuantita);
	}
}
