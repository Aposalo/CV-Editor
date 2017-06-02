package cveditor.merge;

import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import cveditor.main.buttons.TemplateInitializitation;
import cveditor.manager.CVManager;
import cveditor.manager.CVManagerChronological;
import cveditor.manager.CVManagerCombined;
import cveditor.manager.CVManagerFunctional;

public class ShowingDifferences {
	
	private CVManager manager1;
	private CVManager manager2;
	private CVManager manager;
	
	private JTable careerSummaryTable = new JTable();
	private DefaultTableModel modelCareerSummary;
	
	private JTable educationAndTrainingTable = new JTable();
	private DefaultTableModel modelEducationAndTraining;

	private JTable furtherCoursesTable = new JTable();
	private DefaultTableModel modelFurtherCourses;
	
	private ArrayList<DefaultTableModel> skillsAndExperienceModelList = new ArrayList<DefaultTableModel>();
	private ArrayList<String> skillsAndExperienceTitle = new ArrayList<String>();
	
	private ArrayList<DefaultTableModel> professionalExperienceAchievementsModel = new ArrayList<DefaultTableModel>();
	private ArrayList<String> professionalExperienceTitle = new ArrayList<String>();
	private ArrayList<String> professionalExperienceParagraph = new ArrayList<String>();
	
	public boolean compareDates(String date1,String date2){
		String array1[] = date1.split("-");
		String array2[] = date2.split("-");
		if(Integer.parseInt(array1[2])>Integer.parseInt(array2[2])){
			return true;
		}
		else if(Integer.parseInt(array1[2])==Integer.parseInt(array2[2])){
			if(Integer.parseInt(array1[1])>Integer.parseInt(array2[1])){
				return true;
			}
			else if(Integer.parseInt(array1[1])==Integer.parseInt(array2[1])){
				if(Integer.parseInt(array1[0])>Integer.parseInt(array2[0])){
					return true;
				}
			}
		}
		return false;
	}
	
	
	public ShowingDifferences(CVManager manager1,CVManager manager2){
		this.manager1=manager1;
		this.manager2=manager2;
	}
	
	public void combineGeneralInformation(){
		manager.setGeneralInformation(manager1.getGeneralInformation());
	}
	
	public void combineProfessionalProfile(){
		if(manager1.getProfessionalProfile().equals(manager2.getProfessionalProfile())){
			manager.setProfessionalProfile(manager1.getProfessionalProfile());
		}
		else{
			manager.setProfessionalProfile(manager1.getProfessionalProfile()+manager2.getProfessionalProfile());
		}
	}
	
	public void combineSkillsAndExperience(){
		int i=0;
		int j=0;
		String array1[];
		String array2[];
		String title;
		int count = 1;
		while(i<manager1.getSkillsAndExperienceTitle().size()&&j<manager2.getSkillsAndExperienceTitle().size()){
			array1 = manager1.getSkillsAndExperienceTitle().get(i).split(" ");
			array2 = manager2.getSkillsAndExperienceTitle().get(j).split(" ");
			if(array1[array1.length-1].equals(array2[array2.length-1])){
				title = "3."+count+"."+"	"+"SKILLS AND EXPERIENCE ON "+array1[array1.length-1];
				count++;
				skillsAndExperienceTitle.add(title);
				skillsAndExperienceModelList.add(manager1.getSkillsAndExperienceModelList().get(i));
				i++;
				j++;
			}
			else{
				title = "3."+count+"."+"	"+"SKILLS AND EXPERIENCE ON "+array1[array1.length-1];
				count++;
				skillsAndExperienceTitle.add(title);
				skillsAndExperienceModelList.add(manager1.getSkillsAndExperienceModelList().get(i));
				i++;
			}
			
		}
		for(;j<manager2.getSkillsAndExperienceTitle().size();j++){
			array2 = manager2.getSkillsAndExperienceTitle().get(j).split(" ");
			title = "3."+count+"."+"	"+"SKILLS AND EXPERIENCE ON "+array2[array2.length-1];
			count++;
			skillsAndExperienceTitle.add(title);
			skillsAndExperienceModelList.add(manager2.getSkillsAndExperienceModelList().get(j));
		}
		manager.setSkillsAndExperience(count, skillsAndExperienceModelList, skillsAndExperienceTitle);
		
	}
	
