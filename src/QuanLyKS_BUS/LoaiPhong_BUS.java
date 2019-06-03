package QuanLyKS_BUS;

import java.util.ArrayList;

import QuanLyKS_DAL.LoaiPhong_DAL;
import QuanLyKS_DAL.NhanVien_DAL;
import QuanLyKS_DTO.LoaiPhong_DTO;
import QuanLyKS_DTO.NhanVien_DTO;

public class LoaiPhong_BUS {
	private static LoaiPhong_DAL dal;
	
	public LoaiPhong_BUS(){
		dal = new LoaiPhong_DAL();
	}

	public static boolean Insert(LoaiPhong_DTO loaiphong){
		return LoaiPhong_DAL.Insert(loaiphong);
	}
	public ArrayList<LoaiPhong_DTO> LoadListLP   (){
		return dal.LoadListLP();
	}
	
	public ArrayList<LoaiPhong_DTO> selectAll() {
		return dal.selectAll();
	}
	public static boolean Update(LoaiPhong_DTO loaiphong) {
		return LoaiPhong_DAL.Update(loaiphong);
	}

	public static boolean Delete(int maLoaiPhong) {
		return LoaiPhong_DAL.Delete(maLoaiPhong);
	}
}
