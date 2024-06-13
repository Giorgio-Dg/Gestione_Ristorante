package boundary;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.ControllerCuoco;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SegnalaOrdinePronto extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SegnalaOrdinePronto frame = new SegnalaOrdinePronto();
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
	public SegnalaOrdinePronto() {
		super("Area Cuoco - Segnala ordine pronto per consegna");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 470, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextField textFielIdOrdine = new JTextField();
		textFielIdOrdine.setBounds(79, 97, 111, 38);
		contentPane.add(textFielIdOrdine);
		textFielIdOrdine.setColumns(10);
		
		JLabel errore = new JLabel("New label");
		errore.setBounds(122, 146, 221, 14);
		contentPane.add(errore);
		errore.setVisible(false);
		
		JButton btnNewButton = new JButton("Segnala ordine pronto");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int idord = Integer.parseInt(textFielIdOrdine.getText());
					ControllerCuoco.SegnalaOrdineProntoPerConsegna(idord);
				}
				catch (NumberFormatException e1){
					errore.setForeground(Color.RED);
					errore.setText("Errore l'id non è un numero intero");
					errore.setVisible(true);
				}
			}
		});
		btnNewButton.setBounds(230, 97, 163, 38);
		contentPane.add(btnNewButton);
		
		JLabel idordineLabel = new JLabel("Id Ordine");
		idordineLabel.setBounds(79, 77, 96, 14);
		contentPane.add(idordineLabel);
		
	}
}
