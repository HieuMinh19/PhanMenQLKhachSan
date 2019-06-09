package QuanLyKS_BUS;

import java.sql.Date;
import java.util.ArrayList;
import QuanLyKS_DTO.NhanVien_DTO;
import QuanLyKS_DTO.HoaDon_DTO;
import javax.swing.JInternalFrame;

import QuanLyKS_DAL.HoaDon_DAL;
public class HoaDon_BUS extends JInternalFrame {
	private HoaDon_DAL dal;


	/**
	 * Create the frame.
	 */
	public HoaDon_BUS() {
		setBounds(100, 100, 450, 300);
		dal = new HoaDon_DAL();
	}
	
	public ArrayList<HoaDon_DTO> SearchNV (int mactdatphong,Date ngaytra){
		return dal.SearchNV(mactdatphong, ngaytra);
	}
	public ArrayList<HoaDon_DTO> SearchTenDV (int mactdatphong,Date ngaytra){
		return dal.SearchTenDV(mactdatphong,ngaytra);
	}
	
//	public ArrayList<NhanVien_DTO> LoadListNV (){
//		return dal.LoadListNV();
//	}
//	
	public static boolean Insert(HoaDon_DTO nhanvien) {
		return HoaDon_DAL.Insert(nhanvien);
	}
//	
//	public static boolean Update(NhanVien_DTO nhanvien) {
//		return NhanVien_DAL.Update(nhanvien);
//	}
//
//	public static boolean Delete(int maNV) {
//		return NhanVien_DAL.Delete(maNV);
//	}
//
//	public static NhanVien_DTO Login(String username, String password) {
//		return NhanVien_DAL.login(username, password);
//	}
}
