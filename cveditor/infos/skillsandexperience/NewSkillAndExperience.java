package cveditor.infos.skillsandexperience;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import cveditor.infos.SkillsAndExperience;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NewSkillAndExperience {

	private JFrame frmNameOfNew;
	private JTextField textField;
	
	private String name;
	private String title;
	private int count;
	private DefaultTableModel model;
	private String choice;
	
	private PageOfSkillAndExperience page;
	private SkillsAndExperience skill;

	/**
	 * Launch the application.
	 */
	public void getNewSkillAndExperience() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewSkillAndExperience window = new NewSkillAndExperience(count,skill,model,choice);
					window.frmNameOfNew.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public NewSkillAndExperience(int count,SkillsAndExperience skill,DefaultTableModel model,String choice) {
		this.count = count;
		this.skill=skill;
		this.model=model;
		this.choice=choice;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmNameOfNew = new JFrame();
		frmNameOfNew.setTitle("Name Of New Skill");
		frmNameOfNew.setBounds(100, 100, 450, 300);
		frmNameOfNew.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frmNameOfNew.getContentPane().add(panel, BorderLayout.SOUTH);
		
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(choice.equals("New")){
					name = textField.getText();
					title = "3."+count+"."+"	"+"SKILLS AND EXPERIENCE ON "+name;
					page = new PageOfSkillAndExperience(model,title,skill,"New",count-1);
					page.getPageOfSkillAndExperience();//we add stuff to the new page
					frmNameOfNew.setVisible(false);
				}
				else if(choice.equals("Edit")){
					name = textField.getText();
					int count2 = count+1;
					title = "3."+count2+"."+"	"+"SKILLS AND EXPERIENCE ON "+name;
					skill.setPageOfSkillAndExperience(model, title, "Name", count);//we open the main page of SkillsAndExperience
					frmNameOfNew.setVisible(false);
				}
			}
		});
		panel.add(btnOk);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmNameOfNew.setVisible(false);
			}
		});
		panel.add(btnCancel);
		
		textField = new JTextField();
		frmNameOfNew.getContentPane().add(textField, BorderLayout.CENTER);
		textField.setColumns(10);
	}

}
