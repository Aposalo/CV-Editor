package cveditor.open;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import cveditor.main.buttons.OpeningFile;
import cveditor.manager.CVManagerChronological;
import cveditor.manager.CVManagerCombined;
import cveditor.manager.CVManagerFunctional;



public class OpeningTXTFile extends OpeningFile {
	
	private String line;
	private BufferedReader in;
	private String array[];
	private String newArray[];
	
	private String template;
	
	private String infoGeneralInformation;
	
	private String infoCoreStrengths = "";
	
	private String infoProfessionalProfile = "";
	
	private String infoInterests = "";
	
	private String infoAdditionalInformation = "";
	
	private ArrayList<DefaultTableModel> skillsAndExperienceModelList = new ArrayList<DefaultTableModel>();
	private JTable table = new JTable();
	private ArrayList<String> skillsAndExperienceTitle = new ArrayList<String>();
	private int numberOfSkills = 1;
	
	private ArrayList<DefaultTableModel> professionalExperienceAchievementsModel = new ArrayList<DefaultTableModel>();
	private ArrayList<String> professionalExperienceTitle = new ArrayList<String>();
	private ArrayList<String> professionalExperienceParagraph = new ArrayList<String>();
	
	private DefaultTableModel modelEducationAndTraining;
	
	private DefaultTableModel modelFurtherCourses;
	
	private DefaultTableModel modelCareerSummary;
	
	public void openGeneralInformation() throws IOException{
		line = in.readLine();
        array = line.split(" ");
        infoGeneralInformation = array[1];
        for(int i=2;i<array.length-1;i++){
        	infoGeneralInformation += (" "+array[i]);
        }
        if(array.length>2){
        	infoGeneralInformation += " "+array[array.length-1];
        }
        infoGeneralInformation +="-";
        
        line = in.readLine();
        array = line.split(" ");
        infoGeneralInformation += array[1]+" ";
        for(int i=2;i<array.length-1;i++){
        	infoGeneralInformation += (array[i]+" ");
        }
        if(array.length>2){
        	infoGeneralInformation += array[array.length-1];
        }
        infoGeneralInformation +="-";
        
        line = in.readLine();
        array = line.split(" ");
        infoGeneralInformation += array[2]+"-";
        infoGeneralInformation += array[4]+"-";
        
        line = in.readLine();
        array = line.split(" ");
        infoGeneralInformation += array[1];
	}
	
	public void openProfessionalProfile() throws IOException{
		line = in.readLine();
		array = line.split("	");
	    while(!(array[0].equals("3."))){
		    infoProfessionalProfile += array[2]+" ";
		    line = in.readLine();
		    array = line.split("	");
	    }
	}
	
	public void openSkillsAndExperience() throws IOException{
		String title;
		String check;
		String word;
		DefaultTableModel model;
		line = in.readLine();
		array = line.split("	");
		newArray = array[0].split("	");
		while(!(newArray[0].equals("4."))){
			title = array[1]+" "+array[2];
    		skillsAndExperienceTitle.add(title);
			line = in.readLine();
			array = line.split(" ");
    		newArray = array[0].split("	");
    		
    		numberOfSkills++;
    		check="3."+numberOfSkills+".";
    		model = (DefaultTableModel) table.getModel();
    		model.addColumn(null);
    		while(!(newArray[1].equals(check)||newArray[0].equals("4."))){
    			word = newArray[3];
    			
    			for(int i=1;i<array.length;i++){
    				word+=" "+array[i];
    			}
    			model.addRow(new Object[]{});
    			model.setValueAt(word, model.getRowCount()-1, 0);
    			line = in.readLine();
    			array = line.split(" ");
        		newArray = array[0].split("	");
    		}
    		if(model.getRowCount()>0){
    			skillsAndExperienceModelList.add(model);
        		table = new JTable();
    		}
    		array = line.split("	");
    		newArray = array[0].split("	");
		}
	}
	
