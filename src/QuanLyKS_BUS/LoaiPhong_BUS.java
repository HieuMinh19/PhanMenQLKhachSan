package QuanLyKS_BUS;

import java.sql.ResultSet;

import QuanLyKS_DAL.LoaiPhong_DAL;
import QuanLyKS_DTO.LoaiPhong_DTO;

public class LoaiPhong_BUS {
	private static LoaiPhong_DAL LoaiPhongDAL;
	public LoaiPhong_BUS(){
		LoaiPhongDAL = new LoaiPhong_DAL();
	}
	
	public ResultSet selectAll() {
		return LoaiPhongDAL.getListLoaiPhong();
	}
	public static boolean Insert(LoaiPhong_DTO loaiphong){
		return LoaiPhong_DAL.Insert(loaiphong);
	}
}
