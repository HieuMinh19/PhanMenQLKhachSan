package QuanLyKS_DTO;

import java.sql.Date;

public class NhanVien_DTO {

	private int iMaNhanVien;
	private String strTenNhanVien;
	private Date dateNgaySinh;
	private int iCMND;
	private Date dateNgayVaoLam;
	private int iMaChucVu;

	public NhanVien_DTO() {
		// TODO Auto-generated constructor stub
	}
	public NhanVien_DTO(String strTenNhanVien, Date NgaySinh, int iCMND,Date ngayVaoLam,int iMaChucVu) {
		this.strTenNhanVien = strTenNhanVien;
		this.dateNgaySinh = NgaySinh;
		this.iCMND = iCMND;
		this.dateNgayVaoLam = ngayVaoLam;
		this.iMaChucVu = iMaChucVu;
	}
	public NhanVien_DTO(int iMaNhanVien, String strTenNhanVien, Date NgaySinh, int iCMND,Date ngayVaoLam,int iMaChucVu) {
		this.strTenNhanVien = strTenNhanVien;
		this.dateNgaySinh = NgaySinh;
		this.iCMND = iCMND;
		this.dateNgayVaoLam = ngayVaoLam;
		this.iMaChucVu = iMaChucVu;
		this.iMaNhanVien = iMaNhanVien;
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

	public Date getNgaySinh() {
		return dateNgaySinh;
	}
	public void setNgaySinh(Date dateNgaySinh) {
		this.dateNgaySinh = dateNgaySinh;
	}

	public int getCMND() {
		return iCMND;
	}
	public void setCMND(int iCMND) {
		this.iCMND = iCMND;
	}

	public Date getNgayVaoLam() {
		return dateNgayVaoLam;
	}
	public void setNgayVaoLam(Date dateNgayVaoLam) {
		this.dateNgayVaoLam = dateNgayVaoLam;
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
