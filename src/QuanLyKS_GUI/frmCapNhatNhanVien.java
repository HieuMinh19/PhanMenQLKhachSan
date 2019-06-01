package QuanLyKS_GUI;

import java.awt.Button;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Properties;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import Utility.DateLabelFormatter;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import org.jdatepicker.util.JDatePickerUtil;

import QuanLyKS_BUS.NhanVien_BUS;
import QuanLyKS_DTO.NhanVien_DTO;

import org.jdatepicker.DateModel;
import org.jdatepicker.impl.DateComponentFormatter;
import javax.swing.SpringLayout;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.sql.Date;
import java.awt.event.ActionEvent;

public class frmCapNhatNhanVien extends JInternalFrame {
	private JTextField txtTenNhanVien;
	private JTextField txtCMND;
	private SpringLayout springLayout;
	private SpringLayout sl_jdpNgayVaoLam;
	private JTable table;
	private NhanVien_BUS bus;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmCapNhatNhanVien frame = new frmCapNhatNhanVien();
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
	public frmCapNhatNhanVien() {
		bus=new NhanVien_BUS();
		setBounds(100, 100, 770, 596);
		getContentPane().setLayout(null);
		
		txtTenNhanVien = new JTextField();
		txtTenNhanVien.setColumns(10);
		txtTenNhanVien.setBounds(214, 219, 320, 20);
		getContentPane().add(txtTenNhanVien);
		
		txtCMND = new JTextField();
		txtCMND.setColumns(10);
		txtCMND.setBounds(214, 277, 320, 20);
		getContentPane().add(txtCMND);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(214, 326, 320, 20);
		getContentPane().add(comboBox);
		
		JLabel label = new JLabel("T\u00EAn nh\u00E2n vi\u00EAn");
		label.setBounds(54, 218, 122, 22);
		getContentPane().add(label);
		
		JLabel label_1 = new JLabel("CMND");
		label_1.setBounds(54, 276, 75, 22);
		getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("Ch\u1EE9c v\u1EE5");
		label_2.setBounds(54, 325, 63, 22);
		getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("Ng\u00E0y v\u00E0o l\u00E0m");
		label_3.setBounds(54, 379, 122, 22);
		getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("Ng\u00E0y sinh");
		label_4.setBounds(54, 438, 108, 22);
		getContentPane().add(label_4);
		
		
		JButton btnCapNhat = new JButton("Cap Nhat");
		btnCapNhat.setBounds(269, 501, 219, 25);
		getContentPane().add(btnCapNhat);
		
		JButton btnXoa = new JButton("Xoa");
		btnXoa.setBounds(573, 476, 98, 71);
		getContentPane().add(btnXoa);
		
		UtilDateModel model = new UtilDateModel();
		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
		JDatePickerImpl jdpNgayVaoLam = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		sl_jdpNgayVaoLam = (SpringLayout) jdpNgayVaoLam.getLayout();
		jdpNgayVaoLam.setSize(320, 25);
		jdpNgayVaoLam.setLocation(214, 438);
		getContentPane().add(jdpNgayVaoLam);

		UtilDateModel model2 = new UtilDateModel();
		Properties p2 = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		JDatePanelImpl datePanel2 = new JDatePanelImpl(model2, p2);
		JDatePickerImpl jdpNgaySinh = new JDatePickerImpl(datePanel2, new DateLabelFormatter());
		jdpNgaySinh.setSize(320, 25);
		jdpNgaySinh.setLocation(214, 435);
		sl_jdpNgayVaoLam = (SpringLayout) jdpNgayVaoLam.getLayout();
		jdpNgayVaoLam.setSize(320, 25);
		jdpNgayVaoLam.setLocation(214, 379);
		getContentPane().add(jdpNgaySinh);

		JScrollPane srcListNhanVien = new JScrollPane();
		srcListNhanVien.setBounds(65, 25, 605, 123);
		getContentPane().add(srcListNhanVien);
		
		DefaultTableModel m = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"MaNhanVien", "TenNhanVien", "NgaySinh", "CMND", "NgayVaoLam"
			}
		);
		table = new JTable(m);
		ListSelectionModel cellSelectionModel = table.getSelectionModel();
	    cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	    cellSelectionModel.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
			    String selectedData = null;
			
			    int[] selectedRow = table.getSelectedRows();
			    int[] selectedColumns = table.getSelectedColumns();
			
			    for (int i = 0; i < selectedRow.length; i++) {
			    	System.out.println(selectedColumns.length);
			        txtTenNhanVien.setText((String) table.getValueAt(selectedRow[i], 1));
			        txtCMND.setText(table.getValueAt(selectedRow[i], 3).toString());
			        Date d = (Date) table.getValueAt(selectedRow[i], 4);
//			        jdpNgaySinh.((Date) table.getValueAt(selectedRow[i], 2));
			        model.setDate(1991,2,2);
//			        jdpNgayVaoLam.setText((Date) table.getValueAt(selectedRow[i], 4));
			    }
			  }

        });
		table.setRowSelectionAllowed(true);
		srcListNhanVien.setViewportView(table);
		JButton btnLoadDanhSach = new JButton("Load Danh Sach Nhan Vien");
		btnLoadDanhSach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (m.getRowCount() > 0) {
				    for (int i = m.getRowCount() - 1; i > -1; i--) {
				        m.removeRow(i);
				    }
				}
				ArrayList<NhanVien_DTO> dsnv = bus.LoadListNV();
				dsnv.forEach(nv -> m.addRow(new Object[]{nv.getMaNhanVien(), nv.getTenNhanVien(),nv.getNgaySinh(), nv.getCMND(),nv.getNgayVaoLam()}));
			}
		}); 
		btnLoadDanhSach.setBounds(257, 163, 202, 25);
		getContentPane().add(btnLoadDanhSach);
	}
}
