package QuanLyKS_BUS;

import QuanLyKS_DAL.KhachHang_DAL;

public class KhachHang_BUS {
	public static int getnextMaKH() {
		return KhachHang_DAL.buildMaKH();
	}
}
