package QuanLyKS_BUS;

import java.sql.ResultSet;
import java.util.ArrayList;

import QuanLyKS_DAL.LoaiPhong_DAL;
import QuanLyKS_DTO.LoaiPhong_DTO;

public class LoaiPhong_BUS {
	private static LoaiPhong_DAL LoaiPhongDAL;
	public LoaiPhong_BUS(){
		LoaiPhongDAL = new LoaiPhong_DAL();
	}
	
	public ArrayList<LoaiPhong_DTO> selectAll() {
		return LoaiPhongDAL.selectAll();
	}
}
