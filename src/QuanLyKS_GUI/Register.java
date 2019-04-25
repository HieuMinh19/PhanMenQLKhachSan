package QuanLyKS_GUI;

import java.awt.EventQueue;
import QuanLyKS_DAL.Account_DAL;
import QuanLyKS_DTO.Account_DTO;
import Utility.Result;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import QuanLyKS_BUS.Account_BUS;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.awt.event.ActionEvent;

public class Register extends JInternalFrame {
	private JTextField textUname;
	private JPasswordField textPassword;
	private JPasswordField textPasswordRetype;
	private Account_BUS accountBus;
	private Account_DTO accountDTO;
	private Account_DAL accountDAL;

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
		
		textUname = new JTextField();
		textUname.setText("hieu1");
		textUname.setBounds(208, 52, 86, 20);
		getContentPane().add(textUname);
		textUname.setColumns(10);
		
		textPassword = new JPasswordField();
		textPassword.setToolTipText("123");
		textPassword.setBounds(208, 87, 86, 20);
		getContentPane().add(textPassword);
		
		textPasswordRetype = new JPasswordField();
		textPasswordRetype.setToolTipText("123");
		textPasswordRetype.setBounds(208, 124, 86, 20);
		getContentPane().add(textPasswordRetype);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				accountDTO = new Account_DTO(); 
				accountDTO.setUsername( textUname.getText() );
				boolean isValidPass = Arrays.equals(textPassword.getPassword(),textPasswordRetype.getPassword());
				if(isValidPass){
					 accountDTO.setPassword( textPassword.getPassword() );
					 accountDTO.setRole(2);
					 accountBus.Insert(accountDTO);
					 JOptionPane.showMessageDialog(null, "Insert account Success", "Success: " + "Success Mesage", JOptionPane.INFORMATION_MESSAGE);
				 }else {
					 JOptionPane.showMessageDialog(null, "2 Password is not the same", "Warning: " + "error Mesage", JOptionPane.INFORMATION_MESSAGE);
				 }
			}
		});
		btnRegister.setBounds(141, 174, 89, 23);
		getContentPane().add(btnRegister);

	}

}
