package QuanLyKS_DAL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Phong_DAL {
	public static ResultSet selectCondition(int MaLoaiPhong, String NgayNhan, String NgayTra) {
		PreparedStatement ptmt = null; 
		MyConnection mycon = new QuanLyKS_DAL.MyConnection();
		Connection conn = mycon.getConnection();
		String query = "SELECT DISTINCT p.MaPhong from PHONG as p where (not EXISTS ";
		query += "(select MaPhong from CTDATPHONG as ctdp where p.MaPhong  = ctdp.MaPhong "
				+ "and NgayNhan between ? and ?)) and (p.MaLoaiPhong = ?)";
		try {
			ptmt = conn.prepareStatement(query);
			ptmt.setString(1, NgayNhan);
			ptmt.setString(2, NgayTra);
			ptmt.setInt(3, MaLoaiPhong);
			ResultSet rs = ptmt.executeQuery();
			
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println(" ket noi that bai");
		}
		return null;
	}

	public static ResultSet selectAll() {
		PreparedStatement ptmt = null; 
		MyConnection mycon = new QuanLyKS_DAL.MyConnection();
		Connection conn = mycon.getConnection();
		String query = "SELECT * from PHONG";
		
		try {
			ptmt = conn.prepareStatement(query);
			ResultSet rs = ptmt.executeQuery();
			
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println(" ket noi that bai");
		}
		return null;
	}
	
	public static int getGiaPhong(int iMaPhong) {
		int iGiaPhong = 1;
		PreparedStatement ptmt = null; 
		MyConnection mycon = new QuanLyKS_DAL.MyConnection();
		Connection conn = mycon.getConnection();
		String query = "select GiaPhong from PHONG as p, LOAIPHONG as lp  where p.MaLoaiPhong = lp.MaLoaiPhong and p.MaPhong = ?";
		try {
			ptmt = conn.prepareStatement(query);
			ptmt.setInt(1, iMaPhong);
			ResultSet rs = ptmt.executeQuery();
			
			while(rs.next() ) {
         		iGiaPhong = rs.getInt("GiaPhong");
 		   }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println(" ket noi that bai");
		}
		return iGiaPhong;
	}


}
