package QuanLyKS_DAL;
import java.sql.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import QuanLyKS_DTO.CTDatPhong_DTO;
import QuanLyKS_DTO.CTDichVu_DTO;
import QuanLyKS_DTO.DichVu_DTO;
import QuanLyKS_DTO.KhachHang_DTO;
import QuanLyKS_DTO.LoaiPhong_DTO;;
public class CTDichVu_DAL {
	public static boolean Insert(CTDichVu_DTO ctdvDTO)  {
		PreparedStatement ptmt = null; 
		String query = "INSERT INTO CTDICHVU(MaDichVu, SoLuong, MaCTDatPhong, TongTienDichVu) VALUES (?, ?, ?, ?)";
		MyConnection mycon = new QuanLyKS_DAL.MyConnection();
		Connection conn = mycon.getConnection(); 
		try {
			ptmt = conn.prepareStatement(query);
			ptmt.setInt(1, ctdvDTO.getMaDichVu());
			ptmt.setInt(2, ctdvDTO.getSoLuong());
			ptmt.setInt(3, ctdvDTO.getMaCTDatPhong());
			System.err.println("MaCTDatPhong trong CTDichVu DAL" +" "+ ctdvDTO.getMaCTDatPhong());
			ptmt.setInt(4, ctdvDTO.getTongTienDichVu());
			if( ptmt.executeUpdate() != 0) {
				System.err.println("booking Service success");
				return true;
			}
				
			else {
				System.err.println("booking Service fail");
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println(" ket noi that bai");
			return false;
		}
	}
	
	public static ArrayList<CTDichVu_DTO> loadTableDV(int MaCTDP) {
		PreparedStatement ptmt = null; 
		String query = "SELECT TenDichVu, SoLuong, TongTienDichVu   from CTDICHVU ctdv, DICHVU dv where dv.MaDichVu=ctdv.MaDichVu and MaCTDatPhong=?";
		MyConnection mycon = new QuanLyKS_DAL.MyConnection();
		Connection conn = mycon.getConnection();
		
		try {
			ptmt = conn.prepareStatement(query);
			ptmt.setInt(1,MaCTDP);
			ResultSet rs = ptmt.executeQuery();
			ArrayList<CTDichVu_DTO> listctdv = new ArrayList<CTDichVu_DTO>();
			while(rs.next()) {
				CTDichVu_DTO ctdv = new CTDichVu_DTO();
				DichVu_DTO dv = new DichVu_DTO();
				dv.setTenDichVu(rs.getString("TenDichVu"));
				ctdv.setDichVu(dv);
				ctdv.setSoLuong(rs.getInt("SoLuong"));
				ctdv.setTongTienDichVu(rs.getInt("TongTienDichVu"));
				
				listctdv.add(ctdv);
			}
			
			return listctdv;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ArrayList<CTDichVu_DTO>();
		}
	}
}
