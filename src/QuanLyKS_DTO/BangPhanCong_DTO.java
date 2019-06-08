package QuanLyKS_DTO;
import java.sql.Date;
public class BangPhanCong_DTO {
	private int iMaPhanCong;
	private Date dtNgayPhanCong;
	private String strLoaiCongViec;
	private int iMaNhanVien;
	private NhanVien_DTO nhanvien;

	public BangPhanCong_DTO() {
		// TODO Auto-generated constructor stub
	}
	public NhanVien_DTO getNhanVien() {
		return nhanvien;
	}
	public void setNhanVien(NhanVien_DTO nhanvien) {
		this.nhanvien = nhanvien;
	}
	public BangPhanCong_DTO(int iMaPhanCong,String strLoaiCongViec, Date strNgayPhanCong,  int iMaNhanVien) {
		this.iMaPhanCong = iMaPhanCong;
		this.strLoaiCongViec = strLoaiCongViec;
		this.dtNgayPhanCong = strNgayPhanCong;
		this.iMaNhanVien = iMaNhanVien;
	}
	public BangPhanCong_DTO(Date strNgayPhanCong, String strLoaiCongViec, int iMaNhanVien) {

		this.dtNgayPhanCong = strNgayPhanCong;
		this.strLoaiCongViec = strLoaiCongViec;
		this.iMaNhanVien = iMaNhanVien;
	}
	public int getMaPhanCong() {
		return iMaPhanCong;
	}

	public void setMaPhanCong(int iMaPhanCong) {
		this.iMaPhanCong = iMaPhanCong;
	}

	public Date getNgayPhanCong() {
		return dtNgayPhanCong;
	}

	public void setNgayPhanCong(Date dtNgayPhanCong) {
		this.dtNgayPhanCong = dtNgayPhanCong;
	}

	public String getLoaiCongViec() {
		return strLoaiCongViec;
	}

	public void setLoaiCongViec(String strLoaiCongViec) {
		this.strLoaiCongViec = strLoaiCongViec;
	}

	public int getMaNhanVien() {
		return iMaNhanVien;
	}

	public void setMaNhanVien(int iMaNhanVien) {
		this.iMaNhanVien = iMaNhanVien;
	}
}

