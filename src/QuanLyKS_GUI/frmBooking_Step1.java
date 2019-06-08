package QuanLyKS_GUI;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.ibm.icu.text.SimpleDateFormat;
import com.toedter.calendar.JDateChooser;

import QuanLyKS_BUS.CTDatPhong_BUS;
import QuanLyKS_BUS.LoaiPhong_BUS;
import QuanLyKS_BUS.Phong_BUS;
import QuanLyKS_DAL.Phong_DAL;
import QuanLyKS_DTO.CTDatPhong_DTO;
import QuanLyKS_DTO.LoaiPhong_DTO;
import QuanLyKS_DTO.Phong_DTO;
import QuanLyKS_GUI.frmLogin;


public class frmBooking_Step1 extends JInternalFrame {
	ArrayList<LoaiPhong_DTO> listLP = LoaiPhong_BUS.LoadListLP();
	ArrayList<Phong_DTO> listPhong = new ArrayList<Phong_DTO>();
	public static CTDatPhong_DTO ctdpDTO = new CTDatPhong_DTO();
	
	private int iMaPhong = 0;
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
		 
		date_NgayNhanPhong.setBounds(208, 121, 142, 25);
		getContentPane().add(date_NgayNhanPhong);
		date_NgayNhanPhong.setDateFormatString("yyyy-MM-dd");
		
		
		JDateChooser date_NgayTraPhong = new JDateChooser();
		
		date_NgayTraPhong.setBounds(420, 121, 133, 25);
		getContentPane().add(date_NgayTraPhong);
		date_NgayTraPhong.setDateFormatString("yyyy-MM-dd");
		
		
		//set Default NgayNhanPhong
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");        	 	
		Date currentDate = new Date();
		date_NgayNhanPhong.setDate(currentDate);
		Date dtNgayNhan =  new Date(date_NgayNhanPhong.getDate().getTime());
		String strNgayNhan = sdf.format(dtNgayNhan);
		
