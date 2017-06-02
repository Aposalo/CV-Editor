package cveditor.tests;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

import java.io.IOException;

import org.junit.Test;

import cveditor.main.buttons.OpeningFile;
import cveditor.manager.CVManager;
import cveditor.open.OpeningTEXFile;
import cveditor.open.OpeningTXTFile;

public class TestOpen {
	
	private String openFileTest1 = "C:\\Users\\apostolis\\workspace\\CVEditor\\test1.txt";
	private String openFileTest2 = "C:\\Users\\apostolis\\workspace\\CVEditor\\test2.tex";
	
	private OpeningTXTFile openTXT = new OpeningTXTFile();
	private OpeningTEXFile openTEX = new OpeningTEXFile();
	
	private CVManager manager1;
	private CVManager manager2;
	
	private String name = "Apostolis Salomidis";
	private String address = "Mpizaniou 15";
	private String telephone1 = "6987048669";
	private String telephone2 = "2641032160";
	private String email = "aposalo@gmail.com";
	String information = name+"-"+address+"-"+telephone1+"-"+telephone2+"-"+email;
	
	@Test
	public void testOpeningTXT() throws IOException{
		
		openTXT.readFile(openFileTest1);
		manager1 = openTXT.getManager();
		
		assertNotNull(manager1.getGeneralInformation());
		assertNotNull(manager1.getProfessionalProfile());
		assertNotNull(manager1.getSkillsAndExperienceTitle());
		assertNotNull(manager1.getCareerSummary());
		assertNotNull(manager1.getEducationAndTraining());
		assertNotNull(manager1.getFurtherCourses());
		assertNotNull(manager1.getAdditionalInformation());
		assertNotNull(manager1.getInterests());
	}
	
	@Test
	public void testOpeningTEX() throws IOException{
		openTEX.readFile(openFileTest2);
		manager2 = openTEX.getManager();
		
		assertNotNull(manager2.getGeneralInformation());
		assertNotNull(manager2.getProfessionalProfile());
		assertNotNull(manager2.getSkillsAndExperienceTitle());
		assertNotNull(manager2.getCareerSummary());
		assertNotNull(manager2.getEducationAndTraining());
		assertNotNull(manager2.getFurtherCourses());
		assertNotNull(manager2.getAdditionalInformation());
		assertNotNull(manager2.getInterests());
	}
}
