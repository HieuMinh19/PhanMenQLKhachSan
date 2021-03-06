package QuanLyKS_BUS;
import java.sql.ResultSet;
import java.util.ArrayList;

import QuanLyKS_DTO.DichVu_DTO;
import QuanLyKS_DTO.NhanVien_DTO;
import QuanLyKS_DAL.DichVu_DAL;
public class DichVu_BUS {
	private static DichVu_DAL DichVuDAL;
	public DichVu_BUS(){
		DichVuDAL = new DichVu_DAL();
	}
	
	public ResultSet selectAll() {
		return DichVuDAL.getListDV();
	}
	public static boolean Insert(DichVu_DTO dichvu) {
		return DichVu_DAL.Insert(dichvu);
	}
	
	public static boolean Update(DichVu_DTO dichvu) {
		return DichVu_DAL.Update(dichvu);
	}
	public static boolean Delete(int dichvu) {
		return DichVu_DAL.Delete(dichvu);
	}
	
	public ArrayList<DichVu_DTO> LoadListDV (){
		return DichVuDAL.LoadListDV();
		
	}
	public static ArrayList<DichVu_DTO> getListDV(){
		return DichVu_DAL.getallDV();
	}

	public static DichVu_DTO getListDV(int maDV){
		return DichVu_DAL.getDVById(maDV);
	}
	
}
