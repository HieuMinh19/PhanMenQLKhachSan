package QuanLyKS_DAL;
import java.sql.SQLException;

import org.eclipse.swt.widgets.DateTime;

import com.toedter.calendar.JCalendar;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

import QuanLyKS_DTO.Account_DTO;

public class Account_DAL {
	public static boolean Insert(Account_DTO account)  {
		PreparedStatement ptmt = null; 
		String query = "INSERT INTO ACCOUNT(Username, Password, Role, NgayLap) VALUES (?, ?, ?, ?)";
		MyConnection mycon = new QuanLyKS_DAL.MyConnection();
		Connection conn = mycon.getConnection();
		String uname = account.getUsername();
		char[] pass = account.getPassword();
		String dtNgayLap = account.getNgayLap();
		//ep kieu tu string sang char
		String strPass = new String(pass);
		int role = account.getRole();
		try {
			ptmt = conn.prepareStatement(query);
			ptmt.setString(1, uname);
			ptmt.setString(2, strPass);
			ptmt.setInt(3, role);
			
			ptmt.setString(4, dtNgayLap);
			if( ptmt.executeUpdate() != 0) {
				System.err.println("insert thanh cong account");
				return true;
			}
				
			else {
				System.err.println("khoi tao account that bai");
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println(" ket noi that bai");
			 return false;
		}
	}
}