package QuanLyKS_DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class KhachHang_DAL {
	public static int buildMaKH() {
		PreparedStatement ptmt = null; 
		String query = "SELECT top 1 MaKhachHang from KHACHHANG "
				+ "ORDER BY MaKhachHang DESC";
		MyConnection mycon = new QuanLyKS_DAL.MyConnection();
		Connection conn = mycon.getConnection();
		
		try {
			int nextID = 0;
			ptmt = conn.prepareStatement(query);
			ResultSet rs = ptmt.executeQuery();
			while(rs.next()) 
				nextID = rs.getInt("MaKhachHang") + 1;
			
			return nextID;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
}
