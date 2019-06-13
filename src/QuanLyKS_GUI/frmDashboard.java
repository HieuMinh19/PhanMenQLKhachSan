package QuanLyKS_GUI;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JDesktopPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.UIManager;
import javax.swing.border.LineBorder;

import com.sun.xml.internal.ws.api.server.Adapter.Toolkit;

import QuanLyKS_DTO.NhanVien_DTO;
import QuanLyKS_DTO.CTDatPhong_DTO;
import QuanLyKS_DTO.CTDichVu_DTO;
import QuanLyKS_DTO.KhachHang_DTO;

import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class frmDashboard extends JFrame {
	/**
	 * 
	 */
	static NhanVien_DTO user;
	static CTDatPhong_DTO ctdp;
	static ArrayList<CTDichVu_DTO> listCTDV = new ArrayList<CTDichVu_DTO>();
	static KhachHang_DTO khDTO;
	static JDesktopPane desktopPane = new JDesktopPane();
	// khai bao tat ca cac frame

//	static Register frmRegister = new Register();// 2
	static QLDichVu frmQLDV = new QLDichVu();// 3
	// 4
	static DichVu frmDichVu = new DichVu();// 5
	static frmTimKiemNV frmTimKiemNV = new frmTimKiemNV();
	// 6
	static frmThemNhanVien frmThemNhanVien = new frmThemNhanVien();
	// 7
	static frmDanhGia frmDanhGia = new frmDanhGia();
	// 8
//	static DatDichVu frmDatDichVu = new DatDichVu();
	// 9
	static ThemLoaiPhong frmThemLoaiPhong = new ThemLoaiPhong();// 10
	static frmDanhSachPhong frmDanhSachPhong = new frmDanhSachPhong();
	// 11
	static frmCapNhatNhanVien frmCapNhatNhanVien = new frmCapNhatNhanVien();
	// 12
	static frmCapNhatLoaiPhong frmCapNhatLoaiPhong = new frmCapNhatLoaiPhong();
	// 13
	static frmBooking_Step1 frmBooking1 = new frmBooking_Step1();
	// 14
	static frmBooking_Step2 frmBooking2 = new frmBooking_Step2();
	// 15
	static frmThanhToan frmThanhToan = new frmThanhToan();
	// 16
	static BangPhanCong BangPhanCong = new BangPhanCong();
	// 17
	static QLBangPhanCong QLBangPhanCong = new QLBangPhanCong();
	// 18
//	static frmDashboard frame = new frmDashboard(null);
	//19
	static frmBooking_Step3 frmBooking3 = new frmBooking_Step3();
	static frmBooking_Step4 frmBooking4;
	
	static frmThemPhong frmThemPhong = new frmThemPhong();
	private Image backgroundImage;

	// deifne static varriable cho frame
	static final int FRM_THEMPHONG = 2;
	static final int FRM_QLDV = 3;
	static final int FRM_DATPHONG = 4;
	static final int FRM_DichVu = 5;
	static final int FRM_TIMKIEM = 6;
	static final int FRM_THEMNHANVIEN = 7;
	static final int FRM_DANHGIA = 8;
	static final int FRM_DATDICHVU = 9;
	static final int FRM_THEMLOAIPHONG = 10;
	static final int FRM_DANHSACHPHONG = 11;
	static final int FRM_CAPNHATNHANVIEN = 12;
	static final int FRM_CAPNHATLOAIPHONG = 13;
	static final int FRM_BOOKING1 = 14;
	static final int FRM_BOOKING2 = 15;
	static final int FRM_THANHTOAN = 16;
	static final int FRM_BANGPHANCONG = 17;
	static final int FRM_QLBANGPHANCONG = 18;
	static final int FRM_BOOKING3 = 19;
	static final int FRM_BOOKING4 = 20;
	static final long serialVersionUID = 1L;
	private static JPanel contentPane;

	// private JMenuItem mntmQLBPC;
	/**
	 * Launch the application.
	 */
	public static void controlFrame(int Frame) {
		switch (Frame) {
		case 2:
			// close another frame
			frmQLDV.setVisible(false);
			frmDichVu.setVisible(false);
			frmThemNhanVien.setVisible(false);
			frmTimKiemNV.setVisible(false);
			frmDanhGia.setVisible(false);
			frmThemLoaiPhong.setVisible(false);
			frmDanhSachPhong.setVisible(false);
			frmCapNhatNhanVien.setVisible(false);
			frmCapNhatLoaiPhong.setVisible(false);
			frmBooking1.setVisible(false);
			frmBooking2.setVisible(false);
			frmThanhToan.setVisible(false);
			BangPhanCong.setVisible(false);
			QLBangPhanCong.setVisible(false);
			// set current frame

			contentPane.add(frmThemPhong);
			frmThemPhong.setVisible(true);
			break;

		case 3:
			// close another frame
			frmThemPhong.setVisible(false);
			frmDichVu.setVisible(false);
			frmThemNhanVien.setVisible(false);
			frmTimKiemNV.setVisible(false);
			frmDanhGia.setVisible(false);
//			frmDatDichVu.setVisible(false);
			frmThemLoaiPhong.setVisible(false);
			frmDanhSachPhong.setVisible(false);
			frmCapNhatNhanVien.setVisible(false);
			frmCapNhatLoaiPhong.setVisible(false);
			frmBooking1.setVisible(false);
			frmBooking2.setVisible(false);
			frmThanhToan.setVisible(false);
			BangPhanCong.setVisible(false);
			QLBangPhanCong.setVisible(false);
			// set current frame
			contentPane.add(frmQLDV);
			frmQLDV.setVisible(true);
			break;

		case 5:
			// close another frame
			frmThemPhong.setVisible(false);
			frmThemNhanVien.setVisible(false);
			frmTimKiemNV.setVisible(false);
			frmDanhGia.setVisible(false);
//			frmDatDichVu.setVisible(false);
			frmThemLoaiPhong.setVisible(false);
			frmDanhSachPhong.setVisible(false);
			frmCapNhatNhanVien.setVisible(false);
			frmCapNhatLoaiPhong.setVisible(false);
			frmBooking1.setVisible(false);
			frmBooking2.setVisible(false);
			frmQLDV.setVisible(false);
			frmThanhToan.setVisible(false);
			BangPhanCong.setVisible(false);
			QLBangPhanCong.setVisible(false);
			// set current frame
			contentPane.add(frmDichVu);
			frmDichVu.setVisible(true);
			break;

		case 6:
			// close another frame
			frmThemPhong.setVisible(false);
			frmThemNhanVien.setVisible(false);
			frmDichVu.setVisible(false);
			frmDanhGia.setVisible(false);
//			frmDatDichVu.setVisible(false);
			frmThemLoaiPhong.setVisible(false);
			frmDanhSachPhong.setVisible(false);
			frmCapNhatNhanVien.setVisible(false);
			frmCapNhatLoaiPhong.setVisible(false);
			frmBooking1.setVisible(false);
			frmBooking2.setVisible(false);
			frmQLDV.setVisible(false);
			frmThanhToan.setVisible(false);
			BangPhanCong.setVisible(false);
			QLBangPhanCong.setVisible(false);
			// set current frame
			contentPane.add(frmTimKiemNV);
			frmTimKiemNV.setVisible(true);
			break;
		case 7:
			// close another frame
			
			
			frmThemPhong.setVisible(false);
			frmTimKiemNV.setVisible(false);
			frmDichVu.setVisible(false);
			frmDanhGia.setVisible(false);
//			frmDatDichVu.setVisible(false);
			frmThemLoaiPhong.setVisible(false);
			frmDanhSachPhong.setVisible(false);
			frmCapNhatNhanVien.setVisible(false);
			frmCapNhatLoaiPhong.setVisible(false);
			frmBooking1.setVisible(false);
			frmBooking2.setVisible(false);
			frmQLDV.setVisible(false);
			frmThanhToan.setVisible(false);
			BangPhanCong.setVisible(false);
			QLBangPhanCong.setVisible(false);
			// set current frame
			contentPane.add(frmThemNhanVien);
			frmThemNhanVien.setVisible(true);
			break;
		case 8:
			// close another frame
			frmThemPhong.setVisible(false);
			frmTimKiemNV.setVisible(false);
			frmDichVu.setVisible(false);
			frmThemNhanVien.setVisible(false);
//			frmDatDichVu.setVisible(false);
			frmThemLoaiPhong.setVisible(false);
			frmDanhSachPhong.setVisible(false);
			frmCapNhatNhanVien.setVisible(false);
			frmCapNhatLoaiPhong.setVisible(false);
			frmBooking1.setVisible(false);
			frmBooking2.setVisible(false);
			frmQLDV.setVisible(false);
			frmThanhToan.setVisible(false);
			BangPhanCong.setVisible(false);
			QLBangPhanCong.setVisible(false);
			// set current frame
			contentPane.add(frmDanhGia);
			frmDanhGia.setVisible(true);
			break;
//		case 9:
//			// close another frame
////			frmRegister.setVisible(false);
//			frmTimKiemNV.setVisible(false);
//			frmDichVu.setVisible(false);
//			frmThemNhanVien.setVisible(false);
//			frmDanhGia.setVisible(false);
//			frmThemLoaiPhong.setVisible(false);
//			frmDanhSachPhong.setVisible(false);
//			frmCapNhatNhanVien.setVisible(false);
//			frmCapNhatLoaiPhong.setVisible(false);
//			frmBooking1.setVisible(false);
//			frmBooking2.setVisible(false);
//			frmQLDV.setVisible(false);
//			frmThanhToan.setVisible(false);
//			BangPhanCong.setVisible(false);
//			QLBangPhanCong.setVisible(false);
//			// set current frame
//			contentPane.add(frmDatDichVu);
//			frmDatDichVu.setVisible(true);
//			break;
		case 10:
			// close another frame
			frmThemPhong.setVisible(false);
			frmTimKiemNV.setVisible(false);
			frmDichVu.setVisible(false);
			frmThemNhanVien.setVisible(false);
			frmDanhGia.setVisible(false);
//			frmDatDichVu.setVisible(false);
			frmDanhSachPhong.setVisible(false);
			frmCapNhatNhanVien.setVisible(false);
			frmCapNhatLoaiPhong.setVisible(false);
			frmBooking1.setVisible(false);
			frmBooking2.setVisible(false);
			frmQLDV.setVisible(false);
			frmThanhToan.setVisible(false);
			BangPhanCong.setVisible(false);
			QLBangPhanCong.setVisible(false);
			// set current frame
			contentPane.add(frmThemLoaiPhong);
			frmThemLoaiPhong.setVisible(true);
			break;

		case 11:
			// close another fram
			frmThemPhong.setVisible(false);
			frmTimKiemNV.setVisible(false);
			frmDichVu.setVisible(false);
			frmThemNhanVien.setVisible(false);
			frmDanhGia.setVisible(false);
//			frmDatDichVu.setVisible(false);
			frmThemLoaiPhong.setVisible(false);
			frmCapNhatNhanVien.setVisible(false);
			frmCapNhatLoaiPhong.setVisible(false);
			frmBooking1.setVisible(false);
			frmBooking2.setVisible(false);
			frmQLDV.setVisible(false);
			frmThanhToan.setVisible(false);
			BangPhanCong.setVisible(false);
			QLBangPhanCong.setVisible(false);
			// set current frame
			contentPane.add(frmDanhSachPhong);
			frmDanhSachPhong.setVisible(true);
			break;

		case 12:
			// close another frame
			frmThemPhong.setVisible(false);
			frmTimKiemNV.setVisible(false);
			frmDichVu.setVisible(false);
			frmThemNhanVien.setVisible(false);
			frmDanhGia.setVisible(false);
//			frmDatDichVu.setVisible(false);
			frmThemLoaiPhong.setVisible(false);
			frmDanhSachPhong.setVisible(false);
			frmCapNhatLoaiPhong.setVisible(false);
			frmBooking1.setVisible(false);
			frmBooking2.setVisible(false);
			frmQLDV.setVisible(false);
			frmThanhToan.setVisible(false);
			BangPhanCong.setVisible(false);
			QLBangPhanCong.setVisible(false);
			// set current frame
			contentPane.add(frmCapNhatNhanVien);
			frmCapNhatNhanVien.setVisible(true);
			break;
		case 13:
			// close another frame
			frmThemPhong.setVisible(false);
			frmTimKiemNV.setVisible(false);
			frmDichVu.setVisible(false);
			frmThemNhanVien.setVisible(false);
			frmDanhGia.setVisible(false);
//			frmDatDichVu.setVisible(false);
			frmThemLoaiPhong.setVisible(false);
			frmDanhSachPhong.setVisible(false);
			frmCapNhatNhanVien.setVisible(false);
			frmBooking1.setVisible(false);
			frmBooking2.setVisible(false);
			frmQLDV.setVisible(false);
			frmThanhToan.setVisible(false);
			BangPhanCong.setVisible(false);
			QLBangPhanCong.setVisible(false);
			// set current frame
			contentPane.add(frmCapNhatLoaiPhong);
			frmCapNhatLoaiPhong.setVisible(true);
			break;

		case 14:
			// close another frame
			frmThemPhong.setVisible(false);
			frmTimKiemNV.setVisible(false);
			frmDichVu.setVisible(false);
			frmThemNhanVien.setVisible(false);
			frmDanhGia.setVisible(false);
//			frmDatDichVu.setVisible(false);
			frmThemLoaiPhong.setVisible(false);
			frmDanhSachPhong.setVisible(false);
			frmCapNhatNhanVien.setVisible(false);
			frmCapNhatLoaiPhong.setVisible(false);
			frmBooking2.setVisible(false);
			frmQLDV.setVisible(false);
			frmThanhToan.setVisible(false);
			BangPhanCong.setVisible(false);
			QLBangPhanCong.setVisible(false);
			//frmBooking4.setVisible(true);
			// set current frame
			contentPane.add(frmBooking1);
			frmBooking1.setVisible(true);
			break;

		case 15:
			// close another frame
			frmThemPhong.setVisible(false);
			frmTimKiemNV.setVisible(false);
			frmDichVu.setVisible(false);
			frmThemNhanVien.setVisible(false);
			frmDanhGia.setVisible(false);
//			frmDatDichVu.setVisible(false);
			frmThemLoaiPhong.setVisible(false);
			frmDanhSachPhong.setVisible(false);
			frmCapNhatNhanVien.setVisible(false);
			frmCapNhatLoaiPhong.setVisible(false);
			frmBooking1.setVisible(false);
			frmQLDV.setVisible(false);
			frmThanhToan.setVisible(false);
			BangPhanCong.setVisible(false);
			QLBangPhanCong.setVisible(false);
			// set current frame
			contentPane.add(frmBooking2);
			frmBooking2.setVisible(true);
			break;
		case 16:
			// close another frame

			frmThemPhong.setVisible(false);
			frmTimKiemNV.setVisible(false);
			frmDichVu.setVisible(false);
			frmThemNhanVien.setVisible(false);
			frmDanhGia.setVisible(false);
//			frmDatDichVu.setVisible(false);
			frmThemLoaiPhong.setVisible(false);
			frmDanhSachPhong.setVisible(false);
			frmCapNhatNhanVien.setVisible(false);
			frmCapNhatLoaiPhong.setVisible(false);
			frmBooking1.setVisible(false);
			frmQLDV.setVisible(false);
			frmBooking2.setVisible(false);
			BangPhanCong.setVisible(false);
			QLBangPhanCong.setVisible(false);
			// set current frame
			contentPane.add(frmThanhToan);
			frmThanhToan.setVisible(true);
			break;
		case 17:
			// close another frame

			frmThemPhong.setVisible(false);
			frmTimKiemNV.setVisible(false);
			frmDichVu.setVisible(false);
			frmThemNhanVien.setVisible(false);
			frmDanhGia.setVisible(false);
//			frmDatDichVu.setVisible(false);
			frmThemLoaiPhong.setVisible(false);
			frmDanhSachPhong.setVisible(false);
			frmCapNhatNhanVien.setVisible(false);
			frmCapNhatLoaiPhong.setVisible(false);
			frmBooking1.setVisible(false);
			frmQLDV.setVisible(false);
			frmBooking2.setVisible(false);
			frmThanhToan.setVisible(false);
			QLBangPhanCong.setVisible(false);
			// set current frame
			contentPane.add(BangPhanCong);
			BangPhanCong.setVisible(true);
			break;
		case 18:
			// close another frame
			frmThemPhong.setVisible(false);
			frmTimKiemNV.setVisible(false);
			frmDichVu.setVisible(false);
			frmThemNhanVien.setVisible(false);
			frmDanhGia.setVisible(false);
//			frmDatDichVu.setVisible(false);
			frmThemLoaiPhong.setVisible(false);
			frmDanhSachPhong.setVisible(false);
			frmCapNhatNhanVien.setVisible(false);
			frmCapNhatLoaiPhong.setVisible(false);
			frmBooking1.setVisible(false);
			frmQLDV.setVisible(false);
			frmBooking2.setVisible(false);
			frmThanhToan.setVisible(false);
			BangPhanCong.setVisible(false);
			// set current frame
			contentPane.add(QLBangPhanCong);
			QLBangPhanCong.setVisible(true);
			break;
		case 19:
			//close another frame
			frmThemPhong.setVisible(false);
			frmQLDV.setVisible(false);
			frmDichVu.setVisible(false);
			frmTimKiemNV.setVisible(false);
			frmThemNhanVien.setVisible(false);
			//frmDanhGia.setVisible(false);
//			frmDatDichVu.setVisible(false);
			frmDanhSachPhong.setVisible(false);
			frmCapNhatNhanVien.setVisible(false);
			frmThemLoaiPhong.setVisible(false);
			frmCapNhatLoaiPhong.setVisible(false);
			frmBooking1.setVisible(false);
			frmBooking2.setVisible(false);
//			frmBooking4.setVisible(false);
			//set current frame
			contentPane.add(frmBooking3);
			frmBooking3.setVisible(true);
			break;
			
		case 20:
			// close another frame
			frmThemPhong.setVisible(false);
			frmTimKiemNV.setVisible(false);
			frmDichVu.setVisible(false);
			frmThemNhanVien.setVisible(false);
			frmDanhGia.setVisible(false);
//			frmDatDichVu.setVisible(false);
			frmThemLoaiPhong.setVisible(false);
			frmDanhSachPhong.setVisible(false);
			frmCapNhatNhanVien.setVisible(false);
			frmCapNhatLoaiPhong.setVisible(false);
			frmBooking1.setVisible(false);
			frmQLDV.setVisible(false);
			frmBooking2.setVisible(false);
			frmThanhToan.setVisible(false);
			BangPhanCong.setVisible(false);
			frmBooking3.setVisible(false);
			// set current frame
			contentPane.add(frmBooking4);
			frmBooking4.setVisible(true);
			break;
		}
	}

//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
//					frame.setUndecorated(true);
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public frmDashboard(NhanVien_DTO user) {
		this.user = user;
		frmDashboard _self = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 811, 300);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		setJMenuBar(menuBar);

		switch (user.getChucVu().getMaChucVu()) {
		case 1:
			JMenu mnNhanVien = new JMenu("Nhân viên");
			mnNhanVien.setFont(new Font("Segoe UI", Font.PLAIN, 20));
			menuBar.add(mnNhanVien);

			JMenuItem mntmThemNV = new JMenuItem("Thêm nhân viên");
			mntmThemNV.setFont(new Font("Segoe UI", Font.PLAIN, 18));
			mntmThemNV.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					controlFrame(FRM_THEMNHANVIEN);
				}
			});
			mnNhanVien.add(mntmThemNV);
			

			JMenuItem mntmCapNhatNV = new JMenuItem("Cập nhật danh sách nhân viên");
			mntmCapNhatNV.setFont(new Font("Segoe UI", Font.PLAIN, 18));
			mntmCapNhatNV.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					controlFrame(FRM_CAPNHATNHANVIEN);
				}
			});
			

			JMenu mnDichVu = new JMenu("Dịch vụ");
			mnDichVu.setFont(new Font("Segoe UI", Font.PLAIN, 20));
			mnNhanVien.add(mntmCapNhatNV);
			menuBar.add(mnDichVu);
			
			JMenuItem mntmThemDV = new JMenuItem("Thêm dịch vụ");
			mntmThemDV.setFont(new Font("Segoe UI", Font.PLAIN, 18));
			mntmThemDV.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					controlFrame(FRM_DichVu);

				}
			});
			mnDichVu.add(mntmThemDV);


			JMenuItem mntmCapNhatDV = new JMenuItem("Cập nhật danh sách dịch vụ");
			mntmCapNhatDV.setFont(new Font("Segoe UI", Font.PLAIN, 18));
			mntmCapNhatDV.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					controlFrame(FRM_QLDV);

				}
			});
			mnDichVu.add(mntmCapNhatDV);

			JMenu mnLoaiPhong = new JMenu("Loại phòng");
			mnLoaiPhong.setFont(new Font("Segoe UI", Font.PLAIN, 20));
			menuBar.add(mnLoaiPhong);

			JMenuItem mntmThemLP = new JMenuItem("Thêm loại phòng");
			mntmThemLP.setFont(new Font("Segoe UI", Font.PLAIN, 18));
			mntmThemLP.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					controlFrame(FRM_THEMLOAIPHONG);
				}
			});
			mnLoaiPhong.add(mntmThemLP);

			JMenuItem mntmCapNhatLP = new JMenuItem("Cập nhật danh sách loại phòng");
			mntmCapNhatLP.setFont(new Font("Segoe UI", Font.PLAIN, 18));
			mnLoaiPhong.add(mntmCapNhatLP);
			mntmCapNhatLP.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					controlFrame(FRM_CAPNHATLOAIPHONG);
				}
			});

			JMenu mnPhng = new JMenu("Phòng");
			mnPhng.setFont(new Font("Segoe UI", Font.PLAIN, 20));
			menuBar.add(mnPhng);
			
			JMenuItem mntmThemP = new JMenuItem("Thêm phòng");
			mntmThemP.setFont(new Font("Segoe UI", Font.PLAIN, 18));
			mntmThemP.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					controlFrame(FRM_THEMPHONG);
				}
			});
			mnPhng.add(mntmThemP);
			
			JMenuItem mntmCapNhatP = new JMenuItem("Cập nhật danh sách phòng");
			mntmCapNhatP.setFont(new Font("Segoe UI", Font.PLAIN, 18));
			mntmCapNhatP.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					controlFrame(FRM_DANHSACHPHONG);
				}
			});
			mnPhng.add(mntmCapNhatP);


			JMenu mnBangPhanCong = new JMenu("Phân công nhân viên");
			mnBangPhanCong.setFont(new Font("Segoe UI", Font.PLAIN, 20));
			menuBar.add(mnBangPhanCong);

			JMenuItem mntmThm = new JMenuItem("Phân công nhiệm vụ");
			// mnBangPhanCong.add(mntmThm);
			mntmThm.setFont(new Font("Segoe UI", Font.PLAIN, 18));
			mntmThm.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					controlFrame(FRM_BANGPHANCONG);
				}
			});
			mnBangPhanCong.add(mntmThm);

			JMenuItem mntmNewMenuItem_1 = new JMenuItem("Cập nhật phân công nhiệm vụ");
			mntmNewMenuItem_1.setFont(new Font("Segoe UI", Font.PLAIN, 18));
			mntmNewMenuItem_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					controlFrame(FRM_QLBANGPHANCONG);
				}
			});
			mnBangPhanCong.add(mntmNewMenuItem_1);
			break;
		case 2:
			JMenu mnDatPhong = new JMenu("Đặt phòng");
			mnDatPhong.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					controlFrame(FRM_BOOKING1);
				}
			});
			mnDatPhong.setFont(new Font("Segoe UI", Font.PLAIN, 20));
			menuBar.add(mnDatPhong);

			JMenu mnDanhGia = new JMenu("Phản hồi");
			mnDanhGia.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					controlFrame(FRM_DANHGIA);
				}
			});
			mnDanhGia.setFont(new Font("Segoe UI", Font.PLAIN, 20));
			menuBar.add(mnDanhGia);

			JMenu mnThanhToan = new JMenu("Thanh toán");
			mnThanhToan.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					controlFrame(FRM_THANHTOAN);
				}
			});
			mnThanhToan.setFont(new Font("Segoe UI", Font.PLAIN, 20));
			menuBar.add(mnThanhToan);

			JMenu mnTimKiem = new JMenu("Tìm kiếm thông tin");
			mnTimKiem.setFont(new Font("Segoe UI", Font.PLAIN, 20));
			menuBar.add(mnTimKiem);

			JMenuItem mntmTimKiemNV = new JMenuItem("Nhân viên");
			mntmTimKiemNV.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					controlFrame(FRM_TIMKIEM);

				}
			});
			mntmTimKiemNV.setFont(new Font("Segoe UI", Font.PLAIN, 18));
			mnTimKiem.add(mntmTimKiemNV);

			JMenuItem mntmTimKiemLP = new JMenuItem("Loại phòng");
			mntmTimKiemLP.setFont(new Font("Segoe UI", Font.PLAIN, 18));
			mnTimKiem.add(mntmTimKiemLP);

			JMenuItem mntmTimKiemDV = new JMenuItem("Dịch vụ");
			mntmTimKiemDV.setFont(new Font("Segoe UI", Font.PLAIN, 18));
			mnTimKiem.add(mntmTimKiemDV);
			break;
		default:
			break;
		}

		
		

		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(255, 0, 0)));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		desktopPane.setBorder(UIManager.getBorder("Button.border"));
		desktopPane.setBackground(SystemColor.activeCaption);
		contentPane.add(desktopPane, BorderLayout.SOUTH);
	}
}