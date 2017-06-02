package cveditor.save;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import cveditor.main.buttons.SavingTemplate;

import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;


public class SavingTXTFormat extends SavingTemplate {

	private static String infoGeneralInformation;
	private static String infoProfessionalProfile;
	private static String infoSkillsAndExperience;
	private static String infoCareerSummary;
	private static String infoEducationAndTraining;
	private static String infoFurtherCourses;
	private static String infoAdditionalInformation;
	private static String infoInterests;
	private static String infoCoreStrengths;
	private static String infoProfessionalExperience;
	private static String title;
	
	public static void createGeneralInfomation(String newInfoGeneralInformation){
		String array[] = newInfoGeneralInformation.split("-");
		String name = array[0];
		title=name;
		String address = array[1];
		String telephone1 = array[2];
		String telephone2 = array[3];
		String email = array[4];
		infoGeneralInformation = "1.	GENERAL INFORMATION"+"\nName "+name+"\nAddress "+address+"\nTelephone: (Home) "+telephone1
		+" (Mobile) "+telephone2+"\nEmail: "+email;
	}
	
	public static void createProfessionalProfile(String newInfoProfessionalProfile){
		String array[] = newInfoProfessionalProfile.split(" ");
		infoProfessionalProfile = "\n2.	PROFESSIONAL PROFILE"+"\n		"+array[0]+" ";
		for(int i=1;i<array.length;i++){
			infoProfessionalProfile +=array[i]+" ";
			if(i%5==0){
				infoProfessionalProfile+="\n		";
			}
		}
	}
	
	public static void createSkillsAndExperience(ArrayList<String> skillsAndExperienceTitle,ArrayList<DefaultTableModel> skillsAndExperienceModelList){
		infoSkillsAndExperience="\n3.	SKILLS AND EXPERIENCE";
		for(int i=0;i<skillsAndExperienceTitle.size();i++){
			infoSkillsAndExperience+="\n	"+skillsAndExperienceTitle.get(i);
			for(int j=0;j<skillsAndExperienceModelList.get(i).getRowCount();j++){
				infoSkillsAndExperience+="\n			"+skillsAndExperienceModelList.get(i).getValueAt(j, 0).toString();
			}
		}
	}
	
	public static void createCareerSummary(DefaultTableModel modelCareerSummary){
		infoCareerSummary = "\n4.	CAREER SUMMARY";
		for(int i=0;i<modelCareerSummary.getRowCount();i++){
			infoCareerSummary+="\n		"+modelCareerSummary.getValueAt(i, 0).toString()+",";
			infoCareerSummary+=modelCareerSummary.getValueAt(i, 1).toString()+","+modelCareerSummary.getValueAt(i, 2).toString();
		}
	}
	
	public static void createEducationAndTraining(DefaultTableModel modelEducationAndTraining){
		infoEducationAndTraining = "\n5.	EDUCATION AND TRAINING";
		System.out.println(modelEducationAndTraining.getRowCount());
		for(int i=0;i<modelEducationAndTraining.getRowCount();i++){
			infoEducationAndTraining+="\n		"+modelEducationAndTraining.getValueAt(i, 0).toString()+",";
			infoEducationAndTraining+=modelEducationAndTraining.getValueAt(i, 1).toString()+","+
			modelEducationAndTraining.getValueAt(i, 2).toString()+","+modelEducationAndTraining.getValueAt(i, 3).toString();
		}
	}
	
	public static void createFurtherCourses(DefaultTableModel modelFurtherCourses){
		infoFurtherCourses = "\n6.	FURTHER COURSES";
		for(int i=0;i<modelFurtherCourses.getRowCount();i++){
			infoFurtherCourses+="\n		"+modelFurtherCourses.getValueAt(i, 0).toString()+",";
			infoFurtherCourses+=modelFurtherCourses.getValueAt(i, 1).toString()+","+modelFurtherCourses.getValueAt(i, 2).toString()
					+","+modelFurtherCourses.getValueAt(i, 3).toString();
		}
	}
	
