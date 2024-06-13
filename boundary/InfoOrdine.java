package boundary;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.ControllerCuoco;

import javax.swing.JTextArea;

public class InfoOrdine extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InfoOrdine frame = new InfoOrdine();
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
	public InfoOrdine() {
		super("Area Cuoco - Info ordine preso in carico");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		String ordine = ControllerCuoco.PrendiOrdineInCarico();
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(32, 48, 467, 238);
		contentPane.add(textArea);
		textArea.setText(ordine);
	}
}
