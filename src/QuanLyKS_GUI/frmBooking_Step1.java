package QuanLyKS_GUI;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

import com.ibm.icu.text.DateFormat;
import com.ibm.icu.text.SimpleDateFormat;
import com.toedter.calendar.JDateChooser;

import QuanLyKS_DTO.LoaiPhong_DTO;
import QuanLyKS_DTO.CTDatPhong_DTO;
import QuanLyKS_BUS.LoaiPhong_BUS;
import QuanLyKS_GUI.frmDashboard;


import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JEditorPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;

public class frmBooking_Step1 extends JInternalFrame {
	private JTable tbChiTiet;
	ArrayList<LoaiPhong_DTO> listLP = LoaiPhong_BUS.LoadListLP();
	public CTDatPhong_DTO ctdpDTO = new CTDatPhong_DTO();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmBooking_Step1 frame = new frmBooking_Step1();
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
	public frmBooking_Step1() {
		setBounds(100, 100, 729, 593);
		getContentPane().setLayout(null);
		
		JDateChooser date_NgayNhanPhong = new JDateChooser();
		date_NgayNhanPhong.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent arg0) {
				ctdpDTO.setNgayNhan(new Date(date_NgayNhanPhong.getDate().getTime()));
			 	//System.out.println(NgayDen); 
			}
			public void ancestorMoved(AncestorEvent arg0) {
			}
			public void ancestorRemoved(AncestorEvent arg0) {
			}
		});
		date_NgayNhanPhong.addInputMethodListener(new InputMethodListener() {
			public void caretPositionChanged(InputMethodEvent arg0) {
			}
			public void inputMethodTextChanged(InputMethodEvent arg0) {
				
			}
		});
		date_NgayNhanPhong.setBounds(208, 121, 142, 25);
		getContentPane().add(date_NgayNhanPhong);
		date_NgayNhanPhong.setDateFormatString("dd/MM/yyyy");
		
		
		JDateChooser date_NgayTraPhong = new JDateChooser();
		date_NgayTraPhong.setBounds(420, 121, 133, 25);
		getContentPane().add(date_NgayTraPhong);
		date_NgayTraPhong.setDateFormatString("dd/MM/yyyy");
		
		JLabel lblNewLabel = new JLabel("Ng\u00E0y nh\u1EADn ph\u00F2ng");
		lblNewLabel.setBounds(224, 85, 110, 25);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNgyTrPhng = new JLabel("Ng\u00E0y tr\u1EA3 ph\u00F2ng");
		lblNgyTrPhng.setBounds(435, 85, 110, 25);
		getContentPane().add(lblNgyTrPhng);
		
		JLabel lblNewLabel_1 = new JLabel("CH\u00C0O M\u1EEANG B\u1EA0N \u0110\u1EB6T PH\u00D2NG");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(249, 27, 296, 37);
		getContentPane().add(lblNewLabel_1);
		
		JEditorPane edMoTa = new JEditorPane();
		edMoTa.setEditable(false);
		edMoTa.setText("c,jbsjk");
		edMoTa.setBounds(208, 266, 218, 37);
		getContentPane().add(edMoTa);
		
		JEditorPane edGia = new JEditorPane();
		edGia.setEditable(false);
		edGia.setBounds(435, 266, 118, 37);
		getContentPane().add(edGia);
		
		JButton btnTiepTuc = new JButton("Ti\u1EBFp t\u1EE5c");
		btnTiepTuc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int SoPhong = 1;
				//frmDashboard.frmBooking2 = new frmBooking_Step2(SoPhong);
				frmDashboard.controlFrame(frmDashboard.FRM_BOOKING2);
			}
		});
		btnTiepTuc.setBounds(420, 494, 133, 25);
		getContentPane().add(btnTiepTuc);
		
		JComboBox cbxLoaiPhong = new JComboBox();
		cbxLoaiPhong.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				String nameLP = (String) cbxLoaiPhong.getSelectedItem();
				for(int i = 0; i < listLP.size(); i++) {
					LoaiPhong_DTO lpCompare = listLP.get(i);
        			if(nameLP.equals( lpCompare.getTenLoaiPhong() ) ) {
        				int Gia = lpCompare.getGiaPhong();
        				edGia.setText(String.valueOf(Gia));
        				//edMoTa.setText(lpCompare.getMoTa());
        			}
        				 
				}
			}
		});
		cbxLoaiPhong.setBounds(208, 195, 345, 20);
		getContentPane().add(cbxLoaiPhong);
		
		  //Load list LoaiPhong
				
		for(int i = 0; i < listLP.size(); i++) {
			cbxLoaiPhong.addItem(listLP.get(i).getTenLoaiPhong());
			cbxLoaiPhong.getSelectedItem();
		}
		
		JLabel lblDchV = new JLabel("Lo\u1EA1i ph\u00F2ng");
		lblDchV.setBounds(336, 157, 110, 25);
		getContentPane().add(lblDchV);
			
		DefaultTableModel m = new DefaultTableModel(
				new Object[][] {
				}, 
				new String[] {
					"MaNhanVien", "TenNhanVien", "NgaySinh", "CMND", "NgayVaoLam", "TenChucVu"
				}
			);
		tbChiTiet = new JTable(m);
		tbChiTiet.setBounds(208, 383, 345, 62);
		getContentPane().add(tbChiTiet);
		tbChiTiet.setRowSelectionAllowed(true);
		
		JButton btnDatPhong = new JButton("\u0110\u1EB7t ph\u00F2ng");
		btnDatPhong.setBounds(208, 494, 110, 25);
		getContentPane().add(btnDatPhong);
		
		JComboBox cbxMaPhong = new JComboBox();
		cbxMaPhong.setBounds(208, 352, 345, 20);
		getContentPane().add(cbxMaPhong);
		
		JLabel lblNewLabel_2 = new JLabel("S\u1ED1 ph\u00F2ng");
		lblNewLabel_2.setBounds(208, 327, 67, 14);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblMT = new JLabel("M\u00F4 t\u1EA3");
		lblMT.setBounds(229, 230, 61, 25);
		getContentPane().add(lblMT);
		
		JLabel lblGi = new JLabel("Gi\u00E1");
		lblGi.setBounds(435, 230, 61, 25);
		getContentPane().add(lblGi);
	}
}
