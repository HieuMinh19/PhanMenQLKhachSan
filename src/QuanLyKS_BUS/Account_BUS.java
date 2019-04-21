package QuanLyKS_BUS;
import QuanLyKS_DTO.Account_DTO;
import Utility.Result;
import QuanLyKS_DAL.Account_DAL;
public class Account_BUS {
	private static Account_DAL accountDAL;
	Account_BUS(){
		accountDAL = new Account_DAL();
	}
	
	public static Result Insert(Account_DTO account) {
		
		return Account_DAL.Insert(account);
	}
}
