package QuanLyKS_DTO;
import java.sql.Date;
public class HoaDon_DTO {
	private int iMaHoaDon;
	private Date dtNgayThuTien;
	private int iSoTienThu;
	private int iMaCTDatPhong;
	private int iMaNhanVien;

	public HoaDon_DTO() {
		// TODO Auto-generated constructor stub
	}

	public HoaDon_DTO(int iMaHoaDon, Date dtNgayThuTien, int iSoTienThu, int iMaNhanVien) {
		this.iMaHoaDon = iMaHoaDon;
		this.dtNgayThuTien = dtNgayThuTien;
		this.iSoTienThu = iSoTienThu;
		this.iMaNhanVien = iMaNhanVien;
	}


	public int getMaHoaDon() {
		return iMaHoaDon;
	}
	public void setMaHoaDon(int iMaHoaDon) {
		this.iMaHoaDon = iMaHoaDon;
	}
	public Date getNgayThuTien() {
		return dtNgayThuTien;
	}

	public void setNgayThuTien(Date dtNgayThuTien) {
		this.dtNgayThuTien = dtNgayThuTien;
	}

	public int getSoTienThu() {
		return iSoTienThu;
	}

	public void setSoTienThu(int iSoTienThu) {
		this.iSoTienThu = iSoTienThu;
	}

	public int getMaCTDatPhong() {
		return iMaCTDatPhong;
	}

	public void setMaCTDatPhong(int iMaCTDatPhong) {
		this.iMaCTDatPhong = iMaCTDatPhong;
	}
	
	public int getMaNhanVien() {
		return iMaNhanVien;
	}

	public void setMaNhanVien(int iMaNhanVien) {
		this.iMaNhanVien = iMaNhanVien;
	}
}
