package QuanLyKS_DAL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import QuanLyKS_DTO.ChucVu_DTO;
import QuanLyKS_DTO.DichVu_DTO;
import QuanLyKS_DTO.NhanVien_DTO;
public class DichVu_DAL {
	DichVu_DTO DichVu = new DichVu_DTO();
	
	public DichVu_DAL() {
	}
	
	public static ResultSet getListDV(){
		//get connection
		PreparedStatement ptmt = null; 
		MyConnection mycon = new QuanLyKS_DAL.MyConnection();
		Connection conn = mycon.getConnection();
		
		String query = "SELECT * FROM DICHVU";
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
	
	public ArrayList<DichVu_DTO> LoadListDV (){
		//get connection
		PreparedStatement ptmt = null; 
		MyConnection mycon = new QuanLyKS_DAL.MyConnection();
		Connection conn = mycon.getConnection();
		
		String query = "SELECT MaDichVu,TenDichVu,GiaDichVu FROM DichVu";
		try {
			ptmt = conn.prepareStatement(query);
			ResultSet rs = ptmt.executeQuery();
			ArrayList<DichVu_DTO> dsnv = new ArrayList<DichVu_DTO>();
			while(rs.next()) {
				DichVu_DTO nv = new DichVu_DTO();
				nv.setMaDichVu(rs.getInt("MaDichVu"));
				nv.setTenDichVu(rs.getString("TenDichVu"));
				//nv.setNgaySinh(rs.getDate("NgaySinh"));
				//nv.setCMND(rs.getInt("CMND"));
				//nv.setNgayVaoLam(rs.getDate("NgayVaoLam"));
				nv.setGiaDichVu(rs.getInt("GiaDichVu"));
				//nv.setChucVu(new ChucVu_DTO(rs.getInt("MaChucVu"),rs.getString("TenChucVu")));
				dsnv.add(nv);
			}
			return dsnv;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;	
	}
	
	public static ArrayList<DichVu_DTO> getallDV(){
		 ArrayList<DichVu_DTO> dvList = new ArrayList<>();
			//get connection
			PreparedStatement ptmt = null; 
			MyConnection mycon = new QuanLyKS_DAL.MyConnection();
			Connection conn = mycon.getConnection();

			String query = "SELECT * FROM DICHVU";
			try {
				ptmt = conn.prepareStatement(query);
				ResultSet rs = ptmt.executeQuery();
				DichVu_DTO dv;
				while(rs.next()) {
					dv = new DichVu_DTO(rs.getString("TenDichVu"), rs.getInt("GiaDichVu"), rs.getInt("MaDichVu"));
					dvList.add(dv);
				}
				//return rs;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();	
			}
			return dvList;
	}
	
	public static boolean Insert(DichVu_DTO dichvu){
		PreparedStatement ptmt = null; 
		String query = "INSERT INTO DICHVU(TenDichVu,GiaDichVu) VALUES (?,?)";
		MyConnection mycon = new QuanLyKS_DAL.MyConnection();
		Connection conn = mycon.getConnection();
		String TenDichVu = dichvu.getTenDichVu();
		Integer GiaDichVu = dichvu.getGiaDichVu();
		try {
			ptmt = conn.prepareStatement(query);
			ptmt.setString(1, TenDichVu);
			ptmt.setInt(2, GiaDichVu);
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
	
	public static boolean Update(DichVu_DTO dichvu){
		PreparedStatement ptmt = null; 

		String query = ("Update DICHVU SET TenDichVu = ?, GiaDichVu = ? where MaDichVu = ? ");
		MyConnection mycon = new QuanLyKS_DAL.MyConnection();
		Connection conn = mycon.getConnection();
		String TenDichVu = dichvu.getTenDichVu();
		Integer GiaDichVu = dichvu.getGiaDichVu();
		Integer MaDichVu = dichvu.getMaDichVu();
		try {
			ptmt = conn.prepareStatement(query);
			ptmt.setString(1, TenDichVu);
			ptmt.setInt(2, GiaDichVu);
			ptmt.setInt(3, MaDichVu);
			if( ptmt.executeUpdate() != 0) {
				System.err.println("update thanh cong dich vu");
				return true;
			}

			else {
				System.err.println("update dich vu that bai");
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println(" ket noi that bai");
			 return false;
		}
	}
	public static boolean Delete(int dichvu){
		PreparedStatement ptmt = null; 

		String query = ("DELETE FROM DICHVU where MaDichVu = ? ");
		MyConnection mycon = new QuanLyKS_DAL.MyConnection();
		Connection conn = mycon.getConnection();
		//Integer MaDichVu = dichvu.getMaDichVu();
	
			try {
				ptmt = conn.prepareStatement(query);
				ptmt.setInt(1, dichvu);

				if( ptmt.executeUpdate() != 0) {
					System.err.println("delete thanh cong nhan vien");
					return true;
				}

				else {
					System.err.println("xoa nhan vien that bai");
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
