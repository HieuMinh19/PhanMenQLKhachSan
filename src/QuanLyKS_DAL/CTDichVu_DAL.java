package QuanLyKS_DAL;
import java.sql.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import QuanLyKS_DTO.CTDichVu_DTO;;
public class CTDichVu_DAL {
	public static boolean Insert(CTDichVu_DTO ctdvDTO)  {
		PreparedStatement ptmt = null; 
		String query = "INSERT INTO CTDICHVU(MaDichVu, SoLuong, MaCTDatPhong, TongTienDichVu) VALUES (?, ?, ?, ?)";
		MyConnection mycon = new QuanLyKS_DAL.MyConnection();
		Connection conn = mycon.getConnection(); 
		try {
			ptmt = conn.prepareStatement(query);
			ptmt.setInt(1, ctdvDTO.getMaDichVu());
			ptmt.setInt(2, ctdvDTO.getSoLuong());
			ptmt.setInt(3, ctdvDTO.getMaCTDatPhong());
			System.err.println("MaCTDatPhong trong CTDichVu DAL" +" "+ ctdvDTO.getMaCTDatPhong());
			ptmt.setInt(4, ctdvDTO.getTongTienDichVu());
			if( ptmt.executeUpdate() != 0) {
				System.err.println("booking Service success");
				return true;
			}
				
			else {
				System.err.println("booking Service fail");
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println(" ket noi that bai");
			return false;
		}
	}
}
