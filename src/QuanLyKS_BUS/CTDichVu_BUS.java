package QuanLyKS_BUS;

import QuanLyKS_DAL.CTDichVu_DAL;
import QuanLyKS_DTO.CTDichVu_DTO;

public class CTDichVu_BUS {
	private static CTDichVu_DAL ChucVuDAL;
	public CTDichVu_BUS(){
		ChucVuDAL = new CTDichVu_DAL();
	}

	
	
	
	public static boolean Insert(CTDichVu_DTO ctdv) {
		return CTDichVu_DAL.Insert(ctdv);
	}
}
