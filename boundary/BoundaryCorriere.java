package boundary;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.ControllerCliente;
import control.ControllerCorriere;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BoundaryCorriere extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BoundaryCorriere frame = new BoundaryCorriere();
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
	public BoundaryCorriere() {
		super("Area Corriere");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIdCorriere = new JLabel("Id Corriere");
		lblIdCorriere.setBounds(89, 40, 92, 14);
		contentPane.add(lblIdCorriere);
		
		JTextField textFieldIdCorriere = new JTextField();
		textFieldIdCorriere.setBounds(89, 57, 114, 20);
		contentPane.add(textFieldIdCorriere);
		textFieldIdCorriere.setColumns(10);
		
		JLabel lblIdConsegna = new JLabel("Id Consegna");
		lblIdConsegna.setBounds(89, 103, 86, 14);
		contentPane.add(lblIdConsegna);
		
		JTextField textFieldIdConsegna = new JTextField();
		textFieldIdConsegna.setBounds(89, 118, 114, 20);
		contentPane.add(textFieldIdConsegna);
		textFieldIdConsegna.setColumns(10);
		
		JLabel lblRisp = new JLabel("New label");
		lblRisp.setBounds(63, 204, 302, 37);
		contentPane.add(lblRisp);
		lblRisp.setVisible(false);
		
		JButton btnAssCons = new JButton("Aggiorna stato consegna");
		btnAssCons.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Integer idcorriere = Integer.parseInt(textFieldIdCorriere.getText());
					Integer idconsegna = Integer.parseInt(textFieldIdConsegna.getText());
					
					String risp = ControllerCorriere.AggiornaStatoConsegna(idcorriere, idconsegna);
					lblRisp.setText(risp);
					lblRisp.setVisible(true);
				}
				catch (NumberFormatException e1){
					lblRisp.setForeground(Color.RED);
					lblRisp.setText("Errore l'id non è un numero intero");
					lblRisp.setVisible(true);
				}
			}
		});
		btnAssCons.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnAssCons.setBounds(228, 157, 164, 36);
		contentPane.add(btnAssCons);
	}
}
