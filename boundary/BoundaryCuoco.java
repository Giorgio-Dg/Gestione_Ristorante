package boundary;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BoundaryCuoco extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BoundaryCuoco frame = new BoundaryCuoco();
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
	public BoundaryCuoco() {
		super("Area Cuoco");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnPrendiOrdineInCarico = new JButton("Prendi ordine in carico");
		btnPrendiOrdineInCarico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InfoOrdine info = new InfoOrdine();
				info.setVisible(true);
			}
		});
		btnPrendiOrdineInCarico.setBounds(114, 81, 201, 23);
		contentPane.add(btnPrendiOrdineInCarico);
		
		JButton btnSegnala = new JButton("Segnala ordine pronto");
		btnSegnala.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnSegnala.setBounds(114, 146, 201, 23);
		contentPane.add(btnSegnala);
		
	}
}
