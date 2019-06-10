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
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;

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
		setBounds(100, 100, 900, 700);
		getContentPane().setLayout(null);
		bus=new NhanVien_BUS();
		
		JScrollPane scrListThongTin = new JScrollPane();
		scrListThongTin.setBounds(98, 238, 691, 339);
		getContentPane().add(scrListThongTin);

		JTextArea txtTenNhanVien = new JTextArea();
		txtTenNhanVien.setFont(new Font("Monospaced", Font.PLAIN, 16));
		txtTenNhanVien.setBounds(166, 82, 150, 30);
		getContentPane().add(txtTenNhanVien);
		
		JDateChooser dtNgayVaoLam = new JDateChooser();
		dtNgayVaoLam.setDateFormatString("dd/MM/yyyy");
		dtNgayVaoLam.setBounds(564, 82, 150, 30);
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
		
		JButton btnTimKiem = new JButton("T\u00ECm ki\u1EBFm");
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
		btnTimKiem.setBackground(Color.GREEN);
		btnTimKiem.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnTimKiem.setBounds(351, 138, 150, 40);
		getContentPane().add(btnTimKiem);
		
		JLabel lblNewLabel = new JLabel("H\u1ECD t\u00EAn");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(98, 81, 56, 27);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("V\u00E0o l\u00E0m tr\u01B0\u1EDBc ng\u00E0y");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(397, 79, 155, 30);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Tra c\u1EE9u th\u00F4ng tin nh\u00E2n vi\u00EAn");
		lblNewLabel_2.setForeground(Color.BLUE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_2.setBounds(275, 13, 322, 37);
		getContentPane().add(lblNewLabel_2);
		
		
		
		
		
	}
}
