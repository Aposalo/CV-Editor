package cveditor.infos;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import cveditor.infos.skillsandexperience.NewSkillAndExperience;
import cveditor.infos.skillsandexperience.PageOfSkillAndExperience;
import cveditor.manager.CVManager;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class SkillsAndExperience {

	/**
	 * Launch the application.
	 */
	private JFrame frmSkillsAndExperience;
	private JPanel panel2;
	private int count=1;
	private ArrayList<JRadioButton> button = new ArrayList<JRadioButton>();
	private ButtonGroup group = new ButtonGroup();
	private NewSkillAndExperience skillandExpName;//when we create a page
	private SkillsAndExperience skillAndExp;//we send it to the other pages when we create or open on
											//so that when we finish with them we come back to the original
	
	private PageOfSkillAndExperience SkillAndExpPage;//we hold the page so that we can call it
	private ArrayList<DefaultTableModel> modelList = new ArrayList<DefaultTableModel>();
	private JTable table = new JTable();
	private ArrayList<String> titleList = new ArrayList<String>();
	private CVManager manager;
	
	public void setPageOfSkillAndExperience(DefaultTableModel model,String title,String choice,int modelChosen){
		if(choice.equals("New")){
			JRadioButton RadioButton = new JRadioButton(title);
			group.add(RadioButton);
			button.add(RadioButton);
			JPanel panel1 = new JPanel();
			panel1.add(button.get(modelChosen));
			modelList.set(modelChosen, model);
			panel2.add(panel1);
			titleList.add(title);
			count++;
		}
		else if(choice.equals("Edit")){
			modelList.set(modelChosen,model);
		}
		else if(choice.equals("Name")){
			button.get(modelChosen).setText(title);
			titleList.set(modelChosen, title);
		}
		frmSkillsAndExperience.setVisible(true);
	}
	
	public void getSkillsAndExperience() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SkillsAndExperience window = new SkillsAndExperience(count,modelList,titleList,manager);
					window.frmSkillsAndExperience.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public SkillsAndExperience(int count,ArrayList<DefaultTableModel> modelList,ArrayList<String> title,CVManager manager){
		this.count=count;
		this.manager=manager;
		panel2 = new JPanel();
		for(int i=0;i<modelList.size();i++){
			this.modelList.add(modelList.get(i));
			this.titleList.add(title.get(i));
			JRadioButton RadioButton = new JRadioButton(titleList.get(i));
			button.add(RadioButton);
			JPanel panel1 = new JPanel();
			panel1.add(button.get(i));
			panel2.add(panel1);
			group.add(button.get(i));
		}
		initialize();
	}
	
	
	private void initialize() {
		skillAndExp = this;
		frmSkillsAndExperience = new JFrame();;
		frmSkillsAndExperience.setTitle("SKILLS AND EXPERIENCE");
		frmSkillsAndExperience.setBounds(100, 100, 450, 300);
		frmSkillsAndExperience.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frmSkillsAndExperience.getContentPane().add(panel, BorderLayout.SOUTH);
		
		JButton btnOk = new JButton("Ok");//we select one page and go there
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i=0;i<count-1;i++){
					if(button.get(i).isSelected()){
						SkillAndExpPage = new PageOfSkillAndExperience(modelList.get(i),titleList.get(i),skillAndExp,"Edit",i);
						SkillAndExpPage.getPageOfSkillAndExperience();
					}
				}
			}
		});
		panel.add(btnOk);
		
		JButton btnCancel = new JButton("Cancel");//we don t save the page
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmSkillsAndExperience.setVisible(false);
			}
		});
		panel.add(btnCancel);
		
		JButton btnAdd = new JButton("Add ");//add a new page
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
				DefaultTableModel NewModel = (DefaultTableModel)table.getModel();
				modelList.add(NewModel);
				skillandExpName = new NewSkillAndExperience(count,skillAndExp,modelList.get(count-1),"New");
				skillandExpName.getNewSkillAndExperience();
				frmSkillsAndExperience.setVisible(false);
			}
		});
		panel.add(btnAdd);
		
		JButton btnClose = new JButton("Close");//we close the page with the changes
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager.setSkillsAndExperience(count,modelList,titleList);
				frmSkillsAndExperience.setVisible(false);
			}
		});
		panel.add(btnClose);
		
		JButton btnEdit = new JButton("Edit");//change the name
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i=0;i<button.size();i++){
					if(button.get(i).isSelected()){
						skillandExpName = new NewSkillAndExperience(i,skillAndExp,modelList.get(i),"Edit");
						skillandExpName.getNewSkillAndExperience();
						frmSkillsAndExperience.setVisible(false);
					}
				}
			}
		});
		panel.add(btnEdit);
		
		JButton btnDelete = new JButton("Delete");//delete a skill
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int j=button.size()+1;
				for(int i=0;i<button.size();i++){
					if(button.get(i).isSelected()){
						button.remove(i);
						titleList.remove(i);
						modelList.remove(i);
						j=i;
					}
					else if(j<button.size()){
						System.out.println(i);
						String[]Title = titleList.get(i).split(".");
						Title[1] = ""+(i);
						titleList.set(i,Title[0]+"."+Title[1]+"."+Title[2]);
					}
				}
				manager.setSkillsAndExperience(button.size(),modelList,titleList);
				frmSkillsAndExperience.setVisible(false);
			}
		});
		panel.add(btnDelete);
		
		frmSkillsAndExperience.getContentPane().add(panel2, BorderLayout.CENTER);
		
	}

}
