package QuanLyKS_DTO;

public class LoaiPhong_DTO {

    private int iMaLoaiPhong;
	private String strTenLoaiPhong;
    private int iGiaPhong;
    
    public LoaiPhong_DTO() {
		
	}

	public LoaiPhong_DTO( int iMaLoaiPhong, String strTenLoaiPhong, int iGiaPhong) {
		
		this.iMaLoaiPhong = iMaLoaiPhong;
		this.strTenLoaiPhong = strTenLoaiPhong;
		this.iGiaPhong = iGiaPhong;
    }
    
	public LoaiPhong_DTO( int iMaLoaiPhong, String strTenLoaiPhong) {
		this.iMaLoaiPhong = iMaLoaiPhong;
		this.strTenLoaiPhong = strTenLoaiPhong;
    }
    
	
	public int getMaLoaiPhong() {
		return iMaLoaiPhong;
	}
	public void setMaLoaiPhong(int iMaLoaiPhong) {
		this.iMaLoaiPhong = iMaLoaiPhong;
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
}

