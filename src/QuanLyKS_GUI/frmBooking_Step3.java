package QuanLyKS_GUI;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JTextPane;
import javax.swing.SwingConstants;

import QuanLyKS_BUS.KhachHang_BUS;

import javax.swing.JButton;

import QuanLyKS_DTO.CTDichVu_DTO;
import QuanLyKS_DTO.KhachHang_DTO;
import QuanLyKS_DTO.CTDatPhong_DTO;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmBooking_Step3 extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	public static KhachHang_DTO  khDTO;
	public frmBooking_Step3(CTDatPhong_DTO ctdp, ArrayList<CTDichVu_DTO> listCTDV) {
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
		
		JTextPane txtSDT = new JTextPane();
		txtSDT.setBounds(205, 277, 225, 34);
		getContentPane().add(txtSDT);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPhone.setBounds(68, 277, 90, 34);
		getContentPane().add(lblPhone);
		
		JTextPane txtCMND = new JTextPane();
		txtCMND.setBounds(205, 341, 225, 34);
		getContentPane().add(txtCMND);
		
		JLabel label = new JLabel("Indentify Card");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label.setBounds(52, 341, 126, 34);
		getContentPane().add(label);
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnBack.setBounds(146, 416, 180, 45);
		getContentPane().add(btnBack);
		
		JButton btnContinue = new JButton("Continue");
		btnContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String strHoten = txtHoTen.getText();
				String strEmail = txtEmail.getText();
				String strDiaChi = txtDiaChi.getText();
				String strSDT = txtSDT.getText();
				String strCMND = txtCMND.getText();
				int iMaKH = KhachHang_BUS.getnextMaKH();
				
				khDTO = new KhachHang_DTO(iMaKH, strHoten, strSDT, strCMND, strDiaChi, strEmail);
				
				
			}
		});
		btnContinue.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnContinue.setBounds(497, 416, 180, 45);
		getContentPane().add(btnContinue);
		
		
		
		
	}

}
