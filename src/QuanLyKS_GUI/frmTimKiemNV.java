package QuanLyKS_GUI;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.awt.Label;
import java.awt.TextField;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionEvent;
import QuanLyKS_BUS.NhanVien_BUS;
import QuanLyKS_DTO.NhanVien_DTO;
import java.awt.ScrollPane;
import javax.swing.JButton;
import com.toedter.calendar.JCalendar;

public class frmTimKiemNV extends JInternalFrame {
	
	private NhanVien_BUS bus;
	private JTable table;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmTimKiemNV frame = new frmTimKiemNV();
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
	public frmTimKiemNV() {
		setBounds(100, 100, 781, 480);
		getContentPane().setLayout(null);
		bus=new NhanVien_BUS();
		
		Label label = new Label("Tim kiem thong tin");
		label.setBounds(296, 10, 160, 24);
		getContentPane().add(label);
		
		TextField txtNhap = new TextField();
		txtNhap.setBounds(157, 63, 247, 24);
		getContentPane().add(txtNhap);
		
		JScrollPane scrListThongTin = new JScrollPane();
		scrListThongTin.setBounds(37, 308, 605, 123);
		getContentPane().add(scrListThongTin);

		JCalendar calendar = new JCalendar();
		calendar.setBounds(167, 117, 198, 153);
		getContentPane().add(calendar);

		
		//------------------------------add table-------------------------------
		DefaultTableModel m = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"MaNhanVien", "TenNhanVien", "NgaySinh", "CMND", "NgayVaoLam"
			}
		);
		table = new JTable(m);
		scrListThongTin.setViewportView(table);
		Button btnTimKiem = new Button("Tim kiem");
		btnTimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (m.getRowCount() > 0) {
				    for (int i = m.getRowCount() - 1; i > -1; i--) {
				        m.removeRow(i);
				    }
				}
				ArrayList<NhanVien_DTO> dsnv = bus.SearchNV(txtNhap.getText(), new Date(calendar.getDate().getTime()));
				dsnv.forEach(nv -> m.addRow(new Object[]{nv.getMaNhanVien(), nv.getTenNhanVien(),nv.getNgaySinh(), nv.getCMND(),nv.getNgayVaoLam()}));
			}
		}); 
		//-----------------------------------------------------------------------
		
		btnTimKiem.setBounds(440, 63, 79, 24);
		getContentPane().add(btnTimKiem);
		
	}
}
