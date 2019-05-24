package QuanLyKS_DTO;

public class DichVu_DTO {
	private int iMaDichVu;
	private String strTenDichVu;
	private int iGiaDichVu;
	
	
	public DichVu_DTO(int iMaDichVu, String strTenDichVu, int iGiaDichVu) {
		this.iMaDichVu = iMaDichVu;
		this.strTenDichVu = strTenDichVu;
		this.iGiaDichVu = iGiaDichVu;
	}
	
	public DichVu_DTO(int iMaDichVu, String TenDichVu) {
		this.iMaDichVu = iMaDichVu;
		this.strTenDichVu = TenDichVu;
	}
	
	
	public DichVu_DTO(  String strTenDichVu, int iGiaDichVu, int iMaDichVu) {
		this.strTenDichVu = strTenDichVu;
		this.iGiaDichVu = iGiaDichVu;
		this.iMaDichVu = iMaDichVu;
		
	}
	public DichVu_DTO() {
		this.iMaDichVu  = 1;
		this.strTenDichVu = "";
		this.iGiaDichVu  = 1;
	}

	public int getMaDichVu() {
		return iMaDichVu;
	}
	public void setMaDichVu(int iMaDichVu) {
		this.iMaDichVu = iMaDichVu;
	} 
	public String getTenDichVu() {
		return strTenDichVu;
	}
	public void setTenDichVu(String tenDichVu) {
		strTenDichVu = tenDichVu;
	}
		public int getGiaDichVu() {
		return iGiaDichVu;
	}
	public void setGiaDichVu(int iGiaDichVu) {
		this.iGiaDichVu = iGiaDichVu;
	}
}
