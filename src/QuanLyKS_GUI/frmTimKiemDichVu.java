package QuanLyKS_GUI;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class frmTimKiemDichVu extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmTimKiemDichVu frame = new frmTimKiemDichVu();
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
	public frmTimKiemDichVu() {
		setBounds(100, 100, 450, 300);

	}

}
