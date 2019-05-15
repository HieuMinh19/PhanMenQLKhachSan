package QuanLyKS_GUI;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;

import java.awt.Label;
import java.awt.TextField;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import QuanLyKS_BUS.NhanVien_BUS;
import QuanLyKS_DTO.NhanVien_DTO;
import java.awt.ScrollPane;

public class frmTimKiemNV extends JInternalFrame {
	
	private NhanVien_BUS bus;
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
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		bus=new NhanVien_BUS();
		
		Label label = new Label("Tim kiem thong tin");
		label.setBounds(146, 10, 160, 24);
		getContentPane().add(label);
		
		TextField txtNhap = new TextField();
		txtNhap.setBounds(37, 63, 247, 24);
		getContentPane().add(txtNhap);
		
		JScrollPane scrListThongTin = new JScrollPane();
		scrListThongTin.setBounds(37, 113, 247, 123);
		getContentPane().add(scrListThongTin);
		
		
		Button btnTimKiem = new Button("Tim kiem");
		btnTimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<NhanVien_DTO> dsnv = bus.SearchNV(txtNhap.getText());
				System.err.println(dsnv.size());
				JList tb = new JList(dsnv.toArray());
				scrListThongTin.setViewportView(tb);
			}
		});
		btnTimKiem.setBounds(315, 63, 79, 24);
		getContentPane().add(btnTimKiem);

	}
}
