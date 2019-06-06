package QuanLyKS_GUI;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import QuanLyKS_BUS.NhanVien_BUS;
import QuanLyKS_DTO.NhanVien_DTO;
import javax.swing.JPasswordField;

public class frmLogin extends JFrame {

	private JPanel contentPane;
	private JPasswordField txtMatKhau;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmLogin frame = new frmLogin();
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
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
		frmLogin _self = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 560, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane txtTaiKhoan = new JTextPane();
		txtTaiKhoan.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtTaiKhoan.setBounds(161, 50, 243, 30);
		contentPane.add(txtTaiKhoan);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPassword.setBounds(67, 113, 82, 30);
		contentPane.add(lblPassword);
		
		JLabel lblAccount = new JLabel("Account");
		lblAccount.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAccount.setBounds(77, 50, 72, 30);
		contentPane.add(lblAccount);

		txtMatKhau = new JPasswordField();
		txtMatKhau.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtMatKhau.setBounds(161, 115, 243, 30);
		contentPane.add(txtMatKhau);
		
		JButton btnDangNhap = new JButton("LOG IN");
		btnDangNhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NhanVien_DTO acc = NhanVien_BUS.Login(txtTaiKhoan.getText(),new String(txtMatKhau.getPassword()));
				if(acc != null)
				{
					JOptionPane.showMessageDialog(null, "Dang nhap thanh cong!", "Thong bao", JOptionPane.CLOSED_OPTION);
					frmDashboard main = new frmDashboard(acc);
					_self.setVisible(false);
					main.setVisible(true);
					main.setExtendedState(JFrame.MAXIMIZED_BOTH); 
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Sai tai khoan hoac mat khau!", "Loi dang nhap", JOptionPane.CLOSED_OPTION);
				}
			}
		});
		btnDangNhap.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnDangNhap.setBounds(201, 175, 156, 38);
		contentPane.add(btnDangNhap);
		
	}
}
