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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

import QuanLyKS_DTO.DichVu_DTO;
import net.proteanit.sql.DbUtils;

import QuanLyKS_BUS.DichVu_BUS;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class QLDichVu extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table_2;
	private JTextField txtTenDichVu;
	
	
	ArrayList<DichVu_DTO> listDV_DTO =  new ArrayList<DichVu_DTO>();
	static DichVu_BUS dvBus = new DichVu_BUS();	
	public static ResultSet DV = dvBus.selectAll();
	private DichVu_DTO dichvu_DTO;
	private JTextField txtGiaDichVu;
	
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
		setBounds(100, 100, 1009, 512);
		getContentPane().setLayout(null);

		JScrollPane scrListDV = new JScrollPane();
		JComboBox<Object> cbxMaDV = new javax.swing.JComboBox<>();
		cbxMaDV.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				int idDV = Integer.parseInt( ( (String) cbxMaDV.getSelectedItem() ));
				for(int i = 0; i < listDV_DTO.size(); i++) {
        			DichVu_DTO dvCompare = listDV_DTO.get(i);
        			if(idDV == dvCompare.getMaDichVu())
        				txtTenDichVu.setText(dvCompare.getTenDichVu());
        				txtGiaDichVu.setText( String.valueOf(dvCompare.getGiaDichVu() ) );
        		}
			}
		});
		
		scrListDV.addMouseListener(new MouseAdapter() {
			 
			public void mouseClicked(MouseEvent e) {
			
			}
		});
		scrListDV.setBounds(276, 40, 270, 163);
		getContentPane().add(scrListDV);
		
		table_2 = new JTable();
		scrListDV.setViewportView(table_2);
		
		JButton btnLoadData = new JButton("Load list Service");
		btnLoadData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ResultSet listDV = dvBus.selectAll();
				ResultSet subList = dvBus.selectAll();
								
				if(listDV != null) {
					table_2.setModel(DbUtils.resultSetToTableModel(listDV));
				}else {
					JOptionPane.showMessageDialog(null, "get List Services not success", "Error: " + "error Mesage", JOptionPane.CLOSED_OPTION);
				}
				//load list MaDV from db
				 try {
			        	while(subList.next()) {
			        		DichVu_DTO dvItem = new DichVu_DTO(subList.getInt("MaDichVu"), subList.getString("TenDichVu"),subList.getInt("GiaDichVu"));
			        		listDV_DTO.add(dvItem);  		
			        		cbxMaDV.addItem(subList.getString("MaDichVu"));
			        		cbxMaDV.getSelectedItem();			        		
					   }		  
				} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		});
		btnLoadData.setBounds(341, 214, 109, 30);
		getContentPane().add(btnLoadData);
		
		JLabel lblMadichvu = new JLabel("M\u00E3 d\u1ECBch v\u1EE5");
		lblMadichvu.setBounds(27, 59, 59, 14);
		getContentPane().add(lblMadichvu);
		
		JLabel lblTnDchVu = new JLabel("T\u00EAn d\u1ECBch v\u1EE5");
		lblTnDchVu.setBounds(27, 101, 59, 14);
		getContentPane().add(lblTnDchVu);
		
		txtTenDichVu = new JTextField();
		txtTenDichVu.setBounds(96, 98, 142, 20);
		getContentPane().add(txtTenDichVu);
		txtTenDichVu.setColumns(10);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dichvu_DTO = new DichVu_DTO( ); 

				dichvu_DTO.setTenDichVu( txtTenDichVu.getText() );
				dichvu_DTO.setGiaDichVu( Integer.parseInt(txtGiaDichVu.getText()));
					 if(  DichVu_BUS.Update(dichvu_DTO) == true)
						 JOptionPane.showMessageDialog(null, "Update Dich Vu Success", "Success: " + "Success Mesage", JOptionPane.INFORMATION_MESSAGE);
					 else
						 JOptionPane.showMessageDialog(null, "Update Dich Vu Fail", "Fail: " + "Success Mesage", JOptionPane.CLOSED_OPTION);

			}
		});
		btnUpdate.setBounds(81, 203, 89, 23);
		getContentPane().add(btnUpdate);
		
		JButton btnSelect = new JButton("Select");
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnSelect.setBounds(198, 218, 89, 23);
		getContentPane().add(btnSelect);
		
		cbxMaDV.setBounds(96, 56, 142, 20);
		getContentPane().add(cbxMaDV);

		txtGiaDichVu = new JTextField();
		txtGiaDichVu.setColumns(10);
		txtGiaDichVu.setBounds(96, 144, 142, 20);
		getContentPane().add(txtGiaDichVu);

		JLabel lblGiaDichVu = new JLabel("Gia Dich Vu");
		lblGiaDichVu.setBounds(27, 147, 109, 14);
		getContentPane().add(lblGiaDichVu);

		JButton btndelete = new JButton("Delete");
		btndelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dichvu_DTO = new DichVu_DTO( ); 		
					 if(  DichVu_BUS.Delete(dichvu_DTO) == true)
						 JOptionPane.showMessageDialog(null, "Update Dich Vu Success", "Success: " + "Success Mesage", JOptionPane.INFORMATION_MESSAGE);
					 else
						 JOptionPane.showMessageDialog(null, "Update Dich Vu Fail", "Fail: " + "Success Mesage", JOptionPane.CLOSED_OPTION);
			}
		});
		btndelete.setBounds(184, 254, 134, 38);
		getContentPane().add(btndelete);
	}
}
