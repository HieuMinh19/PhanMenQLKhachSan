package QuanLyKS_BUS;

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
	
	public ArrayList<NhanVien_DTO> SearchNV (String tukhoa){
		return dal.SearchNV(tukhoa);
		
	}
	
	public static boolean Insert(NhanVien_DTO nhanvien) {
		return NhanVien_DAL.Insert(nhanvien);
	}
}
