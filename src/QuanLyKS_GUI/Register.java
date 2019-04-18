package QuanLyKS_GUI;

import java.awt.EventQueue;
import QuanLyKS_DAL.Account_DAL;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Register extends JInternalFrame {
	private JTextField textField;
	private JPasswordField password;
	private JPasswordField passwordRetype;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
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
	public Register() {
		setBounds(100, 100, 409, 250);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setBounds(52, 52, 69, 21);
		getContentPane().add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(52, 84, 100, 26);
		getContentPane().add(lblPassword);
		
		JLabel lblRetypePassword = new JLabel("Retype password");
		lblRetypePassword.setBounds(52, 121, 120, 26);
		getContentPane().add(lblRetypePassword);
		
		textField = new JTextField();
		textField.setBounds(208, 52, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		password = new JPasswordField();
		password.setBounds(208, 87, 86, 20);
		getContentPane().add(password);
		
		passwordRetype = new JPasswordField();
		passwordRetype.setBounds(208, 124, 86, 20);
		getContentPane().add(passwordRetype);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Account_DAL account = new Account_DAL();
				account.Insert();
				
			}
		});
		btnRegister.setBounds(141, 174, 89, 23);
		getContentPane().add(btnRegister);

	}

}