	public void combineProfessionalExperience(){
		int i=0;
		int j=0;
		String array1[];
		String array2[];
		while(i<manager1.getProfessionalExperienceTitle().size()&&j<manager2.getProfessionalExperienceTitle().size()){
			array1 = manager1.getProfessionalExperienceTitle().get(i).split(",");
			array2 = manager2.getProfessionalExperienceTitle().get(j).split(",");
			if(manager1.getProfessionalExperienceTitle().get(i).equals(manager2.getProfessionalExperienceTitle().get(j))){
				professionalExperienceTitle.add(manager1.getProfessionalExperienceTitle().get(i));
				professionalExperienceAchievementsModel.add(manager1.getProfessionalExperienceModelList().get(i));
				professionalExperienceParagraph.add(manager1.getProfessionalExperienceParagraph().get(i));
				i++;
				j++;
			}
			else if(compareDates(array1[array1.length-1],array2[array2.length-1])){
				professionalExperienceTitle.add(manager1.getProfessionalExperienceTitle().get(i));
				professionalExperienceAchievementsModel.add(manager1.getProfessionalExperienceModelList().get(i));
				professionalExperienceParagraph.add(manager1.getProfessionalExperienceParagraph().get(i));
				i++;
			}
			else{
				professionalExperienceTitle.add(manager2.getProfessionalExperienceTitle().get(j));
				professionalExperienceAchievementsModel.add(manager2.getProfessionalExperienceModelList().get(j));
				professionalExperienceParagraph.add(manager2.getProfessionalExperienceParagraph().get(j));
				j++;
			}
		}
		
		if(i<manager1.getProfessionalExperienceTitle().size()){
			for(;i<manager1.getProfessionalExperienceTitle().size();i++){
				professionalExperienceTitle.add(manager1.getProfessionalExperienceTitle().get(i));
				professionalExperienceAchievementsModel.add(manager1.getProfessionalExperienceModelList().get(i));
				professionalExperienceParagraph.add(manager1.getProfessionalExperienceParagraph().get(i));
			}
		}
		
		else if(j<manager2.getProfessionalExperienceTitle().size()){
			for(;j<manager2.getProfessionalExperienceTitle().size();j++){
				professionalExperienceTitle.add(manager2.getProfessionalExperienceTitle().get(j));
				professionalExperienceAchievementsModel.add(manager2.getProfessionalExperienceModelList().get(j));
				professionalExperienceParagraph.add(manager2.getProfessionalExperienceParagraph().get(j));
			}
		}
		manager.setProfessionalExperience(professionalExperienceAchievementsModel, professionalExperienceTitle, professionalExperienceParagraph);
	}
	
	public void combineAdditionalInformation(){
		if(manager1.getAdditionalInformation().equals(manager2.getAdditionalInformation())){
			manager.setAdditionalInformation(manager1.getAdditionalInformation());
		}
		else {
			manager.setAdditionalInformation(manager1.getAdditionalInformation()+manager2.getAdditionalInformation());
		}
	}	
	
