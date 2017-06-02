package cveditor.infos;

import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import cveditor.errormessage.DateError;
import cveditor.infos.professionalexperience.NewProfessionalExperience;
import cveditor.infos.professionalexperience.PageOfProfessionalExperience;
import cveditor.manager.CVManager;
import cveditor.manager.CheckDate;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class ProfessionalExperience {

	private JFrame frmProfessionalExperience;
	
	private ProfessionalExperience professionalExp;//we send it to the other pages when we create or open on
													//so that when we finish with them we come back to the original
	private NewProfessionalExperience newProfessionalExp;//when we create a page
	private PageOfProfessionalExperience pageOfProfessionalExp;//we hold the page so that we can call it
	
	private ArrayList<String> titleList = new ArrayList<String>();
	private ArrayList<String> paragraphList = new ArrayList<String>();
	private ArrayList<JRadioButton> button = new ArrayList<JRadioButton>();
	private ArrayList<DefaultTableModel> modelList = new ArrayList<DefaultTableModel>();
	private ButtonGroup group = new ButtonGroup();
	private JTable table = new JTable();
	private DateError error;

	private JPanel panel;
	
	private CVManager manager;
	/**
	 * Launch the application.
	 */
	public void setPageOfProfessionalExperience(String title,DefaultTableModel model,String paragraph,int modelChosen,String choice){
		if (choice.equals("New")){
			titleList.add(title);
			modelList.add(model);
			JRadioButton RadioButton = new JRadioButton(title);
			button.add(RadioButton);
			group.add(button.get(button.size()-1));
			JPanel panel1 = new JPanel();
			panel1.add(button.get(button.size()-1));
			panel.add(panel1);
			paragraphList.add(paragraph);
		}
		else if (choice.equals("Edit")){
			modelList.set(modelChosen, model);
			paragraphList.set(modelChosen,paragraph);
		}
		else if((choice.equals("Title"))){
			titleList.set(modelChosen, title);
			button.get(modelChosen).setText(title);
		}
		frmProfessionalExperience.setVisible(true);
	}
	
	public void getProfessionalExperience() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProfessionalExperience window = new ProfessionalExperience(modelList,titleList,paragraphList,manager);
					window.frmProfessionalExperience.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ProfessionalExperience(ArrayList<DefaultTableModel> modelList,ArrayList<String> title,ArrayList<String> paragraph,CVManager manager) {
		panel = new JPanel();
		this.manager=manager;
		for(int i=0;i<modelList.size();i++){
			titleList.add(title.get(i));
			paragraphList.add(paragraph.get(i));
			this.modelList.add(modelList.get(i));
			JRadioButton radioButton = new JRadioButton(title.get(i));
			button.add(radioButton);
			group.add(button.get(button.size()-1));
			JPanel panel1 = new JPanel();
			panel1.add(button.get(button.size()-1));
			panel.add(panel1);
		}
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		professionalExp =this;
		frmProfessionalExperience = new JFrame();
		frmProfessionalExperience.setTitle("PROFESSIONAL EXPERIENCE");
		frmProfessionalExperience.setBounds(100, 100, 450, 300);
		frmProfessionalExperience.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel2 = new JPanel();
		frmProfessionalExperience.getContentPane().add(panel2, BorderLayout.SOUTH);
		
		JButton btnOk = new JButton("Ok");//we select one page and go there
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(CheckDate.getDate(titleList)){
					for(int i=0;i<modelList.size();i++){
						if(button.get(i).isSelected()){
							pageOfProfessionalExp = new PageOfProfessionalExperience(titleList.get(i),professionalExp,modelList.get(i),paragraphList.get(i),i,"Edit");
							pageOfProfessionalExp.getPageOfProfessionalExperience();
						}
					}
				}
				else{
					error = new DateError();
					error.getDateError();
				}
				
			}
		});
		panel2.add(btnOk);
		
		JButton btnCancel = new JButton("Cancel");//we don t save the page
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmProfessionalExperience.setVisible(false);
			}
		});
		panel2.add(btnCancel);
		
		JButton btnAdd = new JButton("Add");//add a new page
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table.setModel(new DefaultTableModel(
						new Object[][] {
							{null},
						},
						new String[] {
							"New column"
						}
					));
				DefaultTableModel newModel = (DefaultTableModel)table.getModel();
				newProfessionalExp = new NewProfessionalExperience(professionalExp,newModel,modelList.size()-1,"New");
				newProfessionalExp.getNewProfessionalExperience();
				frmProfessionalExperience.setVisible(false);
			}
		});
		panel2.add(btnAdd);
		
		JButton btnClose = new JButton("Close");//we close the page with the changes
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager.setProfessionalExperience(modelList, titleList, paragraphList);
				frmProfessionalExperience.setVisible(false);
				
			}
		});
		panel2.add(btnClose);
		
		JButton btnEdit = new JButton("Edit");//change the name
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i=0;i<button.size();i++){
					if(button.get(i).isSelected()){
						newProfessionalExp = new NewProfessionalExperience(professionalExp,modelList.get(i),i,"Edit");
						newProfessionalExp.getNewProfessionalExperience();
						frmProfessionalExperience.setVisible(false);
					}
				}
			}
		});
		panel2.add(btnEdit);
		
		JButton btnDelete = new JButton("Delete");//delete an experience
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i=0;i<button.size();i++){
					if(button.get(i).isSelected()){
						button.remove(i);
						modelList.remove(i);
						paragraphList.remove(i);
						titleList.remove(i);
						manager.setProfessionalExperience(modelList, titleList, paragraphList);
						frmProfessionalExperience.setVisible(false);
					}
				}
			}
		});
		panel2.add(btnDelete);
		
		frmProfessionalExperience.getContentPane().add(panel, BorderLayout.CENTER);
	}

}
