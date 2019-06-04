package QuanLyKS_DTO;

public class ChucVu_DTO {
	private int iMaChucVu;
	private String strTenChucVu;
	
	public ChucVu_DTO() {
	}
	public ChucVu_DTO(int iMaChucVu,String strTenChucVu) {
		this.strTenChucVu = strTenChucVu;
		this.iMaChucVu = iMaChucVu;
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

	@Override
	public String toString() {
		return this.strTenChucVu;
	}

}
