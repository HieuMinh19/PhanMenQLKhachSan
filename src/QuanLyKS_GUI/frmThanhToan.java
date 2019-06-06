package QuanLyKS_GUI;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JButton;

public class frmThanhToan extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmThanhToan frame = new frmThanhToan();
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
	public frmThanhToan() {
		setBounds(100, 100, 650, 444);
		getContentPane().setLayout(null);
		
		JLabel lblInvoicePayment = new JLabel("INVOICE PAYMENT");
		lblInvoicePayment.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblInvoicePayment.setBounds(187, 13, 239, 42);
		getContentPane().add(lblInvoicePayment);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(135, 88, 102, 29);
		getContentPane().add(textPane);
		
		JLabel lblNewLabel = new JLabel("Room");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(71, 88, 52, 29);
		getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(281, 88, 102, 29);
		getContentPane().add(btnNewButton);

	}

}
