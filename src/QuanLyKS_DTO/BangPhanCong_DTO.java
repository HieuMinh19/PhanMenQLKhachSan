package QuanLyKS_DTO;
import java.sql.Date;
public class BangPhanCong_DTO {
	private int iMaPhanCong;
	private Date dtNgayPhanCong;
	private String strLoaiCongViec;
	private int iMaNhanVien;

	public BangPhanCong_DTO() {
		// TODO Auto-generated constructor stub
	}

	public BangPhanCong_DTO(int iMaPhanCong, Date strNgayPhanCong, String strLoaiCongViec, int iMaNhanVien) {
		this.iMaPhanCong = iMaPhanCong;
		this.dtNgayPhanCong = dtNgayPhanCong;
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

