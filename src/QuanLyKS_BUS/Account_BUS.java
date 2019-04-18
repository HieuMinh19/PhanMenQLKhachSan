package QuanLyKS_BUS;
import QuanLyKS_DTO.Account_DTO;
import Utility.Result;
import QuanLyKS_DAL.Account_DAL;
public class Account_BUS {
	private Account_DAL accountDAL;
	Account_BUS(){
		accountDAL = new Account_DAL();
	}
	
	public Result Insert(Account_DTO account) {
		
		return accountDAL.Insert(account);
	}
}
