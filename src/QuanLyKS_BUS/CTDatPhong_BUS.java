package QuanLyKS_BUS;
import java.text.ParseException;
import java.util.ArrayList;
import java.sql.Date;
import com.ibm.icu.text.SimpleDateFormat;
import com.ibm.icu.util.Calendar;

import QuanLyKS_DAL.LoaiPhong_DAL;
import QuanLyKS_DAL.CTDatPhong_DAL;
import QuanLyKS_DTO.CTDatPhong_DTO;
import QuanLyKS_DAL.Phong_DAL;
public class CTDatPhong_BUS {
	private static CTDatPhong_DAL ctdpDAL;
	
	public static boolean Insert(CTDatPhong_DTO ctdp) {
		//int iThanhTien = tinhThanhTien(ctdp.getNgayNhan(), ctdp.getNgayTra(), ctdp.getMaPhong());
		//ctdp.setThanhTien(iThanhTien);
		return CTDatPhong_DAL.Insert(ctdp);
	}
	
	public static int getMaPhong(String TenPhong) {
		
		return 0; 
	}
//	
//	private static int tinhThanhTien(String strDateFrom, String strDateTo, int iMaPhong) {
//		int iSoNgay = 0;
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		Date dtNgayNhan = null, dtNgayTra = null;
//		
//		//dem so ngay dat phong
//		try {
//			dtNgayNhan = sdf.parse(strDateFrom);
//			Calendar calNgayNhan = Calendar.getInstance();
//			calNgayNhan.setTime(dtNgayNhan);
//			dtNgayTra = sdf.parse(strDateTo);
//			Calendar calNgayTra = Calendar.getInstance();
//			calNgayTra.setTime(dtNgayTra);
//			
//			while(calNgayNhan.compareTo(calNgayTra) < 0) {
//				iSoNgay++;
//				calNgayTra.add(Calendar.DATE, -1);
//			}
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		int iGiaPhong = Phong_DAL.getGiaPhong(iMaPhong);		
//		return iSoNgay * iGiaPhong;
//	}

	public static int getnextID() {
		return CTDatPhong_DAL.buildMaCTDatPhong();
	}
	
	public static ArrayList<CTDatPhong_DTO> searchKH(int maPhong, Date ng) {
		return CTDatPhong_DAL.searchKH(maPhong, ng);
	}

}




