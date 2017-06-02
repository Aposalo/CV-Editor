package cveditor.main.buttons;

import cveditor.manager.CVManager;
import cveditor.save.SavingTEXFormat;
import cveditor.save.SavingTXTFormat;
import cveditor.save.SelectingFormat;

public class SavingTemplate{
	
	private static String template;
	private static String format;
	private static CVManager manager;
	
	public void saveFile(CVManager manager){
		template = manager.getTemplate();
		SavingTemplate.manager=manager;
		SelectingFormat.setSelectingFormat();//opens a window and the user selects one of the two formats
	}
	
	public static void selectSaveFormat(String newFormat){
		format = newFormat;
	}
	
	
	public static void saveTemplateTXT(){
		
		if(template.equals("Functional")){
			
			SavingTXTFormat.createGeneralInfomation(manager.getGeneralInformation());
			SavingTXTFormat.createProfessionalProfile(manager.getProfessionalProfile());
			SavingTXTFormat.createSkillsAndExperience(manager.getSkillsAndExperienceTitle(), manager.getSkillsAndExperienceModelList());
			SavingTXTFormat.createCareerSummary(manager.getCareerSummary());
			SavingTXTFormat.createEducationAndTraining(manager.getEducationAndTraining());
			SavingTXTFormat.createFurtherCourses(manager.getFurtherCourses());
			SavingTXTFormat.createAdditionalInformation(manager.getAdditionalInformation());
			SavingTXTFormat.createInterests(manager.getInterests());
			SavingTXTFormat.createTXTSaveFileFunctional();
			
		}
		
		else if(template.equals("Chronological")){
			
			SavingTXTFormat.createGeneralInfomation(manager.getGeneralInformation());
			SavingTXTFormat.createProfessionalProfile(manager.getProfessionalProfile());
			SavingTXTFormat.createCoreStrengths(manager.getCoreStrengths());
			SavingTXTFormat.createProfessionalExperience(manager.getProfessionalExperienceModelList(), manager.getProfessionalExperienceTitle(), manager.getProfessionalExperienceParagraph());
			SavingTXTFormat.createEducationAndTraining(manager.getEducationAndTraining());
			SavingTXTFormat.createFurtherCourses(manager.getFurtherCourses());
			SavingTXTFormat.createAdditionalInformation(manager.getAdditionalInformation());
			SavingTXTFormat.createInterests(manager.getInterests());
			SavingTXTFormat.createTXTSaveFileChronological();
			
		}
		
		else if(template.equals("Combined")){
			
			SavingTXTFormat.createGeneralInfomation(manager.getGeneralInformation());
			SavingTXTFormat.createProfessionalProfile(manager.getProfessionalProfile());
			SavingTXTFormat.createSkillsAndExperience(manager.getSkillsAndExperienceTitle(), manager.getSkillsAndExperienceModelList());
			SavingTXTFormat.createProfessionalExperience(manager.getProfessionalExperienceModelList(), manager.getProfessionalExperienceTitle(), manager.getProfessionalExperienceParagraph());
			SavingTXTFormat.createEducationAndTraining(manager.getEducationAndTraining());
			SavingTXTFormat.createFurtherCourses(manager.getFurtherCourses());
			SavingTXTFormat.createAdditionalInformation(manager.getAdditionalInformation());
			SavingTXTFormat.createInterests(manager.getInterests());
			SavingTXTFormat.createTXTSaveFileCombined();
			
		}
	}
	
	
	
	public static void saveTemplateTEX(){
		if(template.equals("Functional")){
			SavingTEXFormat.createGeneralInfomation(manager.getGeneralInformation());
			SavingTEXFormat.createProfessionalProfile(manager.getProfessionalProfile());
			SavingTEXFormat.createSkillsAndExperience(manager.getSkillsAndExperienceTitle(), manager.getSkillsAndExperienceModelList());
			SavingTEXFormat.createCareerSummary(manager.getCareerSummary());
			SavingTEXFormat.createEducationAndTraining(manager.getEducationAndTraining());
			SavingTEXFormat.createFurtherCourses(manager.getFurtherCourses());
			SavingTEXFormat.createAdditionalInformation(manager.getAdditionalInformation());
			SavingTEXFormat.createInterests(manager.getInterests());
			SavingTEXFormat.createTEXSaveFileFunctional();
		}
		else if(template.equals("Chronological")){
			SavingTEXFormat.createGeneralInfomation(manager.getGeneralInformation());
			SavingTEXFormat.createProfessionalProfile(manager.getProfessionalProfile());
			SavingTEXFormat.createCoreStrengths(manager.getCoreStrengths());
			SavingTEXFormat.createProfessionalExperience(manager.getProfessionalExperienceModelList(), manager.getProfessionalExperienceTitle(), manager.getProfessionalExperienceParagraph());
			SavingTEXFormat.createEducationAndTraining(manager.getEducationAndTraining());
			SavingTEXFormat.createFurtherCourses(manager.getFurtherCourses());
			SavingTEXFormat.createAdditionalInformation(manager.getAdditionalInformation());
			SavingTEXFormat.createInterests(manager.getInterests());
			SavingTEXFormat.createTEXSaveFileChronological();
		}
		else if(template.equals("Combined")){
			SavingTEXFormat.createGeneralInfomation(manager.getGeneralInformation());
			SavingTEXFormat.createProfessionalProfile(manager.getProfessionalProfile());
			SavingTEXFormat.createSkillsAndExperience(manager.getSkillsAndExperienceTitle(), manager.getSkillsAndExperienceModelList());
			SavingTEXFormat.createProfessionalExperience(manager.getProfessionalExperienceModelList(), manager.getProfessionalExperienceTitle(), manager.getProfessionalExperienceParagraph());
			SavingTEXFormat.createEducationAndTraining(manager.getEducationAndTraining());
			SavingTEXFormat.createFurtherCourses(manager.getFurtherCourses());
			SavingTEXFormat.createAdditionalInformation(manager.getAdditionalInformation());
			SavingTEXFormat.createInterests(manager.getInterests());
			SavingTEXFormat.createTEXSaveFileCombined();
		}
	}
	
	
	

	public static void saveTemplate(){//after the format is selected a file is created with the given information
		if(format.equals("txt")){
			saveTemplateTXT();
		}
		else if(format.equals("tex")){
			saveTemplateTEX();
		}
	}
	
}
