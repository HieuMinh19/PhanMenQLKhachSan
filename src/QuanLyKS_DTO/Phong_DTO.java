package QuanLyKS_DTO;

public class Phong_DTO {
    private int iMaPhong;
	private int iMaLoaiPhong;
    public Phong_DTO() {
		//
    }
    public Phong_DTO(int iMaPhong, int iMaLoaiPhong) {
		this.iMaPhong = iMaPhong;
		this.iMaLoaiPhong = iMaLoaiPhong;
		
    }

    public int getMaPhong() {
		return iMaPhong;
	}
	public void setMaPhong(int iMaPhong) {
		this.iMaPhong = iMaPhong;
    }
    
	public int getMaLoaiPhong() {
		return iMaLoaiPhong;
	}
	public void setMaLoaiPhong(int iMaLoaiPhong) {
		this.iMaLoaiPhong = iMaLoaiPhong;
    }
}



