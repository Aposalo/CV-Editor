package cveditor.main.buttons;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import cveditor.errormessage.TemplateCreationError;
import cveditor.manager.CVManager;
import cveditor.manager.CVManagerChronological;
import cveditor.manager.CVManagerCombined;
import cveditor.manager.CVManagerFunctional;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class TemplateCreation {

	private JFrame frmSelectTemplate;
	
	private JTable careerSummaryTable = new JTable();
	private DefaultTableModel modelCareerSummary;
	
	private JTable educationAndTrainingTable = new JTable();
	private DefaultTableModel modelEducationAndTraining;

	private JTable furtherCoursesTable = new JTable();
	private DefaultTableModel modelFurtherCourses;
	
	private ArrayList<DefaultTableModel> skillsAndExperienceModelList = new ArrayList<DefaultTableModel>();
	private ArrayList<String> skillsAndExperienceTitle = new ArrayList<String>();
	
	private ArrayList<DefaultTableModel> professionalExperienceAchievementsModel = new ArrayList<DefaultTableModel>();
	private ArrayList<String> professionalExperienceTitle = new ArrayList<String>();
	private ArrayList<String> professionalExperienceParagraph = new ArrayList<String>();
	
	

	/**
	 * Launch the application.
	 */
	
	
	
	
	
	public static void create() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TemplateCreation window = new TemplateCreation();
					window.frmSelectTemplate.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TemplateCreation() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSelectTemplate = new JFrame();
		
		frmSelectTemplate.setTitle("Select Template");
		frmSelectTemplate.setBounds(100, 100, 350, 150);
		frmSelectTemplate.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ButtonGroup group = new ButtonGroup();
		
		
		JPanel panel = new JPanel();
		frmSelectTemplate.getContentPane().add(panel, BorderLayout.CENTER);
		
		JPanel panel1 = new JPanel();
		panel.add(panel1);
		
		final JRadioButton rdbtnNewRadioButton = new JRadioButton("Combined");
		group.add(rdbtnNewRadioButton);
		panel1.add(rdbtnNewRadioButton);
		
		final JRadioButton rdbtnNewRadioButton1 = new JRadioButton("Chronological");
		group.add(rdbtnNewRadioButton1);
		panel1.add(rdbtnNewRadioButton1);
		
		final JRadioButton rdbtnNewRadioButton2 = new JRadioButton("Functional");
		group.add(rdbtnNewRadioButton2);
		panel1.add(rdbtnNewRadioButton2);
		
		JPanel panel2 = new JPanel();
		panel.add(panel2);
		
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CVEditor cv = new CVEditor();
				
				if(rdbtnNewRadioButton.isSelected()){
					
					final CVManager manager = new CVManagerCombined();
					
					manager.setAdditionalInformation(null);
					manager.setInterests(null);
					manager.setGeneralInformation(null);
					manager.setProfessionalProfile(null);
					
					
					
					educationAndTrainingTable.setModel(new DefaultTableModel(
							new Object[][] {
									{null, null, null,null},
								},
							new String[] {
								"Qualification", "Establishment","Location", "Date"
							}
						));
					
					modelEducationAndTraining = (DefaultTableModel) educationAndTrainingTable.getModel();
					manager.setEducationAndTraining(modelEducationAndTraining);
					
					
					furtherCoursesTable.setModel(new DefaultTableModel(
							new Object[][] {
									{null, null, null,null},
								},
							new String[] {
								"Course", "Establishment","Location", "Date"
							}
						));
					
					modelFurtherCourses = (DefaultTableModel) furtherCoursesTable.getModel();
					manager.setFurtherCourses(modelFurtherCourses);
					
					manager.setSkillsAndExperience(1, skillsAndExperienceModelList, skillsAndExperienceTitle);
					manager.setProfessionalExperience(professionalExperienceAchievementsModel, professionalExperienceTitle, professionalExperienceParagraph);
					
					manager.setTemplate("Combined");
					
					cv.setManager(manager);
					cv.CombinedCVTemplate();
					frmSelectTemplate.setVisible(false);
					frmSelectTemplate.dispose();
				}
				
				else if(rdbtnNewRadioButton1.isSelected()){
					
					final CVManager manager = new CVManagerChronological();
					
					manager.setCoreStrengths(null);
					manager.setAdditionalInformation(null);
					manager.setInterests(null);
					manager.setGeneralInformation(null);
					manager.setProfessionalProfile(null);
					
					
					educationAndTrainingTable.setModel(new DefaultTableModel(
							new Object[][] {
									{null, null, null,null},
								},
							new String[] {
								"Qualification", "Establishment","Location", "Date"
							}
						));
					
					modelEducationAndTraining = (DefaultTableModel) educationAndTrainingTable.getModel();
					manager.setEducationAndTraining(modelEducationAndTraining);
					
					
					furtherCoursesTable.setModel(new DefaultTableModel(
							new Object[][] {
									{null, null, null,null},
								},
							new String[] {
								"Course", "Establishment","Location", "Date"
							}
						));
					
					modelFurtherCourses = (DefaultTableModel) furtherCoursesTable.getModel();
					manager.setFurtherCourses(modelFurtherCourses);
					
					manager.setProfessionalExperience(professionalExperienceAchievementsModel, professionalExperienceTitle, professionalExperienceParagraph);
					
					manager.setTemplate("Chronological");
					cv.setManager(manager);
					cv.ChronologicalCVTemplate();
					frmSelectTemplate.setVisible(false);
					frmSelectTemplate.dispose();
				}
				
				
				
				else if(rdbtnNewRadioButton2.isSelected()){
					final CVManager manager = new CVManagerFunctional();
					manager.setAdditionalInformation(null);
					manager.setInterests(null);
					manager.setGeneralInformation(null);
					manager.setProfessionalProfile(null);
					
					careerSummaryTable.setModel(new DefaultTableModel(
							new Object[][] {
									{null, null, null},
								},
							new String[] {
								"Company", "Job Title", "Date"
							}
						));
					modelCareerSummary = (DefaultTableModel) careerSummaryTable.getModel();
					manager.setCareerSummary(modelCareerSummary);
					
					
					educationAndTrainingTable.setModel(new DefaultTableModel(
							new Object[][] {
									{null, null, null,null},
								},
							new String[] {
								"Qualification", "Establishment","Location", "Date"
							}
						));
					
					modelEducationAndTraining = (DefaultTableModel) educationAndTrainingTable.getModel();
					manager.setEducationAndTraining(modelEducationAndTraining);
					
					
					furtherCoursesTable.setModel(new DefaultTableModel(
							new Object[][] {
									{null, null, null,null},
								},
							new String[] {
								"Course", "Establishment","Location", "Date"
							}
						));
					
					modelFurtherCourses = (DefaultTableModel) furtherCoursesTable.getModel();
					manager.setFurtherCourses(modelFurtherCourses);
					
					manager.setSkillsAndExperience(1, skillsAndExperienceModelList, skillsAndExperienceTitle);
					
					manager.setTemplate("Functional");
					cv.setManager(manager);
					cv.FunctionalCVTemplate();
					frmSelectTemplate.setVisible(false);
					frmSelectTemplate.dispose();
				}
				else{
					TemplateCreationError.getTemplateCreationError();
				}
			}
		});
		panel2.add(btnOk);
		
	}

}
