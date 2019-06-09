package QuanLyKS_GUI;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;

import com.ibm.icu.text.SimpleDateFormat;
import com.toedter.calendar.JCalendar;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Arrays;
import QuanLyKS_DTO.CTDatPhong_DTO;
import QuanLyKS_DTO.ChucVu_DTO;
import QuanLyKS_DTO.LoaiPhong_DTO;
import QuanLyKS_DTO.NhanVien_DTO;
import QuanLyKS_DAL.ChucVu_DAL;
import QuanLyKS_BUS.CTDatPhong_BUS;
import QuanLyKS_BUS.NhanVien_BUS;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import com.toedter.calendar.JDateChooser;
import javax.swing.JPasswordField;
import java.awt.Color;

public class frmThemNhanVien extends JInternalFrame {
	private JTextField txtTenNhanVien;
	private JTextField txtCMND;

	/**
	 * Launch the application.
	 */
	
	//prepare list
	ArrayList<ChucVu_DTO> listCV_DTO =  new ArrayList<ChucVu_DTO>();
	private static int idCV = 0;
	ChucVu_DAL cvDAL = new ChucVu_DAL();
	ResultSet rslistChucVu = cvDAL.getListChucVu();
	private JTextField txtusername;
	private JPasswordField txtpass;
	private JPasswordField txtconfpass;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmThemNhanVien frame = new frmThemNhanVien();
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
	public frmThemNhanVien() {
		setBounds(100, 100, 900, 700);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("H\u1ECD t\u00EAn");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(474, 119, 57, 22);
		getContentPane().add(lblNewLabel);
		
		JLabel lblCmnd = new JLabel("CMND");
		lblCmnd.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCmnd.setBounds(474, 189, 49, 22);
		getContentPane().add(lblCmnd);
		
		txtTenNhanVien = new JTextField();
		txtTenNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtTenNhanVien.setBounds(543, 117, 170, 30);
		getContentPane().add(txtTenNhanVien);
		txtTenNhanVien.setColumns(10);
		
		txtCMND = new JTextField();
		txtCMND.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtCMND.setBounds(543, 187, 170, 30);
		getContentPane().add(txtCMND);
		txtCMND.setColumns(10);
		
		JLabel lblChcV = new JLabel("Ch\u1EE9c v\u1EE5");
		lblChcV.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblChcV.setBounds(466, 389, 65, 22);
		getContentPane().add(lblChcV);
		
		JComboBox<String> cbxChucVu = new JComboBox<String>();
		cbxChucVu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cbxChucVu.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				//get the value selected of cbx and using loop to scan Arraylist LoaiPhong
        		//after find the LoaiPhong selected, using function getMaLoaiPhong to get ID
        		String nameLP = (String) cbxChucVu.getSelectedItem();
        		for(int i = 0; i < listCV_DTO.size(); i++) {
        			ChucVu_DTO cvCompare = listCV_DTO.get(i);
        			if(nameLP.equals( cvCompare.getTenChucVu() ) )
        				idCV = cvCompare.getMaChucVu();
        		}
			}
		});
		cbxChucVu.setBounds(543, 387, 170, 30);
		getContentPane().add(cbxChucVu);
		
		JDateChooser dtngaysinh = new JDateChooser();
		dtngaysinh.setDateFormatString("dd/MM/yyyy");
		dtngaysinh.setBounds(543, 256, 170, 30);
		getContentPane().add(dtngaysinh);
		
		JDateChooser dtngayvaolam = new JDateChooser();
		dtngayvaolam.setDateFormatString("dd/MM/yyyy");
		dtngayvaolam.setBounds(543, 322, 170, 30);
		getContentPane().add(dtngayvaolam);
		
		JLabel label_1 = new JLabel("Ng\u00E0y sinh");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_1.setBounds(453, 256, 78, 30);
		getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("Ng\u00E0y v\u00E0o l\u00E0m");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_2.setBounds(423, 322, 108, 22);
		getContentPane().add(label_2);
		
		JLabel lblTaiKhoan = new JLabel("T\u00E0i kho\u1EA3n");
		lblTaiKhoan.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTaiKhoan.setBounds(97, 119, 78, 22);
		getContentPane().add(lblTaiKhoan);
		
		JLabel lblMatKhau = new JLabel("M\u1EADt kh\u1EA9u");
		lblMatKhau.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMatKhau.setBounds(102, 189, 73, 22);
		getContentPane().add(lblMatKhau);
		
		JLabel lblXacNhanMk = new JLabel("X\u00E1c nh\u1EADn m\u1EADt kh\u1EA9u");
		lblXacNhanMk.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblXacNhanMk.setBounds(23, 256, 152, 22);
		getContentPane().add(lblXacNhanMk);
		 
		txtusername = new JTextField();
		txtusername.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtusername.setColumns(10);
		txtusername.setBounds(187, 121, 170, 30);
		getContentPane().add(txtusername);
		
        try {    
        	while(rslistChucVu.next() ) {
        		ChucVu_DTO cvDTO = new ChucVu_DTO(rslistChucVu.getInt("MaChucVu"), rslistChucVu.getString("TenChucVu"));
        		listCV_DTO.add(cvDTO);
        		cbxChucVu.addItem(rslistChucVu.getString("TenChucVu"));
        		cbxChucVu.getSelectedItem();
		   }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); 
		}
		 
		
		Button button = new Button("Th\u00EAm nh\u00E2n vi\u00EAn");
		button.setBackground(Color.ORANGE);
		button.setFont(new Font("Tahoma", Font.BOLD, 18));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//         		String NgayVaoLam = sdf.format( dtNgayVaoLam.getDate() );
         		//String NgaySinh = sdf.format( dtNgaySinh.getDate() );	
				
				
				//accountDTO = new Account_DTO(); 
			//	accountDTO.setUsername( txtusername.getText() );
				boolean isValidPass = Arrays.equals(txtpass.getPassword(),txtconfpass.getPassword());		
				if(isValidPass){
					String CMND = txtCMND.getText();
	         		int iCMND = Integer.parseInt(CMND);
	         		char[] a = txtpass.getPassword();
	         		//String b;
	         		String b = String.valueOf(a);
	         		System.err.println("NgayPhanCong trong form" + dtngaysinh.getDate().getTime());
	         		NhanVien_DTO nvDTO = new NhanVien_DTO(txtusername.getText(),b, txtTenNhanVien.getText(), new Date(dtngaysinh.getDate().getTime()), iCMND, new Date(dtngayvaolam.getDate().getTime()), idCV);
	        		if(NhanVien_BUS.Insert(nvDTO) == true) {
	        			JOptionPane.showMessageDialog(null, "Insert Employee Success", "Success: " + "Success Mesage", JOptionPane.INFORMATION_MESSAGE);
	        		}else {
	        			JOptionPane.showMessageDialog(null, "Insert Employee Fail", "Fail: " + "Success Mesage", JOptionPane.CLOSED_OPTION);
	        		}
				}else {
					 JOptionPane.showMessageDialog(null, "2 Password is not the same", "Warning: " + "error Mesage", JOptionPane.INFORMATION_MESSAGE);
				 }
         		
			}
		});
		button.setBounds(352, 478, 150, 40);
		getContentPane().add(button);
		
		JLabel lblThmNhnVin = new JLabel("Th\u00EAm nh\u00E2n vi\u00EAn");
		lblThmNhnVin.setForeground(Color.BLUE);
		lblThmNhnVin.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblThmNhnVin.setBounds(325, 29, 200, 30);
		getContentPane().add(lblThmNhnVin);
		
		txtpass = new JPasswordField();
		txtpass.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtpass.setBounds(187, 187, 170, 30);
		getContentPane().add(txtpass);
		
		txtconfpass = new JPasswordField();
		txtconfpass.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtconfpass.setBounds(187, 256, 170, 30);
		getContentPane().add(txtconfpass);
		
		
		
		

	}
}
