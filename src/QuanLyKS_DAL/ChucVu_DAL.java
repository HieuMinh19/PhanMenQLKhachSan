package QuanLyKS_DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import QuanLyKS_DTO.ChucVu_DTO;
import QuanLyKS_DTO.NhanVien_DTO;

public class ChucVu_DAL {
	public ResultSet getListChucVu(){
		//get connection
		PreparedStatement ptmt = null; 
		MyConnection mycon = new QuanLyKS_DAL.MyConnection();
		Connection conn = mycon.getConnection();
		
		String query = "SELECT * FROM CHUCVU";
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

	public ArrayList<ChucVu_DTO> selectAll(){
		//get connection
		PreparedStatement ptmt = null; 
		MyConnection mycon = new QuanLyKS_DAL.MyConnection();
		Connection conn = mycon.getConnection();
		
		String query = "SELECT * FROM CHUCVU";
		try {
			ptmt = conn.prepareStatement(query);
			ResultSet rs = ptmt.executeQuery();
			ArrayList<ChucVu_DTO> dscv = new ArrayList<ChucVu_DTO>();
			while(rs.next()) {
				ChucVu_DTO cv = new ChucVu_DTO();
				cv.setMaChucVu(rs.getInt("MaChucVu"));
				cv.setTenChucVu(rs.getString("TenChucVu"));
				dscv.add(cv);
			}
			return dscv;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;	
		}
	}
	
	public static ChucVu_DTO selectCondition(int MaCV)  {
		PreparedStatement ptmt = null; 
		String query = "SELECT * FROM CHUCVU where MaChucVu = ?";
		MyConnection mycon = new QuanLyKS_DAL.MyConnection();
		Connection conn = mycon.getConnection();
		try {
			ptmt = conn.prepareStatement(query);
			ResultSet rs = ptmt.executeQuery();
			rs.next();
			ChucVu_DTO cv = new ChucVu_DTO();
			cv.setMaChucVu(rs.getInt("MaChucVu"));
			cv.setTenChucVu(rs.getString("TenChucVu"));
			return cv;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;	
		}
	} 
}
