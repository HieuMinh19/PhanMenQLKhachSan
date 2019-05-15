package QuanLyKS_DAL;

import java.sql.ResultSet;
import java.text.ParseException;
import java.util.Date;

import com.ibm.icu.text.SimpleDateFormat;

public class Phong_DAL {
	public static ResultSet selectCondition(int MaLoaiPhong, String NgayNhan, String NgayTra) {
		 String sDate1="1999-10-18";  
		    Date date1;
			try {
				date1 = new SimpleDateFormat("yyyy-MM-dd").parse(sDate1);
				 System.out.println(sDate1+"\t"+date1);  
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
		return null;
	}

}
