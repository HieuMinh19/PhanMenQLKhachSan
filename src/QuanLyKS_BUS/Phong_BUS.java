package QuanLyKS_BUS;

import java.sql.Date;
import java.util.ArrayList;

import QuanLyKS_DAL.Phong_DAL;
import QuanLyKS_DTO.Phong_DTO;

public class Phong_BUS {
	private Phong_DAL dal = new Phong_DAL();
	
	public ArrayList<Phong_DTO> LoadListPhong (){
		return dal.LoadListPhong();
	}
}
 