package QuanLyKS_DTO;

public class CTDATPHONG_DTO {
	private int iMaDatPhong;
	private String strTenKH;
	private String strCMNN;
    private int iMaDichVu;
    private int iMaPhong;
	
	public CTDATPHONG_DTO() {
	
	}

	public CTDATPHONG_DTO(int iMaDatPhong, String strTenKH, String strCMNN, int iMaDichVu, int iMaPhong ) {
		this.iMaDatPhong = iMaDatPhong;
		this.strTenKH = strTenKH;
		this.strCMNN = strCMNN;
        this.iMaDichVu = iMaDichVu;
        this.iMaPhong = iMaPhong;
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
		return strCMNN;
	}
	public void setCMND(String strCMNN) {
		this.strCMNN = strCMNN;
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

}
