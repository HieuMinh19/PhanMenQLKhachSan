package QuanLyKS_DTO;

public class Phong_DTO {
    private int iMaPhong;
	private int iMaLoaiPhong;
	private LoaiPhong_DTO loaiphong;
    public Phong_DTO() {
		//
    }
    public Phong_DTO(int iMaPhong, int iMaLoaiPhong) {
		this.iMaPhong = iMaPhong;
		this.iMaLoaiPhong = iMaLoaiPhong;
		
    }
    
    public Phong_DTO(int iMaPhong, LoaiPhong_DTO loaiphong) {
  		this.iMaPhong = iMaPhong;
  		this.loaiphong = loaiphong;
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
	
	public LoaiPhong_DTO getLoaiPhong() {
		return loaiphong;
	}
	public void setLoaiPhong(LoaiPhong_DTO loaiphong) {
		this.loaiphong = loaiphong;
    }
	
}



