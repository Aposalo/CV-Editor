package cveditor.manager;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;



public abstract class CVManager{
	
	private String template;
	
	public void setTemplate(String template){
		this.template=template;
	}
	
	public String getTemplate(){
		return template;
	}
	
	public abstract void setGeneralInformation(String generalInformationInfo);
	public abstract String getGeneralInformation();
	
	public abstract void setProfessionalProfile(String professionalProfileInfo);
	public abstract String getProfessionalProfile();
	
	public abstract void setAdditionalInformation(String additionalInformationInfo);
	public abstract String getAdditionalInformation();
	
	public abstract void setInterests(String interestsInfo);
	public abstract String getInterests();
	
	public abstract void setSkillsAndExperience(int numberOfSkills,ArrayList<DefaultTableModel> modelList,ArrayList<String> title);
	public abstract ArrayList<DefaultTableModel> getSkillsAndExperienceModelList();
	public abstract ArrayList<String> getSkillsAndExperienceTitle();
	public abstract int getNumberOfSkills();
	
	public abstract void setCareerSummary(DefaultTableModel careerSummaryModel);
	public abstract DefaultTableModel getCareerSummary();
	
	public abstract void setEducationAndTraining(DefaultTableModel educationAndTrainingModel);
	public abstract DefaultTableModel getEducationAndTraining();
	
	public abstract void setFurtherCourses(DefaultTableModel furtherCoursesModel);
	public abstract DefaultTableModel getFurtherCourses();
	
	public abstract void setProfessionalExperience(ArrayList<DefaultTableModel> modelList,ArrayList<String> title,ArrayList<String> paragraph);
	public abstract ArrayList<DefaultTableModel> getProfessionalExperienceModelList();
	public abstract ArrayList<String> getProfessionalExperienceTitle();
	public abstract ArrayList<String> getProfessionalExperienceParagraph();
	
	public abstract void setCoreStrengths(String coreStrengthsInfo);
	public abstract String getCoreStrengths();

}
