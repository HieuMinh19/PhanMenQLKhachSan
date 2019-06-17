package QuanLyKS_GUI;

import java.awt.EventQueue;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import QuanLyKS_BUS.BangPhanCong_BUS;
import QuanLyKS_BUS.ChucVu_BUS;
import QuanLyKS_BUS.LoaiPhong_BUS;
import QuanLyKS_BUS.Phong_BUS;
import QuanLyKS_DTO.ChucVu_DTO;
import QuanLyKS_DTO.DichVu_DTO;
import QuanLyKS_DTO.LoaiPhong_DTO;
import QuanLyKS_DTO.NhanVien_DTO;
import QuanLyKS_DTO.Phong_DTO;
import net.proteanit.sql.DbUtils;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.Color;

public class frmDanhSachPhong extends JInternalFrame {
	private JTable table;
	private LoaiPhong_BUS bus;
	private Phong_BUS pbus;
	private int selectedMaPhong;
//	private LoaiPhong_BUS cv_bus;
	private JTextField txtMaPhong;
	private int iMaPhong = 0;
	private ArrayList<Phong_DTO> dsp;
	private ArrayList<LoaiPhong_DTO> dscv;
	private int selectTenLoaiPhongIndex;
	private int selectedRow;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmDanhSachPhong frame = new frmDanhSachPhong();
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
	public frmDanhSachPhong() {
		bus = new LoaiPhong_BUS();
		pbus = new Phong_BUS();
		//cv_bus = new ChucVu_BUS();
		setBounds(100, 100, 900, 700);
		getContentPane().setLayout(null);

		JComboBox cbLoaiPhong = new JComboBox();
		cbLoaiPhong.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cbLoaiPhong.setBounds(649, 266, 191, 30);
		getContentPane().add(cbLoaiPhong);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(94, 107, 365, 250);
		getContentPane().add(scrollPane);

		table = new JTable();
		scrollPane.setColumnHeaderView(table);

		DefaultTableModel m = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Mã Phòng", "Tên Loại Phòng"
				}
			);
		table = new JTable(m);
		ListSelectionModel cellSelectionModel = table.getSelectionModel();
	    cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	    cellSelectionModel.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {

			selectedRow = table.getSelectedRow() < 0 ? 0 : table.getSelectedRow();
		    int[] selectedRowColums = table.getSelectedRows();
		
		    for (int i = 0; i < selectedRowColums.length; i++) {
		    	selectedMaPhong = (int) table.getValueAt(selectedRowColums[i], 0);
		        txtMaPhong.setText(table.getValueAt(selectedRowColums[i], 0).toString());
		        iMaPhong = Integer.parseInt( txtMaPhong.getText() );
		        selectTenLoaiPhongIndex = dscv.indexOf(dsp.get(selectedRow).getLoaiPhong());
			    cbLoaiPhong.setSelectedIndex(selectTenLoaiPhongIndex);
		        cbLoaiPhong.setSelectedItem(dsp.get(selectedRow).getLoaiPhong());
		    }
		   
			}
        });
		table.setRowSelectionAllowed(true);
		scrollPane.setViewportView(table);
		
		dscv = LoaiPhong_BUS.selectAll();
		dscv.forEach(cv -> cbLoaiPhong.addItem(cv.getTenLoaiPhong()));
		
		JButton btnLoadListPhong = new JButton("Danh s\u00E1ch ph\u00F2ng");
		btnLoadListPhong.setBackground(Color.GREEN);
		btnLoadListPhong.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnLoadListPhong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (m.getRowCount() > 0) {
				    for (int i = m.getRowCount() - 1; i > -1; i--) {
				        m.removeRow(i);
				    }
				}
				dsp = Phong_BUS.LoadListPhong();
				dsp.forEach(p -> m.addRow(new Object[]{p.getMaPhong(), p.getLoaiPhong()}));
				
			}
		});
		btnLoadListPhong.setBounds(109, 385, 222, 40);
		getContentPane().add(btnLoadListPhong);
		
		txtMaPhong = new JTextField();
		txtMaPhong.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtMaPhong.setBounds(649, 203, 191, 30);
		getContentPane().add(txtMaPhong);
		txtMaPhong.setColumns(10);
		
		JLabel lblMaphong = new JLabel("M\u00E3 ph\u00F2ng");
		lblMaphong.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMaphong.setBounds(543, 211, 79, 22);
		getContentPane().add(lblMaphong);
		
		JLabel lblLoaiPhong = new JLabel("T\u00EAn lo\u1EA1i ph\u00F2ng");
		lblLoaiPhong.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblLoaiPhong.setBounds(503, 269, 119, 22);
		getContentPane().add(lblLoaiPhong);
		
		JButton btnCapNhat = new JButton("C\u1EADp nh\u1EADt");
		btnCapNhat.setBackground(Color.ORANGE);
		btnCapNhat.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnCapNhat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println( cbLoaiPhong.getSelectedItem() );
				ArrayList<LoaiPhong_DTO> listLP = LoaiPhong_BUS.LoadListLP();
				int iMaLoaiPhong = 0;
				
				for(int i = 0; i < listLP.size(); i++)
					if(listLP.get(i).getTenLoaiPhong().equals( cbLoaiPhong.getSelectedItem().toString()))						
						iMaLoaiPhong = listLP.get(i).getMaLoaiPhong();
				
				boolean result = Phong_BUS.Update(new Phong_DTO(Integer.parseInt(txtMaPhong.getText()),iMaLoaiPhong), iMaPhong);
				
				
			}
		});
		btnCapNhat.setBounds(503, 385, 150, 40);
		getContentPane().add(btnCapNhat);
		
		JButton btnXoa = new JButton("X\u00F3a");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean result = Phong_BUS.Delete(selectedMaPhong);
				if(result) {
					if (m.getRowCount() > 0) {
					    for (int i = m.getRowCount() - 1; i > -1; i--) {
					        m.removeRow(i);
					    }
					}
					dsp = Phong_BUS.LoadListPhong();
					dsp.forEach(p -> m.addRow(new Object[]{p.getMaPhong(), p.getLoaiPhong()}));
				}
			}
		});
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnXoa.setBackground(Color.ORANGE);
		btnXoa.setBounds(690, 385, 150, 40);
		getContentPane().add(btnXoa);
		
		
		
		JLabel lblQunLPhng = new JLabel("Qu\u1EA3n l\u00FD ph\u00F2ng");
		lblQunLPhng.setForeground(Color.BLUE);
		lblQunLPhng.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblQunLPhng.setBounds(351, 13, 185, 42);
		getContentPane().add(lblQunLPhng);

	}
}