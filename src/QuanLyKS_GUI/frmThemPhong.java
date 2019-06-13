package QuanLyKS_GUI;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.Color;
import javax.swing.JTextField;
import QuanLyKS_DTO.Phong_DTO;
import QuanLyKS_BUS.NhanVien_BUS;
import QuanLyKS_DAL.ChucVu_DAL;
import QuanLyKS_DTO.ChucVu_DTO;
import QuanLyKS_DTO.LoaiPhong_DTO;
import QuanLyKS_DTO.NhanVien_DTO;
import QuanLyKS_DAL.LoaiPhong_DAL;
import QuanLyKS_BUS.Phong_BUS;
import QuanLyKS_DAL.Phong_DAL;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmThemPhong extends JInternalFrame {
	private JTextField txtMaPhong;

	/**
	 * Launch the application.
	 */
	
	ArrayList<LoaiPhong_DTO> listLP_DTO =  new ArrayList<LoaiPhong_DTO>();
	private static int idLP = 0;
	LoaiPhong_DAL LPDAL = new LoaiPhong_DAL();
	ResultSet rslistLoaihPhong = LPDAL.getListLoaiPhong();
	///
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmThemPhong frame = new frmThemPhong();
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
	public frmThemPhong() {
		setBounds(100, 100, 900, 700);
		getContentPane().setLayout(null);
		
		JLabel lblThmPhng = new JLabel("M\u1EDF r\u1ED9ng s\u1ED1 l\u01B0\u1EE3ng ph\u00F2ng");
		lblThmPhng.setForeground(Color.BLUE);
		lblThmPhng.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblThmPhng.setBounds(282, 13, 274, 37);
		getContentPane().add(lblThmPhng);
		
		txtMaPhong = new JTextField();
		txtMaPhong.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtMaPhong.setColumns(10);
		txtMaPhong.setBounds(348, 105, 200, 30);
		getContentPane().add(txtMaPhong);
		
		JLabel label = new JLabel("M\u00E3 ph\u00F2ng");
		label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label.setBounds(257, 108, 79, 22);
		getContentPane().add(label);
		
//		JComboBox cbTenLoaiPhong = new JComboBox();
//		cbTenLoaiPhong.setFont(new Font("Tahoma", Font.PLAIN, 16));
//		
//		getContentPane().add(cbTenLoaiPhong);
		
		////
		JComboBox<String> cbTenLoaiPhong = new JComboBox<String>();
		cbTenLoaiPhong.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cbTenLoaiPhong.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				//get the value selected of cbx and using loop to scan Arraylist LoaiPhong
        		//after find the LoaiPhong selected, using function getMaLoaiPhong to get ID
        		String nameLP = (String) cbTenLoaiPhong.getSelectedItem();
        		for(int i = 0; i < listLP_DTO.size(); i++) {
        			LoaiPhong_DTO cvCompare = listLP_DTO.get(i);
        			if(nameLP.equals( cvCompare.getTenLoaiPhong() ) )
        				idLP = cvCompare.getMaLoaiPhong();
        		}
			}
		});
		//cbTenLoaiPhong.setBounds(543, 387, 170, 30);
		cbTenLoaiPhong.setBounds(348, 168, 200, 30);
		getContentPane().add(cbTenLoaiPhong);
		////
		try {    
        	while(rslistLoaihPhong.next() ) {
        		LoaiPhong_DTO cvDTO = new LoaiPhong_DTO(rslistLoaihPhong.getInt("MaLoaiPhong"), rslistLoaihPhong.getString("TenLoaiPhong"));
        		listLP_DTO.add(cvDTO);
        		cbTenLoaiPhong.addItem(rslistLoaihPhong.getString("TenLoaiPhong"));
        		cbTenLoaiPhong.getSelectedItem();
		   }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); 
		}
		///////
		
		
		
		JLabel label_1 = new JLabel("T\u00EAn lo\u1EA1i ph\u00F2ng");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_1.setBounds(217, 171, 119, 22);
		getContentPane().add(label_1);
		
		JButton btnThemPhong = new JButton("Th\u00EAm ph\u00F2ng");
		btnThemPhong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String maphong = txtMaPhong.getText();
         		int maphong1 = Integer.parseInt(maphong);	      	
         		Phong_DTO lpDTO = new Phong_DTO(maphong1, idLP);
        		if(Phong_BUS.Insert(lpDTO) == true) {
        			JOptionPane.showMessageDialog(null, "Thêm Phòng Thành Công", "Success: " + "Success Mesage", JOptionPane.INFORMATION_MESSAGE);
        		}else {
        			JOptionPane.showMessageDialog(null, "Thêm Phòng Thất Bại", "Fail: " + "Success Mesage", JOptionPane.CLOSED_OPTION);
        		}
			}
		});
		btnThemPhong.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnThemPhong.setBackground(Color.ORANGE);
		btnThemPhong.setBounds(366, 230, 150, 40);
		getContentPane().add(btnThemPhong);

	}
}
