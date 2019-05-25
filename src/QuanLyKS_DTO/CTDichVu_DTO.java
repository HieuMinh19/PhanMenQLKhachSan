package QuanLyKS_DTO;

public class CTDichVu_DTO {
	private int iMaCTDichVu;
	private String dtTuNgay;
	private String dtDenNgay;
	private int iMaDichVu;
	private int iSoLuong;
	private int iMaDatPhong;
	
	public CTDichVu_DTO( int iSoLuong, String dtTuNgay, String dtDenNgay, int iMaDichVu, int iMaDatPhong) {
		this.iSoLuong = iSoLuong;
		this.dtTuNgay = dtTuNgay;
		this.dtDenNgay = dtDenNgay;
		this.iMaDichVu = iMaDichVu;
		this.iMaDatPhong = iMaDatPhong;
	}

	public CTDichVu_DTO() {
		iMaCTDichVu = 1;
		iSoLuong = 0;
	}

	public int getMaCTDichVu() {
		return iMaCTDichVu;
	}

	public void setMaCTDichVu(int iMaCTDichVu) {
		this.iMaCTDichVu = iMaCTDichVu;
	}

	public int getSoLuong() {
		return iSoLuong;
	}

	public void setSoLuong(int iSoLuong) {
		this.iSoLuong = iSoLuong;
	}

	public String getTuNgay() {
		return dtTuNgay;
	}

	public void setTuNgay(String dtTuNgay) {
		this.dtTuNgay = dtTuNgay;
	}

	public String getDenNgay() {
		return dtDenNgay;
	}

	public void setDenNgay(String dtDenNgay) {
		this.dtDenNgay = dtDenNgay;
	}

	public int getMaDichVu() {
		return iMaDichVu;
	}

	public void setMaDichVu(int iMaDichVu) {
		this.iMaDichVu = iMaDichVu;
	}

	public int getMaDatPhong() {
		return iMaDatPhong;
	}

	public void setMaDatPhong(int iMaDatPhong) {
		this.iMaDatPhong = iMaDatPhong;
	}

}
