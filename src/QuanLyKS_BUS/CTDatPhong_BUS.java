package QuanLyKS_BUS;
import QuanLyKS_DAL.CTDatPhong_DAL;
import QuanLyKS_DTO.CTDatPhong_DTO;
public class CTDatPhong_BUS {
	private static CTDatPhong_DAL ctdpDAL;
	public static boolean Insert(CTDatPhong_DTO ctdp) {
		return CTDatPhong_DAL.Insert(ctdp);
	}
	
}
