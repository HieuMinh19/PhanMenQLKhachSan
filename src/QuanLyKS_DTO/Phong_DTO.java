package QuanLyKS_DTO;

public class Phong_DTO {
    private int iMaPhong;
	private int iMaLoaiPhong;
    private int iMaTrangThai;

    public DichVu_DTO() {
		//
    }
    public DichVu_DTO(int iMaPhong, int iMaLoaiPhong, int iMaTrangThai) {
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
	public void setMaTrangThai(String iMaTrangThai) {
		this.iMaTrangThai = iMaTrangThai;
	}
}



