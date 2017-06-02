package cveditor.infos;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import cveditor.errormessage.DateError;
import cveditor.manager.CVManager;
import cveditor.manager.CheckDate;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class EducationAndTraining  {
	
	private JFrame frmEducationAndTraining;
	private JTable table = new JTable();
	private DefaultTableModel model;
	private CVManager cv;
	private DateError error;
	/**
	 * Launch the application.
	 */
	public void getEducationAndTraining() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EducationAndTraining window = new EducationAndTraining(model,cv);
					window.frmEducationAndTraining.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});	
	}	
	
	
	/**
	 * Create the application.
	 */
	public EducationAndTraining(DefaultTableModel model,CVManager cv) {
		this.model=model;
		this.table.setModel(this.model);
		this.cv = cv;
		initialize();
	}
	
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEducationAndTraining = new JFrame();
		frmEducationAndTraining.setTitle("EDUCATIONAL AND TRAINING");
		frmEducationAndTraining.setBounds(100, 100, 450, 300);
		frmEducationAndTraining.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		frmEducationAndTraining.getContentPane().add(panel, BorderLayout.SOUTH);
	
		
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				if(CheckDate.getDate(model,model.getColumnCount()-1)){
					cv.setEducationAndTraining(model);//we store the items in manager for future use
					frmEducationAndTraining.setVisible(false);
				}
				else{
					error = new DateError();
					error.getDateError();
				}
				
			}
		});
		panel.add(btnOk);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmEducationAndTraining.setVisible(false);
			}
		});
		panel.add(btnCancel);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(new Object[]{});
			}
		});
		panel.add(btnAdd);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.removeRow(model.getRowCount()-1);
			}
		});
		panel.add(btnDelete);
		
		JPanel panel1 = new JPanel();
		frmEducationAndTraining.getContentPane().add(panel1, BorderLayout.CENTER);
		

		panel1.add(table.getTableHeader(), BorderLayout.NORTH);
		panel1.add(table, BorderLayout.CENTER);
		
	}
}
