package QuanLyKS_BUS;

import java.sql.Date;
import java.util.ArrayList;
import QuanLyKS_DTO.NhanVien_DTO;

import javax.swing.JInternalFrame;

import QuanLyKS_DAL.NhanVien_DAL;
public class NhanVien_BUS extends JInternalFrame {
	private NhanVien_DAL dal;


	/**
	 * Create the frame.
	 */
	public NhanVien_BUS() {
		setBounds(100, 100, 450, 300);
		dal = new NhanVien_DAL();
	}
	
	public ArrayList<NhanVien_DTO> SearchNV (String tukhoa, Date ngayvaolam){
		return dal.SearchNV(tukhoa, ngayvaolam);
	}
	
	public ArrayList<NhanVien_DTO> LoadListNV (){
		return dal.LoadListNV();
	}
	
	public static boolean Insert(NhanVien_DTO nhanvien) {
		return NhanVien_DAL.Insert(nhanvien);
	}
	
	public static boolean Update(NhanVien_DTO nhanvien) {
		return NhanVien_DAL.Update(nhanvien);
	}

	public static boolean Delete(int maNV) {
		return NhanVien_DAL.Delete(maNV);
	}

	public static NhanVien_DTO Login(String username, String password) {
		return NhanVien_DAL.login(username, password);
	}
}
