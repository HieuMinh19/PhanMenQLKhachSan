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
import QuanLyKS_BUS.DichVu_BUS;
import QuanLyKS_BUS.LoaiPhong_BUS;
import QuanLyKS_BUS.Phong_BUS;
import QuanLyKS_DAL.Phong_DAL;
import QuanLyKS_DTO.CTDatPhong_DTO;
import QuanLyKS_DTO.CTDichVu_DTO;
import QuanLyKS_DTO.DichVu_DTO;
import QuanLyKS_DTO.LoaiPhong_DTO;
import QuanLyKS_DTO.Phong_DTO;
import QuanLyKS_GUI.frmLogin;
import java.awt.Color;
import java.awt.Component;


public class frmBooking_Step1 extends JInternalFrame {
	ArrayList<LoaiPhong_DTO> listLP = LoaiPhong_BUS.LoadListLP();
	ArrayList<Phong_DTO> listPhong = new ArrayList<Phong_DTO>();
	ArrayList<CTDichVu_DTO> listBookingDV = new ArrayList<CTDichVu_DTO>();
	public static ArrayList<CTDatPhong_DTO> listCTDP = new ArrayList<CTDatPhong_DTO>();
	public static ArrayList<ArrayList<CTDichVu_DTO>> listBookingDVs = new ArrayList<ArrayList<CTDichVu_DTO>>();
	
	private int iMaPhong = 0;
	
	ArrayList<Component> dataRows = new ArrayList<Component>();
	ArrayList<DichVu_DTO> listDV;
	Component Rows [][];
	boolean isAdd [];
	//ArrayList<JButton> pages = new ArrayList<JButton>();
	
	int page = 0, pageSize = 5, total = 0;
	int pageCount = 0;
	int rowHeight = 30;
	int marginTop = 20;
	int marginLeft = 20;
	int iCTDP = 1;

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
		getContentPane().setFont(new Font("Times New Roman", Font.PLAIN, 13));
		setBounds(100, 100, 900, 800);
		getContentPane().setLayout(null);
		
		JDateChooser date_NgayNhanPhong = new JDateChooser();
		date_NgayNhanPhong.getCalendarButton().setFont(new Font("Tahoma", Font.PLAIN, 16));
		date_NgayNhanPhong.setBounds(208, 121, 150, 30);
		getContentPane().add(date_NgayNhanPhong);
		date_NgayNhanPhong.setDateFormatString("dd-MM-yyyy");
		
		
		JDateChooser date_NgayTraPhong = new JDateChooser();
		date_NgayTraPhong.setBounds(499, 121, 150, 30);
		getContentPane().add(date_NgayTraPhong);
		date_NgayTraPhong.setDateFormatString("dd-MM-yyyy");
		
		
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
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(208, 83, 142, 25);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNgyTrPhng = new JLabel("Ng\u00E0y tr\u1EA3 ph\u00F2ng");
		lblNgyTrPhng.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNgyTrPhng.setBounds(513, 83, 133, 25);
		getContentPane().add(lblNgyTrPhng);
		
		JLabel lblNewLabel_1 = new JLabel("CH\u00C0O M\u1EEANG B\u1EA0N \u0110\u1EB6T PH\u00D2NG");
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(208, 13, 441, 37);
		getContentPane().add(lblNewLabel_1);
		
		JEditorPane edMoTa = new JEditorPane();
		edMoTa.setFont(new Font("Tahoma", Font.PLAIN, 16));
		edMoTa.setEditable(false);
		edMoTa.setBounds(208, 253, 441, 91);
		getContentPane().add(edMoTa);