	public void combineCareerSummary(){
		int i=0;
		int j=0;
		while(i<manager1.getCareerSummary().getRowCount()&&j<manager2.getCareerSummary().getRowCount()){
			if(manager1.getCareerSummary().getValueAt(i, 0).equals(manager2.getCareerSummary().getValueAt(j, 0))){
				if(manager1.getCareerSummary().getValueAt(i, 1).equals(manager2.getCareerSummary().getValueAt(j, 1))){
					modelCareerSummary.addRow(new Object[]{});
					modelCareerSummary.setValueAt(manager1.getCareerSummary().getValueAt(i, 0), manager.getCareerSummary().getRowCount()-1, 0);
					modelCareerSummary.setValueAt(manager1.getCareerSummary().getValueAt(i, 1), manager.getCareerSummary().getRowCount()-1, 1);
					modelCareerSummary.setValueAt(manager1.getCareerSummary().getValueAt(i, 2), manager.getCareerSummary().getRowCount()-1, 2);
					i++;
					j++;
				}
				else{
					if(compareDates((String)manager1.getCareerSummary().getValueAt(i, 2),(String)manager2.getCareerSummary().getValueAt(j, 2))){
						modelCareerSummary.addRow(new Object[]{});
						modelCareerSummary.setValueAt(manager1.getCareerSummary().getValueAt(i, 0), manager.getCareerSummary().getRowCount()-1, 0);
						modelCareerSummary.setValueAt(manager1.getCareerSummary().getValueAt(i, 1), manager.getCareerSummary().getRowCount()-1, 1);
						modelCareerSummary.setValueAt(manager1.getCareerSummary().getValueAt(i, 2), manager.getCareerSummary().getRowCount()-1, 2);
						i++;
					}
					else{
						modelCareerSummary.addRow(new Object[]{});
						modelCareerSummary.setValueAt(manager2.getCareerSummary().getValueAt(i, 0), manager.getCareerSummary().getRowCount()-1, 0);
						modelCareerSummary.setValueAt(manager2.getCareerSummary().getValueAt(i, 1), manager.getCareerSummary().getRowCount()-1, 1);
						modelCareerSummary.setValueAt(manager2.getCareerSummary().getValueAt(i, 2), manager.getCareerSummary().getRowCount()-1, 2);
						j++;
					}
				}
			}
			else{
				if(compareDates((String)manager1.getCareerSummary().getValueAt(i, 2),(String)manager2.getCareerSummary().getValueAt(j, 2))){
					modelCareerSummary.addRow(new Object[]{});
					modelCareerSummary.setValueAt(manager1.getCareerSummary().getValueAt(i, 0), manager.getCareerSummary().getRowCount()-1, 0);
					modelCareerSummary.setValueAt(manager1.getCareerSummary().getValueAt(i, 1), manager.getCareerSummary().getRowCount()-1, 1);
					modelCareerSummary.setValueAt(manager1.getCareerSummary().getValueAt(i, 2), manager.getCareerSummary().getRowCount()-1, 2);
					i++;
				}
				else{
					modelCareerSummary.addRow(new Object[]{});
					modelCareerSummary.setValueAt(manager2.getCareerSummary().getValueAt(i, 0), manager.getCareerSummary().getRowCount()-1, 0);
					modelCareerSummary.setValueAt(manager2.getCareerSummary().getValueAt(i, 1), manager.getCareerSummary().getRowCount()-1, 1);
					modelCareerSummary.setValueAt(manager2.getCareerSummary().getValueAt(i, 2), manager.getCareerSummary().getRowCount()-1, 2);
					j++;
				}
			}
		}
		if(i<manager1.getCareerSummary().getRowCount()){
			for(;i<manager1.getCareerSummary().getRowCount();i++){
				modelCareerSummary.addRow(new Object[]{});
				modelCareerSummary.setValueAt(manager1.getCareerSummary().getValueAt(i, 0), manager.getCareerSummary().getRowCount()-1, 0);
				modelCareerSummary.setValueAt(manager1.getCareerSummary().getValueAt(i, 1), manager.getCareerSummary().getRowCount()-1, 1);
				modelCareerSummary.setValueAt(manager1.getCareerSummary().getValueAt(i, 2), manager.getCareerSummary().getRowCount()-1, 2);
			}
		}
		else if(j<manager2.getCareerSummary().getRowCount()){
			for(;j<manager2.getCareerSummary().getRowCount();j++){
				modelCareerSummary.addRow(new Object[]{});
				modelCareerSummary.setValueAt(manager2.getCareerSummary().getValueAt(i, 0), manager.getCareerSummary().getRowCount()-1, 0);
				modelCareerSummary.setValueAt(manager2.getCareerSummary().getValueAt(i, 1), manager.getCareerSummary().getRowCount()-1, 1);
				modelCareerSummary.setValueAt(manager2.getCareerSummary().getValueAt(i, 2), manager.getCareerSummary().getRowCount()-1, 2);
			}
		}
		manager.setCareerSummary(modelCareerSummary);
	}
	
	public void combineCoreStrengths(){
		if(manager1.getCoreStrengths().equals(manager2.getCoreStrengths())){
			manager.setCoreStrengths(manager1.getCoreStrengths());
		}
		else{
			manager.setCoreStrengths(manager1.getCoreStrengths()+manager2.getCoreStrengths());
		}
	}
	
