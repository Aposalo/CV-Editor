package cveditor.manager;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

public class CVManagerFunctional extends CVManager {

	
	private String infoGeneralInformation;
	
	private String infoProfessionalProfile;
	
	private ArrayList<DefaultTableModel> skillsAndExperienceModelList = new ArrayList<DefaultTableModel>();
	private ArrayList<String> skillsAndExperienceTitle = new ArrayList<String>();
	private int numberOfSkills=1;
	
	private DefaultTableModel modelCareerSummary;
	
	private DefaultTableModel modelEducationAndTraining;
	
	private DefaultTableModel modelFurtherCourses;
	
	private String infoAdditionalInformation;
	
	private String infoInterests;
	
	public void setGeneralInformation(String infoGeneralInformation){
		this.infoGeneralInformation = infoGeneralInformation;
	}
	
	public void setProfessionalProfile(String professionalProfileInfo){
		this.infoProfessionalProfile = professionalProfileInfo;
	}
	
	public void setAdditionalInformation(String additionalInformationInfo){
		this.infoAdditionalInformation = additionalInformationInfo;
	}
	
	public void setInterests(String interestsInfo){
		this.infoInterests = interestsInfo;
	}
	
	public void setSkillsAndExperience(int numberOfSkills,ArrayList<DefaultTableModel> modelList,ArrayList<String> title){
		this.numberOfSkills = numberOfSkills;
		skillsAndExperienceModelList = new ArrayList<DefaultTableModel>();
		skillsAndExperienceTitle = new ArrayList<String>();
		skillsAndExperienceModelList.addAll(modelList);
		skillsAndExperienceTitle.addAll(title);
	}
	
	public void setCareerSummary(DefaultTableModel careerSummaryModel){
			this.modelCareerSummary=careerSummaryModel;
	}
	
	public void setEducationAndTraining(DefaultTableModel educationAndTrainingModel){
			this.modelEducationAndTraining=educationAndTrainingModel;
	}
	
	public void setFurtherCourses(DefaultTableModel furtherCoursesModel){
			this.modelFurtherCourses=furtherCoursesModel;
	}
	
	public String getGeneralInformation(){
		return infoGeneralInformation;
	}
	
	public String getProfessionalProfile(){
		return infoProfessionalProfile;
	}
	
	public String getAdditionalInformation(){
		return infoAdditionalInformation;
	}
	
	public String getInterests(){
		return infoInterests;
	}
	
	public int getNumberOfSkills(){
		return numberOfSkills;
	}
	
	public ArrayList<DefaultTableModel> getSkillsAndExperienceModelList(){
		return skillsAndExperienceModelList;
	}
	
	public ArrayList<String> getSkillsAndExperienceTitle(){
		return skillsAndExperienceTitle;
	}
	
	public DefaultTableModel getCareerSummary(){
		return modelCareerSummary;
	}
	
	public DefaultTableModel getEducationAndTraining(){
		return  modelEducationAndTraining;
	}
	
	public DefaultTableModel getFurtherCourses(){
		return  modelFurtherCourses;
	}
	
	public void setProfessionalExperience(ArrayList<DefaultTableModel> modelList,ArrayList<String> title,ArrayList<String> paragraph){}
	
	public ArrayList<DefaultTableModel> getProfessionalExperienceModelList(){
		return null;
	}
	
	public ArrayList<String> getProfessionalExperienceTitle(){
		return null;
	}
	
	public ArrayList<String> getProfessionalExperienceParagraph(){
		return null;
	}
	
	public String getCoreStrengths(){
		return null;
	}
	
	public void setCoreStrengths(String coreStrengthsInfo){}
	
}
