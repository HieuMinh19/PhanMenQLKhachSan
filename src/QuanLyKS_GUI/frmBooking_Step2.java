package QuanLyKS_GUI;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JEditorPane;
import javax.swing.JButton;

public class frmBooking_Step2 extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmBooking_Step2 frame = new frmBooking_Step2();
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
	public frmBooking_Step2() {
		setBounds(100, 100, 810, 540);
		getContentPane().setLayout(null);
		
		JEditorPane edDV01 = new JEditorPane();
		edDV01.setBounds(53, 73, 235, 30);
		getContentPane().add(edDV01);
		
		JEditorPane edDV02 = new JEditorPane();
		edDV02.setBounds(53, 134, 235, 30);
		getContentPane().add(edDV02);
		
		JEditorPane edDV03 = new JEditorPane();
		edDV03.setBounds(53, 201, 235, 30);
		getContentPane().add(edDV03);
		
		JEditorPane edDV04 = new JEditorPane();
		edDV04.setBounds(53, 266, 235, 30);
		getContentPane().add(edDV04);
		
		JEditorPane edDV05 = new JEditorPane();
		edDV05.setBounds(53, 335, 235, 30);
		getContentPane().add(edDV05);
		
		JEditorPane edGiaDV01 = new JEditorPane();
		edGiaDV01.setBounds(325, 73, 128, 30);
		getContentPane().add(edGiaDV01);
		
		JEditorPane edGiaDV02 = new JEditorPane();
		edGiaDV02.setBounds(325, 134, 128, 30);
		getContentPane().add(edGiaDV02);
		
		JEditorPane edGiaDV03 = new JEditorPane();
		edGiaDV03.setBounds(325, 201, 128, 30);
		getContentPane().add(edGiaDV03);
		
		JEditorPane edGiaDV04 = new JEditorPane();
		edGiaDV04.setBounds(325, 266, 128, 30);
		getContentPane().add(edGiaDV04);
		
		JEditorPane edGiaDV05 = new JEditorPane();
		edGiaDV05.setBounds(325, 335, 128, 30);
		getContentPane().add(edGiaDV05);
		
		JButton btnRemove01 = new JButton("Remove");
		btnRemove01.setBounds(662, 73, 84, 30);
		getContentPane().add(btnRemove01);
		
		JButton btnRemove02 = new JButton("Remove");
		btnRemove02.setBounds(662, 134, 84, 30);
		getContentPane().add(btnRemove02);
		
		JButton btnRemove03 = new JButton("Remove");
		btnRemove03.setBounds(662, 201, 84, 30);
		getContentPane().add(btnRemove03);
		
		JButton btnRemove04 = new JButton("Remove");
		btnRemove04.setBounds(662, 266, 84, 30);
		getContentPane().add(btnRemove04);
		
		JButton btnRemove05 = new JButton("Remove");
		btnRemove05.setBounds(662, 335, 84, 30);
		getContentPane().add(btnRemove05);
		
		JButton btnAddDV01 = new JButton("Add");
		btnAddDV01.setBounds(566, 73, 84, 30);
		getContentPane().add(btnAddDV01);
		
		JButton btnAddDV02 = new JButton("Add");
		btnAddDV02.setBounds(566, 134, 84, 30);
		getContentPane().add(btnAddDV02);
		
		JButton btnAddDV03 = new JButton("Add");
		btnAddDV03.setBounds(566, 201, 84, 30);
		getContentPane().add(btnAddDV03);
		
		JButton btnAddDV05 = new JButton("Add");
		btnAddDV05.setBounds(566, 266, 84, 30);
		getContentPane().add(btnAddDV05);
		
		JButton button_3 = new JButton("Add");
		button_3.setBounds(566, 335, 84, 30);
		getContentPane().add(button_3);
		
		JButton btnContinue = new JButton("Continue");
		btnContinue.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnContinue.setBounds(373, 418, 180, 45);
		getContentPane().add(btnContinue);
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnBack.setBounds(81, 418, 180, 45);
		getContentPane().add(btnBack);
		
		JLabel lblDichVu = new JLabel("SERVICE");
		lblDichVu.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblDichVu.setBounds(259, 13, 135, 30);
		getContentPane().add(lblDichVu);

	}
}
