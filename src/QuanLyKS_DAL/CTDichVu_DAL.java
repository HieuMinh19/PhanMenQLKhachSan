package QuanLyKS_DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import QuanLyKS_DTO.CTDichVu_DTO;;
public class CTDichVu_DAL {
	public static boolean Insert(CTDichVu_DTO ctdvDTO)  {
		PreparedStatement ptmt = null; 
		String query = "INSERT INTO CTDICHVU(TuNgay, DenNgay, MaDichVu, SoLuong, MaDatPhong) VALUES (?, ?, ?, ?, ?)";
		MyConnection mycon = new QuanLyKS_DAL.MyConnection();
		Connection conn = mycon.getConnection();
		try {
			ptmt = conn.prepareStatement(query);
			ptmt.setString(1, ctdvDTO.getTuNgay());
			ptmt.setString(2, ctdvDTO.getDenNgay());
			ptmt.setInt(3, ctdvDTO.getMaDichVu());
			ptmt.setInt(4, ctdvDTO.getSoLuong());
			ptmt.setInt(5, ctdvDTO.getMaDatPhong());
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
