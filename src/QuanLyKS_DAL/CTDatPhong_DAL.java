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
			System.err.println("MaCTDatPhong trong CTDatPhong DAL" +" "+ ctDP.getMaCTDatPhong());
			
			//

			java.sql.Date sqlStartDate = new java.sql.Date(ctDP.getdtNgayThucHien().getTime());
			//
			ptmt.setDate(2, sqlStartDate);
			System.err.println("NgayThucHien trong CTDatPhong DAL" +" "+ ctDP.getdtNgayThucHien());
			
			ptmt.setInt(3,  ctDP.getMaKhachHang());
			System.err.println("MaKhachHang trong CTDatPhong DAL" +""+ ctDP.getMaKhachHang());
			//
			java.sql.Date NgayNhan = new java.sql.Date(ctDP.getNgayNhan().getTime());
			//
			ptmt.setDate(4,  NgayNhan);
			System.err.println("NgayNhan trong CTDatPhong DAL" +""+ ctDP.getNgayNhan());
			//
			java.sql.Date NgayTra = new java.sql.Date(ctDP.getNgayTra().getTime());
			//
			ptmt.setDate(5,  NgayTra);
			System.err.println("NgayTra trong CTDatPhong DAL" +""+ ctDP.getNgayTra());
			
			ptmt.setInt(6,  ctDP.getMaPhong());
			System.err.println("MaPhong trong CTDatPhong DAL" +""+ ctDP.getMaPhong());
			
			ptmt.setInt(7,  ctDP.getMaNhanVien());
			System.err.println("MaNhanVien trong CTDatPhong DAL" +""+ ctDP.getMaNhanVien());
			
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
