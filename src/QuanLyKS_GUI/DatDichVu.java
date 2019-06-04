package QuanLyKS_GUI;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import com.ibm.icu.text.SimpleDateFormat;
import com.toedter.calendar.JCalendar;

import QuanLyKS_BUS.CTDichVu_BUS;
import QuanLyKS_DTO.Phong_DTO;
import QuanLyKS_DAL.DichVu_DAL;
import QuanLyKS_DTO.CTDichVu_DTO;
import QuanLyKS_DTO.DichVu_DTO;
import QuanLyKS_BUS.Phong_BUS;

import java.awt.Font;
import java.awt.TextField;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class DatDichVu extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DatDichVu frame = new DatDichVu();
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
	
	//prepare list
	ArrayList<DichVu_DTO> listDV_DTO =  new ArrayList<DichVu_DTO>();
	DichVu_DAL dvDAL = new DichVu_DAL();
	ResultSet rsDichVu = DichVu_DAL.getListDV();
	private static int idDV = 0;
	
	Phong_BUS phongBUS = new Phong_BUS();

	public DatDichVu() {
		setBounds(100, 100, 667, 491);
		getContentPane().setLayout(null);
		JLabel lblMPhng = new JLabel("M\u00E3 ph\u00F2ng");
		lblMPhng.setBounds(20, 88, 63, 14);
		getContentPane().add(lblMPhng);
		
		JComboBox cbxMaPhong = new JComboBox();
		cbxMaPhong.setBounds(128, 85, 464, 20);
		getContentPane().add(cbxMaPhong);
		
		JLabel lblNewLabel = new JLabel("Th\u1EDDi gian \u0111\u1EB7t");
		lblNewLabel.setBounds(20, 204, 81, 14);
		getContentPane().add(lblNewLabel);
		
		JCalendar dtTuNgay = new JCalendar();
		dtTuNgay.setBounds(128, 143, 198, 153);
		getContentPane().add(dtTuNgay);
		
		JCalendar dtDenNgay = new JCalendar();
		dtDenNgay.setBounds(394, 143, 198, 153);
		getContentPane().add(dtDenNgay);
		
		JComboBox cbxMaDichVu = new JComboBox();
		cbxMaDichVu.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				//get the value selected of cbx and using loop to scan Arraylist LoaiPhong
        		//after find the LoaiPhong selected, using function getMaLoaiPhong to get ID
        		String nameDV = (String) cbxMaDichVu.getSelectedItem();
        		for(int i = 0; i < listDV_DTO.size(); i++) {
        			DichVu_DTO dvCompare = listDV_DTO.get(i);
        			if(nameDV.equals( dvCompare.getTenDichVu() ) )
        				idDV = dvCompare.getMaDichVu();
        		}
			}
		});
		cbxMaDichVu.setBounds(130, 317, 464, 20);
		getContentPane().add(cbxMaDichVu);
		
		JLabel lblDchV = new JLabel("D\u1ECBch v\u1EE5");
		lblDchV.setBounds(20, 320, 63, 14);
		getContentPane().add(lblDchV);
		
		JLabel lblSLng = new JLabel("S\u1ED1 l\u01B0\u1EE3ng");
		lblSLng.setBounds(20, 361, 63, 14);
		getContentPane().add(lblSLng);
		
		JLabel lbltDchV = new JLabel("\u0110\u1EB6T D\u1ECACH V\u1EE4");
		lbltDchV.setFont(new Font("Tahoma", Font.BOLD, 26));
		lbltDchV.setBounds(321, 24, 207, 32);
		getContentPane().add(lbltDchV);
		
		//get list Phong
//		try {    
//	        while(rsPhong.next() ) {
//	        	
//	        	cbxMaPhong.addItem(rsPhong.getString("MaPhong"));
//	        	cbxMaPhong.getSelectedItem();
//			  }
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		
		ArrayList<Phong_DTO> listPhong = phongBUS.LoadListPhong();
		for(int i = 0; i <listPhong.size(); i++) {
			cbxMaPhong.addItem(listPhong.get(i).getMaPhong());
		}
		
		//get List Dich Vu
		try {    
	        while(rsDichVu.next() ) {
	        	DichVu_DTO lpTemp = new DichVu_DTO(rsDichVu.getInt("MaDichVu"), rsDichVu.getString("TenDichVu"));
        		listDV_DTO.add(lpTemp);
	        	cbxMaDichVu.addItem(rsDichVu.getString("TenDichVu"));
	        	cbxMaDichVu.getSelectedItem();
			  }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		TextField txtSoLuong = new TextField();
		txtSoLuong.setBounds(128, 361, 464, 22);
		getContentPane().add(txtSoLuong);
		Button btnDatDichVu = new Button("Booking");
		btnDatDichVu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String strMaPhong = (cbxMaPhong.getSelectedItem()).toString();
				int iMaPhong = Integer.parseInt(strMaPhong);
				
				int SoLuong = Integer.parseInt(txtSoLuong.getText());
					System.out.println(SoLuong);
        		CTDichVu_DTO ctdvDTO = new CTDichVu_DTO(SoLuong, idDV, iMaPhong);
        		
//        		if(CTDichVu_BUS.Insert(ctdvDTO) == true) {
//        			JOptionPane.showMessageDialog(null, "Insert booking Success", "Success: " + "Success Mesage", JOptionPane.INFORMATION_MESSAGE);
//        		}else {
//        			JOptionPane.showMessageDialog(null, "Insert booking Fail", "Fail: " + "Success Mesage", JOptionPane.CLOSED_OPTION);
//        		}
			}
		});
		btnDatDichVu.setFont(new Font("Arial", Font.PLAIN, 12));
		btnDatDichVu.setBounds(328, 409, 108, 22);
		getContentPane().add(btnDatDichVu);

	}
}
