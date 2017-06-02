package cveditor.infos.professionalexperience;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import cveditor.infos.ProfessionalExperience;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PageOfProfessionalExperience {

	private JFrame frmRtewrt;
	
	private String choice;
	private JTextField txtParagraphOfRespon;
	private JTextField txtListOfAchievements;
	private String title;
	private int modelChosen;
	
	private ProfessionalExperienceParagraph paragraph;
	private ProfessionalExperienceAchievements achievements;
	private ProfessionalExperience ProfessionalExp;
	private PageOfProfessionalExperience pageOfProfessionalExp;
	
	private String responsibilities;
	private JTable Table = new JTable();
	private DefaultTableModel achievementsInformation;

	/**
	 * Launch the application.
	 */
	
	public void setProfessionalExperienceParagraph(String responsibilities){
		this.responsibilities = responsibilities;
	}
	
	public void setProfessionalExperienceAchievements(DefaultTableModel achievementsInformation){
		this.achievementsInformation = achievementsInformation;
	}
	
	
	public void getPageOfProfessionalExperience() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PageOfProfessionalExperience window = new PageOfProfessionalExperience(title,ProfessionalExp,achievementsInformation,responsibilities,modelChosen,choice);
					window.frmRtewrt.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PageOfProfessionalExperience(String title,ProfessionalExperience experience,DefaultTableModel achievementsInformation,String responsibilities,int modelChosen,String choice) {
		
		this.title = title;
		this.choice=choice;
		this.achievementsInformation = achievementsInformation;
		this.responsibilities = responsibilities;
		this.ProfessionalExp = experience;
		this.modelChosen = modelChosen;
		Table.setModel(achievementsInformation);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		pageOfProfessionalExp = this;
		frmRtewrt = new JFrame();
		frmRtewrt.setTitle(title);
		frmRtewrt.setBounds(100, 100, 450, 300);
		frmRtewrt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		frmRtewrt.getContentPane().add(panel, BorderLayout.SOUTH);
		
		JButton btnOk = new JButton("Ok");//we go back to the main ProfessionalExperience
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmRtewrt.setVisible(false);
				ProfessionalExp.setPageOfProfessionalExperience(title, achievementsInformation,responsibilities,modelChosen, choice);
			}
		});
		panel.add(btnOk);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmRtewrt.setVisible(false);
			}
		});
		panel.add(btnCancel);
		
		JPanel panel1 = new JPanel();
		frmRtewrt.getContentPane().add(panel1, BorderLayout.CENTER);
		
		JPanel panel2 = new JPanel();
		panel1.add(panel2);
		
		txtParagraphOfRespon = new JTextField();
		txtParagraphOfRespon.setEditable(false);
		txtParagraphOfRespon.setText("Paragraph of responsibilities");
		panel2.add(txtParagraphOfRespon);
		txtParagraphOfRespon.setColumns(20);
		
		JButton button = new JButton("+");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paragraph = new ProfessionalExperienceParagraph(responsibilities,pageOfProfessionalExp);
				paragraph.getProfessionalExperienceParagraph();
				
			}
		});
		panel2.add(button);
		
		JPanel panel3 = new JPanel();
		panel1.add(panel3);
		
		txtListOfAchievements = new JTextField();
		txtListOfAchievements.setEditable(false);
		txtListOfAchievements.setText("List of achievements");
		panel3.add(txtListOfAchievements);
		txtListOfAchievements.setColumns(20);
		
		JButton button1 = new JButton("+");
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				achievements = new ProfessionalExperienceAchievements(achievementsInformation,pageOfProfessionalExp);
				achievements.getProfessionalExperienceAchievements();
			}
		});
		panel3.add(button1);
	}

}
