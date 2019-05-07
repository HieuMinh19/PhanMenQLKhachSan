package QuanLyKS_DAL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import QuanLyKS_DTO.DichVu_DTO;
public class DichVu_DAL {
	DichVu_DTO DichVu = new DichVu_DTO();
	
	public DichVu_DAL() {
		
	}
	
	public ArrayList<DichVu_DTO> getListDV(){
		//get connection
		PreparedStatement ptmt = null; 
		MyConnection mycon = new QuanLyKS_DAL.MyConnection();
		Connection conn = mycon.getConnection();
		
		ArrayList<DichVu_DTO> list = new ArrayList<>();
		String query = "SELECT * FROM DICHVU";
		try {
			PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
               DichVu_DTO dv = new DichVu_DTO();
               dv.setMaDV( rs.getInt("MaDichVu") );
               dv.setMaCTDichVu( rs.getInt("MaCTDichVu") ); 
               dv.setTenDichVu( rs.getString("TenDichVu") );
               list.add(dv);
            }
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return list;	
	}
}
