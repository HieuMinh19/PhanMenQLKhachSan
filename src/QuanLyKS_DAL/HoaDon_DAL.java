package QuanLyKS_DAL;

import java.awt.EventQueue;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import QuanLyKS_DTO.ChucVu_DTO;
import QuanLyKS_DTO.HoaDon_DTO;

import javax.swing.JInternalFrame;

public class HoaDon_DAL extends JInternalFrame {
	public HoaDon_DAL() {
		setBounds(100, 100, 450, 300);
	}
	
	//connect table NHANVIEN
	public ArrayList<HoaDon_DTO> SearchNV (int tukhoa){
		//get connection
		PreparedStatement ptmt = null; 
		MyConnection mycon = new QuanLyKS_DAL.MyConnection();
		Connection conn = mycon.getConnection();
		String query = "SELECT CTDATPHONG.MaCTDatPhong, KHACHHANG.HoTen , LOAIPHONG.TenLoaiPhong,LOAIPHONG.GiaPhong,   CTDATPHONG.NgayNhan, CTDATPHONG.NgayTra FROM CTDATPHONG, KHACHHANG, PHONG, LOAIPHONG WHERE CTDATPHONG.MaKhachHang = KHACHHANG.MaKhachHang and CTDATPHONG.MaPhong = PHONG.MaPhong and LOAIPHONG.MaLoaiPhong = PHONG.MaLoaiPhong and CTDATPHONG.MaPhong = '"+tukhoa+"' ";
		try {
			ptmt = conn.prepareStatement(query);
			ResultSet rs = ptmt.executeQuery();
			ArrayList<HoaDon_DTO> dsnv = new ArrayList<HoaDon_DTO>();
			while(rs.next()) {
				HoaDon_DTO nv = new HoaDon_DTO();
				nv.setMaCTDatPhong(rs.getInt("MaCTDatPhong"));
				nv.setHoTen(rs.getString("HoTen"));
				nv.setTenLoaiPhong(rs.getString("TenLoaiPhong"));
				nv.setGiaPhong(rs.getInt("GiaPhong"));
				nv.setNgayNhan(rs.getDate("NgayNhan"));
				nv.setNgayTra(rs.getDate("NgayTra"));
				dsnv.add(nv);
			}
			return dsnv;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;	
	}
	public ArrayList<HoaDon_DTO> SearchTenDV (int tukhoa){
		//get connection
		PreparedStatement ptmt = null; 
		MyConnection mycon = new QuanLyKS_DAL.MyConnection();
		Connection conn = mycon.getConnection();
		String query = "SELECT DICHVU.TenDichVu, CTDICHVU.SoLuong,CTDICHVU.TongTienDichVu FROM CTDATPHONG, DICHVU, CTDICHVU WHERE DICHVU.MaDichVu = CTDICHVU.MaDichVu and CTDICHVU.MaCTDatPhong = CTDATPHONG.MaCTDatPhong and CTDATPHONG.MaPhong = '"+tukhoa+"' ";
		try {
			ptmt = conn.prepareStatement(query);
			ResultSet rs = ptmt.executeQuery();
			ArrayList<HoaDon_DTO> dsnv = new ArrayList<HoaDon_DTO>();
			while(rs.next()) {
				HoaDon_DTO nv = new HoaDon_DTO();
				nv.setTenDichVu(rs.getString("TenDichVu"));
				nv.setSoLuong(rs.getInt("SoLuong"));
				nv.setTongTienDichVu(rs.getInt("TongTienDichVu"));
				dsnv.add(nv);
			}
			return dsnv;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;	
	}
	public static boolean Insert(HoaDon_DTO hd)  {
		PreparedStatement ptmt = null; 
		String query = "INSERT INTO HOADON(NgayThuTien,SoTienThu, MaCTDatPhong,MaNhanVien) VALUES (?,?, ?,?)";
		MyConnection mycon = new QuanLyKS_DAL.MyConnection();
		Connection conn = mycon.getConnection();
		
		try {
			ptmt = conn.prepareStatement(query);
			ptmt.setDate(1, hd.getNgayThuTien());
			ptmt.setInt(2, hd.getSoTienThu());
			ptmt.setInt(3, hd.getMaCTDatPhong());
			ptmt.setInt(4, hd.getMaNhanVien());
			//ptmt.setDate(2, hd.getNgaySinh());
			//ptmt.setInt(3, hd.getCMND());
			//ptmt.setDate(4, hd.getNgayVaoLam());
			//ptmt.setInt(5, hd.getMaChucVu());
			
			if( ptmt.executeUpdate() != 0) {
				System.err.println("insert thanh cong nhan vien");
				return true;
			}
				
			else {
				System.err.println("khoi tao nhan vien that bai");
				return false;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	} 
//	
//	public static boolean Update(NhanVien_DTO nv)  {
//		PreparedStatement ptmt = null; 
//		String query = "UPDATE NHANVIEN SET TenNhanVien = ?, NgaySinh = ?, CMND = ?, NgayVaoLam = ?, MaChucVu = ? WHERE MaNhanVien = ?";
//		MyConnection mycon = new QuanLyKS_DAL.MyConnection();
//		Connection conn = mycon.getConnection();
//
//		try {
//			ptmt = conn.prepareStatement(query);
//			ptmt.setString(1, nv.getTenNhanVien());
//			ptmt.setDate(2, nv.getNgaySinh());
//			ptmt.setInt(3, nv.getCMND());
//			ptmt.setDate(4, nv.getNgayVaoLam());
//			ptmt.setInt(5, nv.getMaChucVu());
//			ptmt.setInt(6, nv.getMaNhanVien());
//
//			if( ptmt.executeUpdate() != 0) {
//				System.err.println("update thanh cong nhan vien");
//				return true;
//			}
//			
//			else {
//				System.err.println("update nhan vien that bai");
//				return false;
//			}
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		return false;
//	}
//	
//	public static boolean Delete(int maNV)  {
//		PreparedStatement ptmt = null; 
//		String query = "DELETE FROM NHANVIEN WHERE MaNhanVien = ?";
//		MyConnection mycon = new QuanLyKS_DAL.MyConnection();
//		Connection conn = mycon.getConnection();
//
//		try {
//			ptmt = conn.prepareStatement(query);
//			ptmt.setInt(1, maNV);
//
//			if( ptmt.executeUpdate() != 0) {
//				System.err.println("delete thanh cong nhan vien");
//				return true;
//			}
//
//			else {
//				System.err.println("xoa nhan vien that bai");
//				return false;
//			}
//
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		return false;
//	}
	
//	public ArrayList<NhanVien_DTO> LoadListNV (){
//		//get connection
//		PreparedStatement ptmt = null; 
//		MyConnection mycon = new QuanLyKS_DAL.MyConnection();
//		Connection conn = mycon.getConnection();
//		
//		String query = "SELECT MaNhanVien,TenNhanVien,NgaySinh,CMND,NgayVaoLam,CV.MaChucVu as 'MaChucVu',TenChucVu FROM NHANVIEN NV, CHUCVU CV WHERE NV.MACHUCVU=CV.MACHUCVU ";
//		try {
//			ptmt = conn.prepareStatement(query);
//			ResultSet rs = ptmt.executeQuery();
//			ArrayList<NhanVien_DTO> dsnv = new ArrayList<NhanVien_DTO>();
//			while(rs.next()) {
//				NhanVien_DTO nv = new NhanVien_DTO();
//				nv.setMaNhanVien(rs.getInt("MaNhanVien"));
//				nv.setTenNhanVien(rs.getString("TenNhanVien"));
//				nv.setNgaySinh(rs.getDate("NgaySinh"));
//				nv.setCMND(rs.getInt("CMND"));
//				nv.setNgayVaoLam(rs.getDate("NgayVaoLam"));
//				nv.setMaChucVu(rs.getInt("MaChucVu"));
//				nv.setChucVu(new ChucVu_DTO(rs.getInt("MaChucVu"),rs.getString("TenChucVu")));
//				dsnv.add(nv);
//			}
//			return dsnv;
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return null;	
//	}

//	public static NhanVien_DTO login(String username, String password){
//		//get connection
//		PreparedStatement ptmt = null; 
//		MyConnection mycon = new QuanLyKS_DAL.MyConnection();
//		Connection conn = mycon.getConnection();
//		
//		String query = "SELECT MaNhanVien,TenNhanVien,NgaySinh,CMND,NgayVaoLam,CV.MaChucVu as 'MaChucVu',TenChucVu,Username,Password FROM NHANVIEN NV, CHUCVU CV WHERE NV.MACHUCVU=CV.MACHUCVU and Username=? and Password=?";
//		try {
//			ptmt = conn.prepareStatement(query);
//			ptmt.setString(1, username);
//			ptmt.setString(2, password);
//			ResultSet rs = ptmt.executeQuery();
//			rs.next();
//			NhanVien_DTO nv = new NhanVien_DTO();
//			nv.setMaNhanVien(rs.getInt("MaNhanVien"));
//			nv.setTenNhanVien(rs.getString("TenNhanVien"));
//			nv.setNgaySinh(rs.getDate("NgaySinh"));
//			nv.setCMND(rs.getInt("CMND"));
//			nv.setNgayVaoLam(rs.getDate("NgayVaoLam"));
//			nv.setMaChucVu(rs.getInt("MaChucVu"));
//			nv.setChucVu(new ChucVu_DTO(rs.getInt("MaChucVu"),rs.getString("TenChucVu")));
//			nv.setUsername(rs.getString("Username"));
//			nv.setPassword(rs.getString("Password"));
//			return nv;
//		} catch (SQLException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
//			return null;	
//		}
//	}
}
