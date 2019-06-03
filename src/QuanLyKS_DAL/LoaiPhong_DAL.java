package QuanLyKS_DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import QuanLyKS_DTO.DanhGia_DTO;
import QuanLyKS_DTO.LoaiPhong_DTO;

public class LoaiPhong_DAL {
	public ResultSet getListLoaiPhong(){
		//get connection
		PreparedStatement ptmt = null; 
		MyConnection mycon = new QuanLyKS_DAL.MyConnection();
		Connection conn = mycon.getConnection();
		
		String query = "SELECT * FROM LOAIPHONG";
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
	public static boolean Insert(LoaiPhong_DTO loaiphong) {
		PreparedStatement ptmt = null; 
		String query = "INSERT INTO LOAIPHONG(TenLoaiPhong, GiaPhong) VALUES (?, ?)";
		MyConnection mycon = new QuanLyKS_DAL.MyConnection();
		Connection conn = mycon.getConnection();
		String TenLoaiPhong = loaiphong.getTenLoaiPhong();
		int GiaPhong = loaiphong.getGiaPhong();
		try {
			ptmt = conn.prepareStatement(query);
			ptmt.setString(1, TenLoaiPhong);
			ptmt.setInt(2, GiaPhong);
			if(ptmt.executeUpdate() !=0 ) {
				System.err.println("thêm loại phòng thành công! ");
				return true;
			}else {
				System.err.println("thêm loại phòng thất bại ");
				return false;
			}

		} catch(SQLException e){
			e.printStackTrace();
			System.err.println("kết nối thất bại !");
			return false;
		}
		}
	
	public ArrayList<LoaiPhong_DTO> selectAll(){
		//get connection
		PreparedStatement ptmt = null; 
		MyConnection mycon = new QuanLyKS_DAL.MyConnection();
		Connection conn = mycon.getConnection();

		String query = "SELECT * FROM LOAIPHONG";
		try {
			ptmt = conn.prepareStatement(query);
			ResultSet rs = ptmt.executeQuery();
			ArrayList<LoaiPhong_DTO> ds = new ArrayList<LoaiPhong_DTO>();
			while(rs.next()) {
				LoaiPhong_DTO lp = new LoaiPhong_DTO();
				lp.setMaLoaiPhong(rs.getInt("MaLoaiPhong"));
				lp.setTenLoaiPhong(rs.getString("TenLoaiPhong"));
				lp.setGiaPhong(rs.getInt("GiaPhong"));
				ds.add(lp);
			}
			return ds;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;	
	}
}
