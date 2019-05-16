package QuanLyKS_DTO;

public class CTDatPhong_DTO {
	private int iMaDatPhong;
	private String strTenKH;
	private String strCMND;
    private int iMaDichVu;
    private int iMaPhong;
	private String strNgayNhan;
	private String strNgayTra;
	public CTDatPhong_DTO() {
	
	}

	public CTDatPhong_DTO( String strTenKH, String strCMND, int iMaDichVu, int iMaPhong, String NgayNhan, String NgayTra ) {
		this.strTenKH = strTenKH;
		this.strCMND = strCMND;
        this.iMaDichVu = iMaDichVu;
        this.iMaPhong = iMaPhong;
        this.strNgayNhan = NgayNhan;
        this.strNgayTra = NgayTra;
	}
	
	
	public int getMaDatPhong() {
		return iMaDatPhong;
	}
	public void setMaDatPhong(int iMaDatPhong) {
		this.iMaDatPhong = iMaDatPhong;
    }
    
	public String getTenHK() {
		return strTenKH;
	}
	public void setTenHK(String strTenKH) {
		this.strTenKH = strTenKH;
    }
    
    public String getCMND() {
		return strCMND;
	}
	public void setCMND(String strCMNN) {
		this.strCMND = strCMNN;
    }

    public int getMaDichVu() {
		return iMaDichVu;
	}
	public void setMaDichVu(int iMaDichVu) {
		this.iMaDichVu = iMaDichVu;
    }

    public int getMaPhong() {
		return iMaPhong;
	}
	public void setMaPhong(int iMaPhong) {
		this.iMaPhong = iMaPhong;
    }

	public String getNgayNhan() {
		return strNgayNhan;
	}

	public void setNgayNhan(String strNgayNhan) {
		this.strNgayNhan = strNgayNhan;
	}

	public String getNgayTra() {
		return strNgayTra;
	}

	public void setNgayTra(String strNgayTra) {
		this.strNgayTra = strNgayTra;
	}

}
