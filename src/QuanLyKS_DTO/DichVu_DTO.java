package QuanLyKS_DTO;

public class DichVu_DTO {
	private int iMaDV;
	private int iMaCTDichVu;
	private String strTenDichVu;
	
	
	public DichVu_DTO(int MaDV, int MaCTDV, String TenDV) {
		this.iMaDV = MaDV;
		this.iMaCTDichVu = MaCTDV;
		this.strTenDichVu = TenDV;
	}
	
	public DichVu_DTO() {
		this.iMaDV  = 1;
		this.iMaCTDichVu = 1;
		this.strTenDichVu = "";
	}

	public int getMaDV() {
		return iMaDV;
	}
	public void setMaDV(int iMaDV) {
		this.iMaDV = iMaDV;
	}
	public int getMaCTDichVu() {
		return iMaCTDichVu;
	}
	public void setMaCTDichVu(int iMaCVDichVu) {
		this.iMaCTDichVu = iMaCVDichVu;
	}
	public String getTenDichVu() {
		return strTenDichVu;
	}
	public void setTenDichVu(String tenDichVu) {
		strTenDichVu = tenDichVu;
	}
	
}
