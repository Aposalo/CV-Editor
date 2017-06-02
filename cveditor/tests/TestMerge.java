package cveditor.tests;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.junit.Test;

import cveditor.manager.CVManager;
import cveditor.merge.ShowingDifferences;
import cveditor.open.OpeningTEXFile;
import cveditor.open.OpeningTXTFile;

public class TestMerge {
	
	private String openFileTest1 = "C:\\Users\\apostolis\\workspace\\CVEditor\\test1.txt";
	private String openFileTest2 = "C:\\Users\\apostolis\\workspace\\CVEditor\\test2.tex";
	
	private OpeningTXTFile openTXT = new OpeningTXTFile();
	private OpeningTEXFile openTEX = new OpeningTEXFile();
	
	private CVManager manager1;
	private CVManager manager2;
	private CVManager manager;
	
	@Test
	public void testOpeningTXT() throws IOException{
		
		openTXT.readFile(openFileTest1);
		manager1 = openTXT.getManager();
		
		openTEX.readFile(openFileTest2);
		manager2 = openTEX.getManager();
		
		ShowingDifferences show = new ShowingDifferences(manager1,manager2);
		show.getShowingDifferences();
		manager = show.getManager();
		
		assertNotNull(manager.getGeneralInformation());
		assertNotNull(manager.getProfessionalProfile());
		assertNotNull(manager.getSkillsAndExperienceTitle());
		assertNotNull(manager.getCareerSummary());
		assertNotNull(manager.getEducationAndTraining());
		assertNotNull(manager.getFurtherCourses());
		assertNotNull(manager.getAdditionalInformation());
		assertNotNull(manager.getInterests());
	}
	
}
