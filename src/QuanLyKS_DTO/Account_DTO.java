package QuanLyKS_DTO;

import java.util.Date;

public class Account_DTO {
	private int iID;
	private String strUsername;
	private char[] strPassword;
	private int iRole;
	private String dtNgayLap;
	
	public Account_DTO() {
	}
	
	public Account_DTO(String NgayLap ,String Username, char[] Password, int ID) {
		this.iID = ID;
		this.strPassword = Password;
		this.strUsername = Username;
		this.iRole = 2;
		this.dtNgayLap = NgayLap;
	}
	
	public int getID() {
		return iID;
	}
	public String getUsername() {
		return strUsername;
	}
	public void setUsername(String strUsername) {
		this.strUsername = strUsername;
	}
	public char[] getPassword() {
		return strPassword;
	}
	public void setPassword(char[] cs) {
		this.strPassword = cs;
	}

	public int getRole() {
		return iRole;
	}

	public void setRole(int iRole) {
		this.iRole = iRole;
	}

	public String getNgayLap() {
		return dtNgayLap;
		
	}

	public void setNgayLap(String date) {
		this.dtNgayLap = date;
	}

	
	
}
