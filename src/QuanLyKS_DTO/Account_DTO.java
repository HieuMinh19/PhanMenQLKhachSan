package QuanLyKS_DTO;

public class Account_DTO {
	private int iID;
	private String strUsername;
	private String strPassword;
	
	public Account_DTO() {
	}
	
	public Account_DTO(String Username, String Password, int ID) {
		this.iID = ID;
		this.strPassword = Password;
		this.strUsername = Username;
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
	public String getPassword() {
		return strPassword;
	}
	public void setPassword(String strPassword) {
		this.strPassword = strPassword;
	}
	
	
}
