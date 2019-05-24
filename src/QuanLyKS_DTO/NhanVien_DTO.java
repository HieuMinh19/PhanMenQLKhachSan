package QuanLyKS_DTO;

public class NhanVien_DTO {

	private int iMaNhanVien;
	private String strTenNhanVien;
	private String strNgaySinh;
	private int iCMND;
	private String strNgayVaoLam;
	private int iMaChucVu;

	public NhanVien_DTO() {
		// TODO Auto-generated constructor stub
	}
	public NhanVien_DTO(String strTenNhanVien, String strNgaySinh, int iCMND,String strNgayVaoLam,int iMaChucVu) {
		this.strTenNhanVien = strTenNhanVien;
		this.strNgaySinh = strNgaySinh;
		this.iCMND = iCMND;
		this.strNgayVaoLam = strNgayVaoLam;
		this.iMaChucVu = iMaChucVu;
	}

	public int getMaNhanVien() {
		return iMaNhanVien;
	}
	public void setMaNhanVien(int iMaNhanVien) {
		this.iMaNhanVien = iMaNhanVien;
	}

	public String getTenNhanVien() {
		return strTenNhanVien;
	}
	public void setTenNhanVien(String strTenNhanVien) {
		this.strTenNhanVien = strTenNhanVien;
	}

	public String getNgaySinh() {
		return strNgaySinh;
	}
	public void setNgaySinh(String strNgaySinh) {
		this.strNgaySinh = strNgaySinh;
	}

	public int getCMND() {
		return iCMND;
	}
	public void setCMND(int iCMND) {
		this.iCMND = iCMND;
	}

	public String getNgayVaoLam() {
		return strNgayVaoLam;
	}
	public void setNgayVaoLam(String strNgayVaoLam) {
		this.strNgayVaoLam = strNgayVaoLam;
	}

	public int getMaChucVu() {
		return iMaChucVu;
	}
	public void setMaChucVu(int iMaChucVu) {
		this.iMaChucVu = iMaChucVu;
	}
	
	@Override
	public String toString() {
		return this.iMaNhanVien + " - " + this.strTenNhanVien;
	}

}
