package QuanLyKS_DTO;

public class CTHoaDon_DTO {
	private int iMaCTHoaDon;
	private int iMaHoaDon;
	private int iMaDichVu;
	
	public CTHoaDon_DTO() {
		iMaCTHoaDon = 1;
		iMaHoaDon = 1;
		iMaDichVu = 1;
	}

	public int getMaCTHoaDon() {
		return iMaCTHoaDon;
	}

	public void setMaCTHoaDon(int iMaCTHoaDon) {
		this.iMaCTHoaDon = iMaCTHoaDon;
	}

	public int getMaHoaDon() {
		return iMaHoaDon;
	}

	public void setMaHoaDon(int iMaHoaDon) {
		this.iMaHoaDon = iMaHoaDon;
	}

	public int getMaDichVu() {
		return iMaDichVu;
	}

	public void setMaDichVu(int iMaDichVu) {
		this.iMaDichVu = iMaDichVu;
	}

}
