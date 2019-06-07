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
	
	
	private JPasswordField txtpass;
	private JPasswordField txtconfpass;
	private JTextField txtusername;
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
		setBounds(100, 100, 934, 585);
		getContentPane().setLayout(null);
		
		JLabel lblThmNhnVin = new JLabel("Th\u00EAm nh\u00E2n vi\u00EAn");
		lblThmNhnVin.setFont(new Font("Sylfaen", Font.PLAIN, 22));
		lblThmNhnVin.setBounds(242, 27, 159, 35);
		getContentPane().add(lblThmNhnVin);
		
		JLabel lblNewLabel = new JLabel("T\u00EAn nh\u00E2n vi\u00EAn");
		lblNewLabel.setBounds(23, 157, 99, 22);
		getContentPane().add(lblNewLabel);
		
		JLabel lblCmnd = new JLabel("CMND");
		lblCmnd.setBounds(23, 208, 75, 22);
		getContentPane().add(lblCmnd);
		
		txtTenNhanVien = new JTextField();
		txtTenNhanVien.setBounds(151, 158, 198, 20);
		getContentPane().add(txtTenNhanVien);
		txtTenNhanVien.setColumns(10);
		
		txtCMND = new JTextField();
		txtCMND.setBounds(151, 209, 198, 20);
		getContentPane().add(txtCMND);
		txtCMND.setColumns(10);
		
		JLabel lblChcV = new JLabel("Ch\u1EE9c v\u1EE5");
		lblChcV.setBounds(23, 256, 63, 22);
		getContentPane().add(lblChcV);
		
		JComboBox<String> cbxChucVu = new JComboBox<String>();
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
		cbxChucVu.setBounds(151, 257, 198, 20);
		getContentPane().add(cbxChucVu);
		
		JDateChooser dtngaysinh = new JDateChooser();
		dtngaysinh.setBounds(528, 256, 198, 22);
		getContentPane().add(dtngaysinh);
		
		JDateChooser dtngayvaolam = new JDateChooser();
		dtngayvaolam.setBounds(528, 208, 198, 22);
		getContentPane().add(dtngayvaolam);
		
		JLabel label_1 = new JLabel("Ng\u00E0y sinh");
		label_1.setBounds(403, 243, 87, 35);
		getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("Ng\u00E0y v\u00E0o l\u00E0m");
		label_2.setBounds(403, 208, 99, 22);
		getContentPane().add(label_2);
		
		JLabel lblTaiKhoan = new JLabel("Tai Khoan");
		lblTaiKhoan.setBounds(23, 98, 99, 22);
		getContentPane().add(lblTaiKhoan);
		
		JLabel lblMatKhau = new JLabel("Mat Khau");
		lblMatKhau.setBounds(403, 101, 99, 22);
		getContentPane().add(lblMatKhau);
		
		JLabel lblXacNhanMk = new JLabel("Xac Nhan MK");
		lblXacNhanMk.setBounds(403, 160, 99, 22);
		getContentPane().add(lblXacNhanMk);
		
		txtpass = new JPasswordField();
		txtpass.setBounds(528, 98, 198, 22);
		getContentPane().add(txtpass);
		
		txtconfpass = new JPasswordField();
		txtconfpass.setBounds(528, 157, 198, 22);
		getContentPane().add(txtconfpass);
		
		txtusername = new JTextField();
		txtusername.setColumns(10);
		txtusername.setBounds(151, 98, 198, 20);
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
		button.setFont(new Font("Segoe UI", Font.PLAIN, 18));
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
		button.setBounds(344, 345, 146, 52);
		getContentPane().add(button);
		
		
		
		

	}
}
