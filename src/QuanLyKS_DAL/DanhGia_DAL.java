package QuanLyKS_DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;

import QuanLyKS_DTO.DanhGia_DTO;

public class DanhGia_DAL{
	public static boolean Insert(DanhGia_DTO danhgia) {
	PreparedStatement ptmt = null; 
	String query = "INSERT INTO CTDANHGIA(NoiDung, NgayDanhGia, MaPhong) VALUES (?,?,?)";
	MyConnection mycon = new QuanLyKS_DAL.MyConnection();
	Connection conn = mycon.getConnection();
	
	String NoiDung = danhgia.getNoiDung();
	Date NgayDanhGia = danhgia.getNgayDanhGia();
	int MaPhong = danhgia.getMaPhong();
	try {
		ptmt = conn.prepareStatement(query);
		ptmt.setString(1, NoiDung);
		ptmt.setDate(2, NgayDanhGia);
		ptmt.setInt(3, MaPhong);
		if(ptmt.executeUpdate() !=0 ) {
			System.err.println("thêm đánh giá thành công! ");
			return true;
		}else {
			System.err.println("thêm đánh giá thất bại ");
			return false;
		}

	} catch(SQLException e){
		e.printStackTrace();
		System.err.println("kết nối thất bại !");
		return false;
	}
	}
}
