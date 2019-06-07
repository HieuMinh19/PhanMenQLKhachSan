package QuanLyKS_DTO;

public class LoaiPhong_DTO {

    private int iMaLoaiPhong;
	private String strTenLoaiPhong;
    private int iGiaPhong;
    private String strMoTa;
    
    public LoaiPhong_DTO() {
		
	}

	public LoaiPhong_DTO( int iMaLoaiPhong, String strTenLoaiPhong, int iGiaPhong, String strMoTa) {
		this.iMaLoaiPhong = iMaLoaiPhong;
		this.strTenLoaiPhong = strTenLoaiPhong;
		this.iGiaPhong = iGiaPhong;
		this.strMoTa = strMoTa;
    }
    
	public LoaiPhong_DTO( int iMaLoaiPhong, String strTenLoaiPhong) {
		this.iMaLoaiPhong = iMaLoaiPhong;
		this.strTenLoaiPhong = strTenLoaiPhong;
    }
	
	public void setMaLoaiPhong(int iMaLoaiPhong) {
		this.iMaLoaiPhong = iMaLoaiPhong;
    }	
	public int getMaLoaiPhong() {
		return iMaLoaiPhong;
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

	public String getMoTa() {
		return strMoTa;
	}

	public void setMoTa(String strMoTa) {
		this.strMoTa = strMoTa;
	}
}

