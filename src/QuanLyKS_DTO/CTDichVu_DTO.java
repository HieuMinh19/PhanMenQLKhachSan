package QuanLyKS_DTO;

public class CTDichVu_DTO {
	private int iMaCTDichVu;
	private int iMaDichVu;
	private int iSoLuong;
	private int iMaDatPhong;
	
	public CTDichVu_DTO( int iSoLuong, int iMaDichVu, int iMaDatPhong) {
		this.iSoLuong = iSoLuong;
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
