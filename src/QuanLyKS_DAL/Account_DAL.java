package QuanLyKS_DAL;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Connection;
import java.sql.PreparedStatement;

import QuanLyKS_DTO.Account_DTO;
import Utility.Result;
public class Account_DAL {
	public Result Insert(Account_DTO account)  {
		PreparedStatement ptmt = null; 
		String query = "INSERT INTO ACCOUNT(Username, Password, Role) VALUES (?, ?, ?)";
		MyConnection mycon = new QuanLyKS_DAL.MyConnection();
		
		Connection conn = mycon.getConnection();
		String uname = account.getUsername();
		String pass = account.getPassword();
		int role = account.getRole();
		try {
			ptmt = conn.prepareStatement(query);
			
			ptmt.setString(1, uname);
			ptmt.setString(2, pass);
			ptmt.setInt(3, role);
			
			ptmt.executeUpdate();
			if( ptmt.executeUpdate() != 0) {
				System.err.println("insert thanh cong account");
				return new Result(true);
			}
				
			else {
				System.err.println("khoi tao account that bai");
				return new Result(false);
			}
				

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.err.println(" ket noi that bai");
		}
		return null;
	}
}