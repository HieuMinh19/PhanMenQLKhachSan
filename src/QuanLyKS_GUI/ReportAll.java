package QuanLyKS_GUI;

import java.awt.EventQueue;
import java.util.*;

import javax.swing.JInternalFrame;

public class ReportAll extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReportAll frame = new ReportAll();
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
	public ReportAll() {
		setBounds(100, 100, 450, 300);

	}

}
