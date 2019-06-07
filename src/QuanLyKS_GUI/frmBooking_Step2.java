package QuanLyKS_GUI;

import java.awt.Component;
import java.awt.EventQueue;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JButton;

import QuanLyKS_DTO.DichVu_DTO;
import QuanLyKS_DTO.CTDatPhong_DTO;
import QuanLyKS_BUS.DichVu_BUS;
import QuanLyKS_DTO.CTDichVu_DTO;
import QuanLyKS_GUI.frmDashboard;
import QuanLyKS_GUI.frmBooking_Step3;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmBooking_Step2 extends JInternalFrame {
	private JButton btnRemove01;
	CTDatPhong_DTO ctdp;

	ArrayList<Component> dataRows = new ArrayList<Component>();
	ArrayList<DichVu_DTO> listDV;
	Component Rows [][];
	boolean isAdd [];
	//ArrayList<JButton> pages = new ArrayList<JButton>();
	
	int page = 0, pageSize = 5, total = 0;
	int pageCount = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmBooking_Step2 frame = new frmBooking_Step2(new CTDatPhong_DTO());
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
	
	static ArrayList<CTDichVu_DTO> listBookingDV = new ArrayList<CTDichVu_DTO>();
	public frmBooking_Step2(CTDatPhong_DTO ctdp) {
		this.ctdp = ctdp;
		setBounds(100, 100, 810, 540); 
		getContentPane().setLayout(null);
		
		//define
				listDV = DichVu_BUS.getListDV();
				Rows = new Component [listDV.size()][5];
				isAdd = new boolean [listDV.size()];
				//creta default value
				for(int i = 0; i < listDV.size(); i++)
					isAdd[i] = false;
				
		JButton btnContinue = new JButton("Continue");
		btnContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				for(int i = 0; i < isAdd.length; i++) {
					if(isAdd[i]) {
						int iSL = Integer.parseInt( ((JEditorPane)Rows[i][2]).getText() );
						int iMaCTDatPhong = ctdp.getMaCTDatPhong();
						int iDonGia = listDV.get(i).getGiaDichVu();
						int iThanhTien = iSL * iDonGia;
						int iMaDV = listDV.get(i).getMaDichVu();
						CTDichVu_DTO dvTemp = new CTDichVu_DTO(iSL, iMaCTDatPhong, iThanhTien, iMaDV);
						
						listBookingDV.add(dvTemp);
					}
				}
				
				
				frmDashboard.frmBooking3 =  new frmBooking_Step3(ctdp, listBookingDV);
				frmDashboard.controlFrame(frmDashboard.FRM_BOOKING3);
			}
		});
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

		
		
		
		
		render(listDV);

	}
	
	void render(ArrayList<DichVu_DTO> data) {
//		page = 0;
		pageCount = (int) data.size() / pageSize;
		pageCount += data.size() % pageSize > 0 ? 1 : 0;
		int rowHeight = 30;
		int marginTop = 20;
		int marginLeft = 20;
		for(int i = 0; i < pageSize && (pageSize * page + i) < (data.size()); i++) {
			//if((pageSize * page + i) >= (data.size() -1) ) break;
			final int j = i;
			JEditorPane edDV01 = new JEditorPane();
			edDV01.setEditable(false);
			edDV01.setBounds(53, 73 + i * (marginTop + rowHeight), 235, rowHeight);
			getContentPane().add(edDV01);
			Rows[pageSize * page + i][0] = edDV01;
			//dataRows.add(edDV01);
			
			JEditorPane edSLDV01 = new JEditorPane();
			edSLDV01.setEditable(true);
			edSLDV01.setBounds(476, 73 + i * (marginTop + rowHeight), 71, rowHeight);
			getContentPane().add(edSLDV01);
			Rows[pageSize * page + i][2] = edSLDV01;
			//dataRows.add(edSLDV01);
			
			JEditorPane edGiaDV01 = new JEditorPane();
			edGiaDV01.setEditable(false);
			edGiaDV01.setBounds(325, 73 + i * (marginTop + rowHeight), 128, rowHeight);
			getContentPane().add(edGiaDV01);
			Rows[pageSize * page + i][1] = edGiaDV01;
			//dataRows.add(edGiaDV01);
			
			edDV01.setText(data.get(pageSize * page + i).getTenDichVu());
			String  strGiaDV =  String.valueOf(data.get(pageSize * page + i).getGiaDichVu());
			edGiaDV01.setText(strGiaDV);
			
			JButton btnAddDV01 = new JButton("Add");
			btnAddDV01.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					//btnRemove01.setEnabled(true);
					Rows[pageSize * page + j][4].setEnabled(true);
					Rows[pageSize * page + j][3].setEnabled(false);
					Rows[pageSize * page + j][2].setEnabled(false);
					isAdd[pageSize * page + j] = true;
					
					
//					int iSL = Integer.parseInt( edSLDV01.getText() );
//					int iMaCTDatPhong = ctdp.getMaCTDatPhong();
//					int iDonGia = data.get(pageSize * page + j).getGiaDichVu();
//					int iThanhTien = iSL * iDonGia;
//					int iMaDV = data.get(pageSize * page + j).getMaDichVu();
//					
//					CTDichVu_DTO dvTemp = new CTDichVu_DTO(iSL, iMaCTDatPhong, iThanhTien, iMaDV);
//					
//					listBookingDV.add(dvTemp);
				}
			});
			
			btnAddDV01.setBounds(593, 73 + i * (marginTop + rowHeight), 84, rowHeight);
			getContentPane().add(btnAddDV01);
			Rows[pageSize * page + i][3] = btnAddDV01;
			//dataRows.add(btnAddDV01);
			
			btnRemove01 = new JButton("Remove");
			btnRemove01.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Rows[pageSize * page + j][4].setEnabled(false);
					Rows[pageSize * page + j][3].setEnabled(true);
					Rows[pageSize * page + j][2].setEnabled(true);
					isAdd[pageSize * page + j] = false;
					
				}
			});
			btnRemove01.setEnabled(false);
			btnRemove01.setBounds(700, 73 + i * (marginTop + rowHeight), 84, rowHeight);
			getContentPane().add(btnRemove01);
			Rows[pageSize * page + i][4] = btnRemove01;
			
			
		}
		
		for(int i = 0; i < pageCount && pageCount > 1; i++) {
			final int j = i;
//			int m = data.size() % pageSize;
			JButton button = new JButton(Integer.toString(i + 1));
			button.setBounds(53 + i * (50 + marginLeft), 73 + (pageSize - 1) * (marginTop + rowHeight) + marginTop + rowHeight, 50, 39);
			getContentPane().add(button);
			dataRows.add(button);
			if(page == i) {
				button.setEnabled(false);
			}
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dataRows.forEach(p -> getContentPane().remove(p));
					getContentPane().revalidate();
					getContentPane().repaint();
					page = j;
					render(data);
				}
			});
		}
	}
}
