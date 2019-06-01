package QuanLyKS_DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
				LoaiPhong_DTO nv = new LoaiPhong_DTO();
				nv.setMaLoaiPhong(rs.getInt("MaLoaiPhong"));
				nv.setTenLoaiPhong(rs.getString("TenLoaiPhong"));
				nv.setGiaPhong(rs.getInt("GiaPhong"));
				ds.add(nv);
			}
			return ds;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;	
	}
}