	public static void createAdditionalInformation(String newAdditionalInformation){
		infoAdditionalInformation = "\n7.	ADDITIONAL INFORMATION";
		String array[] = newAdditionalInformation.split(" ");
		infoAdditionalInformation += "\n		"+array[0]+" ";
		for(int i=1;i<array.length;i++){
			infoAdditionalInformation +=array[i]+" ";
			if(i%5==0){
				infoAdditionalInformation+="\n		";
			}
		}
	}
	
	public static void createInterests(String newInterests){
		infoInterests = "\n8.	INTERESTS";
		String array[] = newInterests.split(" ");
		infoInterests += "\n		"+array[0]+" ";
		for(int i=1;i<array.length;i++){
			infoInterests +=array[i]+" ";
			if(i%5==0){
				infoInterests+="\n		";
			}
		}
		
	}
	
	public static void createCoreStrengths(String newCoreStrengths){
		infoCoreStrengths = "\n3.	CORE STRENGTHS";
		String array[] = newCoreStrengths.split(" ");
		infoCoreStrengths += "\n		"+array[0]+" ";
		for(int i=1;i<array.length;i++){
			infoCoreStrengths +=array[i]+" ";
			if(i%6==0){
				infoCoreStrengths+="\n		";
			}
		}
		
		
	}
	
	public static void createProfessionalExperience(ArrayList<DefaultTableModel> professionalExperienceModelList,ArrayList<String>
	professionalExperienceTitle,ArrayList<String> professionalExperienceParagraph){
		infoProfessionalExperience="\n4.	PROFESSIONAL EXPERIENCE";
		for(int i=0;i<professionalExperienceTitle.size();i++){
			infoProfessionalExperience+="\n		"+professionalExperienceTitle.get(i);
			String array[] = professionalExperienceParagraph.get(i).split(" ");
			infoProfessionalExperience+="\n			"+array[0]+" ";
			for(int j=1;j<array.length;j++){
				infoProfessionalExperience+=array[j]+" ";
				if(j%6==0){
					infoProfessionalExperience+="\n			";
				}
			}
			for(int j=0;j<professionalExperienceModelList.get(i).getRowCount();j++){
				infoProfessionalExperience+="\n				"+professionalExperienceModelList.get(i).getValueAt(j, 0).toString();
			}
		}
	}
	
	public static void createTXTSaveFileFunctional(){
		try {
			BufferedWriter writer =
			        new BufferedWriter ( new FileWriter(".\\"+title+".txt"));
					writer.write(infoGeneralInformation);
					writer.write(infoProfessionalProfile);
					writer.write(infoSkillsAndExperience);
					writer.write(infoCareerSummary);
					writer.write(infoEducationAndTraining);
					writer.write(infoFurtherCourses);
					writer.write(infoAdditionalInformation);
					writer.write(infoInterests);
					writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void createTXTSaveFileChronological(){
		try {
			BufferedWriter writer =
			        new BufferedWriter ( new FileWriter(".\\"+title+".txt"));
					writer.write(infoGeneralInformation);
					writer.write(infoProfessionalProfile);
					writer.write(infoCoreStrengths);
					writer.write(infoProfessionalExperience);
					writer.write(infoEducationAndTraining);
					writer.write(infoFurtherCourses);
					writer.write(infoAdditionalInformation);
					writer.write(infoInterests);
					writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void createTXTSaveFileCombined(){
		try {
			BufferedWriter writer =
			        new BufferedWriter ( new FileWriter(".\\"+title+".txt"));
					writer.write(infoGeneralInformation);
					writer.write(infoProfessionalProfile);
					writer.write(infoSkillsAndExperience);
					writer.write(infoProfessionalExperience);
					writer.write(infoEducationAndTraining);
					writer.write(infoFurtherCourses);
					writer.write(infoAdditionalInformation);
					writer.write(infoInterests);
					writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
