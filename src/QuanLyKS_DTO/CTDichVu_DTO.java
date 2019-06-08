package QuanLyKS_DTO;

public class CTDichVu_DTO {
	private int iMaCTDichVu;
	private int iMaDichVu;
	private int iSoLuong;
	private int iMaCTDatPhong;
	private int iTongTienDichVu; 
	
	public CTDichVu_DTO( int iSoLuong, int iMaCTDatPhong, int iTongTienDichVu, int iMaDichVu) {
		this.iSoLuong = iSoLuong;
		this.iMaCTDatPhong = iMaCTDatPhong;
		this.iTongTienDichVu = iTongTienDichVu;
		this.iMaDichVu = iMaDichVu;
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

	public int getMaCTDatPhong() {
		return iMaCTDatPhong;
	}

	public void setMaCTDatPhong(int iMaCTDatPhong) {
		this.iMaCTDatPhong = iMaCTDatPhong;
	}
	
	
	public int getTongTienDichVu() {
		return iTongTienDichVu;
	}

	public void setTongTienDichVu(int iTongTienDichVu) {
		this.iTongTienDichVu = iTongTienDichVu;
	}

}
