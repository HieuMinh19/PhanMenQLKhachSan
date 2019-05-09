package QuanLyKS_DTO;

public class ChucVu_DTO {
	private int iMaChucVu;
	private String strTenChucVu;
	
	public ChucVu_DTO() {
		iMaChucVu = 1;
		strTenChucVu = null;
	}


	public int getMaChucVu() {
		return iMaChucVu;
	}




	public void setMaChucVu(int iMaChucVu) {
		this.iMaChucVu = iMaChucVu;
	}




	public String getTenChucVu() {
		return strTenChucVu;
	}




	public void setTenChucVu(String strTenChucVu) {
		this.strTenChucVu = strTenChucVu;
	}

}
