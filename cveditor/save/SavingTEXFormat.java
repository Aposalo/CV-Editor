package cveditor.save;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import cveditor.main.buttons.SavingTemplate;


public class SavingTEXFormat extends SavingTemplate{
	
	private static String infoGeneralInformation;
	private static String infoProfessionalProfile  = "";
	private static String infoSkillsAndExperience;
	private static String infoCareerSummary;
	private static String infoEducationAndTraining;
	private static String infoFurtherCourses;
	private static String infoAdditionalInformation = "";
	private static String infoInterests = "";
	private static String infoCoreStrengths = "";
	private static String infoProfessionalExperience;
	private static String title;
	
	
	public static void createGeneralInfomation(String newInfoGeneralInformation){
		infoGeneralInformation="\\section*{1.	GENERAL INFORMATION}";
		String array[] = newInfoGeneralInformation.split("-");
		String name = array[0];
		title=name;
		String address = array[1];
		String telephone1 = array[2];
		String telephone2 = array[3];
		String email = array[4];
		infoGeneralInformation += "\nName "+name+"\nAddress "+address+"\nTelephone: (Home) "+telephone1
		+" (Mobile) "+telephone2+"\nEmail: "+email+"\n";
	}
	
	public static void createProfessionalProfile(String newInfoProfessionalProfile){
		infoProfessionalProfile="\\section*{2.	PROFESSIONAL PROFILE}";
		String array[] = newInfoProfessionalProfile.split(" ");
		infoProfessionalProfile += "\n		"+array[0]+" ";
		for(int i=1;i<array.length;i++){
			infoProfessionalProfile +=array[i]+" ";
			if(i%5==0){
				infoProfessionalProfile+="\n		";
			}
		}
	}
	
	public static void createSkillsAndExperience(ArrayList<String> skillsAndExperienceTitle,ArrayList<DefaultTableModel> skillsAndExperienceModelList){
		infoSkillsAndExperience="\n\\section*{3.	SKILLS AND EXPERIENCE}";
		infoSkillsAndExperience+="\n\\begin{itemize}";
		for(int i=0;i<skillsAndExperienceTitle.size();i++){
			infoSkillsAndExperience+="\n	\\item "+skillsAndExperienceTitle.get(i);
			infoSkillsAndExperience+="\n\\begin{itemize}";
			for(int j=0;j<skillsAndExperienceModelList.get(i).getRowCount();j++){
				infoSkillsAndExperience+="\n			\\item "+skillsAndExperienceModelList.get(i).getValueAt(j, 0).toString();
			}
			infoSkillsAndExperience+="\n\\end{itemize}";
		}
		infoSkillsAndExperience+="\n\\end{itemize}";
	}
	
	public static void createCareerSummary(DefaultTableModel modelCareerSummary){
		infoCareerSummary="\n\\section*{4.	CAREER SUMMARY}";
		infoCareerSummary+="\\begin{itemize}";
		for(int i=0;i<modelCareerSummary.getRowCount();i++){
			infoCareerSummary+="\n		\\item "+modelCareerSummary.getValueAt(i, 0).toString()+",";
			infoCareerSummary+=modelCareerSummary.getValueAt(i, 1).toString()+","+modelCareerSummary.getValueAt(i, 2).toString();
		}
		infoCareerSummary+="\n\\end{itemize}";
	}
 	
	public static void createEducationAndTraining(DefaultTableModel modelEducationAndTraining){
		infoEducationAndTraining="\n\\section*{5.	EDUCATION AND TRAINING}";
		infoEducationAndTraining+="\n\\begin{itemize}";
		for(int i=0;i<modelEducationAndTraining.getRowCount();i++){
			infoEducationAndTraining+="\n		\\item "+modelEducationAndTraining.getValueAt(i, 0).toString()+",";
			infoEducationAndTraining+=modelEducationAndTraining.getValueAt(i, 1).toString()+","+
			modelEducationAndTraining.getValueAt(i, 2).toString()+","+modelEducationAndTraining.getValueAt(i, 3).toString();
		}
		infoEducationAndTraining+="\n\\end{itemize}";
	}
	
	public static void createFurtherCourses(DefaultTableModel modelFurtherCourses){
		infoFurtherCourses="\n\\section*{6.	FURTHER COURSES}";
		infoFurtherCourses+="\n\\begin{itemize}";
		for(int i=0;i<modelFurtherCourses.getRowCount();i++){
			infoFurtherCourses+="\n		\\item "+modelFurtherCourses.getValueAt(i, 0).toString()+",";
			infoFurtherCourses+=modelFurtherCourses.getValueAt(i, 1).toString()+","+modelFurtherCourses.getValueAt(i, 2).toString()
					+","+modelFurtherCourses.getValueAt(i, 3).toString();
		}
		infoFurtherCourses+="\n\\end{itemize}";
	}
	
