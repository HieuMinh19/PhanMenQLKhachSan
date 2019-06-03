package QuanLyKS_BUS;

import java.util.ArrayList;

import QuanLyKS_DAL.LoaiPhong_DAL;
import QuanLyKS_DTO.LoaiPhong_DTO;

public class LoaiPhong_BUS {
	private static LoaiPhong_DAL dal;
	
	public LoaiPhong_BUS(){
		dal = new LoaiPhong_DAL();
	}

	public static boolean Insert(LoaiPhong_DTO loaiphong){
		return LoaiPhong_DAL.Insert(loaiphong);
	}
	
	public ArrayList<LoaiPhong_DTO> selectAll() {
		return dal.selectAll();
	}
}
