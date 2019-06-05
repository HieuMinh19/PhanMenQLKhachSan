package QuanLyKS_GUI;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JEditorPane;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class frmBooking_Step3 extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmBooking_Step3 frame = new frmBooking_Step3();
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
	public frmBooking_Step3() {
		setBounds(100, 100, 810, 540);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CUSTOMER INFORMATION");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblNewLabel.setBounds(192, 13, 385, 34);
		getContentPane().add(lblNewLabel);
		
		JTextPane txtHoTen = new JTextPane();
		txtHoTen.setBounds(205, 101, 437, 34);
		getContentPane().add(txtHoTen);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(68, 101, 90, 34);
		getContentPane().add(lblNewLabel_1);
		
		JTextPane txtDiaChi = new JTextPane();
		txtDiaChi.setBounds(205, 158, 437, 34);
		getContentPane().add(txtDiaChi);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAddress.setBounds(68, 158, 90, 34);
		getContentPane().add(lblAddress);
		
		JTextPane txtEmail = new JTextPane();
		txtEmail.setBounds(205, 218, 437, 34);
		getContentPane().add(txtEmail);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEmail.setBounds(68, 218, 90, 34);
		getContentPane().add(lblEmail);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(205, 277, 225, 34);
		getContentPane().add(textPane);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPhone.setBounds(68, 277, 90, 34);
		getContentPane().add(lblPhone);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBounds(205, 341, 225, 34);
		getContentPane().add(textPane_1);
		
		JLabel label = new JLabel("Indentify Card");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label.setBounds(52, 341, 126, 34);
		getContentPane().add(label);
		
		JButton button = new JButton("Back");
		button.setFont(new Font("Tahoma", Font.PLAIN, 17));
		button.setBounds(146, 416, 180, 45);
		getContentPane().add(button);
		
		JButton button_1 = new JButton("Continue");
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		button_1.setBounds(497, 416, 180, 45);
		getContentPane().add(button_1);

	}

}
