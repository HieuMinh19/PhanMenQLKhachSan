package QuanLyKS_DAL;
import QuanLyKS_DTO.CTDatPhong_DTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
public class CTDatPhong_DAL {
	public static boolean Insert(CTDatPhong_DTO ctDP){
		PreparedStatement ptmt = null; 
		String query = "INSERT INTO CTDATPHONG(MaCTDatPhong, NgayThucHien, MaKhachHang, NgayNhan, NgayTra, MaPhong, MaNhanVien)"
				+ " VALUES (?, ?, ?, ?, ?, ?, ?)";
		MyConnection mycon = new QuanLyKS_DAL.MyConnection();
		Connection conn = mycon.getConnection();
		try {
			ptmt = conn.prepareStatement(query);
			ptmt.setInt(1, ctDP.getMaCTDatPhong());
			ptmt.setDate(2, (Date) ctDP.getdtNgayThucHien());
			ptmt.setInt(3,  ctDP.getMaKhachHang());
			ptmt.setDate(4,  (Date) ctDP.getNgayNhan());
			ptmt.setDate(5,  (Date) ctDP.getNgayTra());
			ptmt.setInt(6,  ctDP.getMaPhong());
			ptmt.setInt(7,  ctDP.getMaNhanVien());
			if( ptmt.executeUpdate() != 0) {
				System.err.println("insert thanh cong booking");
				return true;
			}
				
			else {
				System.err.println("khoi tao booking that bai");
				return false;
			} 
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println(" ket noi that bai");
			 return false;
		}
	}

	
	public static int buildMaCTDatPhong() {
		PreparedStatement ptmt = null; 
		String query = "SELECT top 1 MaCTDatPhong from CTDATPHONG "
				+ "ORDER BY MaCTDatPhong DESC";
		MyConnection mycon = new QuanLyKS_DAL.MyConnection();
		Connection conn = mycon.getConnection();
		
		try {
			int nextID = 0;
			ptmt = conn.prepareStatement(query);
			ResultSet rs = ptmt.executeQuery();
			while(rs.next()) 
				nextID = rs.getInt("MaCTDatPhong") + 1;
			
			return nextID;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block 
			e.printStackTrace();
		}
		
		return 0;
	}
	
}