	public void combineEducationAndTraining(){
		int i=0;
		int j=0;
		while(i<manager1.getEducationAndTraining().getRowCount()&&j<manager2.getEducationAndTraining().getRowCount()){
			if(manager1.getEducationAndTraining().getValueAt(i, 0).equals(manager2.getEducationAndTraining().getValueAt(j, 0))){
				if(manager1.getEducationAndTraining().getValueAt(i, 1).equals(manager2.getEducationAndTraining().getValueAt(j, 1))){
					if(manager1.getEducationAndTraining().getValueAt(i, 2).equals(manager2.getEducationAndTraining().getValueAt(j, 2))){
						modelEducationAndTraining.addRow(new Object[]{});
						modelEducationAndTraining.setValueAt(manager1.getEducationAndTraining().getValueAt(i, 0), manager.getEducationAndTraining().getRowCount()-1, 0);
						modelEducationAndTraining.setValueAt(manager1.getEducationAndTraining().getValueAt(i, 1), manager.getEducationAndTraining().getRowCount()-1, 1);
						modelEducationAndTraining.setValueAt(manager1.getEducationAndTraining().getValueAt(i, 2), manager.getEducationAndTraining().getRowCount()-1, 2);
						modelEducationAndTraining.setValueAt(manager1.getEducationAndTraining().getValueAt(i, 3), manager.getEducationAndTraining().getRowCount()-1, 3);
						i++;
						j++;
					}
					else{
						if(compareDates((String)manager1.getEducationAndTraining().getValueAt(i, 3),(String)manager2.getEducationAndTraining().getValueAt(j, 3))){
							modelEducationAndTraining.addRow(new Object[]{});
							modelEducationAndTraining.setValueAt(manager1.getEducationAndTraining().getValueAt(i, 0), manager.getEducationAndTraining().getRowCount()-1, 0);
							modelEducationAndTraining.setValueAt(manager1.getEducationAndTraining().getValueAt(i, 1), manager.getEducationAndTraining().getRowCount()-1, 1);
							modelEducationAndTraining.setValueAt(manager1.getEducationAndTraining().getValueAt(i, 2), manager.getEducationAndTraining().getRowCount()-1, 2);
							modelEducationAndTraining.setValueAt(manager1.getEducationAndTraining().getValueAt(i, 3), manager.getEducationAndTraining().getRowCount()-1, 3);
							i++;
						}
						else{
							modelEducationAndTraining.addRow(new Object[]{});
							modelEducationAndTraining.setValueAt(manager2.getEducationAndTraining().getValueAt(i, 0), manager.getEducationAndTraining().getRowCount()-1, 0);
							modelEducationAndTraining.setValueAt(manager2.getEducationAndTraining().getValueAt(i, 1), manager.getEducationAndTraining().getRowCount()-1, 1);
							modelEducationAndTraining.setValueAt(manager2.getEducationAndTraining().getValueAt(i, 2), manager.getEducationAndTraining().getRowCount()-1, 2);
							modelEducationAndTraining.setValueAt(manager2.getEducationAndTraining().getValueAt(i, 3), manager.getEducationAndTraining().getRowCount()-1, 3);
							j++;
						}
					}
				}
				else{
					if(compareDates((String)manager1.getEducationAndTraining().getValueAt(i, 3),(String)manager2.getEducationAndTraining().getValueAt(j, 3))){
						modelEducationAndTraining.addRow(new Object[]{});
						modelEducationAndTraining.setValueAt(manager1.getEducationAndTraining().getValueAt(i, 0), manager.getEducationAndTraining().getRowCount()-1, 0);
						modelEducationAndTraining.setValueAt(manager1.getEducationAndTraining().getValueAt(i, 1), manager.getEducationAndTraining().getRowCount()-1, 1);
						modelEducationAndTraining.setValueAt(manager1.getEducationAndTraining().getValueAt(i, 2), manager.getEducationAndTraining().getRowCount()-1, 2);
						modelEducationAndTraining.setValueAt(manager1.getEducationAndTraining().getValueAt(i, 3), manager.getEducationAndTraining().getRowCount()-1, 3);
						i++;
					}
					else{
						modelEducationAndTraining.addRow(new Object[]{});
						modelEducationAndTraining.setValueAt(manager2.getEducationAndTraining().getValueAt(i, 0), manager.getEducationAndTraining().getRowCount()-1, 0);
						modelEducationAndTraining.setValueAt(manager2.getEducationAndTraining().getValueAt(i, 1), manager.getEducationAndTraining().getRowCount()-1, 1);
						modelEducationAndTraining.setValueAt(manager2.getEducationAndTraining().getValueAt(i, 2), manager.getEducationAndTraining().getRowCount()-1, 2);
						modelEducationAndTraining.setValueAt(manager2.getEducationAndTraining().getValueAt(i, 3), manager.getEducationAndTraining().getRowCount()-1, 3);
						j++;
					}
				}
			}
			else{
				if(compareDates((String)manager1.getEducationAndTraining().getValueAt(i, 3),(String)manager2.getEducationAndTraining().getValueAt(j, 3))){
					modelEducationAndTraining.addRow(new Object[]{});
					modelEducationAndTraining.setValueAt(manager1.getEducationAndTraining().getValueAt(i, 0), manager.getEducationAndTraining().getRowCount()-1, 0);
					modelEducationAndTraining.setValueAt(manager1.getEducationAndTraining().getValueAt(i, 1), manager.getEducationAndTraining().getRowCount()-1, 1);
					modelEducationAndTraining.setValueAt(manager1.getEducationAndTraining().getValueAt(i, 2), manager.getEducationAndTraining().getRowCount()-1, 2);
					modelEducationAndTraining.setValueAt(manager1.getEducationAndTraining().getValueAt(i, 3), manager.getEducationAndTraining().getRowCount()-1, 3);
					i++;
				}
				else{
					modelEducationAndTraining.addRow(new Object[]{});
					modelEducationAndTraining.setValueAt(manager2.getEducationAndTraining().getValueAt(i, 0), manager.getEducationAndTraining().getRowCount()-1, 0);
					modelEducationAndTraining.setValueAt(manager2.getEducationAndTraining().getValueAt(i, 1), manager.getEducationAndTraining().getRowCount()-1, 1);
					modelEducationAndTraining.setValueAt(manager2.getEducationAndTraining().getValueAt(i, 2), manager.getEducationAndTraining().getRowCount()-1, 2);
					modelEducationAndTraining.setValueAt(manager2.getEducationAndTraining().getValueAt(i, 3), manager.getEducationAndTraining().getRowCount()-1, 3);
					j++;
				}
			}
		}
		
		if(i<manager1.getEducationAndTraining().getRowCount()){
			for(;i<manager1.getEducationAndTraining().getRowCount();i++){
				modelEducationAndTraining.addRow(new Object[]{});
				modelEducationAndTraining.setValueAt(manager1.getEducationAndTraining().getValueAt(i, 0), manager.getEducationAndTraining().getRowCount()-1, 0);
				modelEducationAndTraining.setValueAt(manager1.getEducationAndTraining().getValueAt(i, 1), manager.getEducationAndTraining().getRowCount()-1, 1);
				modelEducationAndTraining.setValueAt(manager1.getEducationAndTraining().getValueAt(i, 2), manager.getEducationAndTraining().getRowCount()-1, 2);
				modelEducationAndTraining.setValueAt(manager1.getEducationAndTraining().getValueAt(i, 3), manager.getEducationAndTraining().getRowCount()-1, 3);
			}
		}
		else if(j<manager2.getEducationAndTraining().getRowCount()){
			for(;j<manager2.getEducationAndTraining().getRowCount();j++){
				modelEducationAndTraining.addRow(new Object[]{});
				modelEducationAndTraining.setValueAt(manager2.getEducationAndTraining().getValueAt(i, 0), manager.getEducationAndTraining().getRowCount()-1, 0);
				modelEducationAndTraining.setValueAt(manager2.getEducationAndTraining().getValueAt(i, 1), manager.getEducationAndTraining().getRowCount()-1, 1);
				modelEducationAndTraining.setValueAt(manager2.getEducationAndTraining().getValueAt(i, 2), manager.getEducationAndTraining().getRowCount()-1, 2);
				modelEducationAndTraining.setValueAt(manager2.getEducationAndTraining().getValueAt(i, 3), manager.getEducationAndTraining().getRowCount()-1, 3);
			}
		}
		
		manager.setEducationAndTraining(modelEducationAndTraining);
	}
	
