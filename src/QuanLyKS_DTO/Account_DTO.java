package QuanLyKS_DTO;

public class Account_DTO {
	private int iID;
	private String strUsername;
	private char[] strPassword;
	private int iRole;
	
	public Account_DTO() {
	}
	
	public Account_DTO(String Username, char[] Password, int ID) {
		this.iID = ID;
		this.strPassword = Password;
		this.strUsername = Username;
		this.iRole = 2;
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
	
}
