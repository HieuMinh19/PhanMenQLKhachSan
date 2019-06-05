package QuanLyKS_DTO;
import java.sql.Date;
public class DanhGia_DTO {
    private int iID;
    private String strNoiDung;
    private Date dtNgayDanhGia;

    public DanhGia_DTO() {
	
    }

    public DanhGia_DTO(int iID,String strNoiDung,Date dtNgayDanhGia) {
		this.iID  = iID;
		this.strNoiDung = strNoiDung;
		this.dtNgayDanhGia = dtNgayDanhGia;
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

    public Date getNgayDanhGia() {
        return dtNgayDanhGia;
    }

    public void setNgayDanhGia(Date dtNgayDanhGia) {
        this.dtNgayDanhGia = dtNgayDanhGia;
    }

}