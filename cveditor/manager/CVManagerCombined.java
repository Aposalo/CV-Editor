package cveditor.manager;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;


public class CVManagerCombined extends CVManager {
	
	private String infoGeneralInformation;
	
	private String infoProfessionalProfile;
	
	private ArrayList<DefaultTableModel> skillsAndExperienceModelList = new ArrayList<DefaultTableModel>();
	private ArrayList<String> skillsAndExperienceTitle = new ArrayList<String>();
	private int numberOfSkills;
	
	private ArrayList<DefaultTableModel> professionalExperienceAchievementsModel = new ArrayList<DefaultTableModel>();
	private ArrayList<String> professionalExperienceTitle = new ArrayList<String>();
	private ArrayList<String> professionalExperienceParagraph = new ArrayList<String>();
	
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
	
	public void setProfessionalExperience(ArrayList<DefaultTableModel> modelList,ArrayList<String> title,ArrayList<String> paragraph){
		professionalExperienceAchievementsModel = new ArrayList<DefaultTableModel>();
		professionalExperienceTitle = new ArrayList<String>();
		professionalExperienceParagraph = new ArrayList<String>();
		professionalExperienceAchievementsModel.addAll(modelList);
		professionalExperienceTitle.addAll(title);
		professionalExperienceParagraph.addAll(paragraph);
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
	
	public DefaultTableModel getEducationAndTraining(){
		return  modelEducationAndTraining;
	}
	
	public DefaultTableModel getFurtherCourses(){
		return  modelFurtherCourses;
	}
	
	public ArrayList<DefaultTableModel> getProfessionalExperienceModelList(){
		return professionalExperienceAchievementsModel;
	}
	
	public ArrayList<String> getProfessionalExperienceTitle(){
		return professionalExperienceTitle;
	}
	
	public ArrayList<String> getProfessionalExperienceParagraph(){
		return professionalExperienceParagraph;
	}
	
	public void setCareerSummary(DefaultTableModel careerSummaryModel){}
	
	public DefaultTableModel getCareerSummary(){
		return null;
	}
	
	public String getCoreStrengths(){
		return null;
	}
	
	public void setCoreStrengths(String coreStrengthsInfo){}
	
}