		JEditorPane edGia = new JEditorPane();
		edGia.setToolTipText("");
		edGia.setFont(new Font("Tahoma", Font.PLAIN, 16));
		edGia.setEditable(false);
	 	edGia.setBounds(499, 191, 150, 30);
		getContentPane().add(edGia);
		JComboBox cbxMaPhong = new JComboBox();
		cbxMaPhong.setBounds(208, 371, 173, 30);
	 	JButton btnTiepTuc = new JButton("Ti\u1EBFp t\u1EE5c");
	 	btnTiepTuc.setBackground(Color.ORANGE);
	 	btnTiepTuc.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnTiepTuc.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {			
				//-----------------------Them CTDP----------------------------------------------------------------------------------------------
			 	 System.err.println("update thanh cong dich vu" + date_NgayNhanPhong.getDate().getTime());
//			 	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
			 	 Date NgayNhan = date_NgayNhanPhong.getDate();
			 	 Date NgayTra = date_NgayTraPhong.getDate();
			 	 
			 	 //break if NgayNhan > NgayTra
			 	Date currentDate = new Date();
			 	 if(NgayNhan.compareTo(NgayTra) > 0 || NgayNhan.compareTo(currentDate) < 0) {
			 		JOptionPane.showMessageDialog(null, "Ngày nhận và ngày trả không phù hợp", "Success: " + "Warning Message", JOptionPane.INFORMATION_MESSAGE);
			 		 return;
			 	 }
			 	 
			 	 CTDatPhong_DTO ctdpDTO = new CTDatPhong_DTO();
			 		 
			   	ctdpDTO.setNgayNhan( date_NgayNhanPhong.getDate());
				ctdpDTO.setNgayTra(date_NgayTraPhong.getDate());
//				ctdpDTO.setMaNhanVien(frmLogin.acc.getMaNhanVien());
				ctdpDTO.setMaNhanVien(frmDashboard.user.getMaNhanVien());
				
				//get current date   	 	
				ctdpDTO.setdtNgayThucHien( currentDate);
								
				Object obj = cbxMaPhong.getSelectedItem();
				int iMaPhong = Integer.parseInt(obj.toString());
				ctdpDTO.setMaPhong(iMaPhong);
				if(iCTDP > 0) ctdpDTO.setMaCTDatPhong(++iCTDP);
				else {
					iCTDP = CTDatPhong_BUS.getnextID();
					ctdpDTO.setMaCTDatPhong(iCTDP);
				}

				for(int i = 0; i < isAdd.length; i++) {
					if(isAdd[i]) {
						int iSL = Integer.parseInt( ((JEditorPane)Rows[i][2]).getText() );
						int iMaCTDatPhong = ctdpDTO.getMaCTDatPhong();
						int iDonGia = listDV.get(i).getGiaDichVu();
						int iThanhTien = iSL * iDonGia;
						int iMaDV = listDV.get(i).getMaDichVu();
						CTDichVu_DTO dvTemp = new CTDichVu_DTO(iSL, iMaCTDatPhong, iThanhTien, iMaDV);
						
						listBookingDV.add(dvTemp);
					}
				}
				listBookingDVs.add(listBookingDV);
				
			 	frmBooking_Step1.listCTDP.add(ctdpDTO);
				
//				frmDashboard.frmBooking2 = new frmBooking_Step2(ctdpDTO);
				//-----------------------End Them CTDP----------------------------------------------------------------------------------------------
				frmDashboard.controlFrame(frmDashboard.FRM_BOOKING3);
//				frmDashboard.controlFrame(frmDashboard.FRM_BOOKING2);
			}
		});
		btnTiepTuc.setBounds(499, 520 + (pageSize - 1) * (marginTop + rowHeight) + marginTop + rowHeight, 150, 40);
		getContentPane().add(btnTiepTuc);
		
		getContentPane().add(cbxMaPhong);
		JComboBox cbxLoaiPhong = new JComboBox();
		cbxLoaiPhong.setFont(new Font("Tahoma", Font.PLAIN, 16));
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
		cbxLoaiPhong.setBounds(208, 191, 218, 30);
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
		lblDchV.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDchV.setBounds(97, 191, 99, 25);
		getContentPane().add(lblDchV);
			
		DefaultTableModel m = new DefaultTableModel(
				new Object[][] {
				}, 
				new String[] {
					"MaNhanVien", "TenNhanVien", "NgaySinh", "CMND", "NgayVaoLam", "TenChucVu"
				}
			);
		
		 
		
		JLabel lblNewLabel_2 = new JLabel("S\u1ED1 ph\u00F2ng");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(111, 372, 76, 24);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblMT = new JLabel("M\u00F4 t\u1EA3");
		lblMT.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMT.setBounds(143, 253, 45, 25);
		getContentPane().add(lblMT);
		
		JLabel lblGi = new JLabel("Gi\u00E1");
		lblGi.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblGi.setBounds(450, 191, 38, 25);
		getContentPane().add(lblGi);
		
		JButton btnDatThem = new JButton("Đặt thêm");
		btnDatThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//-----------------------Them CTDP----------------------------------------------------------------------------------------------
			 	 System.err.println("update thanh cong dich vu" + date_NgayNhanPhong.getDate().getTime());
