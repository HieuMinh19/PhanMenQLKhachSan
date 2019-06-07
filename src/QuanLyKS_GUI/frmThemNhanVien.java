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

import QuanLyKS_DTO.CTDatPhong_DTO;
import QuanLyKS_DTO.ChucVu_DTO;
import QuanLyKS_DTO.LoaiPhong_DTO;
import QuanLyKS_DTO.NhanVien_DTO;
import QuanLyKS_DAL.ChucVu_DAL;
import QuanLyKS_BUS.CTDatPhong_BUS;
import QuanLyKS_BUS.NhanVien_BUS;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

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
		setBounds(100, 100, 626, 434);
		getContentPane().setLayout(null);
		
		JLabel lblThmNhnVin = new JLabel("Th\u00EAm nh\u00E2n vi\u00EAn");
		lblThmNhnVin.setFont(new Font("Sylfaen", Font.PLAIN, 22));
		lblThmNhnVin.setBounds(242, 27, 159, 35);
		getContentPane().add(lblThmNhnVin);
		
		JLabel lblNewLabel = new JLabel("T\u00EAn nh\u00E2n vi\u00EAn");
		lblNewLabel.setBounds(23, 72, 75, 22);
		getContentPane().add(lblNewLabel);
		
		JLabel lblCmnd = new JLabel("CMND");
		lblCmnd.setBounds(23, 114, 75, 22);
		getContentPane().add(lblCmnd);
		
		txtTenNhanVien = new JTextField();
		txtTenNhanVien.setBounds(108, 73, 159, 20);
		getContentPane().add(txtTenNhanVien);
		txtTenNhanVien.setColumns(10);
		
		txtCMND = new JTextField();
		txtCMND.setBounds(108, 115, 159, 20);
		getContentPane().add(txtCMND);
		txtCMND.setColumns(10);
		
		JLabel lblChcV = new JLabel("Ch\u1EE9c v\u1EE5");
		lblChcV.setBounds(23, 161, 63, 22);
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
		cbxChucVu.setBounds(108, 162, 159, 20);
		getContentPane().add(cbxChucVu);
		
		JLabel lblNgySinh = new JLabel("Ng\u00E0y v\u00E0o l\u00E0m");
		lblNgySinh.setBounds(23, 237, 75, 22);
		getContentPane().add(lblNgySinh);
		
		JCalendar dtNgayVaoLam = new JCalendar();
		dtNgayVaoLam.setBounds(108, 201, 198, 153);
		getContentPane().add(dtNgayVaoLam);
		
		JCalendar dtNgaySinh = new JCalendar();
		dtNgaySinh.setBounds(388, 72, 198, 153);
		getContentPane().add(dtNgaySinh);
		
		JLabel label = new JLabel("Ng\u00E0y sinh");
		label.setBounds(315, 114, 63, 22);
		getContentPane().add(label);
		
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
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//         		String NgayVaoLam = sdf.format( dtNgayVaoLam.getDate() );
         		String NgaySinh = sdf.format( dtNgaySinh.getDate() );	
         		String CMND = txtCMND.getText();
         		int iCMND = Integer.parseInt(CMND);
         		NhanVien_DTO nvDTO = new NhanVien_DTO(txtTenNhanVien.getText(), new Date(dtNgaySinh.getDate().getTime()), iCMND, new Date(dtNgayVaoLam.getDate().getTime()), idCV);
        		if(NhanVien_BUS.Insert(nvDTO) == true) {
        			JOptionPane.showMessageDialog(null, "Insert Employee Success", "Success: " + "Success Mesage", JOptionPane.INFORMATION_MESSAGE);
        		}else {
        			JOptionPane.showMessageDialog(null, "Insert Employee Fail", "Fail: " + "Success Mesage", JOptionPane.CLOSED_OPTION);
        		}
			}
		});
		button.setBounds(315, 361, 93, 22);
		getContentPane().add(button);

	}
}
