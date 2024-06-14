package boundary;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
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
	public MainFrame() {
		super("Ristorante");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCliente = new JButton("Area Cliente");
		btnCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BoundaryCliente bcliente = new BoundaryCliente();
				bcliente.setVisible(true);
			}
		});
		btnCliente.setBounds(142, 75, 144, 23);
		contentPane.add(btnCliente);
	
		JButton btnCuoco = new JButton("Area Cuoco");
		btnCuoco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BoundaryCuoco bcuoco = new BoundaryCuoco();
				bcuoco.setVisible(true);
			}
		});
		btnCuoco.setBounds(142, 169, 144, 23);
		contentPane.add(btnCuoco);
		
		JButton btnCorriere = new JButton("Area Corriere");
		btnCorriere.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BoundaryCorriere bcorriere = new BoundaryCorriere();
				bcorriere.setVisible(true);
			}
		});
		btnCorriere.setBounds(142, 121, 144, 23);
		contentPane.add(btnCorriere);
	}
}
