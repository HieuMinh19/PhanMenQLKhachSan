package QuanLyKS_BUS;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Date;
import QuanLyKS_DTO.BangPhanCong_DTO;
import QuanLyKS_DTO.NhanVien_DTO;
import QuanLyKS_DAL.BangPhanCong_DAL;
import QuanLyKS_DAL.NhanVien_DAL;
public class BangPhanCong_BUS {
	private static BangPhanCong_DAL BangPhanCongDAL;
	
	
	public BangPhanCong_BUS(){
		BangPhanCongDAL = new BangPhanCong_DAL();
	}
	
	public ResultSet selectAll() {
		return BangPhanCongDAL.getListBPC();
	}
	public static boolean Insert(BangPhanCong_DTO bangphancong) {
		return BangPhanCong_DAL.Insert(bangphancong);
	}
	public ArrayList<BangPhanCong_DTO> LoadListBPC (){
		return BangPhanCongDAL.LoadListBPC();
	}
//	
	public static boolean Update(BangPhanCong_DTO bangphancong) {
		return BangPhanCong_DAL.Update(bangphancong);
	}
	public static boolean Delete(int bangphancong) {
		return BangPhanCong_DAL.Delete(bangphancong);
	}
//	
	
}
