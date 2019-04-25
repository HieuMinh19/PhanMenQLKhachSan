package QuanLyKS_DAL;
import java.sql.SQLException;

import java.sql.Connection;
import java.sql.PreparedStatement;

import QuanLyKS_DTO.Account_DTO;
import Utility.Result;
public class Account_DAL {
	public static Result Insert(Account_DTO account)  {
		PreparedStatement ptmt = null; 
		String query = "INSERT INTO ACCOUNT(Username, Password, Role) VALUES (?, ?, ?)";
		MyConnection mycon = new QuanLyKS_DAL.MyConnection();
		Connection conn = mycon.getConnection();
		String uname = account.getUsername();
		char[] pass = account.getPassword();
		//ep kieu tu string sang char
		String strPass = new String(pass);
		int role = account.getRole();
		try {
			ptmt = conn.prepareStatement(query);
			
			ptmt.setString(1, uname);
			ptmt.setString(2, strPass);
			ptmt.setInt(3, role);
			if( ptmt.executeUpdate() != 0) {
				System.err.println("insert thanh cong account");
				return new Result(true);
			}
				
			else {
				System.err.println("khoi tao account that bai");
				return new Result(false);
			}
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.err.println(" ket noi that bai");
			 return new  Result("Them hoc sinh khong thanh cong", false, ex.getStackTrace());
		}
	}
}