package QuanLyKS_BUS;

import java.sql.Date;
import java.util.ArrayList;

import QuanLyKS_DAL.Phong_DAL;
import QuanLyKS_DTO.Phong_DTO;

public class Phong_BUS {
	private Phong_DAL dal = new Phong_DAL();
	
	public ArrayList<Phong_DTO> LoadListPhong (){
		return dal.LoadListPhong();
	}
	
	public static ArrayList<Phong_DTO> getListCondition (int MaLoaiPhong, String NgayNhan, String NgayTra){
		return Phong_DAL.getListCondition(MaLoaiPhong, NgayNhan, NgayTra);
	}

	public static String getTenLoaiPhong(int iMaPhong) {
		return Phong_DAL.getLoaiPhongbyMaPhong(iMaPhong);
	}

	public static int getGiaPhong(int iMaPhong) {
		return Phong_DAL.getGiaPhong(iMaPhong);
	}
}
 