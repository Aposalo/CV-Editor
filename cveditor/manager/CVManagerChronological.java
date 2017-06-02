package cveditor.manager;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

public class CVManagerChronological extends CVManager {//anti gia DefaultTableModel kanto string
	
	
	private String infoGeneralInformation;
	
	private String infoProfessionalProfile;
	
	private String infoCoreStrengths;
	
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
	
	public void setProfessionalExperience(ArrayList<DefaultTableModel> modelList,ArrayList<String> title,ArrayList<String> paragraph){
		professionalExperienceAchievementsModel = new ArrayList<DefaultTableModel>();
		professionalExperienceTitle = new ArrayList<String>();
		professionalExperienceParagraph = new ArrayList<String>();
		professionalExperienceAchievementsModel.addAll(modelList);
		professionalExperienceTitle.addAll(title);
		professionalExperienceParagraph.addAll(paragraph);
	}
	
	public void setCoreStrengths(String coreStrengthsInfo){
		this.infoCoreStrengths = coreStrengthsInfo;
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
	
	public String getCoreStrengths(){
		return infoCoreStrengths;
	}
	
	
	public void setSkillsAndExperience(int numberOfSkills,ArrayList<DefaultTableModel> modelList,ArrayList<String> title){
	}
	
	public ArrayList<DefaultTableModel> getSkillsAndExperienceModelList(){
		return null;
	}
	
	public int getNumberOfSkills(){
		return 0;
	}
	
	public ArrayList<String> getSkillsAndExperienceTitle(){
		return null;
	}
	
	public void setCareerSummary(DefaultTableModel careerSummaryModel){}
	
	public DefaultTableModel getCareerSummary(){
		return null;
	}

}
