package QuanLyKS_DTO;

public class HoaDon_DTO {
	private int iMaHoaDon;
	private String strNgayThuTien;
	private int iSoTienThu;
	private int iMaNhanVien;

	public HoaDon_DTO() {
		// TODO Auto-generated constructor stub
	}

	public HoaDon_DTO(int iMaHoaDon, String strNgayThuTien, int iSoTienThu, int iMaNhanVien) {
		this.iMaHoaDon = iMaHoaDon;
		this.strNgayThuTien = strNgayThuTien;
		this.iSoTienThu = iSoTienThu;
		this.iMaNhanVien = iMaNhanVien;
	}


	public int getMaHoaDon() {
		return iMaHoaDon;
	}
	public void setMaHoaDon(int iMaHoaDon) {
		this.iMaHoaDon = iMaHoaDon;
	}
	public String getNgayThuTien() {
		return strNgayThuTien;
	}

	public void setNgayThuTien(String strNgayThuTien) {
		this.strNgayThuTien = strNgayThuTien;
	}



	public int getSoTienThu() {
		return iSoTienThu;
	}

	public void setSoTienThu(int iSoTienThu) {
		this.iSoTienThu = iSoTienThu;
	}

	public int getMaNhanVien() {
		return iMaNhanVien;
	}

	public void setMaNhanVien(int iMaNhanVien) {
		this.iMaNhanVien = iMaNhanVien;
	}
}