//			 	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
			 	 Date NgayNhan = date_NgayNhanPhong.getDate();
			 	 Date NgayTra = date_NgayTraPhong.getDate();
			 	 
			 	 //break if NgayNhan > NgayTra
			 	Date currentDate = new Date();
			 	 if(NgayNhan.compareTo(NgayTra) > 0 || NgayNhan.compareTo(currentDate) < 0) {
			 		JOptionPane.showMessageDialog(null, "Ngày nhận và ngày trả không phù hợp", "Success: " + "Warning Message", JOptionPane.INFORMATION_MESSAGE);
			 		 return;
			 	 }
			 	 
			 	 CTDatPhong_DTO ctdpDTO = new CTDatPhong_DTO();
			 		 
			   	ctdpDTO.setNgayNhan( date_NgayNhanPhong.getDate());
				ctdpDTO.setNgayTra(date_NgayTraPhong.getDate());
//				ctdpDTO.setMaNhanVien(frmLogin.acc.getMaNhanVien());
				ctdpDTO.setMaNhanVien(frmDashboard.user.getMaNhanVien());
				
				//get current date   	 	
				ctdpDTO.setdtNgayThucHien( currentDate);
								
				Object obj = cbxMaPhong.getSelectedItem();
				int iMaPhong = Integer.parseInt(obj.toString());
				ctdpDTO.setMaPhong(iMaPhong);
				if(iCTDP > 0) ctdpDTO.setMaCTDatPhong(++iCTDP);
				else {
					iCTDP = CTDatPhong_BUS.getnextID();
					ctdpDTO.setMaCTDatPhong(iCTDP);
				}

				for(int i = 0; i < isAdd.length; i++) {
					if(isAdd[i]) {
						int iSL = Integer.parseInt( ((JEditorPane)Rows[i][2]).getText() );
						int iMaCTDatPhong = ctdpDTO.getMaCTDatPhong();
						int iDonGia = listDV.get(i).getGiaDichVu();
						int iThanhTien = iSL * iDonGia;
						int iMaDV = listDV.get(i).getMaDichVu();
						CTDichVu_DTO dvTemp = new CTDichVu_DTO(iSL, iMaCTDatPhong, iThanhTien, iMaDV);
						
						listBookingDV.add(dvTemp);
					}
				}
				listBookingDVs.add(listBookingDV);
				for(int i = 0; i < listDV.size(); i++)
					isAdd[i] = false;
				
			 	frmBooking_Step1.listCTDP.add(ctdpDTO);
			 	
				JOptionPane.showMessageDialog(null, "Nhập thông tin phòng tiếp theo", "Thông báo", JOptionPane.CLOSED_OPTION);
			 	
			 
				//-----------------------End Them CTDP----------------------------------------------------------------------------------------------
			}
		});
		btnDatThem.setBackground(Color.ORANGE);
		btnDatThem.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnDatThem.setBounds(208, 520 + (pageSize - 1) * (marginTop + rowHeight) + marginTop + rowHeight, 150, 40);
		getContentPane().add(btnDatThem);
		
		

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

		//define
				listDV = DichVu_BUS.getListDV();
				Rows = new Component [listDV.size()][5];
				isAdd = new boolean [listDV.size()];
				//creta default value
				for(int i = 0; i < listDV.size(); i++)
					isAdd[i] = false;
				
		JLabel lblDichVu = new JLabel("Th\u00EAm c\u00E1c d\u1ECBch v\u1EE5 theo y\u00EAu c\u1EA7u kh\u00E1ch h\u00E0ng");
		lblDichVu.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblDichVu.setBounds(197, 437, 489, 33);
		getContentPane().add(lblDichVu);
		
		JLabel lblNewLabel_3 = new JLabel("Tên dịch vụ");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(122, 483, 83, 25);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblGiTin = new JLabel("Giá tiền");
		lblGiTin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblGiTin.setBounds(359, 483, 54, 25);
		getContentPane().add(lblGiTin);
		
		JLabel lblSLng = new JLabel("Số lượng");
		lblSLng.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSLng.setBounds(481, 483, 64, 25);
		getContentPane().add(lblSLng);
		
		render(listDV);
	}

	void render(ArrayList<DichVu_DTO> data) {
//		page = 0;
		pageCount = (int) data.size() / pageSize;
		pageCount += data.size() % pageSize > 0 ? 1 : 0;
		for(int i = 0; i < pageSize && (pageSize * page + i) < (data.size()); i++) {
			//if((pageSize * page + i) >= (data.size() -1) ) break;
			final int j = i;
			JEditorPane edDV01 = new JEditorPane();
			edDV01.setEditable(false);
			edDV01.setBounds(53, 520 + i * (marginTop + rowHeight), 235, rowHeight);
			getContentPane().add(edDV01);
			Rows[pageSize * page + i][0] = edDV01;
			
			JEditorPane edSLDV01 = new JEditorPane();
			edSLDV01.setEditable(true);
			edSLDV01.setBounds(476, 520 + i * (marginTop + rowHeight), 71, rowHeight);
			getContentPane().add(edSLDV01);
			Rows[pageSize * page + i][2] = edSLDV01;
			
			JEditorPane edGiaDV01 = new JEditorPane();
			edGiaDV01.setEditable(false);
			edGiaDV01.setBounds(325, 520 + i * (marginTop + rowHeight), 128, rowHeight);
			getContentPane().add(edGiaDV01);
			Rows[pageSize * page + i][1] = edGiaDV01;
			
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
					
				}
			});
			
			btnAddDV01.setBounds(593, 520 + i * (marginTop + rowHeight), 84, rowHeight);
			getContentPane().add(btnAddDV01);
			Rows[pageSize * page + i][3] = btnAddDV01;
			//dataRows.add(btnAddDV01);
			
			JButton btnRemove01 = new JButton("Remove");
			btnRemove01.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Rows[pageSize * page + j][4].setEnabled(false);
					Rows[pageSize * page + j][3].setEnabled(true);
					Rows[pageSize * page + j][2].setEnabled(true);
					isAdd[pageSize * page + j] = false;
					
				}
			});
			btnRemove01.setEnabled(false);
			btnRemove01.setBounds(700, 520 + i * (marginTop + rowHeight), 84, rowHeight);
			getContentPane().add(btnRemove01);
			Rows[pageSize * page + i][4] = btnRemove01;
			
			
		}
		
		for(int i = 0; i < pageCount && pageCount > 1; i++) {
			final int j = i;
//			int m = data.size() % pageSize;
			JButton button = new JButton(Integer.toString(i + 1));
			button.setBounds(53 + i * (50 + marginLeft), 520 + (pageSize - 1) * (marginTop + rowHeight) + marginTop + rowHeight, 50, 39);
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
