package QuanLyKS_DTO;

public class CTDichVu_DTO {
	private int iMaCTDichVu;
	private String strTenCTDichVu;
	private int iGia;
	private int iSoLuong;
	
	public CTDichVu_DTO() {
		iMaCTDichVu = 1;
		strTenCTDichVu = null;
		iGia = 0;
		iSoLuong = 0;
		
	}

	public int getMaCTDichVu() {
		return iMaCTDichVu;
	}

	public void setMaCTDichVu(int iMaCTDichVu) {
		this.iMaCTDichVu = iMaCTDichVu;
	}

	public String getTenCTDichVu() {
		return strTenCTDichVu;
	}

	public void setTenCTDichVu(String strTenCTDichVu) {
		this.strTenCTDichVu = strTenCTDichVu;
	}

	public int getGia() {
		return iGia;
	}

	public void setGia(int iGia) {
		this.iGia = iGia;
	}

	public int getSoLuong() {
		return iSoLuong;
	}

	public void setSoLuong(int iSoLuong) {
		this.iSoLuong = iSoLuong;
	}

}