	public void combineFurtherCourses(){
		int i=0;
		int j=0;
		while(i<manager1.getFurtherCourses().getRowCount()&&j<manager2.getFurtherCourses().getRowCount()){
			if(manager1.getFurtherCourses().getValueAt(i, 0).equals(manager2.getFurtherCourses().getValueAt(j, 0))){
				if(manager1.getFurtherCourses().getValueAt(i, 1).equals(manager2.getFurtherCourses().getValueAt(j, 1))){
					if(manager1.getFurtherCourses().getValueAt(i, 2).equals(manager2.getFurtherCourses().getValueAt(j, 2))){
						modelFurtherCourses.addRow(new Object[]{});
						modelFurtherCourses.setValueAt(manager1.getFurtherCourses().getValueAt(i, 0), manager.getFurtherCourses().getRowCount()-1, 0);
						modelFurtherCourses.setValueAt(manager1.getFurtherCourses().getValueAt(i, 1), manager.getFurtherCourses().getRowCount()-1, 1);
						modelFurtherCourses.setValueAt(manager1.getFurtherCourses().getValueAt(i, 2), manager.getFurtherCourses().getRowCount()-1, 2);
						modelFurtherCourses.setValueAt(manager1.getFurtherCourses().getValueAt(i, 3), manager.getFurtherCourses().getRowCount()-1, 3);
						i++;
						j++;
					}
					else{
						if(compareDates((String)manager1.getFurtherCourses().getValueAt(i, 3),(String)manager2.getFurtherCourses().getValueAt(j, 3))){
							modelFurtherCourses.addRow(new Object[]{});
							modelFurtherCourses.setValueAt(manager1.getFurtherCourses().getValueAt(i, 0), manager.getFurtherCourses().getRowCount()-1, 0);
							modelFurtherCourses.setValueAt(manager1.getFurtherCourses().getValueAt(i, 1), manager.getFurtherCourses().getRowCount()-1, 1);
							modelFurtherCourses.setValueAt(manager1.getFurtherCourses().getValueAt(i, 2), manager.getFurtherCourses().getRowCount()-1, 2);
							modelFurtherCourses.setValueAt(manager1.getFurtherCourses().getValueAt(i, 3), manager.getFurtherCourses().getRowCount()-1, 3);
							i++;
						}
						else{
							modelFurtherCourses.addRow(new Object[]{});
							modelFurtherCourses.setValueAt(manager2.getFurtherCourses().getValueAt(i, 0), manager.getFurtherCourses().getRowCount()-1, 0);
							modelFurtherCourses.setValueAt(manager2.getFurtherCourses().getValueAt(i, 1), manager.getFurtherCourses().getRowCount()-1, 1);
							modelFurtherCourses.setValueAt(manager2.getFurtherCourses().getValueAt(i, 2), manager.getFurtherCourses().getRowCount()-1, 2);
							modelFurtherCourses.setValueAt(manager2.getFurtherCourses().getValueAt(i, 3), manager.getFurtherCourses().getRowCount()-1, 3);
							j++;
						}
					}
				}
				else{
					if(compareDates((String)manager1.getFurtherCourses().getValueAt(i, 3),(String)manager2.getFurtherCourses().getValueAt(j, 3))){
						modelFurtherCourses.addRow(new Object[]{});
						modelFurtherCourses.setValueAt(manager1.getFurtherCourses().getValueAt(i, 0), manager.getFurtherCourses().getRowCount()-1, 0);
						modelFurtherCourses.setValueAt(manager1.getFurtherCourses().getValueAt(i, 1), manager.getFurtherCourses().getRowCount()-1, 1);
						modelFurtherCourses.setValueAt(manager1.getFurtherCourses().getValueAt(i, 2), manager.getFurtherCourses().getRowCount()-1, 2);
						modelFurtherCourses.setValueAt(manager1.getFurtherCourses().getValueAt(i, 3), manager.getFurtherCourses().getRowCount()-1, 3);
						i++;
					}
					else{
						modelFurtherCourses.addRow(new Object[]{});
						modelFurtherCourses.setValueAt(manager2.getFurtherCourses().getValueAt(i, 0), manager.getFurtherCourses().getRowCount()-1, 0);
						modelFurtherCourses.setValueAt(manager2.getFurtherCourses().getValueAt(i, 1), manager.getFurtherCourses().getRowCount()-1, 1);
						modelFurtherCourses.setValueAt(manager2.getFurtherCourses().getValueAt(i, 2), manager.getFurtherCourses().getRowCount()-1, 2);
						modelFurtherCourses.setValueAt(manager2.getFurtherCourses().getValueAt(i, 3), manager.getFurtherCourses().getRowCount()-1, 3);
						j++;
					}
				}
			}
			else{
				if(compareDates((String)manager1.getFurtherCourses().getValueAt(i, 3),(String)manager2.getFurtherCourses().getValueAt(j, 3))){
					modelFurtherCourses.addRow(new Object[]{});
					modelFurtherCourses.setValueAt(manager1.getFurtherCourses().getValueAt(i, 0), manager.getFurtherCourses().getRowCount()-1, 0);
					modelFurtherCourses.setValueAt(manager1.getFurtherCourses().getValueAt(i, 1), manager.getFurtherCourses().getRowCount()-1, 1);
					modelFurtherCourses.setValueAt(manager1.getFurtherCourses().getValueAt(i, 2), manager.getFurtherCourses().getRowCount()-1, 2);
					modelFurtherCourses.setValueAt(manager1.getFurtherCourses().getValueAt(i, 3), manager.getFurtherCourses().getRowCount()-1, 3);
					i++;
				}
				else{
					modelFurtherCourses.addRow(new Object[]{});
					modelFurtherCourses.setValueAt(manager2.getFurtherCourses().getValueAt(i, 0), manager.getFurtherCourses().getRowCount()-1, 0);
					modelFurtherCourses.setValueAt(manager2.getFurtherCourses().getValueAt(i, 1), manager.getFurtherCourses().getRowCount()-1, 1);
					modelFurtherCourses.setValueAt(manager2.getFurtherCourses().getValueAt(i, 2), manager.getFurtherCourses().getRowCount()-1, 2);
					modelFurtherCourses.setValueAt(manager2.getFurtherCourses().getValueAt(i, 3), manager.getFurtherCourses().getRowCount()-1, 3);
					j++;
				}
			}
		}
		
		if(i<manager1.getFurtherCourses().getRowCount()){
			for(;i<manager1.getFurtherCourses().getRowCount();i++){
				modelFurtherCourses.addRow(new Object[]{});
				modelFurtherCourses.setValueAt(manager1.getFurtherCourses().getValueAt(i, 0), manager.getFurtherCourses().getRowCount()-1, 0);
				modelFurtherCourses.setValueAt(manager1.getFurtherCourses().getValueAt(i, 1), manager.getFurtherCourses().getRowCount()-1, 1);
				modelFurtherCourses.setValueAt(manager1.getFurtherCourses().getValueAt(i, 2), manager.getFurtherCourses().getRowCount()-1, 2);
				modelFurtherCourses.setValueAt(manager1.getFurtherCourses().getValueAt(i, 3), manager.getFurtherCourses().getRowCount()-1, 3);
			}
		}
		else if(j<manager2.getFurtherCourses().getRowCount()){
			for(;j<manager2.getFurtherCourses().getRowCount();j++){
				modelFurtherCourses.addRow(new Object[]{});
				modelFurtherCourses.setValueAt(manager2.getFurtherCourses().getValueAt(i, 0), manager.getFurtherCourses().getRowCount()-1, 0);
				modelFurtherCourses.setValueAt(manager2.getFurtherCourses().getValueAt(i, 1), manager.getFurtherCourses().getRowCount()-1, 1);
				modelFurtherCourses.setValueAt(manager2.getFurtherCourses().getValueAt(i, 2), manager.getFurtherCourses().getRowCount()-1, 2);
				modelFurtherCourses.setValueAt(manager2.getFurtherCourses().getValueAt(i, 3), manager.getFurtherCourses().getRowCount()-1, 3);
			}
		}
		manager.setFurtherCourses(modelFurtherCourses);
		
	}
	
