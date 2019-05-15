package QuanLyKS_BUS;

import java.awt.EventQueue;
import java.util.ArrayList;

import QuanLyKS_DTO.NhanVien_DTO;

import javax.swing.JInternalFrame;

import QuanLyKS_DAL.NhanVien_DAL;

public class NhanVien_BUS extends JInternalFrame {
	private NhanVien_DAL dal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NhanVien_BUS frame = new NhanVien_BUS();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public NhanVien_BUS() {
		setBounds(100, 100, 450, 300);
		dal = new NhanVien_DAL();
	}
	
	public ArrayList<NhanVien_DTO> SearchNV (String tukhoa){
		return dal.SearchNV(tukhoa);
		
	}

}
