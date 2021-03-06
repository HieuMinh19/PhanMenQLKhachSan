package QuanLyKS_GUI;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import QuanLyKS_DTO.BangPhanCong_DTO;
import QuanLyKS_DTO.ChucVu_DTO;
import QuanLyKS_DTO.NhanVien_DTO;

import javax.swing.JOptionPane;
//import QuanLyKS_BUS.BangPhanCong_BUS;
import javax.swing.JPasswordField;

import java.util.ArrayList;
import java.util.Arrays;
import com.ibm.icu.text.SimpleDateFormat;
import com.toedter.calendar.JCalendar;
import QuanLyKS_DAL.BangPhanCong_DAL;
import QuanLyKS_DAL.ChucVu_DAL;
import QuanLyKS_DAL.NhanVien_DAL;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.toedter.calendar.JDateChooser;
import QuanLyKS_DTO.NhanVien_DTO;
import QuanLyKS_BUS.BangPhanCong_BUS;
import java.awt.Color;


public class BangPhanCong extends JInternalFrame {
	private JTextField txtTenCongViec;
	private BangPhanCong_DTO dichvu_DTO;
	// private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	ArrayList<NhanVien_DTO> listCV_DTO =  new ArrayList<NhanVien_DTO>();
	private static int idCV = 0;
	NhanVien_DAL cvDAL = new NhanVien_DAL();
	ResultSet rslistNhanVien = cvDAL.getListNhanVien();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DichVu frame = new DichVu();
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
	public BangPhanCong() {
		//BangPhanCong_DAL CTDichVu_DAL = new BangPhanCong_DAL();
//        ResultSet   = CTDichVu_DAL.getListDV();

		setBounds(100, 100, 900, 700);
		getContentPane().setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("T\u00EAn C\u00F4ng Vi\u1EC7c");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(166, 179, 117, 22);
		getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Ng\u00E0y L\u00E0m Vi\u1EC7c");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(166, 244, 117, 22);
		getContentPane().add(lblNewLabel_3);

		JDateChooser dtNgayLam = new JDateChooser();
		dtNgayLam.setDateFormatString("dd/MM/yyyy");
		dtNgayLam.setBounds(295, 244, 250, 30);
		getContentPane().add(dtNgayLam);

		txtTenCongViec = new JTextField();
		txtTenCongViec.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtTenCongViec.setBounds(295, 176, 250, 30);
		getContentPane().add(txtTenCongViec);
		txtTenCongViec.setColumns(10);

		JButton btnThemPhanCong = new JButton("Th\u00EAm Ph\u00E2n C\u00F4ng");
		btnThemPhanCong.setBackground(Color.GREEN);
		btnThemPhanCong.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnThemPhanCong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//dichvu_DTO = new BangPhanCong_DTO(); 
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
				//Date NgaySinh = sdf.format( dtNgayLam.getDate() );	
				//dichvu_DTO.setNgayPhanCong( txtTenCongViec.getText() );
				//dichvu_DTO.setMaNhanVien( Integer.parseInt(txtGiaDichVu.getText()));
				System.err.println("NgayPhanCong trong form" + dtNgayLam.getDate().getTime());
				BangPhanCong_DTO nvDTO = new BangPhanCong_DTO(new Date(dtNgayLam.getDate().getTime()),txtTenCongViec.getText(), idCV);
				 if(  BangPhanCong_BUS.Insert(nvDTO) == true)
					 JOptionPane.showMessageDialog(null, "Thêm Thanh Công", "Success: " + "Success Mesage", JOptionPane.INFORMATION_MESSAGE);
				 else
					 JOptionPane.showMessageDialog(null, "Thêm Thất Bại", "Fail: " + "Success Mesage", JOptionPane.CLOSED_OPTION);

			}
		});
		btnThemPhanCong.setBounds(319, 305, 200, 40);
		getContentPane().add(btnThemPhanCong);
		
		JLabel lblTnNhnVin = new JLabel("T\u00EAn Nh\u00E2n Vi\u00EAn");
		lblTnNhnVin.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTnNhnVin.setBounds(166, 111, 117, 30);
		getContentPane().add(lblTnNhnVin);
		
		JComboBox<String> cbxTenNhanVien = new JComboBox<String>();
		cbxTenNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cbxTenNhanVien.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				System.err.println("cbx ten nhan vien");
				//get the value selected of cbx and using loop to scan Arraylist LoaiPhong
        		//after find the LoaiPhong selected, using function getMaLoaiPhong to get ID
        		String nameLP = (String) cbxTenNhanVien.getSelectedItem();
        		for(int i = 0; i < listCV_DTO.size(); i++) {
        			NhanVien_DTO cvCompare = listCV_DTO.get(i);
        			if(nameLP.equals( cvCompare.getTenNhanVien() ) )
        				idCV = cvCompare.getMaNhanVien();
        		}
			}
		});
		cbxTenNhanVien.setBounds(295, 112, 250, 30);
		getContentPane().add(cbxTenNhanVien);
		
		JLabel lblThmPhnCng = new JLabel("Th\u00EAm ph\u00E2n c\u00F4ng ");
		lblThmPhnCng.setForeground(Color.BLUE);
		lblThmPhnCng.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblThmPhnCng.setBounds(319, 13, 196, 37);
		getContentPane().add(lblThmPhnCng);
		
		  try {    
				System.err.println("try cbx ten nhan vien");
	        	while(rslistNhanVien.next() ) {
	        		NhanVien_DTO cvDTO = new NhanVien_DTO(rslistNhanVien.getInt("MaNhanVien"), rslistNhanVien.getString("TenNhanVien"));
	        		listCV_DTO.add(cvDTO);
	        		cbxTenNhanVien.addItem(rslistNhanVien.getString("TenNhanVien"));
	        		cbxTenNhanVien.getSelectedItem();
			   }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  
		JButton btnNewButton = new JButton("THÃƒÆ’Ã…Â M");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {


		}
		});

	}
}