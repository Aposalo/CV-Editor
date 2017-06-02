package cveditor.main.buttons;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import cveditor.infos.InfoCaller;
import cveditor.manager.CVManager;
import cveditor.merge.ComparingFileSelection;



public class CVEditor {

	/**
	 * 
	 */
	private JFrame frmCvEditor;
	protected CVManager manager;
	private JPanel CV;
	private InfoCaller call;
	
	private JTextField txtSkillsAndExperience;
	private JTextField txtGeneralInformation;
	private JTextField txtProfessionalProfile;
	private JTextField txtCareerSummary;
	private JTextField txtEducationAndTraining;
	private JTextField txtFurtherCourses;
	private JTextField txtAdditionalInformation;
	private JTextField txtInterests;
	private JTextField txtCoreStrengths;
	private JTextField txtProfessionalExperience;
	
	
	/**
	 * Launch the application.
	 */
	
	public void setManager(CVManager manager){
		this.manager=manager;
	}
	
	public CVManager getManager(){
		return manager;
	}
	
	public void FunctionalCVTemplate(){//creates the functional panel
		
		CV = new JPanel();
		JPanel panel = new JPanel();
		CV.add(panel);
		
		txtGeneralInformation = new JTextField();
		txtGeneralInformation.setEditable(false);
		txtGeneralInformation.setText("1.GENERAL INFORMATION");
		panel.add(txtGeneralInformation);
		txtGeneralInformation.setColumns(20);
		
		JButton button = new JButton("+");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				call.callGeneralInformation(manager.getGeneralInformation());
			}
		});
		panel.add(button);
		
		JPanel panel_1 = new JPanel();
		CV.add(panel_1);
		
		txtProfessionalProfile = new JTextField();
		txtProfessionalProfile.setEditable(false);
		txtProfessionalProfile.setText("2.PROFESSIONAL PROFILE");
		panel_1.add(txtProfessionalProfile);
		txtProfessionalProfile.setColumns(20);
		
		JButton button_1 = new JButton("+");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				call.callProfessionalProfile(manager.getProfessionalProfile());
			}
		});
		panel_1.add(button_1);
		
		JPanel panel_2 = new JPanel();
		CV.add(panel_2);
		
		txtSkillsAndExperience = new JTextField();
		txtSkillsAndExperience.setEditable(false);
		txtSkillsAndExperience.setText("3.SKILLS AND EXPERIENCE");
		panel_2.add(txtSkillsAndExperience);
		txtSkillsAndExperience.setColumns(20);
		
		JButton btnNewButton = new JButton("+");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				call.callSkillsAndExperience(manager.getNumberOfSkills(),manager.getSkillsAndExperienceModelList(),manager.getSkillsAndExperienceTitle());
			}
		});
		panel_2.add(btnNewButton);
		
		JPanel panel_3 = new JPanel();
		CV.add(panel_3);
		
		txtCareerSummary = new JTextField();
		txtCareerSummary.setEditable(false);
		txtCareerSummary.setText("4.CAREER SUMMARY");
		panel_3.add(txtCareerSummary);
		txtCareerSummary.setColumns(20);
		
		JButton button_2 = new JButton("+");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				call.callCareerSummary(manager.getCareerSummary());
			}
		});
		panel_3.add(button_2);
		
		JPanel panel_4 = new JPanel();
		CV.add(panel_4);
		
		txtEducationAndTraining = new JTextField();
		txtEducationAndTraining.setEditable(false);
		txtEducationAndTraining.setText("5.EDUCATION AND TRAINING");
		panel_4.add(txtEducationAndTraining);
		txtEducationAndTraining.setColumns(20);
		
		JButton button_3 = new JButton("+");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				call.callEducationAndTraining(manager.getEducationAndTraining());
			}
		});
		panel_4.add(button_3);
		
		JPanel panel_5 = new JPanel();
		CV.add(panel_5);
		
		txtFurtherCourses = new JTextField();
		txtFurtherCourses.setText("6.FURTHER COURSES");
		txtFurtherCourses.setEditable(false);
		panel_5.add(txtFurtherCourses);
		txtFurtherCourses.setColumns(20);
		
		JButton button_4 = new JButton("+");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				call.callFurtherCourses(manager.getFurtherCourses());
			}
		});
		panel_5.add(button_4);
		
		JPanel panel_6 = new JPanel();
		CV.add(panel_6);
		
		txtAdditionalInformation = new JTextField();
		txtAdditionalInformation.setEditable(false);
		txtAdditionalInformation.setText("7.ADDITIONAL INFORMATION");
		panel_6.add(txtAdditionalInformation);
		txtAdditionalInformation.setColumns(20);
		
		JButton button_5 = new JButton("+");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				call.callAdditionalInformation(manager.getAdditionalInformation());
			}
		});
		panel_6.add(button_5);
		
		JPanel panel_7 = new JPanel();
		CV.add(panel_7);
		
		txtInterests = new JTextField();
		txtInterests.setText("8.INTERESTS");
		txtInterests.setEditable(false);
		panel_7.add(txtInterests);
		txtInterests.setColumns(20);
		
		JButton button_6 = new JButton("+");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				call.callInterests(manager.getInterests());
			}
		});
		panel_7.add(button_6);
		
		call = new InfoCaller(manager);
	
		frmCvEditor.getContentPane().add(CV, BorderLayout.CENTER);
		frmCvEditor.repaint();
		frmCvEditor.validate();
		frmCvEditor.setVisible(true);
	}
	
	
	public void ChronologicalCVTemplate(){//creates the chronological panel
		
		CV = new JPanel();
		JPanel panel = new JPanel();
		CV.add(panel);

		txtGeneralInformation = new JTextField();
		txtGeneralInformation.setEditable(false);
		txtGeneralInformation.setText("1.GENERAL INFORMATION");
		panel.add(txtGeneralInformation);
		txtGeneralInformation.setColumns(20);
		
		JButton button = new JButton("+");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				call.callGeneralInformation(manager.getGeneralInformation());
			}
		});
		panel.add(button);
		
		JPanel panel_1 = new JPanel();
		CV.add(panel_1);
		
		txtProfessionalProfile = new JTextField();
		txtProfessionalProfile.setEditable(false);
		txtProfessionalProfile.setText("2.PROFESSIONAL PROFILE");
		panel_1.add(txtProfessionalProfile);
		txtProfessionalProfile.setColumns(20);
		
		JButton button_1 = new JButton("+");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				call.callProfessionalProfile(manager.getProfessionalProfile());
			}
		});
		panel_1.add(button_1);
		
		JPanel panel_2 = new JPanel();
		CV.add(panel_2);
		
		txtCoreStrengths = new JTextField();
		txtCoreStrengths.setText("3.CORE STRENGTHS");
		txtCoreStrengths.setEditable(false);
		panel_2.add(txtCoreStrengths);
		txtCoreStrengths.setColumns(20);
		
		JButton button_2 = new JButton("+");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				call.callCoreStrengths(manager.getCoreStrengths());
			}
		});
		panel_2.add(button_2);
		
		JPanel panel_3 = new JPanel();
		CV.add(panel_3);
		
		txtProfessionalExperience = new JTextField();
		txtProfessionalExperience.setText("4.PROFESSIONAL EXPERIENCE");
		txtProfessionalExperience.setEditable(false);
		panel_3.add(txtProfessionalExperience);
		txtProfessionalExperience.setColumns(20);
		
		JButton button_3 = new JButton("+");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				call.callProfessionalExperience(manager.getProfessionalExperienceModelList(),manager.getProfessionalExperienceTitle(),manager.getProfessionalExperienceParagraph());
			}
		});
		panel_3.add(button_3);
		
		JPanel panel_4 = new JPanel();
		CV.add(panel_4);
		
		txtEducationAndTraining = new JTextField();
		txtEducationAndTraining.setEditable(false);
		txtEducationAndTraining.setText("5.EDUCATION AND TRAINING");
		panel_4.add(txtEducationAndTraining);
		txtEducationAndTraining.setColumns(20);
		
		JButton button_4 = new JButton("+");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				call.callEducationAndTraining(manager.getEducationAndTraining());
			}
		});
		panel_4.add(button_4);
		
		JPanel panel_5 = new JPanel();
		CV.add(panel_5);
		
		txtFurtherCourses = new JTextField();
		txtFurtherCourses.setEditable(false);
		txtFurtherCourses.setText("6.FURTHER COURSES");
		panel_5.add(txtFurtherCourses);
		txtFurtherCourses.setColumns(20);
		
		JButton button_5 = new JButton("+");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				call.callFurtherCourses(manager.getFurtherCourses());
			}
		});
		panel_5.add(button_5);
		
		JPanel panel_6 = new JPanel();
		CV.add(panel_6);
		
		txtAdditionalInformation = new JTextField();
		txtAdditionalInformation.setText("7.ADDITIONAL INFORMATION");
		txtAdditionalInformation.setEditable(false);
		panel_6.add(txtAdditionalInformation);
		txtAdditionalInformation.setColumns(20);
		
		JButton button_6 = new JButton("+");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				call.callAdditionalInformation(manager.getAdditionalInformation());
			}
		});
		panel_6.add(button_6);
		
		JPanel panel_7 = new JPanel();
		CV.add(panel_7);
		
		txtInterests = new JTextField();
		txtInterests.setText("8.INTERESTS");
		txtInterests.setEditable(false);
		panel_7.add(txtInterests);
		txtInterests.setColumns(20);
		
		JButton button_7 = new JButton("+");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				call.callInterests(manager.getInterests());
			}
		});
		panel_7.add(button_7);
		
		call = new InfoCaller(manager);
		
		frmCvEditor.getContentPane().add(CV, BorderLayout.CENTER);
		frmCvEditor.repaint();
		frmCvEditor.validate();
		frmCvEditor.setVisible(true);
	}
	
	
	public void CombinedCVTemplate(){//creates the combined panel
		
		CV = new JPanel();
		
		JPanel panel_1 = new JPanel();
		CV.add(panel_1);
		txtGeneralInformation = new JTextField();
		txtGeneralInformation.setEditable(false);
		txtGeneralInformation.setText("1.GENERAL INFORMATION");
		panel_1.add(txtGeneralInformation);
		txtGeneralInformation.setColumns(20);
		
		JButton button = new JButton("+");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				call.callGeneralInformation(manager.getGeneralInformation());
			}
		});
		panel_1.add(button);
		
		JPanel panel_2 = new JPanel();
		CV.add(panel_2);
		
		txtProfessionalProfile = new JTextField();
		panel_2.add(txtProfessionalProfile);
		txtProfessionalProfile.setText("2.PROFESSIONAL PROFILE");
		txtProfessionalProfile.setEditable(false);
		txtProfessionalProfile.setColumns(20);
		
		JButton button_1 = new JButton("+");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				call.callProfessionalProfile(manager.getProfessionalProfile());
			}
		});
		panel_2.add(button_1);
		
		JPanel panel_3 = new JPanel();
		CV.add(panel_3);
		
		txtSkillsAndExperience = new JTextField();
		txtSkillsAndExperience.setEditable(false);
		txtSkillsAndExperience.setText("3.SKILLS AND EXPERIENCE");
		panel_3.add(txtSkillsAndExperience);
		txtSkillsAndExperience.setColumns(20);
		
		JButton button_2 = new JButton("+");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				call.callSkillsAndExperience(manager.getNumberOfSkills(),manager.getSkillsAndExperienceModelList(),manager.getSkillsAndExperienceTitle());
			}
		});
		panel_3.add(button_2);
		
		JPanel panel_4 = new JPanel();
		CV.add(panel_4);
		
		txtProfessionalExperience = new JTextField();
		txtProfessionalExperience.setText("4.PROFESSIONAL EXPERIENCE");
		txtProfessionalExperience.setEditable(false);
		panel_4.add(txtProfessionalExperience);
		txtProfessionalExperience.setColumns(20);
		
		JButton button_3 = new JButton("+");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				call.callProfessionalExperience(manager.getProfessionalExperienceModelList(),manager.getProfessionalExperienceTitle(),manager.getProfessionalExperienceParagraph());
			}
		});
		panel_4.add(button_3);
		
		JPanel panel_5 = new JPanel();
		CV.add(panel_5);
		
		txtEducationAndTraining = new JTextField();
		txtEducationAndTraining.setText("5.EDUCATION AND TRAINING");
		txtEducationAndTraining.setEditable(false);
		panel_5.add(txtEducationAndTraining);
		txtEducationAndTraining.setColumns(20);
		
		JButton button_4 = new JButton("+");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				call.callEducationAndTraining(manager.getEducationAndTraining());
			}
		});
		panel_5.add(button_4);
		
		JPanel panel_6 = new JPanel();
		CV.add(panel_6);
		
		txtFurtherCourses = new JTextField();
		txtFurtherCourses.setEditable(false);
		txtFurtherCourses.setText("6.FURTHER COURSES");
		panel_6.add(txtFurtherCourses);
		txtFurtherCourses.setColumns(20);
		
		JButton button_5 = new JButton("+");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				call.callFurtherCourses(manager.getFurtherCourses());
			}
		});
		panel_6.add(button_5);
		
		JPanel panel_7 = new JPanel();
		CV.add(panel_7);
		
		txtAdditionalInformation = new JTextField();
		txtAdditionalInformation.setEditable(false);
		txtAdditionalInformation.setText("7.ADDITIONAL INFORMATION");
		panel_7.add(txtAdditionalInformation);
		txtAdditionalInformation.setColumns(20);
		
		JButton button_6 = new JButton("+");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				call.callAdditionalInformation(manager.getAdditionalInformation());
			}
		});
		panel_7.add(button_6);
		
		JPanel panel_8 = new JPanel();
		CV.add(panel_8);
		
		txtInterests = new JTextField();
		txtInterests.setEditable(false);
		txtInterests.setText("8.INTERESTS");
		panel_8.add(txtInterests);
		txtInterests.setColumns(20);
		
		JButton button_7 = new JButton("+");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				call.callInterests(manager.getInterests());
			}
		});
		panel_8.add(button_7);
		
		call = new InfoCaller(manager);
		
		frmCvEditor.getContentPane().add(CV, BorderLayout.CENTER);
		frmCvEditor.repaint();
		frmCvEditor.validate();
		frmCvEditor.setVisible(true);
	}
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CVEditor window = new CVEditor();
					window.frmCvEditor.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CVEditor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCvEditor = new JFrame();
		frmCvEditor.setTitle("CVEditor");
		frmCvEditor.setBounds(150, 100, 400, 410);
		frmCvEditor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frmCvEditor.setJMenuBar(menuBar);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmCvEditor.setVisible(false);
				TemplateCreation.create();//opens a window and the user selects a template
			}
		});
		menuBar.add(btnCreate);

		JButton btnOpen = new JButton("Open");
		btnOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					OpeningFile open = new OpeningFile();
					open.Open();//opens a window and you select a file to open
					manager = open.getManager();
					TemplateInitializitation.initialize(manager);
					frmCvEditor.setVisible(false);
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		menuBar.add(btnOpen);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SavingTemplate save = new SavingTemplate();
				save.saveFile(manager);//saves the template
			}
		});
		menuBar.add(btnSave);
		
		JButton btnMerge = new JButton("Compare");
		btnMerge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ComparingFileSelection.getComparingFileSelection();
				frmCvEditor.setVisible(false);//you add two templates and it combines them
			}
		});
		menuBar.add(btnMerge);
		
		
	}
}