	public void openProfessionalExperience() throws IOException{
		array = line.split(" ");
		newArray = array[0].split("	");
		String companyName;
		String jobTitle;
		String date;
		String paragraph = "";
		String word;
		DefaultTableModel model;
		line = in.readLine();
		while(!(line.equals("5.	EDUCATION AND TRAINING"))){
			String title;
			array = line.split(",");
    		newArray = array[0].split("	");
    		companyName = newArray[newArray.length-1];
    		jobTitle = array[1];
    		date = array[2];
    		title = companyName+","+jobTitle+","+date;
    		professionalExperienceTitle.add(title);
    		line = in.readLine();
			array = line.split(" ");
    		newArray = array[0].split("	");
    		while(newArray.length==4){
    			paragraph += newArray[3];
        		for(int i=1;i<array.length;i++){
        			paragraph +=" "+array[i];
        		}
    			line = in.readLine();
    			array = line.split(" ");
        		newArray = array[0].split("	");
        		paragraph +=" ";
    		}
    		professionalExperienceParagraph.add(paragraph);
    		model = (DefaultTableModel) table.getModel();
    		model.addColumn(null);
    		while(newArray.length==5){
    			word = newArray[4];
    			for(int i=1;i<array.length;i++){
    				word+=" "+array[i];
    			}
    			model.addRow(new Object[]{});
    			model.setValueAt(word, model.getRowCount()-1, 0);
    			line = in.readLine();
    			array = line.split(" ");
        		newArray = array[0].split("	");
    		}
    		if(model.getRowCount()>0){
    			professionalExperienceAchievementsModel.add(model);
        		table = new JTable();
    		}
    		
		}
	}
	
	public void openCareerSummary() throws IOException{
		line = in.readLine();
		array = line.split(",");
		newArray = array[0].split("	");
		modelCareerSummary = (DefaultTableModel) table.getModel();
		modelCareerSummary.addColumn("Career Name");
		modelCareerSummary.addColumn("Job Title");
		modelCareerSummary.addColumn("Date");
		while(!(line.equals("5.	EDUCATION AND TRAINING"))){
			modelCareerSummary.addRow(new Object[]{});
			modelCareerSummary.setValueAt(newArray[newArray.length-1], modelCareerSummary.getRowCount()-1, 0);
			modelCareerSummary.setValueAt(array[1], modelCareerSummary.getRowCount()-1, 1);
			modelCareerSummary.setValueAt(array[2], modelCareerSummary.getRowCount()-1, 2);
			line = in.readLine();
			array = line.split(",");
			newArray = array[0].split("	");
		}
		table = new JTable();
	}
	
	public void openEducationAndTraining() throws IOException{
		line = in.readLine();
		array = line.split(",");
		newArray = array[0].split("	");
		modelEducationAndTraining = (DefaultTableModel) table.getModel();
		modelEducationAndTraining.addColumn("Qualification");
		modelEducationAndTraining.addColumn("Establishment");
		modelEducationAndTraining.addColumn("Location");
		modelEducationAndTraining.addColumn("Date");
		while(!(line.equals("6.	FURTHER COURSES"))){
			modelEducationAndTraining.addRow(new Object[]{});
			modelEducationAndTraining.setValueAt(newArray[newArray.length-1], modelEducationAndTraining.getRowCount()-1, 0);
			modelEducationAndTraining.setValueAt(array[1], modelEducationAndTraining.getRowCount()-1, 1);
			modelEducationAndTraining.setValueAt(array[2], modelEducationAndTraining.getRowCount()-1, 2);
			modelEducationAndTraining.setValueAt(array[3], modelEducationAndTraining.getRowCount()-1, 3);
			line = in.readLine();
			array = line.split(",");
			newArray = array[0].split("	");
		}
		table = new JTable();
	}
	
	public void openFurtherCourses() throws IOException{
		line = in.readLine();
		array = line.split(",");
		newArray = array[0].split("	");
		modelFurtherCourses = (DefaultTableModel) table.getModel();
		modelFurtherCourses.addColumn("Course");
		modelFurtherCourses.addColumn("Establishment");
		modelFurtherCourses.addColumn("Location");
		modelFurtherCourses.addColumn("Date");
		while(!(line.equals("7.	ADDITIONAL INFORMATION"))){
			modelFurtherCourses.addRow(new Object[]{});
			modelFurtherCourses.setValueAt(newArray[newArray.length-1], modelFurtherCourses.getRowCount()-1, 0);
			modelFurtherCourses.setValueAt(array[1], modelFurtherCourses.getRowCount()-1, 1);
			modelFurtherCourses.setValueAt(array[2], modelFurtherCourses.getRowCount()-1, 2);
			modelFurtherCourses.setValueAt(array[3], modelFurtherCourses.getRowCount()-1, 3);
			line = in.readLine();
			array = line.split(",");
			newArray = array[0].split("	");
		}
		table = new JTable();
	}
	
