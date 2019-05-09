package QuanLyKS_DTO;

public class TrangThai_DTO {
	private int iMaTrangThai;
	private String strTenTrangThai;
	
	public TrangThai_DTO() {
		iMaTrangThai = 1;
		strTenTrangThai = null;
	}
	
	public int getMaTrangThai() {
		return iMaTrangThai;
	}
	public void setMaTrangThai(int iMaTrangThai) {
		this.iMaTrangThai = iMaTrangThai;
	}
	public String getTenTrangThai() {
		return strTenTrangThai;
	}
	public void setTenTrangThai(String strTenTrangThai) {
		this.strTenTrangThai = strTenTrangThai;
	}
}
