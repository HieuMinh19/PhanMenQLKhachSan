package QuanLyKS_BUS;

import java.sql.Date;
import java.util.ArrayList;

import QuanLyKS_DAL.NhanVien_DAL;
import QuanLyKS_DAL.Phong_DAL;
import QuanLyKS_DTO.NhanVien_DTO;
import QuanLyKS_DTO.Phong_DTO;

public class Phong_BUS {
	
	public static ArrayList<Phong_DTO> LoadListPhong (){
		return Phong_DAL.LoadListPhong();
	}
	
	public static ArrayList<Phong_DTO> getListCondition (int MaLoaiPhong, String NgayNhan, String NgayTra){
		return Phong_DAL.getListCondition(MaLoaiPhong, NgayNhan, NgayTra);
	}
	
	public static boolean Update(Phong_DTO phong, int iMaPhong) {
		return Phong_DAL.Update(phong, iMaPhong);
	}

	public static String getTenLoaiPhong(int iMaPhong) {
		return Phong_DAL.getLoaiPhongbyMaPhong(iMaPhong);
	}

	public static int getGiaPhong(int iMaPhong) {
		return Phong_DAL.getGiaPhong(iMaPhong);
	}
	public static boolean Insert(Phong_DTO phong) {
		return Phong_DAL.Insert(phong);
	}
	
	public static boolean Delete(int phong) {
		return Phong_DAL.Delete(phong);
	}
}
 