package QuanLyKS_GUI;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;

import QuanLyKS_GUI.Login;
import QuanLyKS_GUI.Register;
import QuanLyKS_GUI.frmTimKiemNV;

import javax.swing.JDesktopPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

import java.awt.SystemColor;

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
	//deifne static varriable cho frame
	private static final int FRM_LOGIN = 1;
	private static final int FRM_REGISTER = 2;
	private static final int FRM_QLDV = 3;
	private static final int FRM_DATPHONG = 4;
	static final int FRM_DichVu = 5;
	private static final int FRM_TIMKIEM = 6; 

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
				frmTimKiemNV.setVisible(false);
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
				frmTimKiemNV.setVisible(false);
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
				frmTimKiemNV.setVisible(false);
				//set current frame
				contentPane.add(frmDatPhong);
				frmDatPhong.setVisible(true);
				break;
			case 5:
				//close another frame
				frmLogin.setVisible(false);
				frmRegister.setVisible(false);
				frmQLDV.setVisible(false);
				frmDatPhong.setVisible(false);
				frmTimKiemNV.setVisible(false);
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
				//set current frame
				contentPane.add(frmTimKiemNV);
				frmTimKiemNV.setVisible(true);
				break;
		}
	}
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmMain frame = new frmMain();
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
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmLogout = new JMenuItem("Login");
		mntmLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controlFrame(FRM_LOGIN);
			}
		});
		mnNewMenu.add(mntmLogout);		
		JMenuItem mntmRegister = new JMenuItem("Register");
		mntmRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controlFrame(FRM_REGISTER);
				
			}
		});
		mnNewMenu.add(mntmRegister);
		JMenuItem mntmit = new JMenuItem("Eixt");
		mnNewMenu.add(mntmit);
		
		JMenu mnDichVu = new JMenu("D\u1ECBch v\u1EE5");
		JMenuItem mntmThemDichVu = new JMenuItem("th�m dich vu");
		mntmThemDichVu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlFrame(FRM_DichVu);
			}
		});
		mnDichVu.add(mntmThemDichVu);
		menuBar.add(mnDichVu);
		
		JMenuItem mntmQuanLyDich = new JMenuItem("Qu\u1EA3n l\u00FD d\u1ECBch v\u1EE5");
		mntmQuanLyDich.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlFrame(FRM_QLDV);
				
			}
		});
		mnDichVu.add(mntmQuanLyDich);
		
		JMenu mnPhng = new JMenu("Ph\u00F2ng");
		menuBar.add(mnPhng);
		
		JMenuItem mntmtPhng = new JMenuItem("\u0110\u1EB7t ph\u00F2ng");
		mnPhng.add(mntmtPhng);
		
		JMenu mnNhnVin = new JMenu("Nh\u00E2n vi\u00EAn");
		menuBar.add(mnNhnVin);
		
		JMenuItem mntmTmKim = new JMenuItem("T\u00ECm ki\u1EBFm");
		mntmTmKim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controlFrame(FRM_TIMKIEM);
			}
		});
		mnNhnVin.add(mntmTmKim);
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