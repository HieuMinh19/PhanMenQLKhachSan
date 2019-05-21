package QuanLyKS_DAL;
import QuanLyKS_DTO.CTDatPhong_DTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class CTDatPhong_DAL {
	public static boolean Insert(CTDatPhong_DTO ctDP){
		PreparedStatement ptmt = null; 
		String query = "INSERT INTO CTDATPHONG(TenKH, CMND, MaPhong, NgayNhan, NgayTra) VALUES (?, ?, ?, ?, ?)";
		MyConnection mycon = new QuanLyKS_DAL.MyConnection();
		Connection conn = mycon.getConnection();
		try {
			ptmt = conn.prepareStatement(query);
			ptmt.setString(1, ctDP.getTenHK());
			ptmt.setString(2, ctDP.getCMND());
			ptmt.setInt(3, ctDP.getMaPhong());
			ptmt.setString(4, ctDP.getNgayNhan());
			ptmt.setString(5, ctDP.getNgayTra());
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

}