	public void openAdditionalInformation() throws IOException{
		line = in.readLine();
		array = line.split("	");
	    while(!(array[0].equals("8."))){
	    	infoAdditionalInformation += array[2]+" ";
		    line = in.readLine();
		    array = line.split("	");
	    }
	}
	
	public void openInterests() throws IOException{
		line = in.readLine();
		array = line.split("	");
	    while(line!=null){
	    	infoInterests += array[2]+" ";
		    line = in.readLine();
		    if(line!=null){
		    	array = line.split("	");
		    }
	    }
	}
	
	public void openCoreStrengths() throws IOException{
		line = in.readLine();
		array = line.split("	");
	    while(!(array[0].equals("4."))){
		    infoCoreStrengths += array[2]+" ";
		    line = in.readLine();
		    array = line.split("	");
	    }
	}
	
	
	
	@SuppressWarnings("static-access")
	public void readFile(String name) throws IOException{//opens a txt file
        in = new BufferedReader(new FileReader(name));
        line = in.readLine();
        boolean check = false;
        
        if(line.equals("1.	GENERAL INFORMATION")){
        	openGeneralInformation();
        }
        
        line = in.readLine();
        if(line.equals("2.	PROFESSIONAL PROFILE")){
        	openProfessionalProfile();
        }
        
        if(line.equals("3.	SKILLS AND EXPERIENCE")){
        	openSkillsAndExperience();
        }
        
        else if(line.equals("3.	CORE STRENGTHS")){
        	openCoreStrengths();
        	template="Chronological";
        	check = true;
        }
        
        if(line.equals("4.	PROFESSIONAL EXPERIENCE")){
        	openProfessionalExperience();
        	if(check==false){
        		template="Combined";
        	}
        }
        
        else if(line.equals("4.	CAREER SUMMARY")){
        	openCareerSummary();
        	template="Functional";
        }
        
        if(line.equals("5.	EDUCATION AND TRAINING")){
        	openEducationAndTraining();
        }
        
        if(line.equals("6.	FURTHER COURSES")){
        	openFurtherCourses();
        }
        
        if(line.equals("7.	ADDITIONAL INFORMATION")){
        	openAdditionalInformation();
        }
        
        if(line.equals("8.	INTERESTS")){
        	openInterests();
        }
		in.close();
		
		if(template.equals("Functional")){
			super.manager = new CVManagerFunctional();
			super.manager.setTemplate(template);
			super.manager.setGeneralInformation(infoGeneralInformation);
			super.manager.setProfessionalProfile(infoProfessionalProfile);
			super.manager.setSkillsAndExperience(numberOfSkills, skillsAndExperienceModelList, skillsAndExperienceTitle);
			super.manager.setCareerSummary(modelCareerSummary);
			super.manager.setEducationAndTraining(modelEducationAndTraining);
			super.manager.setFurtherCourses(modelFurtherCourses);
			super.manager.setAdditionalInformation(infoAdditionalInformation);
			super.manager.setInterests(infoInterests);
		}
		
		else if(template.equals("Chronological")){
			super.manager = new CVManagerChronological();
			super.manager.setTemplate(template);
			super.manager.setGeneralInformation(infoGeneralInformation);
			super.manager.setProfessionalProfile(infoProfessionalProfile);
			super.manager.setCoreStrengths(infoCoreStrengths);
			super.manager.setProfessionalExperience(professionalExperienceAchievementsModel, professionalExperienceTitle, professionalExperienceParagraph);
			super.manager.setEducationAndTraining(modelEducationAndTraining);
			super.manager.setFurtherCourses(modelFurtherCourses);
			super.manager.setAdditionalInformation(infoAdditionalInformation);
			super.manager.setInterests(infoInterests);
		}
		
		else if(template.equals("Combined")){
			super.manager = new CVManagerCombined();
			super.manager.setTemplate(template);
			super.manager.setGeneralInformation(infoGeneralInformation);
			super.manager.setProfessionalProfile(infoProfessionalProfile);
			super.manager.setProfessionalExperience(professionalExperienceAchievementsModel, professionalExperienceTitle, professionalExperienceParagraph);
			super.manager.setSkillsAndExperience(numberOfSkills, skillsAndExperienceModelList, skillsAndExperienceTitle);
			super.manager.setEducationAndTraining(modelEducationAndTraining);
			super.manager.setFurtherCourses(modelFurtherCourses);
			super.manager.setAdditionalInformation(infoAdditionalInformation);
			super.manager.setInterests(infoInterests);
		}
		OpeningFile.getFile(super.manager);
	}
}
