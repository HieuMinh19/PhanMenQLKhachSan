package QuanLyKS_DAL;
import QuanLyKS_DTO.CTDatPhong_DTO;
import QuanLyKS_DTO.KhachHang_DTO;
import QuanLyKS_DTO.LoaiPhong_DTO;
import QuanLyKS_DTO.NhanVien_DTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;
import java.sql.Date;
public class CTDatPhong_DAL {
	public static boolean Insert(CTDatPhong_DTO ctDP){
		PreparedStatement ptmt = null; 
		String query = "INSERT INTO CTDATPHONG(MaCTDatPhong, NgayThucHien, MaKhachHang, NgayNhan, NgayTra, MaPhong, MaNhanVien)"
				+ " VALUES (?, ?, ?, ?, ?, ?, ?)";
		MyConnection mycon = new QuanLyKS_DAL.MyConnection();
		Connection conn = mycon.getConnection();
		try {
			ptmt = conn.prepareStatement(query);
			
			ptmt.setInt(1, ctDP.getMaCTDatPhong());
			System.err.println("MaCTDatPhong trong CTDatPhong DAL" +" "+ ctDP.getMaCTDatPhong());
			
			//

			java.sql.Date sqlStartDate = new java.sql.Date(ctDP.getdtNgayThucHien().getTime());
			//
			ptmt.setDate(2, sqlStartDate);
			System.err.println("NgayThucHien trong CTDatPhong DAL" +" "+ ctDP.getdtNgayThucHien());
			
			ptmt.setInt(3,  ctDP.getMaKhachHang());
			System.err.println("MaKhachHang trong CTDatPhong DAL" +""+ ctDP.getMaKhachHang());
			//
			java.sql.Date NgayNhan = new java.sql.Date(ctDP.getNgayNhan().getTime());
			//
			ptmt.setDate(4,  NgayNhan);
			System.err.println("NgayNhan trong CTDatPhong DAL" +""+ ctDP.getNgayNhan());
			//
			java.sql.Date NgayTra = new java.sql.Date(ctDP.getNgayTra().getTime());
			//
			ptmt.setDate(5,  NgayTra);
			System.err.println("NgayTra trong CTDatPhong DAL" +""+ ctDP.getNgayTra());
			
			ptmt.setInt(6,  ctDP.getMaPhong());
			System.err.println("MaPhong trong CTDatPhong DAL" +""+ ctDP.getMaPhong());
			
			ptmt.setInt(7,  ctDP.getMaNhanVien());
			System.err.println("MaNhanVien trong CTDatPhong DAL" +""+ ctDP.getMaNhanVien());
			
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
			ptmt = conn.prepareStatement(query);
			ResultSet rs = ptmt.executeQuery();
			rs.next();
			return rs.getInt("MaCTDatPhong") + 1;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block 
			e.printStackTrace();
			return 1;
		}
		
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
	
	public static ArrayList<CTDatPhong_DTO> loadPhongChuaThanhToan(Date ng) {
		PreparedStatement ptmt = null; 
		String queryByDate = "SELECT MaPhong,HoTen, MaCTDatPhong from CTDATPHONG ctdp, KHACHHANG kh where ctdp.MaKhachHang=kh.MaKhachHang and datediff(day, NgayNhan, ?) >= 0 and datediff(day, ?, NgayTra) >= 0 and MaCTDatPhong not in (select MaCTDatPhong from HOADON)";
//		String query = "SELECT MaPhong,HoTen from CTDATPHONG ctdp, KHACHHANG kh where ctdp.MaKhachHang=kh.MaKhachHang and MaCTDatPhong not in (select MaCTDatPhong from HOADON)";
		MyConnection mycon = new QuanLyKS_DAL.MyConnection();
		Connection conn = mycon.getConnection();
		
		try {
			ptmt = conn.prepareStatement(queryByDate);
			ptmt.setDate(1,ng);
			ptmt.setDate(2,ng);
			ResultSet rs = ptmt.executeQuery();
			ArrayList<CTDatPhong_DTO> listCTDP = new ArrayList<CTDatPhong_DTO>();
			while(rs.next()) {
				CTDatPhong_DTO ctdp = new CTDatPhong_DTO();
				ctdp.setMaPhong(rs.getInt("MaPhong"));
				ctdp.setMaCTDatPhong(rs.getInt("MaCTDatPhong"));
				KhachHang_DTO kh = new KhachHang_DTO();
				kh.setTenKH(rs.getString("HoTen"));
				ctdp.setKhachHang(kh);
				listCTDP.add(ctdp);	
			}
			
			return listCTDP;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ArrayList<CTDatPhong_DTO>();
		}
	}
	
	
	public static CTDatPhong_DTO loadTableCTDP(int MaPhong) {
		PreparedStatement ptmt = null; 
		String query = "SELECT ctdp.MaCTDatPhong, ctdp.MaPhong, HoTen, TenLoaiPhong, GiaPhong, NgayNhan, NgayTra  from CTDATPHONG ctdp, KHACHHANG kh, LOAIPHONG lp, PHONG p where ctdp.MaKhachHang=kh.MaKhachHang and p.MaLoaiPhong=lp.MaLoaiPhong and p.MaPhong=ctdp.MaPhong and ctdp.MaPhong=?";
		MyConnection mycon = new QuanLyKS_DAL.MyConnection();
		Connection conn = mycon.getConnection();
		
		try {
			ptmt = conn.prepareStatement(query);
			ptmt.setInt(1,MaPhong);
			ResultSet rs = ptmt.executeQuery();
			CTDatPhong_DTO ctdp = new CTDatPhong_DTO();
			while(rs.next()) {
				ctdp.setMaCTDatPhong(rs.getInt("MaCTDatPhong"));
				ctdp.setMaPhong(rs.getInt("MaPhong"));
				KhachHang_DTO kh = new KhachHang_DTO();
				kh.setTenKH(rs.getString("HoTen"));
				ctdp.setKhachHang(kh);
				LoaiPhong_DTO lp = new LoaiPhong_DTO();
				lp.setTenLoaiPhong(rs.getString("TenLoaiPhong"));
				lp.setGiaPhong(rs.getInt("GiaPhong"));
				ctdp.setLoaiPhong(lp);
				ctdp.setNgayNhan(rs.getDate("NgayNhan"));
				ctdp.setNgayTra(rs.getDate("NgayTra"));
			}
			
			return ctdp;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new CTDatPhong_DTO();
		}
	}
}
