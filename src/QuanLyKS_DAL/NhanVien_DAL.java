package QuanLyKS_DAL;

import java.awt.EventQueue;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import QuanLyKS_DTO.ChucVu_DTO;
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
				nv.setNgaySinh(rs.getDate("NgaySinh"));
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
		String query = "INSERT INTO NHANVIEN(Username, Password, TenNhanVien, NgaySinh, CMND, NgayVaoLam, MaChucVu) VALUES (?, ?, ?, ?, ?, ?, ?)";
		MyConnection mycon = new QuanLyKS_DAL.MyConnection();
		Connection conn = mycon.getConnection();
		//char[] nv.getPassword(); = nv.getPassword();
		System.err.println("NgayPhanCong trong DAL" + nv.getNgaySinh());
		String strPass = nv.getPassword();
		try {
			ptmt = conn.prepareStatement(query);
			ptmt.setString(1, nv.getUsername());
			ptmt.setString(2, strPass);
			ptmt.setString(3, nv.getTenNhanVien());
			ptmt.setDate(4, nv.getNgaySinh());
			ptmt.setInt(5, nv.getCMND());
			ptmt.setDate(6, nv.getNgayVaoLam());
			ptmt.setInt(7, nv.getMaChucVu());
			
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
	
	public static boolean Update(NhanVien_DTO nv)  {
		PreparedStatement ptmt = null; 
		String query = "UPDATE NHANVIEN SET TenNhanVien = ?, NgaySinh = ?, CMND = ?, NgayVaoLam = ?, MaChucVu = ? WHERE MaNhanVien = ?";
		MyConnection mycon = new QuanLyKS_DAL.MyConnection();
		Connection conn = mycon.getConnection();

		try {
			ptmt = conn.prepareStatement(query);
			ptmt.setString(1, nv.getTenNhanVien());
			ptmt.setDate(2, nv.getNgaySinh());
			ptmt.setInt(3, nv.getCMND());
			ptmt.setDate(4, nv.getNgayVaoLam());
			ptmt.setInt(5, nv.getMaChucVu());
			ptmt.setInt(6, nv.getMaNhanVien());

			if( ptmt.executeUpdate() != 0) {
				System.err.println("update thanh cong nhan vien");
				return true;
			}
			
			else {
				System.err.println("update nhan vien that bai");
				return false;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	public static boolean Delete(int maNV)  {
		PreparedStatement ptmt = null; 
		String query = "DELETE FROM NHANVIEN WHERE MaNhanVien = ?";
		MyConnection mycon = new QuanLyKS_DAL.MyConnection();
		Connection conn = mycon.getConnection();

		try {
			ptmt = conn.prepareStatement(query);
			ptmt.setInt(1, maNV);

			if( ptmt.executeUpdate() != 0) {
				System.err.println("delete thanh cong nhan vien");
				return true;
			}

			else {
				System.err.println("xoa nhan vien that bai");
				return false;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}
	
	public ArrayList<NhanVien_DTO> LoadListNV (){
		//get connection
		PreparedStatement ptmt = null; 
		MyConnection mycon = new QuanLyKS_DAL.MyConnection();
		Connection conn = mycon.getConnection();
		
		String query = "SELECT MaNhanVien,TenNhanVien,NgaySinh,CMND,NgayVaoLam,CV.MaChucVu as 'MaChucVu',TenChucVu FROM NHANVIEN NV, CHUCVU CV WHERE NV.MACHUCVU=CV.MACHUCVU ";
		try {
			ptmt = conn.prepareStatement(query);
			ResultSet rs = ptmt.executeQuery();
			ArrayList<NhanVien_DTO> dsnv = new ArrayList<NhanVien_DTO>();
			while(rs.next()) {
				NhanVien_DTO nv = new NhanVien_DTO();
				nv.setMaNhanVien(rs.getInt("MaNhanVien"));
				nv.setTenNhanVien(rs.getString("TenNhanVien"));
				nv.setNgaySinh(rs.getDate("NgaySinh"));
				nv.setCMND(rs.getInt("CMND"));
				nv.setNgayVaoLam(rs.getDate("NgayVaoLam"));
				nv.setMaChucVu(rs.getInt("MaChucVu"));
				nv.setChucVu(new ChucVu_DTO(rs.getInt("MaChucVu"),rs.getString("TenChucVu")));
				dsnv.add(nv);
			}
			return dsnv;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;	
	}

	public static NhanVien_DTO login(String username, String password){
		//get connection
		PreparedStatement ptmt = null; 
		MyConnection mycon = new QuanLyKS_DAL.MyConnection();
		Connection conn = mycon.getConnection();
		

		String query = "SELECT MaNhanVien,TenNhanVien,NgaySinh,CMND,NgayVaoLam,CV.MaChucVu as 'MaChucVu',TenChucVu,Username,Password FROM NHANVIEN NV, CHUCVU CV WHERE NV.MACHUCVU=CV.MACHUCVU and Username=? and Password=?";
		try {
			ptmt = conn.prepareStatement(query);
			ptmt.setString(1, username);
			ptmt.setString(2, password);
			ResultSet rs = ptmt.executeQuery();
			rs.next();
			NhanVien_DTO nv = new NhanVien_DTO();
			
			nv.setMaNhanVien(rs.getInt("MaNhanVien"));
			nv.setTenNhanVien(rs.getString("TenNhanVien"));
			nv.setNgaySinh(rs.getDate("NgaySinh"));
			nv.setCMND(rs.getInt("CMND"));
			nv.setNgayVaoLam(rs.getDate("NgayVaoLam"));
			nv.setMaChucVu(rs.getInt("MaChucVu"));
			nv.setChucVu(new ChucVu_DTO(rs.getInt("MaChucVu"),rs.getString("TenChucVu")));
			nv.setUsername(rs.getString("Username"));
			nv.setPassword(rs.getString("Password"));
			return nv;
		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
			return null;	
		}
	}
	
	
	public ResultSet getListNhanVien(){
		//get connection
		PreparedStatement ptmt = null; 
		MyConnection mycon = new QuanLyKS_DAL.MyConnection();
		Connection conn = mycon.getConnection();
		System.err.println("vao get list nhan vien");
		String query = "SELECT * FROM NHANVIEN";
		try {
			ptmt = conn.prepareStatement(query);
			ResultSet rs = ptmt.executeQuery();
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;	
	}
	public ArrayList<NhanVien_DTO> selectAll(){
		//get connection
		PreparedStatement ptmt = null; 
		MyConnection mycon = new QuanLyKS_DAL.MyConnection();
		Connection conn = mycon.getConnection();
		
		String query = "SELECT * FROM NHANVIEN";
		try {
			ptmt = conn.prepareStatement(query);
			ResultSet rs = ptmt.executeQuery();
			ArrayList<NhanVien_DTO> dscv = new ArrayList<NhanVien_DTO>();
			while(rs.next()) {
				NhanVien_DTO cv = new NhanVien_DTO();
				cv.setMaNhanVien(rs.getInt("MaNhanVien"));
				cv.setTenNhanVien(rs.getString("TenNhanVien"));
				dscv.add(cv);
			}
			return dscv;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;	
		}
	}
}
