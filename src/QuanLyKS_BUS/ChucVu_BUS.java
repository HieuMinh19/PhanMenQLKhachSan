package QuanLyKS_BUS;
import QuanLyKS_DAL.ChucVu_DAL;
import QuanLyKS_DAL.NhanVien_DAL;
import QuanLyKS_DTO.ChucVu_DTO;
import QuanLyKS_DTO.NhanVien_DTO;

import java.sql.ResultSet;
import java.util.ArrayList;
public class ChucVu_BUS {
	private static ChucVu_DAL dal;
	public ChucVu_BUS(){
		dal = new ChucVu_DAL();
	}
	public ArrayList<ChucVu_DTO> selectAll() {
		return dal.selectAll();
	}
	
	public ChucVu_DTO selectCondition (int MaCV){
		return dal.selectCondition(MaCV);
	}
	
}
