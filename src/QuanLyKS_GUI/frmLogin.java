package QuanLyKS_GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JButton;

public class frmLogin extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmLogin frame = new frmLogin();
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
	public frmLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 560, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane txtMaNV = new JTextPane();
		txtMaNV.setBounds(161, 50, 243, 30);
		contentPane.add(txtMaNV);
		
		JTextPane txtMatKhau = new JTextPane();
		txtMatKhau.setBounds(161, 113, 243, 30);
		contentPane.add(txtMatKhau);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPassword.setBounds(67, 113, 82, 30);
		contentPane.add(lblPassword);
		
		JLabel lblAccount = new JLabel("Account");
		lblAccount.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAccount.setBounds(77, 50, 72, 30);
		contentPane.add(lblAccount);
		
		JButton btnDangNhap = new JButton("LOG IN");
		btnDangNhap.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnDangNhap.setBounds(201, 175, 156, 38);
		contentPane.add(btnDangNhap);
	}
}
