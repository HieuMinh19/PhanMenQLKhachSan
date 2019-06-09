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
import java.awt.Color;

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
	
	
	public frmBooking_Step3(CTDatPhong_DTO ctdp, ArrayList<CTDichVu_DTO> listCTDV) {
		setBounds(100, 100, 810, 540);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ti\u1EBFp nh\u1EADn th\u00F4ng tin kh\u00E1ch h\u00E0ng");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(220, 23, 361, 34);
		getContentPane().add(lblNewLabel);
		
		JTextPane txtHoTen = new JTextPane();
		txtHoTen.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtHoTen.setBounds(205, 101, 437, 30);
		getContentPane().add(txtHoTen);
		
		JLabel lblNewLabel_1 = new JLabel("H\u1ECD t\u00EAn");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(102, 101, 76, 34);
		getContentPane().add(lblNewLabel_1);
		
		JTextPane txtDiaChi = new JTextPane();
		txtDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtDiaChi.setBounds(205, 158, 437, 30);
		getContentPane().add(txtDiaChi);
		
		JLabel lblAddress = new JLabel("\u0110\u1ECBa ch\u1EC9");
		lblAddress.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAddress.setBounds(107, 158, 71, 34);
		getContentPane().add(lblAddress);
		
		JTextPane txtEmail = new JTextPane();
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtEmail.setBounds(205, 218, 437, 30);
		getContentPane().add(txtEmail);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEmail.setBounds(114, 218, 64, 34);
		getContentPane().add(lblEmail);
		
		JTextPane txtSDT = new JTextPane();
		txtSDT.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtSDT.setBounds(205, 277, 225, 30);
		getContentPane().add(txtSDT);
		
		JLabel lblPhone = new JLabel("S\u1ED1 \u0111i\u1EC7n tho\u1EA1i");
		lblPhone.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPhone.setBounds(62, 277, 116, 34);
		getContentPane().add(lblPhone);
		
		JTextPane txtCMND = new JTextPane();
		txtCMND.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtCMND.setBounds(205, 341, 225, 30);
		getContentPane().add(txtCMND);
		
		JLabel lblSCmnd = new JLabel("S\u1ED1 CMND");
		lblSCmnd.setHorizontalAlignment(SwingConstants.CENTER);
		lblSCmnd.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSCmnd.setBounds(88, 341, 90, 34);
		getContentPane().add(lblSCmnd);
		
		JButton btnBack = new JButton("Quay l\u1EA1i");
		btnBack.setBackground(Color.ORANGE);
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnBack.setBounds(205, 416, 150, 40);
		getContentPane().add(btnBack);
		
		JButton btnContinue = new JButton("Ti\u1EBFp t\u1EE5c");
		btnContinue.setBackground(Color.ORANGE);
		btnContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String strHoten = txtHoTen.getText();
				String strEmail = txtEmail.getText();
				String strDiaChi = txtDiaChi.getText();
				String strSDT = txtSDT.getText();
				String strCMND = txtCMND.getText();
				int iMaKH = KhachHang_BUS.getnextMaKH();
			
				 KhachHang_DTO khDTO = new KhachHang_DTO(iMaKH, strHoten, strSDT, strCMND, strDiaChi, strEmail);
				
				frmDashboard.frmBooking4 = new frmBooking_Step4(ctdp, listCTDV, khDTO);
				frmDashboard.controlFrame(frmDashboard.FRM_BOOKING4);
				
			}
		});
		btnContinue.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnContinue.setBounds(492, 416, 150, 40);
		getContentPane().add(btnContinue);
		
		
		
		
	}

}
