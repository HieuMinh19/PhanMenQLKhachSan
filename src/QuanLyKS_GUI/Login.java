package QuanLyKS_GUI;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;

public class Login extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txt_username;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setBounds(100, 100, 340, 211);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setForeground(Color.GREEN);
		lblNewLabel.setBackground(Color.RED);
		lblNewLabel.setBounds(34, 31, 60, 23);
		getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setBounds(152, 133, 89, 23);
		getContentPane().add(btnNewButton);
		
		txt_username = new JTextField();
		txt_username.setBounds(139, 31, 165, 23);
		getContentPane().add(txt_username);
		txt_username.setColumns(10);
		
		textField = new JTextField();
		textField.setBounds(142, 76, 162, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.RED);
		lblPassword.setBackground(Color.ORANGE);
		lblPassword.setBounds(34, 65, 60, 23);
		getContentPane().add(lblPassword);

	}
}