	public static void createAdditionalInformation(String newAdditionalInformation){
		infoAdditionalInformation="\n\\section*{7.	ADDITIONAL INFORMATION}";
		String array[] = newAdditionalInformation.split(" ");
		infoAdditionalInformation += "\n		"+array[0]+" ";
		for(int i=1;i<array.length;i++){
			infoAdditionalInformation +=array[i]+" ";
			if(i%6==0){
				infoAdditionalInformation+="\n		";
			}
		}
	}
	
	public static void createInterests(String newInterests){
		infoInterests="\n\\section*{8.	INTERESTS}";
		String array[] = newInterests.split(" ");
		infoInterests += "\n		"+array[0]+" ";
		for(int i=1;i<array.length;i++){
			infoInterests +=array[i]+" ";
			if(i%6==0){
				infoInterests+="\n		";
			}
		}
		infoInterests +="\n";
	}
	
	public static void createCoreStrengths(String newCoreStrengths){
		infoCoreStrengths="\n\\section*{3.	CORE STRENGTHS}";
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
		infoProfessionalExperience="\n\\section*{4.	PROFESSIONAL EXPERIENCE}";
		infoProfessionalExperience+="\n\\begin{itemize}";
		for(int i=0;i<professionalExperienceTitle.size();i++){
			infoProfessionalExperience+="\n		\\item "+professionalExperienceTitle.get(i);
			String array[] = professionalExperienceParagraph.get(i).split(" ");
			infoProfessionalExperience+="\n			\\item "+array[0]+" ";
			for(int j=1;j<array.length;j++){
				infoProfessionalExperience +=array[j]+" ";
				if(j%6==0){
					infoProfessionalExperience+="\n			\\item ";
				}
			}
			//infoProfessionalExperience+="\n			\\item "+professionalExperienceParagraph.get(i);
			infoProfessionalExperience+="\n\\begin{itemize}";
			for(int j=0;j<professionalExperienceModelList.get(i).getRowCount();j++){
				infoProfessionalExperience+="\n				\\item "+professionalExperienceModelList.get(i).getValueAt(j, 0).toString();
			}
			infoProfessionalExperience+="\n\\end{itemize}";
		}
		infoProfessionalExperience+="\n\\end{itemize}";
	}
	
	public static void createTEXSaveFileFunctional(){
		try {
			BufferedWriter writer =
			        new BufferedWriter ( new FileWriter(".\\"+title+".tex"));
					writer.write("\\documentclass[10pt]{article}\n");
					writer.write("\\date{}\n");
					writer.write("\\begin{document}\n");
					writer.write(infoGeneralInformation);
					writer.write(infoProfessionalProfile);
					writer.write(infoSkillsAndExperience);
					writer.write(infoCareerSummary);
					writer.write(infoEducationAndTraining);
					writer.write(infoFurtherCourses);
					writer.write(infoAdditionalInformation);
					writer.write(infoInterests);
					writer.write("\\end{document}");
					writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void createTEXSaveFileChronological(){
		try {
			BufferedWriter writer =
			        new BufferedWriter ( new FileWriter(".\\"+title+".tex"));
					writer.write("\\documentclass[10pt]{article}\n");
					writer.write("\\date{}\n");
					writer.write("\\begin{document}\n");
					writer.write(infoGeneralInformation);
					writer.write(infoProfessionalProfile);
					writer.write(infoCoreStrengths);
					writer.write(infoProfessionalExperience);
					writer.write(infoEducationAndTraining);
					writer.write(infoFurtherCourses);
					writer.write(infoAdditionalInformation);
					writer.write(infoInterests);
					writer.write("\\end{document}");
					writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void createTEXSaveFileCombined(){
		try {
			BufferedWriter writer =
			        new BufferedWriter ( new FileWriter(".\\"+title+".tex"));
					writer.write("\\documentclass[10pt]{article}\n");
					writer.write("\\date{}\n");
					writer.write("\\begin{document}\n");
					writer.write(infoGeneralInformation);
					writer.write(infoProfessionalProfile);
					writer.write(infoSkillsAndExperience);
					writer.write(infoProfessionalExperience);
					writer.write(infoEducationAndTraining);
					writer.write(infoFurtherCourses);
					writer.write(infoAdditionalInformation);
					writer.write(infoInterests);
					writer.write("\\end{document}");
					writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
