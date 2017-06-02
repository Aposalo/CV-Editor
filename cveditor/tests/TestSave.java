package cveditor.tests;

import java.util.ArrayList;

import cveditor.main.buttons.SavingTemplate;
import cveditor.manager.CVManager;
import cveditor.manager.CVManagerFunctional;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.junit.Test;

public class TestSave {
	private CVManager managerFunctional = new CVManagerFunctional();	
	private String name = "Apostolis Salomidis";
	private String address = "Mpizaniou 15";
	private String telephone1 = "6987048669";
	private String telephone2 = "2641032160";
	private String email = "aposalo@gmail.com";
	String information = name+"-"+address+"-"+telephone1+"-"+telephone2+"-"+email;
	
	private String professionalProfileInfo = "Student At Ioannina";
	
	private String additionalInformationInfo = "Knowledge at Java,C,C++ etc.";
	
	private String interestsInfo = "I like sports,cooking etc.";
	
	private ArrayList<DefaultTableModel> skillsAndExperienceModelList = new ArrayList<DefaultTableModel>();
	private ArrayList<String> skillsAndExperienceTitle = new ArrayList<String>();
	private int numberOfSkills=1;
	
	private JTable tableCareerSummary = new JTable();
	private JTable tableEducationAndTraining = new JTable();
	private JTable tableFurtherCourses = new JTable();
	private DefaultTableModel modelCareerSummary;
	private DefaultTableModel modelEducationAndTraining;
	private DefaultTableModel modelFurtherCourses;
	
	
	@Test
	public void TestSaveFile(){
		
		managerFunctional.setTemplate("Functional");
		managerFunctional.setGeneralInformation(information);
		managerFunctional.setAdditionalInformation(additionalInformationInfo);
		managerFunctional.setInterests(interestsInfo);
		managerFunctional.setProfessionalProfile(professionalProfileInfo);
		
		skillsAndExperienceTitle.add("3.1. SKILLS AND EXPERIENCE ON Java");
		JTable skillsAndExperienceTable = new JTable();
		skillsAndExperienceTable.setModel(new DefaultTableModel(
				new Object[][] {
						{"Software Engineering"},
					},
					new String[] {
						"New column"
					}
				));
		skillsAndExperienceModelList.add((DefaultTableModel) skillsAndExperienceTable.getModel());
		managerFunctional.setSkillsAndExperience(numberOfSkills, skillsAndExperienceModelList, skillsAndExperienceTitle);
		
		tableCareerSummary.setModel(new DefaultTableModel(
				new Object[][] {
						{"Google", "Admin", "14-6-1988"},
						{"Apple", "CEO", "17-9-1925"},
					},
				new String[] {
					"Company", "Job Title", "Date"
				}
			));
		
		modelCareerSummary = (DefaultTableModel) tableCareerSummary.getModel();
		
		managerFunctional.setCareerSummary(modelCareerSummary);
		
		tableEducationAndTraining.setModel(new DefaultTableModel(
				new Object[][] {
						{"Programmer", "Google", "Greece","14-6-1988"},
						{"Programmer", "Apple", "Greece","17-9-1925"},
					},
				new String[] {
					"Qualification", "Establishment","Location", "Date"
				}
			));
		
		modelEducationAndTraining = (DefaultTableModel) tableEducationAndTraining.getModel();
		
		managerFunctional.setEducationAndTraining(modelEducationAndTraining);
		
		tableFurtherCourses.setModel(new DefaultTableModel(
				new Object[][] {
						{"postgraduate", "England", "Arden","14-6-1988"},
						{"postgraduate", "Thessaloniki", "Aristoteleio","17-9-1925"},
					},
				new String[] {
					"Course", "Establishment","Location", "Date"
				}
			));
		
		modelFurtherCourses = (DefaultTableModel) tableFurtherCourses.getModel();
		
		managerFunctional.setFurtherCourses(modelFurtherCourses);
		
		SavingTemplate save = new SavingTemplate();
		save.saveFile(managerFunctional);
		save.saveTemplateTXT();
		save.saveTemplateTEX();
		
	}
}
