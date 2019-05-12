package QuanLyKS_DTO;

public class DichVu_DTO {
	private int iMaDichVu;
	private int iMaCTDichVu;
	private String strTenDichVu;
	private int iGiaDichVu;
	
	public DichVu_DTO(int MaDichVu, int MaCTDichVu, String TenDichVu, int GiaDichVu) {
		this.iMaDichVu = MaDichVu;
		this.iMaCTDichVu = MaCTDichVu;
		this.strTenDichVu = TenDichVu;
		this.iGiaDichVu = GiaDichVu;
	}
	
	public DichVu_DTO() {
		this.iMaDichVu  = 1;
		this.iMaCTDichVu = 1;
		this.strTenDichVu = "";
		this.iGiaDichVu  = 1;
	}

	public int getMaDichVu() {
		return iMaDichVu;
	}
	public void setMaDV(int iMaDichVu) {
		this.iMaDichVu = iMaDichVu;
	} 
	public int getMaCTDichVu() {
		return iMaCTDichVu;
	}
	public void setMaCTDichVu(int iMaCTDichVu) {
		this.iMaCTDichVu = iMaCTDichVu;
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
