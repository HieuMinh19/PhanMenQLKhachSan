package QuanLyKS_DAL;
import QuanLyKS_DTO.CTDatPhong_DTO;
import QuanLyKS_DTO.KhachHang_DTO;
import QuanLyKS_DTO.NhanVien_DTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
public class CTDatPhong_DAL {
	public static boolean Insert(CTDatPhong_DTO ctDP){
		PreparedStatement ptmt = null; 
		String query = "INSERT INTO CTDATPHONG(TenKH, CMND, MaPhong, NgayNhan, NgayTra, ThanhTien) VALUES (?, ?, ?, ?, ?, ?)";
		MyConnection mycon = new QuanLyKS_DAL.MyConnection();
		Connection conn = mycon.getConnection();
		try {
			ptmt = conn.prepareStatement(query);
//			ptmt.setString(1, ctDP.getTenHK()); 
//			ptmt.setString(2, ctDP.getCMND());
//			ptmt.setInt(3, ctDP.getMaPhong());
//			ptmt.setString(4, ctDP.getNgayNhan());
//			ptmt.setString(5, ctDP.getNgayTra());
//			ptmt.setInt(6, ctDP.getThanhTien());	
//			int ThanhTien = ctDP.getThanhTien();
			//System.out.print(ThanhTien);
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

	
	public static int buildMaCTDatPhong() {
		PreparedStatement ptmt = null; 
		String query = "SELECT top 1 MaCTDatPhong from CTDATPHONG "
				+ "ORDER BY MaCTDatPhong DESC";
		MyConnection mycon = new QuanLyKS_DAL.MyConnection();
		Connection conn = mycon.getConnection();
		
		try {
			int nextID = 0;
			ptmt = conn.prepareStatement(query);
			ResultSet rs = ptmt.executeQuery();
			while(rs.next()) 
				nextID = rs.getInt("MaCTDatPhong") + 1;
			
			return nextID;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}
	
	public static ArrayList<CTDatPhong_DTO> searchKH(int maPhong, Date ng) {
		PreparedStatement ptmt = null; 
		String query = "SELECT MaCTDatPhong, NgayThucHien, kh.MaKhachHang, HoTen, CMND, NgayNhan, NgayTra, MaPhong, MaNhanVien from CTDATPHONG ctdp, KHACHHANG kh where ctdp.MaKhachHang = kh.MaKhachHang and MaPhong= ? and datediff(day, NgayNhan, ?) >= 0 and datediff(day, ?, NgayTra) >= 0";
		MyConnection mycon = new QuanLyKS_DAL.MyConnection();
		Connection conn = mycon.getConnection();
		
		try {
			ptmt = conn.prepareStatement(query);
			ptmt.setInt(1, maPhong);
			ptmt.setDate(2, ng);
			ptmt.setDate(3, ng);
			ResultSet rs = ptmt.executeQuery();
			ArrayList<CTDatPhong_DTO> listCTDP = new ArrayList<CTDatPhong_DTO>();
			while(rs.next()) {
				KhachHang_DTO kh = new KhachHang_DTO();
				kh.setMaKH(rs.getInt("MaKhachHang"));
				kh.setTenKH(rs.getString("HoTen"));
				kh.setCMND(rs.getString("CMND"));
				listCTDP.add(new CTDatPhong_DTO(kh, rs.getInt("MaPhong"), rs.getDate("NgayNhan"), rs.getDate("NgayTra")));
			}
			
			return listCTDP;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ArrayList<CTDatPhong_DTO>();
		}
	}
}
