package QuanLyKS_DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MyConnection {
	static Connection conn = null;
	String connectionUrl = "jdbc:sqlserver://localhost:1433;" +
			"databaseName=QUANLYKHACHSAN;integratedSecurity=true;";
	public Connection getConnection() {
		try {
    		// Establish the connection.
    		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        	conn = DriverManager.getConnection(connectionUrl);        	
        	System.err.println("Ket noi thanh cong.");
    	}
		// Handle any errors that may have occurred.
		catch (Exception e) {
			e.printStackTrace();
			 System.err.println(e.getMessage() + "Ket noi that bai.");
		}
		return conn;
	 }
	
	 public void close(){// dong ket noi co so du lieu 
	       try { 
	           if(conn!=null) 
	               conn.close(); 
	       } catch (SQLException ex) { 
	           System.err.println("exception: " + ex);
	       } 
	   } 
}
