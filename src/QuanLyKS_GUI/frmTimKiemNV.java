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
import com.toedter.calendar.JDateChooser;
import javax.swing.JTextArea;

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
		
		JScrollPane scrListThongTin = new JScrollPane();
		scrListThongTin.setBounds(37, 308, 691, 123);
		getContentPane().add(scrListThongTin);

		JTextArea txtTenNhanVien = new JTextArea();
		txtTenNhanVien.setBounds(146, 63, 234, 52);
		getContentPane().add(txtTenNhanVien);
		
		JDateChooser dtNgayVaoLam = new JDateChooser();
		dtNgayVaoLam.setBounds(146, 128, 234, 46);
		getContentPane().add(dtNgayVaoLam);
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
				System.err.println("txt Nhap"+ txtTenNhanVien.getText());
				System.err.println("dt Ngay Vao Lam"+ dtNgayVaoLam.getDate());
				ArrayList<NhanVien_DTO> dsnv = bus.SearchNV(txtTenNhanVien.getText(), new Date(dtNgayVaoLam.getDate().getTime()));
				dsnv.forEach(nv -> m.addRow(new Object[]{nv.getMaNhanVien(), nv.getTenNhanVien(),nv.getNgaySinh(), nv.getCMND(),nv.getNgayVaoLam()}));
			}
		}); 
		//-----------------------------------------------------------------------
		
		btnTimKiem.setBounds(451, 96, 110, 61);
		getContentPane().add(btnTimKiem);
		
		
		
		
		
	}
}
