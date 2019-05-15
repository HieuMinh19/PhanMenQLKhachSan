package QuanLyKS_DAL;

import java.awt.EventQueue;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import QuanLyKS_DTO.NhanVien_DTO;

import javax.swing.JInternalFrame;

public class NhanVien_DAL extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NhanVien_DAL frame = new NhanVien_DAL();
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
	public NhanVien_DAL() {
		setBounds(100, 100, 450, 300);
	}
	
	//connect table NHANVIEN
	public ArrayList<NhanVien_DTO> SearchNV (String tukhoa){
		//get connection
		PreparedStatement ptmt = null; 
		MyConnection mycon = new QuanLyKS_DAL.MyConnection();
		Connection conn = mycon.getConnection();
		
		String query = "SELECT * FROM NHANVIEN where TenNhanVien like '%" + tukhoa + "%'";
		try {
			ptmt = conn.prepareStatement(query);
			ResultSet rs = ptmt.executeQuery();
			ArrayList<NhanVien_DTO> dsnv = new ArrayList<NhanVien_DTO>();
			while(rs.next()) {
				NhanVien_DTO nv = new NhanVien_DTO();
				nv.setMaNhanVien(rs.getInt("MaNhanVien"));
				nv.setTenNhanVien(rs.getString("TenNhanVien"));
				dsnv.add(nv);
			}
			return dsnv;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;	
	}
	
}
