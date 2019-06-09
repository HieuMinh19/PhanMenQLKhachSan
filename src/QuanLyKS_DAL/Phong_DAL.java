package QuanLyKS_DAL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import QuanLyKS_DTO.LoaiPhong_DTO;
import QuanLyKS_DTO.Phong_DTO;

public class Phong_DAL {
	public static ResultSet selectCondition(int MaLoaiPhong, String NgayNhan, String NgayTra) {
		PreparedStatement ptmt = null; 
		MyConnection mycon = new QuanLyKS_DAL.MyConnection();
		Connection conn = mycon.getConnection();
		String query = "SELECT DISTINCT p.MaPhong from PHONG as p where (not EXISTS ";
		query += "(select MaPhong from CTDATPHONG as ctdp where p.MaPhong  = ctdp.MaPhong "
				+ "and NgayTra > ?)) and (p.MaLoaiPhong = ?)";
		try {
			ptmt = conn.prepareStatement(query);
			ptmt.setString(1, NgayNhan);
			ptmt.setInt(2, MaLoaiPhong);
			ResultSet rs = ptmt.executeQuery();
			
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println(" ket noi that bai");
		}  
		return null;
	}

	public static ArrayList<Phong_DTO> getListCondition(int MaLoaiPhong, String NgayNhan, String NgayTra) {
		ArrayList<Phong_DTO> listPhong = new ArrayList<Phong_DTO>();
		
		PreparedStatement ptmt = null; 
		MyConnection mycon = new QuanLyKS_DAL.MyConnection();
		Connection conn = mycon.getConnection();
		String query = "SELECT DISTINCT p.MaPhong from PHONG as p where (not EXISTS ";
		query += "(select MaPhong from CTDATPHONG as ctdp where p.MaPhong  = ctdp.MaPhong "
				+ "and NgayNhan between ? and ?)) and (p.MaLoaiPhong = ?)";
		try {
			ptmt = conn.prepareStatement(query);
			ptmt.setString(1, NgayNhan);
			ptmt.setString(2, NgayTra);
			ptmt.setInt(3, MaLoaiPhong);
			ResultSet rs = ptmt.executeQuery();
			
			while(rs.next()) {
				Phong_DTO phong = new Phong_DTO();
				phong.setMaLoaiPhong(rs.getInt("MaLoaiPhong"));
				phong.setMaPhong(rs.getInt("MaPhong"));
				listPhong.add(phong); 
			}
			
		}catch(SQLException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listPhong;
	}
	
	public static String getLoaiPhongbyMaPhong(int iMaPhong) {
		String strLoaiPhong = "";
		PreparedStatement ptmt = null; 
		MyConnection mycon = new QuanLyKS_DAL.MyConnection();
		Connection conn = mycon.getConnection();
		String query = "select TenLoaiPhong from PHONG as p, LOAIPHONG as lp  where p.MaLoaiPhong = lp.MaLoaiPhong and p.MaPhong = ?";
		try {
			ptmt = conn.prepareStatement(query);
			ptmt.setInt(1, iMaPhong);
			ResultSet rs = ptmt.executeQuery();
			
			while(rs.next() ) {
				strLoaiPhong = rs.getString("TenLoaiPhong");
 		   }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println(" ket noi that bai");
		}
		return strLoaiPhong;
	}
	
	public static ResultSet selectAll() {
		PreparedStatement ptmt = null; 
		MyConnection mycon = new QuanLyKS_DAL.MyConnection();
		Connection conn = mycon.getConnection();
		String query = "SELECT * from PHONG";
		
		try {
			ptmt = conn.prepareStatement(query);
			ResultSet rs = ptmt.executeQuery();
			
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println(" ket noi that bai");
		}
		return null;
	}
	
	public static int getGiaPhong(int iMaPhong) {
		int iGiaPhong = 1;
		PreparedStatement ptmt = null; 
		MyConnection mycon = new QuanLyKS_DAL.MyConnection();
		Connection conn = mycon.getConnection();
		String query = "select GiaPhong from PHONG as p, LOAIPHONG as lp  where p.MaLoaiPhong = lp.MaLoaiPhong and p.MaPhong = ?";
		try {
			ptmt = conn.prepareStatement(query);
			ptmt.setInt(1, iMaPhong);
			ResultSet rs = ptmt.executeQuery();
			
			while(rs.next() ) {
         		iGiaPhong = rs.getInt("GiaPhong");
 		   }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println(" ket noi that bai");
		}
		return iGiaPhong;
	}

	public static ArrayList<Phong_DTO> LoadListPhong (){
		//get connection
		PreparedStatement ptmt = null; 
		MyConnection mycon = new QuanLyKS_DAL.MyConnection();
		Connection conn = mycon.getConnection();
		
		String query = "SELECT MaPhong, lp.TenLoaiPhong from PHONG p, LOAIPHONG lp where p.MaLoaiPhong=lp.MaLoaiPhong";
		try {
			ptmt = conn.prepareStatement(query);
			ResultSet rs = ptmt.executeQuery();
			ArrayList<Phong_DTO> dsnv = new ArrayList<Phong_DTO>();
			while(rs.next()) {
				Phong_DTO phong = new Phong_DTO();
				phong.setMaPhong(rs.getInt("MaPhong"));
				phong.setLoaiPhong(new LoaiPhong_DTO(rs.getInt("MaPhong"),rs.getString("TenLoaiPhong")));
				dsnv.add(phong);
			}
			return dsnv;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;	
	}
	
	public static boolean Update(Phong_DTO phong)  {
		PreparedStatement ptmt = null; 
		String query = "UPDATE PHONG SET MaPhong = ? , MaLoaiPhong= ? WHERE MaPhong = ?";
		MyConnection mycon = new QuanLyKS_DAL.MyConnection();
		Connection conn = mycon.getConnection();

		try {
			ptmt = conn.prepareStatement(query);
			ptmt.setInt(1,phong.getMaPhong());
			ptmt.setInt(2, phong.getMaLoaiPhong());
			ptmt.setInt(3,phong.getMaPhong());
			
			if( ptmt.executeUpdate() != 0) {
				JOptionPane.showMessageDialog(null, "cap nhat phong thanh cong", "Success: " + "Success Mesage", JOptionPane.INFORMATION_MESSAGE);
				System.err.println("update Phong Thanh Cong");
				return true;
			}
			
			else {
				JOptionPane.showMessageDialog(null, "cap nhat phong that bai", "FAIL:" + "Fail Mesage", JOptionPane.INFORMATION_MESSAGE);
				System.err.println("update Loai Phong That Bai");
				return false;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	
	
}
