package QuanLyKS_DAL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import QuanLyKS_DTO.BangPhanCong_DTO;
import QuanLyKS_DTO.DichVu_DTO;
public class BangPhanCong_DAL {
	BangPhanCong_DTO BangPhanCong = new BangPhanCong_DTO();
	
	public BangPhanCong_DAL() {
	}
	
	public static ResultSet getListBPC(){
		//get connection
		PreparedStatement ptmt = null; 
		MyConnection mycon = new QuanLyKS_DAL.MyConnection();
		Connection conn = mycon.getConnection();
		
		String query = "SELECT * FROM BANGPHANCONG";
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
	
	public static boolean Insert(BangPhanCong_DTO bangphancong){
		PreparedStatement ptmt = null; 
		String query = "INSERT INTO BANGPHANCONG(NgayPhanCong,LoaiCongViec, MaNhanVien) VALUES (?,?,?)";
		MyConnection mycon = new QuanLyKS_DAL.MyConnection();
		Connection conn = mycon.getConnection();
		//String TenCongViec = bangphancong.getLoaiCongViec();
		//Date NgayPhanCong = bangphancong.getNgayPhanCong();
		System.err.println("NgayPhanCong trong DAL" + bangphancong.getNgayPhanCong());
		//Integer MaNhanVien = bangphancong.getMaNhanVien();
		//Integer GiaDichVu = bangphancong.getGiaDichVu();
		try {
			ptmt = conn.prepareStatement(query);
			ptmt.setDate(1, bangphancong.getNgayPhanCong());
			ptmt.setString(2, bangphancong.getLoaiCongViec());
			ptmt.setInt(3, bangphancong.getMaNhanVien());
			
			
			if( ptmt.executeUpdate() != 0) {
				System.err.println("insert Service success");
				return true;
			}
				
			else {
				System.err.println("Fail to create Service");
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println(" ket noi that bai");
			 return false;
		}
	}
	
//	public static boolean Update(BangPhanCong_DTO bangphancong){
//		PreparedStatement ptmt = null; 
//
//		String query = ("Update BANGPHANCONG SET NgayPhanCong = ?, LoaiCongViec = ?, MaNhanVien = ? where MaPhanCong = ? ");
//		MyConnection mycon = new QuanLyKS_DAL.MyConnection();
//		Connection conn = mycon.getConnection();
//		String TenCongViec = bangphancong.getLoaiCongViec();
//		String NgayPhanCong = bangphancong.getNgayPhanCong();
//		Integer MaNhanVien = bangphancong.getMaNhanVien();
//		Integer MaPhanCong = bangphancong.getMaPhanCong();
//		try {
//			ptmt = conn.prepareStatement(query);
//			ptmt.setString(1, NgayPhanCong);
//			ptmt.setString(2, TenCongViec);
//			ptmt.setInt(3, MaNhanVien);
//			ptmt.setInt(4, MaPhanCong);
//			if( ptmt.executeUpdate() != 0) {
//				System.err.println("update thanh cong bang phan cong");
//				return true;
//			}
//
//			else {
//				System.err.println("update bang phan cong that bai");
//				return false;
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			System.err.println(" ket noi that bai");
//			 return false;
//		}
//	}
//	public static boolean Delete(BangPhanCong_DTO bangphancong){
//		PreparedStatement ptmt = null; 
//
//		String query = ("DELETE FROM BANGPHANCONG where MaPhanCong = ? ");
//		MyConnection mycon = new QuanLyKS_DAL.MyConnection();
//		Connection conn = mycon.getConnection();
//		Integer MaPhanCong = bangphancong.getMaPhanCong();
//		try {
//			ptmt = conn.prepareStatement(query);
//			ptmt.setInt(1, MaPhanCong);
//			if( ptmt.executeUpdate() != 0) {
//				System.err.println("delete  thanh cong bang phan cong");
//				return true;
//			}
//
//			else {
//				System.err.println("delte bang phan cong that bai");
//				return false;
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			System.err.println(" ket noi that bai");
//			 return false;
//		}
//	}
}
