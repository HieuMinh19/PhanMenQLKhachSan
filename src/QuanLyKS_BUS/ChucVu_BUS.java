package QuanLyKS_BUS;
import QuanLyKS_DAL.ChucVu_DAL;
import java.sql.ResultSet;
public class ChucVu_BUS {
	private static ChucVu_DAL ChucVuDAL;
	public ChucVu_BUS(){
		ChucVuDAL = new ChucVu_DAL();
	}
	public ResultSet selectAll() {
		return ChucVuDAL.getListChucVu();
	}
}