	public void combineInterests(){
		if(manager1.getInterests().equals(manager2.getInterests())){
			manager.setInterests(manager1.getInterests());
		}
		else{
			manager.setInterests(manager1.getInterests()+manager2.getInterests());
		}
	}
	
	
	
	public void combineFunctional(){
		combineGeneralInformation();
		combineProfessionalProfile();
		combineSkillsAndExperience();
		combineCareerSummary();
		combineEducationAndTraining();
		combineFurtherCourses();
		combineAdditionalInformation();
		combineInterests();
	}
	
	public void combineChronological(){
		combineGeneralInformation();
		combineProfessionalProfile();
		combineCoreStrengths();
		combineProfessionalExperience();
		combineEducationAndTraining();
		combineFurtherCourses();
		combineAdditionalInformation();
		combineInterests();
	}
	
	public void combineCombined(){
		combineGeneralInformation();
		combineProfessionalProfile();
		combineSkillsAndExperience();
		combineProfessionalExperience();
		combineEducationAndTraining();
		combineFurtherCourses();
		combineAdditionalInformation();
		combineInterests();
	}
	

	public CVManager getManager(){
		return manager;
	}
	
	public void getShowingDifferences(){
		if(manager1.getTemplate().equals("Functional")){
			manager = new CVManagerFunctional();
			
			manager.setAdditionalInformation(null);
			manager.setInterests(null);
			manager.setGeneralInformation(null);
			manager.setProfessionalProfile(null);
			
			careerSummaryTable.setModel(new DefaultTableModel(
					new Object[][] {
						},
					new String[] {
						"Company", "Job Title", "Date"
					}
				));
			modelCareerSummary = (DefaultTableModel) careerSummaryTable.getModel();
			manager.setCareerSummary(modelCareerSummary);
			
			
			educationAndTrainingTable.setModel(new DefaultTableModel(
					new Object[][] {
						},
					new String[] {
						"Qualification", "Establishment","Location", "Date"
					}
				));
			
			modelEducationAndTraining = (DefaultTableModel) educationAndTrainingTable.getModel();
			manager.setEducationAndTraining(modelEducationAndTraining);
			
			
			furtherCoursesTable.setModel(new DefaultTableModel(
					new Object[][] {
						},
					new String[] {
						"Course", "Establishment","Location", "Date"
					}
				));
			
			modelFurtherCourses = (DefaultTableModel) furtherCoursesTable.getModel();
			manager.setFurtherCourses(modelFurtherCourses);
			
			manager.setSkillsAndExperience(1, skillsAndExperienceModelList, skillsAndExperienceTitle);
			
			
			
			manager.setTemplate(manager1.getTemplate());
			combineFunctional();
		}
		else if(manager1.getTemplate().equals("Chronological")){
			manager = new CVManagerChronological();

			educationAndTrainingTable.setModel(new DefaultTableModel(
					new Object[][] {
						},
					new String[] {
						"Qualification", "Establishment","Location", "Date"
					}
				));
			
			modelEducationAndTraining = (DefaultTableModel) educationAndTrainingTable.getModel();
			manager.setEducationAndTraining(modelEducationAndTraining);
			
			
			furtherCoursesTable.setModel(new DefaultTableModel(
					new Object[][] {
						},
					new String[] {
						"Course", "Establishment","Location", "Date"
					}
				));
			
			modelFurtherCourses = (DefaultTableModel) furtherCoursesTable.getModel();
			manager.setFurtherCourses(modelFurtherCourses);
			
			manager.setProfessionalExperience(professionalExperienceAchievementsModel, professionalExperienceTitle, professionalExperienceParagraph);
			
			manager.setTemplate(manager1.getTemplate());
			combineChronological();
		}
		else if(manager1.getTemplate().equals("Combined")){
			manager = new CVManagerCombined();
			
			educationAndTrainingTable.setModel(new DefaultTableModel(
					new Object[][] {
						},
					new String[] {
						"Qualification", "Establishment","Location", "Date"
					}
				));
			
			modelEducationAndTraining = (DefaultTableModel) educationAndTrainingTable.getModel();
			manager.setEducationAndTraining(modelEducationAndTraining);
			
			
			furtherCoursesTable.setModel(new DefaultTableModel(
					new Object[][] {
						},
					new String[] {
						"Course", "Establishment","Location", "Date"
					}
				));
			
			modelFurtherCourses = (DefaultTableModel) furtherCoursesTable.getModel();
			manager.setFurtherCourses(modelFurtherCourses);
			
			manager.setSkillsAndExperience(1, skillsAndExperienceModelList, skillsAndExperienceTitle);
			manager.setProfessionalExperience(professionalExperienceAchievementsModel, professionalExperienceTitle, professionalExperienceParagraph);
			
			
			manager.setTemplate(manager1.getTemplate());
			combineCombined();
		}
		TemplateInitializitation.initialize(manager);
	}
}
