package QuanLyKS_GUI;
import java.awt.EventQueue;

import java.util.ArrayList;
import javax.swing.JInternalFrame;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

import QuanLyKS_DTO.ChucVu_DTO;
import QuanLyKS_DTO.DichVu_DTO;
import QuanLyKS_DTO.NhanVien_DTO;
import net.proteanit.sql.DbUtils;

import QuanLyKS_BUS.DichVu_BUS;
import QuanLyKS_BUS.NhanVien_BUS;

import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.Font;
import java.awt.Color;

public class QLDichVu extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table_2;
	private JTextField txtTenDichVu;
	private JTable table;
	ArrayList<DichVu_DTO> listDV_DTO =  new ArrayList<DichVu_DTO>();
	static DichVu_BUS dvBus = new DichVu_BUS();	
	public static ResultSet DV = dvBus.selectAll(); 
	private DichVu_DTO dichvu_DTO;
	private JTextField txtGiaDichVu;
	private DichVu_BUS bus;
	private ArrayList<DichVu_DTO> dsnv;
	private int selectedMaNhanVien;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QLDichVu frame = new QLDichVu();
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
	public QLDichVu() {
		bus=new DichVu_BUS();
		dsnv = new ArrayList<DichVu_DTO>();
		setBounds(100, 100, 900, 700);
		getContentPane().setLayout(null);
		JScrollPane scrListDV = new JScrollPane();
		scrListDV.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
			
			}
		});
		scrListDV.setBounds(31, 115, 391, 189);
		getContentPane().add(scrListDV);
		
		DefaultTableModel m = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Mã dịch vụ", "Tên dịch vụ", "Giá dịch vụ"
				}
			);
		table = new JTable(m);
		ListSelectionModel cellSelectionModel = table.getSelectionModel();
	    cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	    cellSelectionModel.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {	
				int[] selectedRowColums = table.getSelectedRows();	
			    for (int i = 0; i < selectedRowColums.length; i++) {
			    	selectedMaNhanVien = (int) table.getValueAt(selectedRowColums[i], 0);
			        txtTenDichVu.setText((String) table.getValueAt(selectedRowColums[i], 1));
			        txtGiaDichVu.setText(table.getValueAt(selectedRowColums[i], 2).toString());
			    }		
			  }
        });
	    scrListDV.setViewportView(table);
		JButton btnLoadData = new JButton("Danh sách dịch vụ");
		btnLoadData.setBackground(Color.GREEN);
		btnLoadData.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnLoadData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (m.getRowCount() > 0) {
				    for (int i = m.getRowCount() - 1; i > -1; i--) {
				        m.removeRow(i);
				    }
				}
				dsnv = bus.LoadListDV();
				dsnv.forEach(nv -> m.addRow(new Object[]{nv.getMaDichVu(), nv.getTenDichVu(),nv.getGiaDichVu()}));
			}
		});
		btnLoadData.setBounds(125, 333, 200, 40);
		getContentPane().add(btnLoadData);
		
		JLabel lblTnDchVu = new JLabel("T\u00EAn d\u1ECBch v\u1EE5");
		lblTnDchVu.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTnDchVu.setBounds(486, 170, 93, 30);
		getContentPane().add(lblTnDchVu);
		
		txtTenDichVu = new JTextField();
		txtTenDichVu.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtTenDichVu.setBounds(591, 170, 170, 30);
		getContentPane().add(txtTenDichVu);
		txtTenDichVu.setColumns(10);
		
		JButton btnUpdate = new JButton("Cập nhật");
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnUpdate.setBackground(Color.ORANGE);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Integer GiaDichVu =	Integer.parseInt(txtGiaDichVu.getText());
				boolean result = DichVu_BUS.Update(new DichVu_DTO(selectedMaNhanVien, txtTenDichVu.getText(),GiaDichVu ));
				if(result) {
					if (m.getRowCount() > 0) {
					    for (int i = m.getRowCount() - 1; i > -1; i--) {
					        m.removeRow(i);
					    }
					}
					dsnv = bus.LoadListDV();
					dsnv.forEach(nv -> m.addRow(new Object[]{nv.getMaDichVu(), nv.getTenDichVu(),nv.getGiaDichVu()}));
				}

			}
		});
		btnUpdate.setBounds(518, 333, 150, 40);
		getContentPane().add(btnUpdate);

		txtGiaDichVu = new JTextField();
		txtGiaDichVu.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtGiaDichVu.setColumns(10);
		txtGiaDichVu.setBounds(591, 237, 170, 30);
		getContentPane().add(txtGiaDichVu);

		JLabel lblGiaDichVu = new JLabel("Giá dịch vụ");
		lblGiaDichVu.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblGiaDichVu.setBounds(491, 239, 88, 27);
		getContentPane().add(lblGiaDichVu);

		JButton btndelete = new JButton("Xóa");
		btndelete.setFont(new Font("Tahoma", Font.BOLD, 18));
		btndelete.setBackground(Color.ORANGE);
		btndelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean result = DichVu_BUS.Delete(selectedMaNhanVien);
				if(result) {
					if (m.getRowCount() > 0) {
					    for (int i = m.getRowCount() - 1; i > -1; i--) {
					        m.removeRow(i);
					    }
					}
					dsnv = bus.LoadListDV();
					dsnv.forEach(nv -> m.addRow(new Object[]{nv.getMaDichVu(), nv.getTenDichVu(),nv.getGiaDichVu()}));
				}
			}
		});
		btndelete.setBounds(680, 333, 150, 40);
		getContentPane().add(btndelete);
		
		JLabel label = new JLabel("Tra cứu thông tin nhân viên");
		label.setForeground(Color.BLUE);
		label.setFont(new Font("Tahoma", Font.PLAIN, 25));
		label.setBounds(253, 13, 322, 37);
		getContentPane().add(label);
	}
}
