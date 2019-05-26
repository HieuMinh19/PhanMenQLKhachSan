package QuanLyKS_DAL;

import java.awt.EventQueue;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import QuanLyKS_DTO.Account_DTO;
import QuanLyKS_DTO.NhanVien_DTO;

import javax.swing.JInternalFrame;

public class NhanVien_DAL extends JInternalFrame {
	public NhanVien_DAL() {
		setBounds(100, 100, 450, 300);
	}
	
	//connect table NHANVIEN
	public ArrayList<NhanVien_DTO> SearchNV (String tukhoa, java.sql.Date ngayvaolam){
		//get connection
		PreparedStatement ptmt = null; 
		MyConnection mycon = new QuanLyKS_DAL.MyConnection();
		Connection conn = mycon.getConnection();
		
		String query = "SELECT * FROM NHANVIEN where TenNhanVien like '%" + tukhoa + "%' and datediff(DAY, NgayVaoLam, '" + ngayvaolam.toString() + "') >= 0";
		try {
			ptmt = conn.prepareStatement(query);
			ResultSet rs = ptmt.executeQuery();
			ArrayList<NhanVien_DTO> dsnv = new ArrayList<NhanVien_DTO>();
			while(rs.next()) {
				NhanVien_DTO nv = new NhanVien_DTO();
				nv.setMaNhanVien(rs.getInt("MaNhanVien"));
				nv.setTenNhanVien(rs.getString("TenNhanVien"));
				nv.setNgaySinh(rs.getString("NgaySinh"));
				nv.setCMND(rs.getInt("CMND"));
				nv.setNgayVaoLam(rs.getDate("NgayVaoLam"));
				dsnv.add(nv);
			}
			return dsnv;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;	
	}
	public static boolean Insert(NhanVien_DTO nv)  {
		PreparedStatement ptmt = null; 
		String query = "INSERT INTO NHANVIEN(TenNhanVien, NgaySinh, CMND, NgayVaoLam, MaChucVu) VALUES (?, ?, ?, ?, ?)";
		MyConnection mycon = new QuanLyKS_DAL.MyConnection();
		Connection conn = mycon.getConnection();
		
		try {
			ptmt = conn.prepareStatement(query);
			ptmt.setString(1, nv.getTenNhanVien());
			ptmt.setString(2, nv.getNgaySinh());
			ptmt.setInt(3, nv.getCMND());
			ptmt.setDate(4, nv.getNgayVaoLam());
			ptmt.setInt(5, nv.getMaChucVu());
			
			if( ptmt.executeUpdate() != 0) {
				System.err.println("insert thanh cong nhan vien");
				return true;
			}
				
			else {
				System.err.println("khoi tao nhan vien that bai");
				return false;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	} 
}
