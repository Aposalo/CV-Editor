package cveditor.infos.professionalexperience;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import cveditor.infos.ProfessionalExperience;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NewProfessionalExperience {

	private JFrame frmNew;
	private JTextField txtCompanyName;
	private JTextField textField;
	private JTextField txtJobTitle;
	private JTextField textField1;
	private JTextField txtDate;
	private JTextField textField2;
	private String choice;
	
	private String companyName;
	private String jobTitle;
	private String date;
	private int modelChosen;
	private String title;
	private DefaultTableModel model;
	
	private PageOfProfessionalExperience pageOfProfessionalExp;
	private ProfessionalExperience ProfessionalExp;

	/**
	 * Launch the application.
	 */
	public void getNewProfessionalExperience() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewProfessionalExperience window = new NewProfessionalExperience(ProfessionalExp,model,modelChosen,choice);
					window.frmNew.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public NewProfessionalExperience(ProfessionalExperience experience,DefaultTableModel model,int modelChosen,String choice) {
		this.ProfessionalExp = experience;
		this.model = model;
		this.choice=choice;
		this.modelChosen=modelChosen;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmNew = new JFrame();
		frmNew.setTitle("Add Profession");
		frmNew.setBounds(100, 100, 450, 300);
		frmNew.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frmNew.getContentPane().add(panel, BorderLayout.SOUTH);
		
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(choice.equals("New")){
					companyName = textField.getText();
					jobTitle = textField1.getText();
					date = textField2.getText();
					title = companyName+","+jobTitle+","+date;
					pageOfProfessionalExp = new PageOfProfessionalExperience(title,ProfessionalExp,model,null,modelChosen,"New");
					pageOfProfessionalExp.getPageOfProfessionalExperience();//we add stuff to the new page
				}
				else if(choice.equals("Edit")){
					companyName = textField.getText();
					jobTitle = textField1.getText();
					date = textField2.getText();
					title = companyName+","+jobTitle+","+date;
					ProfessionalExp.setPageOfProfessionalExperience(title, model, null, modelChosen, "Title");//we open the main page of ProfessionalExperience
				}
				frmNew.setVisible(false);
			}
		});
		panel.add(btnOk);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmNew.setVisible(false);
			}
		});
		panel.add(btnCancel);
		
		JPanel panel1 = new JPanel();
		frmNew.getContentPane().add(panel1, BorderLayout.CENTER);
		
		JPanel panel2 = new JPanel();
		panel1.add(panel2);
		
		txtCompanyName = new JTextField();
		txtCompanyName.setEditable(false);
		txtCompanyName.setText("Company Name");
		panel2.add(txtCompanyName);
		txtCompanyName.setColumns(10);
		
		textField = new JTextField();
		panel2.add(textField);
		textField.setColumns(10);
		
		JPanel panel3 = new JPanel();
		panel1.add(panel3);
		
		txtJobTitle = new JTextField();
		txtJobTitle.setEditable(false);
		txtJobTitle.setText("Job Title");
		panel3.add(txtJobTitle);
		txtJobTitle.setColumns(10);
		
		textField1 = new JTextField();
		panel3.add(textField1);
		textField1.setColumns(10);
		
		JPanel panel4 = new JPanel();
		panel1.add(panel4);
		
		txtDate = new JTextField();
		txtDate.setText("Date");
		txtDate.setEditable(false);
		panel4.add(txtDate);
		txtDate.setColumns(10);
		
		textField2 = new JTextField();
		panel4.add(textField2);
		textField2.setColumns(10);
	}

}
