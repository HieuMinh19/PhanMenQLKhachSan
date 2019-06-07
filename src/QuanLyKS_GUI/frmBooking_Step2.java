package QuanLyKS_GUI;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JEditorPane;
import javax.swing.JButton;

import QuanLyKS_DTO.DichVu_DTO;
import QuanLyKS_DTO.CTDatPhong_DTO;
import QuanLyKS_BUS.DichVu_BUS;
import QuanLyKS_DTO.CTDichVu_DTO;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmBooking_Step2 extends JInternalFrame {
	private JButton btnRemove01;

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
	
	static ArrayList<CTDichVu_DTO> listBookingDV = new ArrayList<CTDichVu_DTO>();
	public frmBooking_Step2(CTDatPhong_DTO ctdp) {
		setBounds(100, 100, 810, 540); 
		getContentPane().setLayout(null);
		
		JEditorPane edDV01 = new JEditorPane();
		edDV01.setEditable(false);
		edDV01.setBounds(53, 73, 235, 30);
		getContentPane().add(edDV01);
		
		JEditorPane edDV02 = new JEditorPane();
		edDV02.setEditable(false);
		edDV02.setBounds(53, 134, 235, 30);
		getContentPane().add(edDV02);
		
		JEditorPane edDV03 = new JEditorPane();
		edDV03.setEditable(false);
		edDV03.setBounds(53, 201, 235, 30);
		getContentPane().add(edDV03);
		
		JEditorPane edDV04 = new JEditorPane();
		edDV04.setEditable(false);
		edDV04.setBounds(53, 266, 235, 30);
		getContentPane().add(edDV04);
		
		JEditorPane edGiaDV01 = new JEditorPane();
		edGiaDV01.setEditable(false);
		edGiaDV01.setBounds(325, 73, 128, 30);
		getContentPane().add(edGiaDV01);
		
		JEditorPane edGiaDV02 = new JEditorPane();
		edGiaDV02.setEditable(false);
		edGiaDV02.setBounds(325, 134, 128, 30);
		getContentPane().add(edGiaDV02);
		
		JEditorPane edGiaDV03 = new JEditorPane();
		edGiaDV03.setEditable(false);
		edGiaDV03.setBounds(325, 201, 128, 30);
		getContentPane().add(edGiaDV03);
		
		JEditorPane edGiaDV04 = new JEditorPane();
		edGiaDV04.setEditable(false);
		edGiaDV04.setBounds(325, 266, 128, 30);
		getContentPane().add(edGiaDV04);
		
		btnRemove01 = new JButton("Remove");
		btnRemove01.setEnabled(false);
		btnRemove01.setBounds(700, 73, 84, 30);
		getContentPane().add(btnRemove01);
		
		JButton btnRemove02 = new JButton("Remove");
		btnRemove02.setEnabled(false);
		btnRemove02.setBounds(700, 134, 84, 30);
		getContentPane().add(btnRemove02);
		
		JButton btnRemove03 = new JButton("Remove");
		btnRemove03.setEnabled(false);
		btnRemove03.setBounds(700, 201, 84, 30);
		getContentPane().add(btnRemove03);
		
		JButton btnRemove04 = new JButton("Remove");
		btnRemove04.setEnabled(false);
		btnRemove04.setBounds(700, 266, 84, 30);
		getContentPane().add(btnRemove04);
		
		JButton btnAddDV02 = new JButton("Add");
		btnAddDV02.setBounds(593, 134, 84, 30);
		getContentPane().add(btnAddDV02);
		
		JButton btnAddDV03 = new JButton("Add");
		btnAddDV03.setBounds(593, 201, 84, 30);
		getContentPane().add(btnAddDV03);
		
		JButton btnAddDV04 = new JButton("Add");
		btnAddDV04.setBounds(593, 266, 84, 30);
		getContentPane().add(btnAddDV04);
		
		JButton btnContinue = new JButton("Continue");
		btnContinue.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnContinue.setBounds(373, 418, 180, 45);
		getContentPane().add(btnContinue);
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnBack.setBounds(81, 418, 180, 45);
		getContentPane().add(btnBack);
		
		JLabel lblDichVu = new JLabel("SERVICE");
		lblDichVu.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblDichVu.setBounds(259, 13, 135, 30);
		getContentPane().add(lblDichVu);
		
		JEditorPane edSLDV01 = new JEditorPane();
		edSLDV01.setEditable(false);
		edSLDV01.setBounds(476, 73, 71, 30);
		getContentPane().add(edSLDV01);
		
		JEditorPane edSLDV02 = new JEditorPane();
		edSLDV02.setEditable(false);
		edSLDV02.setBounds(476, 134, 71, 30);
		getContentPane().add(edSLDV02);
		
		JEditorPane edSLDV03 = new JEditorPane();
		edSLDV03.setEditable(false);
		edSLDV03.setBounds(482, 201, 71, 30);
		getContentPane().add(edSLDV03);
		
		JEditorPane edSLDV04 = new JEditorPane();
		edSLDV04.setEditable(false);
		edSLDV04.setBounds(482, 266, 71, 30);
		getContentPane().add(edSLDV04);
		
		ArrayList<DichVu_DTO> listDV = DichVu_BUS.getListDV();
		edDV01.setText(listDV.get(0).getTenDichVu());
		String  strGiaDV =  String.valueOf(listDV.get(0).getGiaDichVu());
		edGiaDV01.setText(strGiaDV);
		
		edDV02.setText(listDV.get(1).getTenDichVu());
		strGiaDV =  String.valueOf(listDV.get(1).getGiaDichVu());
		edGiaDV02.setText(strGiaDV);
	
		edDV03.setText(listDV.get(2).getTenDichVu());
		strGiaDV =  String.valueOf(listDV.get(2).getGiaDichVu());
		edGiaDV03.setText(strGiaDV);
		
		edDV04.setText(listDV.get(3).getTenDichVu());
		strGiaDV =  String.valueOf(listDV.get(0).getGiaDichVu());
		edGiaDV04.setText(strGiaDV);
		
		JButton btnAddDV01 = new JButton("Add");
		btnAddDV01.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnRemove01.setEnabled(true);
				
				int iSL = Integer.parseInt( edSLDV01.getText() );
				int iMaCTDatPhong = ctdp.getMaCTDatPhong();
				int iDonGia = listDV.get(0).getGiaDichVu();
				int iThanhTien = iSL * iDonGia;
				int iMaDV = listDV.get(0).getMaDichVu();
				
				CTDichVu_DTO dvTemp = new CTDichVu_DTO(iSL, iMaCTDatPhong, iThanhTien, iMaDV);
				
				listBookingDV.add(dvTemp);
			}
		});
		
		btnAddDV01.setBounds(593, 73, 84, 30);
		getContentPane().add(btnAddDV01);
		
		btnAddDV02.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnRemove02.setEnabled(true);

				int iSL = Integer.parseInt( edSLDV02.getText() );
				int iMaCTDatPhong = ctdp.getMaCTDatPhong();
				int iDonGia = listDV.get(1).getGiaDichVu();
				int iThanhTien = iSL * iDonGia;
				int iMaDV = listDV.get(1).getMaDichVu();
				
				CTDichVu_DTO dvTemp = new CTDichVu_DTO(iSL, iMaCTDatPhong, iThanhTien, iMaDV);
				
				listBookingDV.add(dvTemp);
				
			}
		});
		
		btnAddDV03.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnRemove03.setEnabled(true);
				
				int iSL = Integer.parseInt( edSLDV03.getText() );
				int iMaCTDatPhong = ctdp.getMaCTDatPhong();
				int iDonGia = listDV.get(2).getGiaDichVu();
				int iThanhTien = iSL * iDonGia;
				int iMaDV = listDV.get(2).getMaDichVu();
				
				CTDichVu_DTO dvTemp = new CTDichVu_DTO(iSL, iMaCTDatPhong, iThanhTien, iMaDV);
				
				listBookingDV.add(dvTemp);
			}
		});
		
		btnAddDV04.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnRemove04.setEnabled(true);
				int iSL = Integer.parseInt( edSLDV04.getText() );
				int iMaCTDatPhong = ctdp.getMaCTDatPhong();
				int iDonGia = listDV.get(3).getGiaDichVu();
				int iThanhTien = iSL * iDonGia;
				int iMaDV = listDV.get(3).getMaDichVu();
				
				CTDichVu_DTO dvTemp = new CTDichVu_DTO(iSL, iMaCTDatPhong, iThanhTien, iMaDV);
				
				listBookingDV.add(dvTemp);
			}
		});
		
		
	}
}
