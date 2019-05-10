package QuanLyKS_GUI;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;

import QuanLyKS_GUI.Login;
import QuanLyKS_GUI.Demo2;
import QuanLyKS_GUI.Register;
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
	static Demo2 frmDemo2 = new Demo2();
	//deifne static varriable cho frame
	static final int FRM_LOGIN = 1;
	static final int FRM_REGISTER = 2;
	static final int FRM_QLDV = 3;
	static final int FRM_DEMO = 4;
        
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
                                frmDemo2.setVisible(false);
				//set current frame
				contentPane.add(frmLogin);
				frmLogin.setVisible(true);
				break;
				
			case 2:
				//close another frame
				frmLogin.setVisible(false);
				frmQLDV.setVisible(false);

				//set current frame
				contentPane.add(frmRegister);
				frmRegister.setVisible(true);
				break;
				
				
			case 3:
				//close another frame
				frmLogin.setVisible(false);
				frmRegister.setVisible(false);
                                frmDemo2.setVisible(false);
				//set current frame
				contentPane.add(frmQLDV);
				frmQLDV.setVisible(true);
				break;
                                
                        	
			case 4:
				//close another frame
				frmLogin.setVisible(false);
				frmRegister.setVisible(false);
                                frmQLDV.setVisible(false);
                                
				//set current frame
				contentPane.add(frmDemo2);
				frmDemo2.setVisible(true);
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
				
//				contentPane.add(frmLogin);
//				frmLogin.setVisible(true);
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
		
                //DEMO
                JMenuItem mntmDemo = new JMenuItem("Demo");
		mntmDemo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controlFrame(FRM_DEMO);
				
			}
		});
		mnNewMenu.add(mntmDemo);
		
                
                
                
		JMenuItem mntmit = new JMenuItem("Eixt");
		mnNewMenu.add(mntmit);
		
		JMenu mnDichVu = new JMenu("Dich Vu");
		menuBar.add(mnDichVu);
		
		JMenuItem mntmQuanLyDich = new JMenuItem("Quan Ly Dich Vu");
		mntmQuanLyDich.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlFrame(FRM_QLDV);
				
			}
		});
		mnDichVu.add(mntmQuanLyDich);
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