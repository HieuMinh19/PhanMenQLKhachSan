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
import java.awt.Color;

public class frmLogin extends JFrame {

	private JPanel contentPane;
	private JPasswordField txtMatKhau;
	static NhanVien_DTO acc = new NhanVien_DTO();
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
		frmLogin _self = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 560, 358);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setForeground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane txtTaiKhoan = new JTextPane();
		txtTaiKhoan.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtTaiKhoan.setBounds(147, 104, 240, 30);
		contentPane.add(txtTaiKhoan);
		
		JLabel lblPassword = new JLabel("Mật khẩu");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPassword.setBounds(62, 166, 73, 30);
		contentPane.add(lblPassword);
		
		JLabel lblAccount = new JLabel("Tài khoản");
		lblAccount.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAccount.setBounds(53, 104, 82, 30);
		contentPane.add(lblAccount);

		txtMatKhau = new JPasswordField();
		txtMatKhau.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtMatKhau.setBounds(147, 167, 240, 30);
		contentPane.add(txtMatKhau);
		
		JButton btnDangNhap = new JButton("Đăng nhập");
		btnDangNhap.setBackground(Color.MAGENTA);
		btnDangNhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				acc = NhanVien_BUS.Login(txtTaiKhoan.getText(),new String(txtMatKhau.getPassword()));

				char[] a = txtMatKhau.getPassword();
         		//String b;
         		String b = String.valueOf(a);
				NhanVien_DTO acc = NhanVien_BUS.Login(txtTaiKhoan.getText(),b);
				if(acc != null)
		 		{
//					JOptionPane.showMessageDialog(null, "Dang nhap thanh cong!", "Thong bao", JOptionPane.CLOSED_OPTION);
					frmDashboard main = new frmDashboard(acc);
					_self.setVisible(false);
					main.setVisible(true);
					main.setExtendedState(JFrame.MAXIMIZED_BOTH); 
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Sai tên đăng nhập hoặc mật khẩu!", "Đăng nhập không thành công", JOptionPane.CLOSED_OPTION);
				}
			}
		});
		btnDangNhap.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnDangNhap.setBounds(194, 220, 156, 38);
		contentPane.add(btnDangNhap);
		
		JLabel lblNewLabel = new JLabel("Chúc một buổi làm việc tốt lành");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBackground(Color.LIGHT_GRAY);
		lblNewLabel.setBounds(101, 42, 347, 30);
		contentPane.add(lblNewLabel);
		
	}
}
