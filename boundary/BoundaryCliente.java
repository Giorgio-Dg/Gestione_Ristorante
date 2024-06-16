package boundary;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.ControllerCliente;
import database.OrdineDAO;

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
	private JTextField textFieldQta0;
	private JTextField textFieldQta1;
	private JTextField textFieldQta2;
	private JTextField textFieldQta3;
	private JTextField textFieldQta4;
	
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
	 * Create the frame...
	 */
	public BoundaryCliente() {
		super("Area Cliente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNomePiatto = new JLabel("Nome Piatto");
		lblNomePiatto.setBounds(41, 14, 99, 14);
		contentPane.add(lblNomePiatto);
		lblNomePiatto.setForeground(Color.BLUE);
		
		JLabel lblQuantita = new JLabel("Quantita'");
		lblQuantita.setBounds(306, 14, 90, 14);
		contentPane.add(lblQuantita);
		lblQuantita.setForeground(Color.BLUE);
		
		textFieldQta0 = new JTextField();
		textFieldQta0.setBounds(287, 39, 86, 20);
		contentPane.add(textFieldQta0);
		textFieldQta0.setColumns(10);
		
		ArrayList<String> menu = ControllerCliente.VisualizzaMenu();
		
		JLabel lblPiatto1 = new JLabel(menu.get(0));
		lblPiatto1.setBounds(41, 42, 100, 14);
		contentPane.add(lblPiatto1);
		
		JLabel lblPiatto2 = new JLabel(menu.get(1));
		lblPiatto2.setBounds(41, 67, 100, 14);
		contentPane.add(lblPiatto2);
		
		JLabel lblPiatto3 = new JLabel(menu.get(2));
		lblPiatto3.setBounds(41, 92, 100, 14);
		contentPane.add(lblPiatto3);
		
		JLabel lblPiatto4 = new JLabel(menu.get(3));
		lblPiatto4.setBounds(41, 117, 150, 14);
		contentPane.add(lblPiatto4);
		
		JLabel lblPiatto5 = new JLabel(menu.get(4));
		lblPiatto5.setBounds(41, 142, 150, 14);
		contentPane.add(lblPiatto5);
		
		textFieldQta1 = new JTextField();
		textFieldQta1.setBounds(287, 64, 86, 20);
		contentPane.add(textFieldQta1);
		textFieldQta1.setColumns(10);
		
		textFieldQta2 = new JTextField();
		textFieldQta2.setColumns(10);
		textFieldQta2.setBounds(287, 89, 86, 20);
		contentPane.add(textFieldQta2);
		
		textFieldQta3 = new JTextField();
		textFieldQta3.setColumns(10);
		textFieldQta3.setBounds(287, 114, 86, 20);
		contentPane.add(textFieldQta3);
		
		textFieldQta4 = new JTextField();
		textFieldQta4.setColumns(10);
		textFieldQta4.setBounds(287, 142, 86, 20);
		contentPane.add(textFieldQta4);
		
		JTextField textFieldID = new JTextField();
		textFieldID.setColumns(10);
		textFieldID.setBounds(34, 206, 86, 20);
		contentPane.add(textFieldID);
		
		JLabel lblresult = new JLabel("New label");
		lblresult.setBounds(183, 190, 190, 14);
		contentPane.add(lblresult);
		lblresult.setVisible(false);
		
		JLabel lblerrorqta = new JLabel("New label");
		lblerrorqta.setBounds(80, 165, 300, 14);
		contentPane.add(lblerrorqta);
		lblerrorqta.setVisible(false);
		
		JLabel lblerrorid = new JLabel("New label");
		lblerrorid.setBounds(34, 232, 220, 20);
		contentPane.add(lblerrorid);
		lblerrorid.setVisible(false);
		
		JLabel lblID = new JLabel("ID Cliente");
		lblID.setBounds(34, 180, 86, 14);
		contentPane.add(lblID);
		
		JButton btnEffettuaOrdine = new JButton("Effettua Ordine");
		btnEffettuaOrdine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ArrayList<String> piatti = new ArrayList<String>();
				ArrayList<Integer> qta = new ArrayList<Integer>();
				
				boolean errore = false;
				
				if(!(textFieldQta0.getText().equals("") || textFieldQta0.getText().equals("0"))) {
					try {
						if(Integer.parseInt(textFieldQta0.getText())>0) {
							qta.add(Integer.parseInt(textFieldQta0.getText()));
							piatti.add(menu.get(0));
						}
						else {
							errore = true;
							lblerrorqta.setForeground(Color.RED);
							lblerrorqta.setText("Errore la quantità deve essere un numero > 0");
							lblerrorqta.setVisible(true);
						}
					}
					catch (NumberFormatException e1){
						errore = true;
						lblerrorqta.setForeground(Color.RED);
						lblerrorqta.setText("Errore la quantità deve essere un numero > 0");
						lblerrorqta.setVisible(true);
					}
				}
				
				if(!(textFieldQta1.getText().equals("") || textFieldQta1.getText().equals("0"))) {
					try {
						if(Integer.parseInt(textFieldQta1.getText())>0) {
							qta.add(Integer.parseInt(textFieldQta1.getText()));
							piatti.add(menu.get(1));
						}
						else {
							errore = true;
							lblerrorqta.setForeground(Color.RED);
							lblerrorqta.setText("Errore la quantità deve essere un numero > 0");
							lblerrorqta.setVisible(true);
						}
					}
					catch (NumberFormatException e1){
						errore = true;
						lblerrorqta.setForeground(Color.RED);
						lblerrorqta.setText("Errore la quantità deve essere un numero > 0");
						lblerrorqta.setVisible(true);
					}
				}
				
				if(!(textFieldQta2.getText().equals("") || textFieldQta2.getText().equals("0"))) {
					try {
						if(Integer.parseInt(textFieldQta2.getText())>0) {
							qta.add(Integer.parseInt(textFieldQta2.getText()));
							piatti.add(menu.get(2));
						}
						else {
							errore = true;
							lblerrorqta.setForeground(Color.RED);
							lblerrorqta.setText("Errore la quantità deve essere un numero > 0");
							lblerrorqta.setVisible(true);
						}
					}
					catch (NumberFormatException e1){
						errore = true;
						lblerrorqta.setForeground(Color.RED);
						lblerrorqta.setText("Errore la quantità deve essere un numero > 0");
						lblerrorqta.setVisible(true);
					}
				}
				
				if(!(textFieldQta3.getText().equals("") || textFieldQta3.getText().equals("0"))) {
					try {
						if(Integer.parseInt(textFieldQta3.getText())>0) {
							qta.add(Integer.parseInt(textFieldQta3.getText()));
							piatti.add(menu.get(3));
						}
						else {
							errore = true;
							lblerrorqta.setForeground(Color.RED);
							lblerrorqta.setText("Errore la quantità deve essere un numero > 0");
							lblerrorqta.setVisible(true);
						}
					}
					catch (NumberFormatException e1){
						errore = true;
						lblerrorqta.setForeground(Color.RED);
						lblerrorqta.setText("Errore la quantità deve essere un numero > 0");
						lblerrorqta.setVisible(true);
					}
				}
				
				if(!(textFieldQta4.getText().equals("") || textFieldQta4.getText().equals("0"))) {
					try {
						if(Integer.parseInt(textFieldQta4.getText())>0) {
							qta.add(Integer.parseInt(textFieldQta4.getText()));
							piatti.add(menu.get(4));
						}
						else {
							errore = true;
							lblerrorqta.setForeground(Color.RED);
							lblerrorqta.setText("Errore la quantità deve essere un numero > 0");
							lblerrorqta.setVisible(true);
						}
					}
					catch (NumberFormatException e1){
						errore = true;
						lblerrorqta.setForeground(Color.RED);
						lblerrorqta.setText("Errore la quantità deve essere un numero > 0");
						lblerrorqta.setVisible(true);
					}
				}
				
				if(piatti.isEmpty() || errore == true) {
					lblresult.setForeground(Color.RED);
					lblresult.setVisible(true);
					if(errore) {
						lblresult.setText("Errore nelle quantità");
					}
					else{
						lblresult.setText("Nessun piatto selezionato");
					}
				}
				else {
					try {
						Integer idcliente = Integer.parseInt(textFieldID.getText());
						if(idcliente>0) {
							ArrayList<Integer> idclienti = ControllerCliente.ElencoClienti();
							boolean cliente_trovato = false;
							int i = 0; 
							while(i<idclienti.size() && cliente_trovato == false) {
							        if (idclienti.get(i) == idcliente) {
							        	cliente_trovato = true;
							        }
							        i++;
							}
							if(cliente_trovato) {
								String op= ControllerCliente.EffettuaOrdine(idcliente, piatti, qta);
								lblresult.setText(op);
								lblresult.setVisible(true);
							}
							else {
								lblerrorid.setForeground(Color.RED);
								lblerrorid.setText("IDCliente non presente nel database");
								lblerrorid.setVisible(true);
							}
						}
						else {
							lblerrorid.setForeground(Color.RED);
							lblerrorid.setText("Errore l'id non è un numero intero >0");
							lblerrorid.setVisible(true);
						}
					}
					catch (NumberFormatException e1){
						lblerrorid.setForeground(Color.RED);
						lblerrorid.setText("Errore l'id non è un numero intero");
						lblerrorid.setVisible(true);
					}
				}
			}
		});
		btnEffettuaOrdine.setBounds(198, 215, 175, 23);
		contentPane.add(btnEffettuaOrdine);
		
	}
}
