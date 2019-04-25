package QuanLyKS_GUI;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;

import QuanLyKS_GUI.Login;
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
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
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
				Login frmLogin = new Login();
				contentPane.add(frmLogin);
				frmLogin.setVisible(true);
			}
		});
		mnNewMenu.add(mntmLogout);		
		JMenuItem mntmRegister = new JMenuItem("Register");
		mntmRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Register frmRegister = new Register();
				contentPane.add(frmRegister);
				frmRegister.setVisible(true);
			}
		});
		mnNewMenu.add(mntmRegister);
		
		JMenuItem mntmit = new JMenuItem("Eixt");
		mnNewMenu.add(mntmit);
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