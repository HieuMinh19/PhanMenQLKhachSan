package QuanLyKS_GUI;
import java.awt.BorderLayout;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;

import QuanLyKS_GUI.*;
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

import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class frmDashboard extends JFrame {
	/**
	 * 
	 */
	
	static JDesktopPane desktopPane = new JDesktopPane();
	//khai bao tat ca cac frame
	static QLDichVu frmQLDV = new QLDichVu();
	static Register frmRegister = new Register();
	static frmTimKiemNV frmTimKiemNV = new frmTimKiemNV();
	static frmDatPhong frmDatPhong = new frmDatPhong();
	static DichVu frmDichVu = new DichVu();
	static frmThemNhanVien frmThemNhanVien = new frmThemNhanVien();
	static DanhGia frmDanhGia = new DanhGia();
	static DatDichVu frmDatDichVu = new DatDichVu();
	static ThemLoaiPhong frmThemLoaiPhong = new ThemLoaiPhong();
	static frmDanhSachPhong frmDanhSachPhong = new frmDanhSachPhong();
	static frmCapNhatNhanVien frmCapNhatNhanVien = new frmCapNhatNhanVien();
	static frmCapNhatLoaiPhong frmCapNhatLoaiPhong = new frmCapNhatLoaiPhong();
	static frmBooking_Step1 frmBooking1 = new frmBooking_Step1();
	static frmBooking_Step2 frmBooking2 = new frmBooking_Step2();
	static frmThanhToan frmThanhToan = new frmThanhToan();
	
	static frmDashboard frame = new frmDashboard(null);
	
	
	private Image backgroundImage;

	//deifne static varriable cho frame
	static final int FRM_REGISTER = 2;
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
	
	static final long serialVersionUID = 1L;
	private static JPanel contentPane;  
	/**
	 * Launch the application.
	 */
	public static void controlFrame(int Frame) {
		switch (Frame) {	
		case 2:
			//close another frame
			frmQLDV.setVisible(false);
			frmDichVu.setVisible(false);
			frmThemNhanVien.setVisible(false);
			frmTimKiemNV.setVisible(false);
			frmDanhGia.setVisible(false);
			frmDatDichVu.setVisible(false);
			frmThemLoaiPhong.setVisible(false);
			frmDanhSachPhong.setVisible(false);
			frmCapNhatNhanVien.setVisible(false);
			frmCapNhatLoaiPhong.setVisible(false);
			frmBooking1.setVisible(false);
			frmBooking2.setVisible(false);
			//set current frame
			frmRegister = new Register();
			contentPane.add(frmRegister);
			frmRegister.setVisible(true);
			break;
		
		case 3:
			//close another frame
			frmRegister.setVisible(false);
			frmDatPhong.setVisible(false);
			frmDichVu.setVisible(false);
			frmTimKiemNV.setVisible(false);
			frmDatDichVu.setVisible(false);
			frmThemNhanVien.setVisible(false);
			frmDanhGia.setVisible(false);
			frmThemLoaiPhong.setVisible(false);
			frmDanhSachPhong.setVisible(false);
			frmCapNhatNhanVien.setVisible(false);
			frmCapNhatLoaiPhong.setVisible(false);
			frmBooking1.setVisible(false);
			frmBooking2.setVisible(false);
			//set current frame
			contentPane.add(frmQLDV);
			frmQLDV.setVisible(true);
			break;
			
		case 4:
			//close another frame
			frmRegister.setVisible(false);
			frmQLDV.setVisible(false);
			frmDichVu.setVisible(false);
			frmThemNhanVien.setVisible(false);
			frmTimKiemNV.setVisible(false);
			frmDanhGia.setVisible(false);
			frmDanhSachPhong.setVisible(false);
			frmDatDichVu.setVisible(false);
			frmThemLoaiPhong.setVisible(false);
			frmCapNhatNhanVien.setVisible(false);
			frmCapNhatLoaiPhong.setVisible(false);
			frmBooking1.setVisible(false);
			frmBooking2.setVisible(false);
			//set current frame
			contentPane.add(frmDatPhong);
			frmDatPhong.setVisible(true);
			//frmDanhSachPhong.setVisible(false);
			break;
		case 5:
			//close another frame
			frmRegister.setVisible(false);
			frmQLDV.setVisible(false);
			frmDatPhong.setVisible(false);
			frmTimKiemNV.setVisible(false);
			frmThemNhanVien.setVisible(false);
			frmDanhGia.setVisible(false);
			frmDatDichVu.setVisible(false);
			frmThemLoaiPhong.setVisible(false);
			frmDanhSachPhong.setVisible(false);
			frmCapNhatNhanVien.setVisible(false);
			frmCapNhatLoaiPhong.setVisible(false);
			frmBooking1.setVisible(false);
			frmBooking2.setVisible(false);
			//set current frame
			contentPane.add(frmDichVu);
			frmDichVu.setVisible(true);
			break;
			
		case 6:
			//close another frame
			frmRegister.setVisible(false);
			frmQLDV.setVisible(false);
			frmDatPhong.setVisible(false);
			frmDichVu.setVisible(false);
			frmThemNhanVien.setVisible(false);
			frmDatDichVu.setVisible(false);
			frmDanhGia.setVisible(false);
			frmThemLoaiPhong.setVisible(false);
			frmDanhSachPhong.setVisible(false);
			frmCapNhatNhanVien.setVisible(false);
			frmCapNhatLoaiPhong.setVisible(false);
			frmBooking1.setVisible(false);
			frmBooking2.setVisible(false);
			//set current frame
			contentPane.add(frmTimKiemNV);
			frmTimKiemNV.setVisible(true);
			break;
		case 7:
			//close another frame
			frmRegister.setVisible(false);
			frmQLDV.setVisible(false);
			frmDatPhong.setVisible(false);
			frmDichVu.setVisible(false);
			frmTimKiemNV.setVisible(false);
//			frmThemNhanVien.setVisible(false);
			frmDatDichVu.setVisible(false);
			frmThemLoaiPhong.setVisible(false);
			frmDanhSachPhong.setVisible(false);
			frmCapNhatNhanVien.setVisible(false);
			frmCapNhatLoaiPhong.setVisible(false);
			frmBooking1.setVisible(false);
			frmBooking2.setVisible(false);
			frmThemNhanVien = new frmThemNhanVien();
			//set current frame
			contentPane.add(frmThemNhanVien);
			frmThemNhanVien.setVisible(true);
			break;
			
		case 8:
			//close another frame
			frmRegister.setVisible(false);
			frmQLDV.setVisible(false);
			frmDatPhong.setVisible(false);
			frmDichVu.setVisible(false);
			frmTimKiemNV.setVisible(false);
			frmThemNhanVien.setVisible(false);
			frmDatDichVu.setVisible(false);
			frmThemLoaiPhong.setVisible(false);
			frmDanhSachPhong.setVisible(false);
			frmCapNhatNhanVien.setVisible(false);
			frmCapNhatLoaiPhong.setVisible(false);
			frmBooking1.setVisible(false);
			frmBooking2.setVisible(false);
			//set current frame
			contentPane.add(frmDanhGia);
			frmDanhGia.setVisible(true);
			break;
			
			
		case 9:
			//close another frame
			frmRegister.setVisible(false);
			frmQLDV.setVisible(false);
			frmDatPhong.setVisible(false);
			frmDichVu.setVisible(false);
			frmTimKiemNV.setVisible(false);
			frmThemNhanVien.setVisible(false);
			frmDanhGia.setVisible(false);
			frmThemLoaiPhong.setVisible(false);
			frmDanhSachPhong.setVisible(false);
			frmCapNhatNhanVien.setVisible(false);
			frmCapNhatLoaiPhong.setVisible(false);
			frmBooking1.setVisible(false);
			frmBooking2.setVisible(false);
			//set current frame
			contentPane.add(frmDatDichVu);
			frmDatDichVu.setVisible(true);
			break;
		case 10:
			//close another frame
			frmRegister.setVisible(false);
			frmQLDV.setVisible(false);
			frmDatPhong.setVisible(false);
			frmDichVu.setVisible(false);
			frmTimKiemNV.setVisible(false);
			frmThemNhanVien.setVisible(false);
			frmDanhGia.setVisible(false);
			frmDatDichVu.setVisible(false);
			frmDanhSachPhong.setVisible(false);
			frmCapNhatNhanVien.setVisible(false);
			frmCapNhatLoaiPhong.setVisible(false);
			frmBooking1.setVisible(false);
			frmBooking2.setVisible(false);
			//set current frame
			contentPane.add(frmThemLoaiPhong);
			frmThemLoaiPhong.setVisible(true);
			break;
			
		case 11:
			//close another frame
			frmRegister.setVisible(false);
			frmQLDV.setVisible(false);
			frmDatPhong.setVisible(false);
			frmDichVu.setVisible(false);
			frmTimKiemNV.setVisible(false);
			frmThemNhanVien.setVisible(false);
			frmDanhGia.setVisible(false);
			frmDatDichVu.setVisible(false);
			frmCapNhatNhanVien.setVisible(false);
			frmCapNhatLoaiPhong.setVisible(false);
			frmThemLoaiPhong.setVisible(false);
			frmBooking1.setVisible(false);
			frmBooking2.setVisible(false);
			//set current frame
			contentPane.add(frmDanhSachPhong);
			frmDanhSachPhong.setVisible(true);
			break;
			
		case 12:
			//close another frame
			frmRegister.setVisible(false);
			frmQLDV.setVisible(false);
			frmDatPhong.setVisible(false);
			frmDichVu.setVisible(false);
			frmTimKiemNV.setVisible(false);
			frmThemNhanVien.setVisible(false);
			frmDanhGia.setVisible(false);
			frmDatDichVu.setVisible(false);
			frmDanhSachPhong.setVisible(false);
			frmCapNhatLoaiPhong.setVisible(false);
			frmThemLoaiPhong.setVisible(false);
			frmBooking1.setVisible(false);
			frmBooking2.setVisible(false);
			//set current frame
			contentPane.add(frmCapNhatNhanVien);
			frmCapNhatNhanVien.setVisible(true);
			break;
		case 13:
			//close another frame
			frmRegister.setVisible(false);
			frmQLDV.setVisible(false);
			frmDatPhong.setVisible(false);
			frmDichVu.setVisible(false);
			frmTimKiemNV.setVisible(false);
			frmThemNhanVien.setVisible(false);
			frmDanhGia.setVisible(false);
			frmDatDichVu.setVisible(false);
			frmDanhSachPhong.setVisible(false);
			frmCapNhatNhanVien.setVisible(false);
			frmThemLoaiPhong.setVisible(false);
			frmBooking1.setVisible(false);
			frmBooking2.setVisible(false);
			//set current frame
			contentPane.add(frmCapNhatLoaiPhong);
			frmCapNhatLoaiPhong.setVisible(true);
			break;
			
		case 14:
			//close another frame
			frmRegister.setVisible(false);
			frmQLDV.setVisible(false);
			frmDatPhong.setVisible(false);
			frmDichVu.setVisible(false);
			frmTimKiemNV.setVisible(false);
			frmThemNhanVien.setVisible(false);
			frmDanhGia.setVisible(false);
			frmDatDichVu.setVisible(false);
			frmDanhSachPhong.setVisible(false);
			frmCapNhatNhanVien.setVisible(false);
			frmThemLoaiPhong.setVisible(false);
			frmCapNhatLoaiPhong.setVisible(false);
			frmBooking2.setVisible(false);
			//set current frame
			frmBooking1 = new frmBooking_Step1();
			contentPane.add(frmBooking1);
			frmBooking1.setVisible(true);
			break;
			
			
		case 15:
			//close another frame
			frmRegister.setVisible(false);
			frmQLDV.setVisible(false);
			frmDatPhong.setVisible(false);
			frmDichVu.setVisible(false);
			frmTimKiemNV.setVisible(false);
			frmThemNhanVien.setVisible(false);
			frmDanhGia.setVisible(false);
			frmDatDichVu.setVisible(false);
			frmDanhSachPhong.setVisible(false);
			frmCapNhatNhanVien.setVisible(false);
			frmThemLoaiPhong.setVisible(false);
			frmCapNhatLoaiPhong.setVisible(false);
			frmBooking1.setVisible(false);
			//set current frame
			contentPane.add(frmBooking2);
			frmBooking2.setVisible(true);
			break;
		case 16:
			//close another frame
			frmRegister.setVisible(false);
			frmQLDV.setVisible(false);
			frmDatPhong.setVisible(false);
			frmDichVu.setVisible(false);
			frmTimKiemNV.setVisible(false);
			frmThemNhanVien.setVisible(false);
			frmDanhGia.setVisible(false);
			frmDatDichVu.setVisible(false);
			frmDanhSachPhong.setVisible(false);
			frmCapNhatNhanVien.setVisible(false);
			frmThemLoaiPhong.setVisible(false);
			frmCapNhatLoaiPhong.setVisible(false);
			frmBooking1.setVisible(false);
			frmBooking2.setVisible(false);
			//set current frame
			contentPane.add(frmThanhToan);
			frmThanhToan.setVisible(true);
			break;
		}
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
					frame.setUndecorated(true);
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
	public frmDashboard(NhanVien_DTO user) {		
		frmDashboard _self = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 811, 300);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		setJMenuBar(menuBar);
		
		JMenu mnDichVu = new JMenu("Service");
		mnDichVu.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		
		JMenu mnDatPhong = new JMenu("Booking");
		mnDatPhong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controlFrame(FRM_BOOKING1);
			}
		});
		mnDatPhong.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menuBar.add(mnDatPhong);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Booking");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlFrame(FRM_BOOKING1);
			}
		});
		mnDatPhong.add(mntmNewMenuItem);
		
		JMenu mnDanhGia = new JMenu("Feedback");
		mnDanhGia.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menuBar.add(mnDanhGia);
		
		JMenu mnThanhToan = new JMenu("Payment");
		mnThanhToan.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menuBar.add(mnThanhToan);
		
		JMenuItem mntmThanhToan = new JMenuItem("Thanh Toan");
		mntmThanhToan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controlFrame(FRM_THANHTOAN);
			}
		});
		mnThanhToan.add(mntmThanhToan);
		
		JMenu mnTimKiem = new JMenu("Search");
		mnTimKiem.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menuBar.add(mnTimKiem);
		
		JMenuItem mntmTimKiemNV = new JMenuItem("Employess");
		mntmTimKiemNV.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mnTimKiem.add(mntmTimKiemNV);
		
		JMenuItem mntmTimKiemLP = new JMenuItem("Room Type");
		mntmTimKiemLP.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mnTimKiem.add(mntmTimKiemLP);
		
		JMenuItem mntmTimKiemDV = new JMenuItem("Service");
		mntmTimKiemDV.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mnTimKiem.add(mntmTimKiemDV);
		
		JMenu mnNhanVien = new JMenu("Employees");
		mnNhanVien.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menuBar.add(mnNhanVien);
		
		JMenuItem mntmThemNV = new JMenuItem("Insert");
		mntmThemNV.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mntmThemNV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlFrame(FRM_THEMNHANVIEN);
			}
		});
		
		JMenuItem mntmCapNhatNV = new JMenuItem("Update and Delete");
		mntmCapNhatNV.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mntmCapNhatNV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlFrame(FRM_CAPNHATNHANVIEN);
			}
		});
		mnNhanVien.add(mntmThemNV);
		mnNhanVien.add(mntmCapNhatNV);
		menuBar.add(mnDichVu);
		
		JMenuItem mntmCapNhatDV = new JMenuItem("Update and Delete");
		mntmCapNhatDV.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mntmCapNhatDV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlFrame(FRM_QLDV);
				
			}
		});
		
		JMenuItem mntmThemDV = new JMenuItem("Insert");
		mntmThemDV.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mnDichVu.add(mntmThemDV);
		mnDichVu.add(mntmCapNhatDV);
		
				
				JMenu mnLoaiPhong = new JMenu("Room Type");
				mnLoaiPhong.setFont(new Font("Segoe UI", Font.PLAIN, 20));
				menuBar.add(mnLoaiPhong);
				
				JMenuItem mntmThemLP = new JMenuItem("Insert");
				mntmThemLP.setFont(new Font("Segoe UI", Font.PLAIN, 18));
				mntmThemLP.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						controlFrame(FRM_THEMLOAIPHONG);
					}
				});
				mnLoaiPhong.add(mntmThemLP);
				
				JMenuItem mntmCapNhatLP = new JMenuItem("Update and Delete");
				mntmCapNhatLP.setFont(new Font("Segoe UI", Font.PLAIN, 18));
				mnLoaiPhong.add(mntmCapNhatLP);
				mntmCapNhatLP.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						controlFrame(FRM_CAPNHATLOAIPHONG);
					}
				});
		
		JMenu mnPhng = new JMenu("Room");
		mnPhng.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menuBar.add(mnPhng);
		
		JMenuItem mntmCapNhatP = new JMenuItem("Update and Delete");
		mntmCapNhatP.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mntmCapNhatP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controlFrame(FRM_DANHSACHPHONG);
			}
		});
		
		JMenuItem mntmThemP = new JMenuItem("Insert");
		mntmThemP.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mnPhng.add(mntmThemP);
		mnPhng.add(mntmCapNhatP);
		
		JMenu mnThoat = new JMenu("Exit");
		mnThoat.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menuBar.add(mnThoat);
		
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(255, 0, 0)));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		
		desktopPane.setBorder(UIManager.getBorder("Button.border"));
		desktopPane.setBackground(SystemColor.activeCaption);
		contentPane.add(desktopPane, BorderLayout.SOUTH);
	}
}