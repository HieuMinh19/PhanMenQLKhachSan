package QuanLyKS_GUI;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import com.toedter.calendar.JCalendar;

public class ThanhToan extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThanhToan frame = new ThanhToan();
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
	public ThanhToan() {
		setBounds(100, 100, 617, 424);
		getContentPane().setLayout(null);
		
		JCalendar calendar = new JCalendar();
		calendar.setBounds(215, 73, 198, 153);
		getContentPane().add(calendar);
	}
}
