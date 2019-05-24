package QuanLyKS_BUS;
import QuanLyKS_DAL.DanhGia_DAL;
import QuanLyKS_DTO.DanhGia_DTO;
public class DanhGia_BUS {
	private DanhGia_DAL DanhGiaDAL;
	public DanhGia_BUS(){
		DanhGiaDAL = new DanhGia_DAL();
	}
	public static boolean Insert(DanhGia_DTO danhgia) {
		return DanhGia_DAL.Insert(danhgia);
	}
}
