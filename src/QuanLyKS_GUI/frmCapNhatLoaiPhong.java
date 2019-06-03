package QuanLyKS_GUI;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class frmCapNhatLoaiPhong extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmCapNhatLoaiPhong frame = new frmCapNhatLoaiPhong();
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
	public frmCapNhatLoaiPhong() {
		setBounds(100, 100, 450, 300);

	}

}
