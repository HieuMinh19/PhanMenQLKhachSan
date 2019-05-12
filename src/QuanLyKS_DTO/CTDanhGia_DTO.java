package QuanLyKS_DTO;

public class CTDanhGia_DTO {
    private int iID;
    private String strNoiDung;
    private String strNgayDanhGia;

    public DichVu_DTO() {
	
    }

    public DichVu_DTO(int iID,String strNoiDung,String strNgayDanhGia) {
		this.iID  = iID;
		this.strNoiDung = strNoiDung;
		this.strNgayDanhGia = strNgayDanhGia;
    }
    public int getID() {
        return iID;
    }

    public void setID(int iID) {
        this.iID = iID;
    }

    public String getNoiDung() {
        return strNoiDung;
    }

    public void setNoiDung(String strNoiDung) {
        this.strNoiDung = strNoiDung;
    }

    public String getNgayDanhGia() {
        return strNgayDanhGia;
    }

    public void setNgayDanhGia(String strNgayDanhGia) {
        this.strNgayDanhGia = strNgayDanhGia;
    }
}

 