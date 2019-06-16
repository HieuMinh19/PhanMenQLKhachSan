package QuanLyKS_DTO;

public class Phong_DTO {
    private int iMaPhong;
	private int iMaLoaiPhong;
	private String loaiphong;
    public Phong_DTO() {
		//
    }
    public Phong_DTO(int iMaPhong, int iMaLoaiPhong) {
		this.iMaPhong = iMaPhong;
		this.iMaLoaiPhong = iMaLoaiPhong;
		
    }
    
    public Phong_DTO(int iMaPhong, String loaiphong) {
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
	
	public String getLoaiPhong() {
		return loaiphong;
	}
	public void setLoaiPhong(LoaiPhong_DTO loaiphong) {
		this.loaiphong = loaiphong.getTenLoaiPhong();
    }
	
}



