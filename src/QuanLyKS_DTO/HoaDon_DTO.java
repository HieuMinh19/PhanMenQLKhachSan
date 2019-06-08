package QuanLyKS_DTO;
import java.sql.Date;
public class HoaDon_DTO {
	private int iMaHoaDon;
	private Date dtNgayThuTien;
	private int iSoTienThu;
	private int iMaCTDatPhong;
	private int iMaNhanVien;
	//
	private String strHoTen;
	private String strTenLoaiPhong;
	private int iGiaPhong;
	private Date dtNgayNhan;
	private Date dtNgayTra;
	//
	private int iSoLuong;
	private String strTenDichVu;
	private int iTongTienDichVu;
	
	public HoaDon_DTO() {
		// TODO Auto-generated constructor stub
	}
////
	public String getTenDichVu() {
		return strTenDichVu;
	}
	public void setTenDichVu(String strTenDichVu) {
		this.strTenDichVu = strTenDichVu;
	}
	public int getSoLuong() {
		return iSoLuong;
	}
	public void setSoLuong(int iSoLuong) {
		this.iSoLuong = iSoLuong;
	}
	public int getTongTienDichVu() {
		return iTongTienDichVu;
	}
	public void setTongTienDichVu(int iTongTienDichVu) {
		this.iTongTienDichVu = iTongTienDichVu;
	}
	//
	public String getHoTen() {
		return strHoTen;
	}
	public void setHoTen(String strHoTen) {
		this.strHoTen = strHoTen;
	}
	public String getTenLoaiPhong() {
		return strTenLoaiPhong;
	}
	public void setTenLoaiPhong(String strTenLoaiPhong) {
		this.strTenLoaiPhong = strTenLoaiPhong;
	}
	public int getGiaPhong() {
		return iGiaPhong;
	}
	public void setGiaPhong(int iGiaPhong) {
		this.iGiaPhong = iGiaPhong;
	}
	public Date getNgayNhan() {
		return dtNgayNhan;
	}
	public void setNgayNhan(Date dtNgayNhan) {
		this.dtNgayNhan = dtNgayNhan;
	}
	public Date getNgayTra() {
		return dtNgayTra;
	}
	public void setNgayTra(Date dtNgayTra) {
		this.dtNgayTra = dtNgayTra;
	}
	//
	//int iMaHoaDon, Date dtNgayThuTien, 
	public HoaDon_DTO(Date dtNgayThuTien,int iSoTienThu, int iMaCTDatPhong,int iMaNhanVien ) {
		//this.iMaHoaDon = iMaHoaDon;
		this.dtNgayThuTien = dtNgayThuTien;
		this.iSoTienThu = iSoTienThu;
		this.iMaCTDatPhong = iMaCTDatPhong;
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
