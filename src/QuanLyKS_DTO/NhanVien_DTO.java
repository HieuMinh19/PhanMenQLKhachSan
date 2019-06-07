package QuanLyKS_DTO;
import java.sql.Date;

public class NhanVien_DTO {

	private int iMaNhanVien;
	private String strTenNhanVien;
	private Date dtNgaySinh;
	private int iCMND;
	private Date dtNgayVaoLam;
	private int iMaChucVu;
	private ChucVu_DTO chucvu;
	private String strUsername;
	private String strPassword;
	 
	public NhanVien_DTO() {
		this.iMaNhanVien = 0;
	}
	public NhanVien_DTO(String strUsername,String strPassword,String strTenNhanVien,  Date dtNgaySinh, int iCMND,Date dtNgayVaoLam,int iMaChucVu) {
		this.strUsername = strUsername;
		this.strPassword = strPassword;

		this.strTenNhanVien = strTenNhanVien;
		this.dtNgaySinh = dtNgaySinh;
		this.iCMND = iCMND;
		this.dtNgayVaoLam = dtNgayVaoLam;
		this.iMaChucVu = iMaChucVu;
	}
	
	public NhanVien_DTO(int iMaNhanVien, String strTenNhanVien, Date dtNgaySinh, int iCMND,Date dtNgayVaoLam,int iMaChucVu) {
		this.strTenNhanVien = strTenNhanVien;
		this.dtNgaySinh = dtNgaySinh;
		this.iCMND = iCMND;
		this.dtNgayVaoLam = dtNgayVaoLam;
		this.iMaChucVu = iMaChucVu;
		this.iMaNhanVien = iMaNhanVien;
	}
	
	public NhanVien_DTO(int iMaNhanVien, String strTenNhanVien, Date dtNgaySinh, int iCMND,Date dtNgayVaoLam,ChucVu_DTO chucvu) {
		this.strTenNhanVien = strTenNhanVien;
		this.dtNgaySinh = dtNgaySinh;
		this.iCMND = iCMND;
		this.dtNgayVaoLam = dtNgayVaoLam;
		this.chucvu = chucvu;
		this.iMaNhanVien = iMaNhanVien;
	}
	
	public NhanVien_DTO(int iMaNhanVien,String Username, String Password, String strTenNhanVien, Date dtNgaySinh, int iCMND,Date dtNgayVaoLam,ChucVu_DTO chucvu) {
		this.strTenNhanVien = strTenNhanVien;
		this.dtNgaySinh = dtNgaySinh;
		this.iCMND = iCMND;
		this.dtNgayVaoLam = dtNgayVaoLam;
		this.chucvu = chucvu;
		this.iMaNhanVien = iMaNhanVien;
		this.strPassword = Password;
		this.strUsername = Username;
	}
	
	
	public int getMaNhanVien() {
		return iMaNhanVien;
	}
	public void setMaNhanVien(int iMaNhanVien) {
		this.iMaNhanVien = iMaNhanVien;
	}
	
	public String getUsername() {
		return strUsername;
	}
	public void setUsername(String strUsername) {
		this.strUsername = strUsername;
	}
	public String getPassword() {
		return strPassword;
	}
	public void setPassword(String cs) {
		this.strPassword = cs;
	}

	public String getTenNhanVien() {
		return strTenNhanVien;
	}
	public void setTenNhanVien(String strTenNhanVien) {
		this.strTenNhanVien = strTenNhanVien;
	}

	public Date getNgaySinh() {
		return dtNgaySinh;
	}
	public void setNgaySinh(Date dtNgaySinh) {
		this.dtNgaySinh = dtNgaySinh;
	}
	
	public int getCMND() {
		return iCMND;
	}
	public void setCMND(int iCMND) {
		this.iCMND = iCMND;
	}

	public Date getNgayVaoLam() {
		return dtNgayVaoLam;
	}
	public void setNgayVaoLam(Date dtNgayVaoLam) {
		this.dtNgayVaoLam = dtNgayVaoLam;
	}

	public int getMaChucVu() {
		return iMaChucVu;
	}
	public void setMaChucVu(int iMaChucVu) {
		this.iMaChucVu = iMaChucVu;
	}
	
	public ChucVu_DTO getChucVu() {
		return chucvu;
	}
	public void setChucVu(ChucVu_DTO chucvu) {
		this.chucvu = chucvu;
	}
	
	@Override
	public String toString() {
		return this.iMaNhanVien + " - " + this.strTenNhanVien;
	}

}
