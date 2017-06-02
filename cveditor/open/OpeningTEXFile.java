package cveditor.open;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import cveditor.main.buttons.OpeningFile;
import cveditor.manager.CVManagerChronological;
import cveditor.manager.CVManagerCombined;
import cveditor.manager.CVManagerFunctional;

public class OpeningTEXFile extends OpeningFile  {

	private String line;
	private BufferedReader in;
	private String array[];
	private String newArray[];
	
	private String template;
	
	private String infoGeneralInformation = "";
	
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
	
	public String readArray(String line){
		array=line.split(" ");
		String read = array[1];
		for(int i=2;i<array.length;i++){
			read +=" "+array[i];
		}
		return read;
	}
	
	
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
		infoProfessionalProfile = "";
	    while(!(line.equals("\\section*{3.	SKILLS AND EXPERIENCE}"))){
		    infoProfessionalProfile += array[2] + " ";
		    line = in.readLine();
		    array = line.split("	");
	    }
	}
	
	public void openSkillsAndExperience() throws IOException{
		String title = "";
		String word;
		DefaultTableModel model;
		line = in.readLine();
		if(line.equals("\\begin{itemize}")){
			line = in.readLine();
			while(!(line.equals("\\end{itemize}"))){
				title = "";
				array = line.split(" ");
				for(int i=1;i<array.length-1;i++){
					title +=array[i] + " ";
				}
				title +=array[array.length-1]; 
				skillsAndExperienceTitle.add(title);
				line = in.readLine();
				numberOfSkills++;
				model = (DefaultTableModel) table.getModel();
	    		model.addColumn(null);
				if(line.equals("\\begin{itemize}")){
					line = in.readLine();
					array = line.split(" ");
					while(!(line.equals("\\end{itemize}"))){
						word = array[1];
						for(int i=2;i<array.length;i++){
		    				word+=" "+array[i];
		    			}
						model.addRow(new Object[]{});
		    			model.setValueAt(word, model.getRowCount()-1, 0);
		    			line = in.readLine();
						array = line.split(" ");
					}
					skillsAndExperienceModelList.add(model);
	        		table = new JTable();
					line = in.readLine();
				}
			}
		}
	}
	
	public void openCoreStrengths() throws IOException{
		line = in.readLine();
		array = line.split("	");
	    while(!(line.equals("\\section*{4.	PROFESSIONAL EXPERIENCE}"))){
		    infoCoreStrengths += array[2]+" ";
		    line = in.readLine();
		    array = line.split("	");
	    }
	}
	
	public void openProfessionalExperience() throws IOException{
		line = in.readLine();
		array = line.split(" ");
		String companyName;
		String jobTitle;
		String date;
		String paragraph = "";
		String word = "";
		DefaultTableModel model;
		while(!(line.equals("\\section*{5.	EDUCATION AND TRAINING}"))){
			String title;
			line = in.readLine();
			array = line.split(" ");
			if(line.equals("\\end{itemize}")){
				return;
			}
			newArray = array[1].split(",");
			companyName = newArray[0];
			jobTitle = newArray[1];
			
    		date = newArray[2];
    		title = companyName+","+jobTitle+","+date;
    		professionalExperienceTitle.add(title);
    		line = in.readLine();
    		array = line.split(" ");
    		while(!(line.equals("\\begin{itemize}"))){
    			for(int i=1;i<array.length;i++){
    				paragraph +=array[i]+" ";
    			}
    			line = in.readLine();
        		array = line.split(" ");
    		}
    		professionalExperienceParagraph.add(paragraph);
    		paragraph = "";
    		model = (DefaultTableModel) table.getModel();
    		model.addColumn(null);
    		line = in.readLine();
    		array = line.split(" ");
    		word = "";
    		while(!(line.equals("\\end{itemize}"))){
    			for(int i=1;i<array.length;i++){
    				word+=array[i]+" ";
    			}
    			model.addRow(new Object[]{});
    			model.setValueAt(word, model.getRowCount()-1, 0);
    			line = in.readLine();
    			array = line.split(" ");
    			word = "";
    		}
    		professionalExperienceAchievementsModel.add(model);
    		table = new JTable();
		}
	}
	
	public void openCareerSummary() throws IOException{
		
		line = in.readLine();
		
		
		modelCareerSummary = (DefaultTableModel) table.getModel();
		modelCareerSummary.addColumn("Career Name");
		modelCareerSummary.addColumn("Job Title");
		modelCareerSummary.addColumn("Date");
		line = in.readLine();
		newArray = line.split(",");
		while(!(line.equals("\\end{itemize}"))){
			
			modelCareerSummary.addRow(new Object[]{});
			modelCareerSummary.setValueAt(readArray(newArray[0]), modelCareerSummary.getRowCount()-1, 0);
			modelCareerSummary.setValueAt(newArray[1], modelCareerSummary.getRowCount()-1, 1);
			modelCareerSummary.setValueAt(newArray[2], modelCareerSummary.getRowCount()-1, 2);
			
			line = in.readLine();
			newArray = line.split(",");
		}
		
		table = new JTable();
		
	}
	
	public void openEducationAndTraining() throws IOException{
		line = in.readLine();
		line = in.readLine();
		newArray = line.split(",");
		
		modelEducationAndTraining = (DefaultTableModel) table.getModel();
		modelEducationAndTraining.addColumn("Qualification");
		modelEducationAndTraining.addColumn("Establishment");
		modelEducationAndTraining.addColumn("Location");
		modelEducationAndTraining.addColumn("Date");
		
		while(!(line.equals("\\end{itemize}"))){
			
			modelEducationAndTraining.addRow(new Object[]{});
			modelEducationAndTraining.setValueAt(readArray(newArray[0]), modelEducationAndTraining.getRowCount()-1, 0);
			modelEducationAndTraining.setValueAt(newArray[1], modelEducationAndTraining.getRowCount()-1, 1);
			modelEducationAndTraining.setValueAt(newArray[2], modelEducationAndTraining.getRowCount()-1, 2);
			modelEducationAndTraining.setValueAt(newArray[3], modelEducationAndTraining.getRowCount()-1, 3);
			
			line = in.readLine();
			newArray = line.split(",");
			
		}
		table = new JTable();
	}
	
	public void openFurtherCourses() throws IOException{
		line = in.readLine();
		line = in.readLine();
		newArray = line.split(",");
		
		modelFurtherCourses = (DefaultTableModel) table.getModel();
		modelFurtherCourses.addColumn("Course");
		modelFurtherCourses.addColumn("Establishment");
		modelFurtherCourses.addColumn("Location");
		modelFurtherCourses.addColumn("Date");
		
		while(!(line.equals("\\end{itemize}"))){
			modelFurtherCourses.addRow(new Object[]{});
			modelFurtherCourses.setValueAt(readArray(newArray[0]), modelFurtherCourses.getRowCount()-1, 0);
			modelFurtherCourses.setValueAt(newArray[1], modelFurtherCourses.getRowCount()-1, 1);
			modelFurtherCourses.setValueAt(newArray[2], modelFurtherCourses.getRowCount()-1, 2);
			modelFurtherCourses.setValueAt(newArray[3], modelFurtherCourses.getRowCount()-1, 3);
			
			line = in.readLine();
			array = line.split(" ");
			newArray = line.split(",");
			
		}
		
		table = new JTable();
	}
	
	public void openAdditionalInformation() throws IOException{
		line = in.readLine();
		array = line.split("	");
		infoAdditionalInformation = "";
	    while(!(line.equals("\\section*{8.	INTERESTS}"))){
	    	infoAdditionalInformation += array[2] + " ";
		    line = in.readLine();
		    array = line.split("	");
	    }
	}
	
	public void openInterests() throws IOException{
		line = in.readLine();
		array = line.split("	");
		infoInterests = "";
		while(!(line.equals("\\end{document}"))){
	    	infoInterests += array[2] + " ";
		    line = in.readLine();
		    if(line!=null){
		    	array = line.split("	");
		    }
	    }
	}
	
	
	@SuppressWarnings("static-access")
	public void readFile(String name) throws IOException{//opens a tex file
		boolean check = false;
		in = new BufferedReader(new FileReader(name));
        line = in.readLine();
        line = in.readLine();
        line = in.readLine();
        line = in.readLine();
        
        array = line.split(Pattern.quote("{"));
        newArray = array[1].split(Pattern.quote("}"));
        
        if(newArray[0].equals("1.	GENERAL INFORMATION")){
        	openGeneralInformation();
        }
        
        line = in.readLine();
        array = line.split(Pattern.quote("{"));
        newArray = array[1].split(Pattern.quote("}"));
        
        if(newArray[0].equals("2.	PROFESSIONAL PROFILE")){
        	openProfessionalProfile();
        }
        
        array = line.split(Pattern.quote("{"));
        newArray = array[1].split(Pattern.quote("}"));
        
        if(newArray[0].equals("3.	SKILLS AND EXPERIENCE")){
        	openSkillsAndExperience();
        }
        
        else if(newArray[0].equals("3.	CORE STRENGTHS")){
        	openCoreStrengths();
        	template="Chronological";
        	check = true;
        }
        
        line = in.readLine();
        array = line.split(Pattern.quote("{"));
        newArray = array[1].split(Pattern.quote("}"));
        
        if(newArray[0].equals("4.	PROFESSIONAL EXPERIENCE")){
        	openProfessionalExperience();
        	if(check==false){
        		template="Combined";
        	}
        }
        
        else if(newArray[0].equals("4.	CAREER SUMMARY")){
        	openCareerSummary();
        	template="Functional";
        }
        
        line = in.readLine();
        array = line.split(Pattern.quote("{"));
        newArray = array[1].split(Pattern.quote("}"));
        
        if(newArray[0].equals("5.	EDUCATION AND TRAINING")){
        	openEducationAndTraining();
        }
        
        line = in.readLine();
        array = line.split(Pattern.quote("{"));
        newArray = array[1].split(Pattern.quote("}"));
        
        if(newArray[0].equals("6.	FURTHER COURSES")){
        	openFurtherCourses();
        }
        
        line = in.readLine();
        array = line.split(Pattern.quote("{"));
        newArray = array[1].split(Pattern.quote("}"));
        
        if(newArray[0].equals("7.	ADDITIONAL INFORMATION")){
        	openAdditionalInformation();
        }
        
        array = line.split(Pattern.quote("{"));
        newArray = array[1].split(Pattern.quote("}"));
        
        if(newArray[0].equals("8.	INTERESTS")){
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
	}
}
