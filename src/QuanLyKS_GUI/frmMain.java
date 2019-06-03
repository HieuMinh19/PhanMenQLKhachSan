package QuanLyKS_GUI;
import java.awt.BorderLayout;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;

import QuanLyKS_GUI.Login;
import QuanLyKS_GUI.Register;
import QuanLyKS_GUI.frmTimKiemNV;

import QuanLyKS_GUI.DanhGia;
import QuanLyKS_GUI.frmThemNhanVien;
import QuanLyKS_GUI.frmCapNhatNhanVien;
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

import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

public class frmMain extends JFrame {
	/**
	 * 
	 */
	//khai bao tat ca cac frame
	static QLDichVu frmQLDV = new QLDichVu();
	static Login frmLogin = new Login();
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
	
	static frmMain frame = new frmMain();
	
	
	private Image backgroundImage;

	//deifne static varriable cho frame
	private static final int FRM_LOGIN = 1;
	private static final int FRM_REGISTER = 2;
	private static final int FRM_QLDV = 3;
	private static final int FRM_DATPHONG = 4;
	static final int FRM_DichVu = 5;
	private static final int FRM_TIMKIEM = 6; 

	private static final int FRM_THEMNHANVIEN = 7; 
	private static final int FRM_DANHGIA = 8;
	private static final int FRM_DATDICHVU = 9;
	private static final int FRM_THEMLOAIPHONG = 10;
	private static final int FRM_DANHSACHPHONG = 11;
	private static final int FRM_CAPNHATNHANVIEN = 12;
	private static final long serialVersionUID = 1L;
	private static JPanel contentPane;
	/**
	 * Launch the application.
	 */
	public static void controlFrame(int Frame) {
		switch (Frame) {
			case 1: 
				//close another frame
				frmRegister.setVisible(false);
				frmQLDV.setVisible(false);
				frmDatPhong.setVisible(false);
				frmDichVu.setVisible(false);
				frmThemNhanVien.setVisible(false);
				frmTimKiemNV.setVisible(false);
				frmDanhGia.setVisible(false);
				frmDatDichVu.setVisible(false);
				frmThemLoaiPhong.setVisible(false);
				frmDanhSachPhong.setVisible(false);
				frmCapNhatNhanVien.setVisible(false);
				//set current frame
				contentPane.add(frmLogin);
				frmLogin.setVisible(true);
				break;
				
			case 2:
				//close another frame
				frmLogin.setVisible(false);
				frmQLDV.setVisible(false);
				frmDatPhong.setVisible(false);
				frmDichVu.setVisible(false);
				frmThemNhanVien.setVisible(false);
				frmTimKiemNV.setVisible(false);
				frmDanhGia.setVisible(false);
				frmDatDichVu.setVisible(false);
				frmThemLoaiPhong.setVisible(false);
				frmDanhSachPhong.setVisible(false);
				frmCapNhatNhanVien.setVisible(false);
				//set current frame
				contentPane.add(frmRegister);
				frmRegister.setVisible(true);
				break;
			
			case 3:
				//close another frame
				frmLogin.setVisible(false);
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
				//set current frame
				contentPane.add(frmQLDV);
				frmQLDV.setVisible(true);
				break;
				
			case 4:
				//close another frame
				frmLogin.setVisible(false);
				frmRegister.setVisible(false);
				frmQLDV.setVisible(false);
				frmDichVu.setVisible(false);
				frmThemNhanVien.setVisible(false);
				frmTimKiemNV.setVisible(false);
				frmDanhGia.setVisible(false);
				frmDatPhong.setVisible(false);
				frmDatDichVu.setVisible(false);
				frmThemLoaiPhong.setVisible(false);
				frmCapNhatNhanVien.setVisible(false);
				//set current frame
				contentPane.add(frmDatPhong);
				frmDatPhong.setVisible(true);
				frmDanhSachPhong.setVisible(false);
				break;
			case 5:
				//close another frame
				frmLogin.setVisible(false);
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
				//set current frame
				contentPane.add(frmDichVu);
				frmDichVu.setVisible(true);
				break;
				
			case 6:
				//close another frame
				frmLogin.setVisible(false);
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
				//set current frame
				contentPane.add(frmTimKiemNV);
				frmTimKiemNV.setVisible(true);
				break;
			case 7:
				//close another frame
				frmLogin.setVisible(false);
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
				
				contentPane.add(frmThemNhanVien);
				frmThemNhanVien.setVisible(true);
				break;
				
			case 8:
				//close another frame
				frmLogin.setVisible(false);
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
				//set current frame
				contentPane.add(frmDanhGia);
				frmDanhGia.setVisible(true);
				break;
				
				
			case 9:
				//close another frame
				frmLogin.setVisible(false);
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
				//set current frame
				contentPane.add(frmDatDichVu);
				frmDatDichVu.setVisible(true);
				break;
			case 10:
				//close another frame
				frmLogin.setVisible(false);
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
				//set current frame
				contentPane.add(frmThemLoaiPhong);
				frmThemLoaiPhong.setVisible(true);
				break;
				
			case 11:
				//close another frame
				frmLogin.setVisible(false);
				frmRegister.setVisible(false);
				frmQLDV.setVisible(false);
				frmDatPhong.setVisible(false);
				frmDichVu.setVisible(false);
				frmTimKiemNV.setVisible(false);
				frmThemNhanVien.setVisible(false);
				frmDanhGia.setVisible(false);
				frmDatDichVu.setVisible(false);
				frmCapNhatNhanVien.setVisible(false);
				//set current frame
				contentPane.add(frmDanhSachPhong);
				frmDanhSachPhong.setVisible(true);
				break;
				
			case 12:
				//close another frame
				frmLogin.setVisible(false);
				frmRegister.setVisible(false);
				frmQLDV.setVisible(false);
				frmDatPhong.setVisible(false);
				frmDichVu.setVisible(false);
				frmTimKiemNV.setVisible(false);
				frmThemNhanVien.setVisible(false);
				frmDanhGia.setVisible(false);
				frmDatDichVu.setVisible(false);
				frmDanhSachPhong.setVisible(false);
				//set current frame
				contentPane.add(frmCapNhatNhanVien);
				frmCapNhatNhanVien.setVisible(true);
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
	public frmMain() {
//		backgroundImage = new ImageIcon("~/images/main-background.png").getImage();
//	    Dimension size = new Dimension(backgroundImage.getWidth(null), backgroundImage.getHeight(null));
//	    this.setPreferredSize(size);
//	    this.setMinimumSize(size);
//	    this.setMaximumSize(size);
//	    this.setSize(size);
//	    this.setLayout(null);
//	    JPanel panel = new JPanel() {
//	    	@Override
//	    	public void paintComponent(Graphics g) {
//	    	    g.drawImage(backgroundImage, 0, 0, null);
//	        }
//	    };
//	    this.getContentPane().add(panel);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("File");
		mnNewMenu.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menuBar.add(mnNewMenu);
		JMenuItem mntmdanhgia = new JMenuItem("FeedBack");
		mntmdanhgia.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		mntmdanhgia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controlFrame(FRM_DANHGIA);

			}
		});
		mnNewMenu.add(mntmdanhgia);
		JMenuItem mntmLogout = new JMenuItem("Login");
		mntmLogout.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		mntmLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controlFrame(FRM_LOGIN);
			}
		});
		mnNewMenu.add(mntmLogout);		
		JMenuItem mntmRegister = new JMenuItem("Register");
		mntmRegister.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		mntmRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controlFrame(FRM_REGISTER);
				
				
			}
		});
		mnNewMenu.add(mntmRegister);
		JMenuItem mntmit = new JMenuItem("Eixt");
		mntmit.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		mntmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
			}
		});
		mnNewMenu.add(mntmit);
		
		JMenu mnDichVu = new JMenu("D\u1ECBch v\u1EE5");
		mnDichVu.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		JMenuItem mntmThemDichVu = new JMenuItem("Th\u00EAm d\u1ECBch v\u1EE5");
		mntmThemDichVu.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		mntmThemDichVu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlFrame(FRM_DichVu);
			}
		});
		
		JMenuItem mntmtDchV = new JMenuItem("\u0110\u1EB7t d\u1ECBch v\u1EE5");
		mntmtDchV.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		mntmtDchV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controlFrame(FRM_DATDICHVU);
			}
		});
		mnDichVu.add(mntmtDchV);
		mnDichVu.add(mntmThemDichVu);
		menuBar.add(mnDichVu);
		
		JMenuItem mntmQuanLyDich = new JMenuItem("Qu\u1EA3n l\u00FD d\u1ECBch v\u1EE5");
		mntmQuanLyDich.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		mntmQuanLyDich.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlFrame(FRM_QLDV);
				
			}
		});
		mnDichVu.add(mntmQuanLyDich);
		
		JMenu mnPhng = new JMenu("Ph\u00F2ng");
		mnPhng.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menuBar.add(mnPhng);
		
		JMenuItem mntmtPhng = new JMenuItem("\u0110\u1EB7t ph\u00F2ng");
		mntmtPhng.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		
		JMenuItem mntmDanhSachPhong = new JMenuItem("Danh sach phong");
		mntmDanhSachPhong.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		mntmDanhSachPhong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controlFrame(FRM_DANHSACHPHONG);
			}
		});
		
		mnPhng.add(mntmtPhng);
		mnPhng.add(mntmDanhSachPhong);
		
		JMenu mnNhnVin = new JMenu("Nh\u00E2n vi\u00EAn");
		mnNhnVin.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menuBar.add(mnNhnVin);
		
		JMenuItem mntmTmKim = new JMenuItem("T\u00ECm ki\u1EBFm");
		mntmTmKim.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		mntmTmKim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controlFrame(FRM_TIMKIEM);
			}
		});
		
		JMenuItem mntmThmNhnVin = new JMenuItem("Th\u00EAm nh\u00E2n vi\u00EAn");
		mntmThmNhnVin.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		mntmThmNhnVin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlFrame(FRM_THEMNHANVIEN);
			}
		});
		
		JMenuItem mntmCpNhtNhn = new JMenuItem("C\u1EADp nh\u1EADt nh\u00E2n vi\u00EAn");
		mntmCpNhtNhn.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		mntmCpNhtNhn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlFrame(FRM_CAPNHATNHANVIEN);
			}
		});
		
		mnNhnVin.add(mntmTmKim);
		mnNhnVin.add(mntmThmNhnVin);
		mnNhnVin.add(mntmCpNhtNhn);

		
		JMenu mnLoiPhng = new JMenu("Lo\u1EA1i ph\u00F2ng");
		mnLoiPhng.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menuBar.add(mnLoiPhng);
		
		JMenuItem mntmThmLoiPhng = new JMenuItem("Th\u00EAm lo\u1EA1i ph\u00F2ng");
		mntmThmLoiPhng.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		mntmThmLoiPhng.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controlFrame(FRM_THEMLOAIPHONG);
			}
		});
		mnLoiPhng.add(mntmThmLoiPhng);
		mntmtPhng.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlFrame(FRM_DATPHONG);
			}
		});
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBorder(UIManager.getBorder("Button.border"));
		desktopPane.setBackground(SystemColor.activeCaption);
		contentPane.add(desktopPane, BorderLayout.SOUTH);
	}
	
	
}