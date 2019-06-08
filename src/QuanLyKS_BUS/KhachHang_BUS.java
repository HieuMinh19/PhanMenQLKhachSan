package QuanLyKS_BUS;

import QuanLyKS_DAL.KhachHang_DAL;
import QuanLyKS_DTO.KhachHang_DTO;

public class KhachHang_BUS {
	public static int getnextMaKH() {
		return KhachHang_DAL.buildMaKH(); 
	}
	
	public static boolean Insert(KhachHang_DTO kh) {
		return KhachHang_DAL.Insert(kh);
	}
}
