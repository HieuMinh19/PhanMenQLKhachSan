package QuanLyKS_DTO;

public class Phong_DTO {
    private int iMaPhong;
	private int iMaLoaiPhong;
    private int iMaTrangThai;

    public Phong_DTO() {
		//
    }
    public Phong_DTO(int iMaPhong, int iMaLoaiPhong, int iMaTrangThai) {
		this.iMaPhong = iMaPhong;
		this.iMaLoaiPhong = iMaLoaiPhong;
		this.iMaTrangThai = iMaTrangThai;
		
    }

    public int getMaPhong() {
		return iMaPhong;
	}
	public void setMaDichVu(int iMaPhong) {
		this.iMaPhong = iMaPhong;
    }
    
	public int getMaLoaiPhong() {
		return iMaLoaiPhong;
	}
	public void setMaLoaiPhong(int iMaLoaiPhong) {
		this.iMaLoaiPhong = iMaLoaiPhong;
    }
    
	public int getMaTrangThai() {
		return iMaTrangThai;
	}
	public void setMaTrangThai(int iMaTrangThai) {
		this.iMaTrangThai = iMaTrangThai;
	}
}



