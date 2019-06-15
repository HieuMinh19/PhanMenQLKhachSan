package QuanLyKS_DTO;
import java.util.Date;

public class CTDatPhong_DTO {
	private int iMaCTDatPhong;
	private Date dtNgayThucHien;
	private int iMaKhachHang;
	private Date dtNgayNhan;
	private Date dtNgayTra;
	private int iMaPhong;
	private int iMaNhanVien;
	private int iThanhTien;
	private KhachHang_DTO kh;
	private LoaiPhong_DTO lp;
	
	
	public CTDatPhong_DTO() {
		
	}
	
	public CTDatPhong_DTO( String strTenKH, String strCMND, int iMaDichVu, int iMaPhong, String NgayNhan, String NgayTra, int iThanhTien ) {
        this.iMaPhong = iMaPhong;
      
	} 
	
	public CTDatPhong_DTO( String strTenKH, String strCMND, int iMaDichVu, int iMaPhong, String NgayNhan, String NgayTra) {
		
        this.iMaPhong = iMaPhong;
       
	}
	
	public CTDatPhong_DTO(KhachHang_DTO kh, int iMaPhong, Date NgayNhan, Date NgayTra) {
        this.kh = kh;
        this.iMaPhong = iMaPhong;
        this.dtNgayNhan = NgayNhan;
        this.dtNgayTra = NgayTra;
	}
	
	public int getMaCTDatPhong() {
		return iMaCTDatPhong;
	}
	public void setMaCTDatPhong(int iMaCTDatPhong) {
		this.iMaCTDatPhong = iMaCTDatPhong;
    }
    
    public int getMaPhong() {
		return iMaPhong;
	}
	public void setMaPhong(int iMaPhong) {
		this.iMaPhong = iMaPhong;
    }

	public Date getdtNgayThucHien() {
		return dtNgayThucHien;
	}

	public void setdtNgayThucHien(Date dtNgayThucHien) {
		this.dtNgayThucHien = dtNgayThucHien;
	}

	public int getMaKhachHang() {
		return iMaKhachHang;
	}

	public void setMaKhachHang(int iMaKhachHang) {
		this.iMaKhachHang = iMaKhachHang;
	}

	public int getMaNhanVien() {
		return iMaNhanVien;
	}

	public void setMaNhanVien(int iMaNhanVien) {
		this.iMaNhanVien = iMaNhanVien;
	}

	public void setNgayNhan(Date date) {
		this.dtNgayNhan = date;
	}

	public Date getNgayNhan() {
		return dtNgayNhan;
	}

	public Date getNgayTra() { 
		return dtNgayTra;
	}

	public void setNgayTra(Date dtNgayTra) {
		this.dtNgayTra = dtNgayTra; 
	}

	public KhachHang_DTO getKhachHang() {
		return kh;
	}

	public void setKhachHang(KhachHang_DTO kh) {
		this.kh = kh; 
	}

	public LoaiPhong_DTO getLoaiPhong() {
		return lp;
	}

	public void setLoaiPhong(LoaiPhong_DTO lp) {
		this.lp = lp; 
	}
}
