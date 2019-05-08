package QuanLyKS_BUS;
import QuanLyKS_DTO.Account_DTO;
import QuanLyKS_DAL.Account_DAL;
public class Account_BUS {
	private static Account_DAL accountDAL;
	public Account_BUS(){
		accountDAL = new Account_DAL();
	}
	
	public static boolean Insert(Account_DTO account) {
		return Account_DAL.Insert(account);
	}
}
