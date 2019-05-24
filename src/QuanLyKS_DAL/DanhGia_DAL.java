package QuanLyKS_DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import QuanLyKS_DTO.DanhGia_DTO;

public class DanhGia_DAL{
	public static boolean Insert(DanhGia_DTO danhgia) {
	PreparedStatement ptmt = null; 
	String query = "INSERT INTO CTDANHGIA(NoiDung, NgayDanhGia) VALUES (?, ?)";
	MyConnection mycon = new QuanLyKS_DAL.MyConnection();
	Connection conn = mycon.getConnection();
	String NoiDung = danhgia.getNoiDung();
	String NgayDanhGia = danhgia.getNgayDanhGia();
	try {
		ptmt = conn.prepareStatement(query);
		ptmt.setString(1, NoiDung);
		ptmt.setString(2, NgayDanhGia);
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