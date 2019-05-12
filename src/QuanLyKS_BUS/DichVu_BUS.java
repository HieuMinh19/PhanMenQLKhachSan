package QuanLyKS_BUS;
import java.sql.ResultSet;
import QuanLyKS_DAL.DichVu_DAL;
public class DichVu_BUS {
	private static DichVu_DAL DichVuDAL;
	public DichVu_BUS(){
		DichVuDAL = new DichVu_DAL();
	}
	
	public ResultSet selectAll() {
		return DichVuDAL.getListDV();
	}
	
}
