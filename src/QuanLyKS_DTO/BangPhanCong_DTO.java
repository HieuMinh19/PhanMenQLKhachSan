package QuanLyKS_DTO;

public class BangPhanCong_DTO {
	private int iMaPhanCong;
	private String strNgayPhanCong;
	private String strLoaiCongViec;
	private int iMaNhanVien;

	public BangPhanCong_DTO() {
		// TODO Auto-generated constructor stub
	}

	public BangPhanCong_DTO(int iMaPhanCong, String strNgayPhanCong, String strLoaiCongViec, int iMaNhanVien) {
		this.iMaPhanCong = iMaPhanCong;
		this.strNgayPhanCong = strNgayPhanCong;
		this.strLoaiCongViec = strLoaiCongViec;
		this.iMaNhanVien = iMaNhanVien;
	}

	public int getMaPhanCong() {
		return iMaPhanCong;
	}

	public void setMaPhanCong(int iMaPhanCong) {
		this.iMaPhanCong = iMaPhanCong;
	}

	public String getNgayPhanCong() {
		return strNgayPhanCong;
	}

	public void setNgayPhanCong(String strNgayPhanCong) {
		this.strNgayPhanCong = strNgayPhanCong;
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

