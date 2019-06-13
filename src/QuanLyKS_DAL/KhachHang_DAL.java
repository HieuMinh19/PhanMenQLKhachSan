package QuanLyKS_DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import QuanLyKS_DTO.KhachHang_DTO;

public class KhachHang_DAL {
	public static int buildMaKH() {
		PreparedStatement ptmt = null; 
		String query = "SELECT top 1 MaKhachHang from KHACHHANG "
				+ "ORDER BY MaKhachHang DESC";
		MyConnection mycon = new QuanLyKS_DAL.MyConnection();
		Connection conn = mycon.getConnection();
		 
		try {
			ptmt = conn.prepareStatement(query);
			ResultSet rs = ptmt.executeQuery();
			rs.next();
			return rs.getInt("MaKhachHang") + 1;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 1;
		}
		
	}
	
	public static boolean Insert(KhachHang_DTO kh){
		PreparedStatement ptmt = null; 
		String query = "INSERT INTO KHACHHANG(MaKhachHang, HoTen, Email, DiaChi, DienThoai, CMND) VALUES (?, ?, ?, ?, ?, ?)";
		MyConnection mycon = new QuanLyKS_DAL.MyConnection();
		Connection conn = mycon.getConnection();
		try {
			ptmt = conn.prepareStatement(query);
			ptmt.setInt(1, kh.getMaKH());
			ptmt.setString(2, kh.getTenKH());
			ptmt.setString(3, kh.getEmail());
			ptmt.setString(4, kh.getDiaChi());
			ptmt.setString(5, kh.getSDT());
			ptmt.setString(6, kh.getCMND());
			if(ptmt.executeUpdate() !=0 ) {
				System.err.println("them khach hang thanh cong! ");
				return true;
			}else {
				System.err.println("them khach hang that bai ");
				return false;
			}

		} catch(SQLException e){
			e.printStackTrace();
			System.err.println("ket noi that bai!");
			return false;
		}
	}
	
	
	
	
	
	
}
