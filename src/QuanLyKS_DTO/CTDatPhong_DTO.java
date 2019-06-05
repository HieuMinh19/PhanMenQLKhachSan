package QuanLyKS_DTO;

import java.sql.Date;

public class CTDatPhong_DTO {
	private int iMaDatPhong;
	private Date dtCreatedAt;
	private int iMaKH;
    private int iMaNhanVien;
    private int iMaPhong;
	private Date dtNgayNhan;
	private Date dtNgayTra;
	
	
	public CTDatPhong_DTO() {
		
	}
	
	public CTDatPhong_DTO( String strTenKH, String strCMND, int iMaDichVu, int iMaPhong, String NgayNhan, String NgayTra, int iThanhTien ) {
		;
        this.iMaPhong = iMaPhong;
      
	}
	
	public CTDatPhong_DTO( String strTenKH, String strCMND, int iMaDichVu, int iMaPhong, String NgayNhan, String NgayTra) {
		
        this.iMaPhong = iMaPhong;
       
	}
	
	public int getMaDatPhong() {
		return iMaDatPhong;
	}
	public void setMaDatPhong(int iMaDatPhong) {
		this.iMaDatPhong = iMaDatPhong;
    }
    
    public int getMaPhong() {
		return iMaPhong;
	}
	public void setMaPhong(int iMaPhong) {
		this.iMaPhong = iMaPhong;
    }

	public Date getCreatedAt() {
		return dtCreatedAt;
	}

	public void setCreatedAt(Date dtCreatedAt) {
		this.dtCreatedAt = dtCreatedAt;
	}

	public int getMaKH() {
		return iMaKH;
	}

	public void setMaKH(int iMaKH) {
		this.iMaKH = iMaKH;
	}

	public int getMaNhanVien() {
		return iMaNhanVien;
	}

	public void setMaNhanVien(int iMaNhanVien) {
		this.iMaNhanVien = iMaNhanVien;
	}

	public void setNgayNhan(Date dtNgayNhan) {
		this.dtNgayNhan = dtNgayNhan;
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

}
