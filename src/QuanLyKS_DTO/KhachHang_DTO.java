package QuanLyKS_DTO;

public class KhachHang_DTO {
	private int iMaKhachHang;
	private String strHoTen;
	private String strDienThoai;
	private String strDiaChi;
	private String strCMND;
	private String strEmail;
	
	public KhachHang_DTO(int iMaKhachHang, String strHoTen, String strDienThoai, String strCMND, String strDiaChi, String strEmail) {
		this.iMaKhachHang = iMaKhachHang;
		this.strHoTen = strHoTen;
		this.strDienThoai = strDienThoai;
		this.strCMND = strCMND;
		this.strDiaChi = strDiaChi;
		this.strEmail = strEmail;
	} 
	
	public KhachHang_DTO(String strHoTen, String strDienThoai, String strCMND) {
		this.strHoTen = strHoTen;
		this.strDienThoai = strDienThoai;
		this.strCMND = strCMND;
	}
	
	
	public int getMaKH() {
		return iMaKhachHang;
	}
	public void setMaKH(int iMaKhachHang) {
		this.iMaKhachHang = iMaKhachHang;
	}
	public String getTenKH() {
		return strHoTen;
	}
	public void setTenKH(String strHoTen) {
		this.strHoTen = strHoTen;
	}
	public String getSDT() {
		return strDienThoai;
	}
	public void setSDT(String strDienThoai) {
		this.strDienThoai = strDienThoai;
	}
	public String getCMND() {
		return strCMND;
	}
	public void setCMND(String strCMND) {
		this.strCMND = strCMND;
	}

	public String getDiaChi() {
		return strDiaChi;
	}

	public void setDiaChi(String strDiaChi) {
		this.strDiaChi = strDiaChi;
	}

	public String getEmail() {
		return strEmail;
	}

	public void setEmail(String strEmail) {
		this.strEmail = strEmail;
	}
	
}