		//set Default NgayTraPhong
		date_NgayTraPhong.setDate(currentDate);
		date_NgayNhanPhong.setDate(currentDate);
		Date dtNgayTra =  new Date(date_NgayTraPhong.getDate().getTime());
		String strNgayTra = sdf.format(dtNgayTra);
		
		
		
		
		
		
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
		JComboBox cbxMaPhong = new JComboBox();
		cbxMaPhong.setBounds(208, 352, 345, 20);
	 	JButton btnTiepTuc = new JButton("Ti\u1EBFp t\u1EE5c");
		btnTiepTuc.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {					 
			 	 System.err.println("update thanh cong dich vu" + date_NgayNhanPhong.getDate().getTime());
			 	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
			 	 Date NgayNhan = date_NgayNhanPhong.getDate();
			 	 Date NgayTra = date_NgayTraPhong.getDate();
			 	 
			 	 //break if NgayNhan > NgayTra
			 	 if(NgayNhan.compareTo(NgayTra) > 0) {
			 		JOptionPane.showMessageDialog(null, "Ngày Nhận và ngày trả không phù hợp", "Success: " + "Warning Message", JOptionPane.INFORMATION_MESSAGE);
			 		 return;
			 	 }
			 		 
			 	 
			   	ctdpDTO.setNgayNhan( date_NgayNhanPhong.getDate());
				ctdpDTO.setNgayTra(date_NgayTraPhong.getDate());
				ctdpDTO.setMaNhanVien(frmLogin.acc.getMaNhanVien());
				
				//get current date   	 	
				Date currentDate = new Date();
				ctdpDTO.setdtNgayThucHien( currentDate);
								
				Object obj = cbxMaPhong.getSelectedItem();
				int iMaPhong = Integer.parseInt(obj.toString());
				ctdpDTO.setMaPhong(iMaPhong);
				int iCTDP = CTDatPhong_BUS.getnextID();
				ctdpDTO.setMaCTDatPhong(iCTDP);
					
				
				frmDashboard.frmBooking2 = new frmBooking_Step2(ctdpDTO);
				frmDashboard.controlFrame(frmDashboard.FRM_BOOKING2);
			}
		});
		btnTiepTuc.setBounds(309, 427, 133, 25);
		getContentPane().add(btnTiepTuc);
		
		getContentPane().add(cbxMaPhong);
		JComboBox cbxLoaiPhong = new JComboBox();
	  //Load list LoaiPhong
		for(int i = 0; i < listLP.size(); i++) {
			cbxLoaiPhong.addItem(listLP.get(i).getTenLoaiPhong());
			cbxLoaiPhong.getSelectedItem();
		}
		cbxLoaiPhong.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				String nameLP = (String) cbxLoaiPhong.getSelectedItem();
				int iMaLoaiPhong = 0;
				for(int i = 0; i < listLP.size(); i++) {
					LoaiPhong_DTO lpCompare = listLP.get(i);
        			if(nameLP.equals( lpCompare.getTenLoaiPhong() ) ) {
        				int Gia = lpCompare.getGiaPhong();
        				edGia.setText(String.valueOf(Gia));
        				edMoTa.setText(lpCompare.getMoTa());
        				iMaLoaiPhong = lpCompare.getMaLoaiPhong();
        			}
        				 
				}
				//set Default NgayNhanPhong
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");        	 	
				Date dtNgayNhan =  new Date(date_NgayNhanPhong.getDate().getTime());
				String strNgayNhan = sdf.format(dtNgayNhan);
				
				//set Default NgayTraPhong
				Date dtNgayTra =  new Date(date_NgayTraPhong.getDate().getTime());
				String strNgayTra = sdf.format(dtNgayTra);
							
				ResultSet rslistPhong = Phong_DAL.selectCondition(iMaLoaiPhong, strNgayNhan, strNgayTra);
				try {
					cbxMaPhong.removeAllItems();
					while(rslistPhong.next() ) {
					 		cbxMaPhong.addItem(rslistPhong.getInt("MaPhong"));
					 		cbxMaPhong.getSelectedItem();
					   }
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
               	  
         		
			}
		});
		cbxLoaiPhong.setBounds(208, 195, 345, 20);
		getContentPane().add(cbxLoaiPhong);
		
		//autoload MaPong Validated
		String nameLP = (String) cbxLoaiPhong.getSelectedItem();
		int iMaLoaiPhong = 0;
		for(int i = 0; i < listLP.size(); i++) {
			LoaiPhong_DTO lpCompare = listLP.get(i);
			if(nameLP.equals( lpCompare.getTenLoaiPhong() ) ) {
				int Gia = lpCompare.getGiaPhong();
				edGia.setText(String.valueOf(Gia));
				edMoTa.setText(lpCompare.getMoTa());
				iMaLoaiPhong = lpCompare.getMaLoaiPhong();
			}
				 
		}				
		ResultSet rslistPhong = Phong_DAL.selectCondition(iMaLoaiPhong, strNgayNhan, strNgayTra);
		try {
			cbxMaPhong.removeAllItems();
			while(rslistPhong.next() ) {
			 		cbxMaPhong.addItem(rslistPhong.getInt("MaPhong"));
			 		cbxMaPhong.getSelectedItem();
			   }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       	  ///////end autoload
		
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
		
		 
		
		JLabel lblNewLabel_2 = new JLabel("S\u1ED1 ph\u00F2ng");
		lblNewLabel_2.setBounds(208, 327, 67, 14);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblMT = new JLabel("M\u00F4 t\u1EA3");
		lblMT.setBounds(229, 230, 61, 25);
		getContentPane().add(lblMT);
		
		JLabel lblGi = new JLabel("Gi\u00E1");
		lblGi.setBounds(435, 230, 61, 25);
		getContentPane().add(lblGi);
		
		

		date_NgayNhanPhong.addInputMethodListener(new InputMethodListener() {
			public void caretPositionChanged(InputMethodEvent arg0) {
			}
			public void inputMethodTextChanged(InputMethodEvent arg0) {
				//autoload MaPong Validated
				String nameLP = (String) cbxLoaiPhong.getSelectedItem();
				int iMaLoaiPhong = 0;
				for(int i = 0; i < listLP.size(); i++) {
					LoaiPhong_DTO lpCompare = listLP.get(i);
					if(nameLP.equals( lpCompare.getTenLoaiPhong() ) ) {
						int Gia = lpCompare.getGiaPhong();
						edGia.setText(String.valueOf(Gia));
						edMoTa.setText(lpCompare.getMoTa());
						iMaLoaiPhong = lpCompare.getMaLoaiPhong();
					}
						 
				}	
				
				//set Default NgayNhanPhong
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");        	 	
				Date dtNgayNhan =  new Date(date_NgayNhanPhong.getDate().getTime());
				String strNgayNhan = sdf.format(dtNgayNhan);
				
				//set Default NgayTraPhong
				Date dtNgayTra =  new Date(date_NgayTraPhong.getDate().getTime());
				String strNgayTra = sdf.format(dtNgayTra);
				
				ResultSet rslistPhong = Phong_DAL.selectCondition(iMaLoaiPhong, strNgayNhan, strNgayTra);
				try {
					cbxMaPhong.removeAllItems();
					while(rslistPhong.next() ) {
					 		cbxMaPhong.addItem(rslistPhong.getInt("MaPhong"));
					 		cbxMaPhong.getSelectedItem();
					   }
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		       	  ///////end autoload
				
			}
		});
		
	}
}
