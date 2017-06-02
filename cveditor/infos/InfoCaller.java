package cveditor.infos;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import cveditor.manager.CVManager;

public class InfoCaller {
	
	
	private CVManager cv;
	private GeneralInformation generalInfo;//holds the objects so that we can call them again 
	private ProfessionalProfile professionalProf;//with the new information that we got from last time
	private AdditionalInformation additionalInfo;
	private Interests interInfo;
	private CoreStrengths coreStr;
	private SkillsAndExperience skillsAndExp;
	private CareerSummary careerSum;
	private EducationAndTraining educationAndTrain;
	private FurtherCourses furtherCrs;
	private ProfessionalExperience ProfessionalExp;
	
	
	public InfoCaller(CVManager cv){
		this.cv=cv;
	}
	

	public void callGeneralInformation(String infoGeneralInformation){
		generalInfo = new GeneralInformation(infoGeneralInformation,cv);
		generalInfo.getGeneralInformation();
	}
	
	public void callProfessionalProfile(String infoProfessionalProfile){
		professionalProf = new ProfessionalProfile(infoProfessionalProfile,cv);
		professionalProf.getProfessionalProfile();
	}
	
	public void callAdditionalInformation(String infoAdditionalInformation){
		additionalInfo = new AdditionalInformation(infoAdditionalInformation,cv);
		additionalInfo.getAdditionalInformation();
	}
	
	public void callInterests(String infoInterests){
		interInfo = new Interests(infoInterests,cv);
		interInfo.getInterests();
	}
	
	public void callSkillsAndExperience(int numberOfSkills,ArrayList<DefaultTableModel> skillsAndExperienceModelList,ArrayList<String> skillsAndExperienceTitle){
		skillsAndExp = new SkillsAndExperience(numberOfSkills,skillsAndExperienceModelList,skillsAndExperienceTitle,cv);
		skillsAndExp.getSkillsAndExperience();
	}
	
	public void callEducationAndTraining(DefaultTableModel modelEducationAndTraining){
		educationAndTrain = new EducationAndTraining(modelEducationAndTraining,cv);
		educationAndTrain.getEducationAndTraining();
	}
	
	public void callFurtherCourses(DefaultTableModel modelFurtherCourses){
		furtherCrs = new FurtherCourses(modelFurtherCourses,cv);
		furtherCrs.getFurtherCourses();
	}
	
	public void callCareerSummary(DefaultTableModel modelCareerSummary){
		careerSum = new CareerSummary(modelCareerSummary,cv);
		careerSum.getCareerSummary();
	}
	
	public void callCoreStrengths(String infoCoreStrengths){
		coreStr = new CoreStrengths(infoCoreStrengths,cv);
		coreStr.getCoreStrengths();
	}
	
	public void callProfessionalExperience(ArrayList<DefaultTableModel> professionalExperienceAchievementsModel,ArrayList<String> professionalExperienceTitle,ArrayList<String> professionalExperienceParagraph){
		ProfessionalExp = new ProfessionalExperience(professionalExperienceAchievementsModel,professionalExperienceTitle,professionalExperienceParagraph,cv);
		ProfessionalExp.getProfessionalExperience();
	}
	
	
	
	
	
}
