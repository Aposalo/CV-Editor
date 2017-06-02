package cveditor.tests;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import cveditor.manager.CVManager;
import cveditor.manager.CVManagerChronological;
import cveditor.manager.CVManagerCombined;
import cveditor.manager.CVManagerFunctional;

public class TestManager {
	
	
	private CVManager managerFunctional = new CVManagerFunctional();
	private CVManager managerCombined = new CVManagerCombined();
	private CVManager managerChronological = new CVManagerChronological();	
	private String name = "Apostolis Salomidis";
	private String address = "Mpizaniou 15";
	private String telephone1 = "6987048669";
	private String telephone2 = "2641032160";
	private String email = "aposalo@gmail.com";
	String information = name+"-"+address+"-"+telephone1+"-"+telephone2+"-"+email;
	
	private String professionalProfileInfo = "Student At Ioannina";
	
	private String additionalInformationInfo = "Knowledge at Java,C,C++ etc.";
	
	private String interestsInfo = "I like sports,cooking etc.";
	
	private String coreStrengthsInfo = "Like learning programming languages";
	
	@Test
	public void TestGeneralInformationFunctional(){
		managerFunctional.setGeneralInformation(information);
		assertNotNull(managerFunctional.getGeneralInformation());
	}
	
	@Test
	public void TestProfessionalProfileFunctional(){
		managerFunctional.setProfessionalProfile(professionalProfileInfo);
		assertNotNull(managerFunctional.getProfessionalProfile());
	}
	
	@Test
	public void TestAdditionalInformationFunctional(){
		managerFunctional.setAdditionalInformation(additionalInformationInfo);
		assertNotNull(managerFunctional.getAdditionalInformation());
	}
	
	@Test
	public void TestInterestsFunctional(){
		managerFunctional.setInterests(interestsInfo);
		assertNotNull(managerFunctional.getInterests());
	}

	
	@Test
	public void TestGeneralInformationCombined(){
		managerCombined.setGeneralInformation(information);
		assertNotNull(managerCombined.getGeneralInformation());
	}
	
	@Test
	public void TestProfessionalProfileCombined(){
		managerCombined.setProfessionalProfile(professionalProfileInfo);
		assertNotNull(managerCombined.getProfessionalProfile());
	}
	
	@Test
	public void TestAdditionalInformationCombined(){
		managerCombined.setAdditionalInformation(additionalInformationInfo);
		assertNotNull(managerCombined.getAdditionalInformation());
	}
	
	@Test
	public void TestInterestsCombined(){
		managerCombined.setInterests(interestsInfo);
		assertNotNull(managerCombined.getInterests());
	}
	
	@Test
	public void TestGeneralInformationChronological(){
		managerChronological.setGeneralInformation(information);
		assertNotNull(managerChronological.getGeneralInformation());
	}
	
	@Test
	public void TestProfessionalProfileChronological(){
		managerChronological.setProfessionalProfile(professionalProfileInfo);
		assertNotNull(managerChronological.getProfessionalProfile());
	}
	
	@Test
	public void TestAdditionalInformationChronological(){
		managerChronological.setAdditionalInformation(additionalInformationInfo);
		assertNotNull(managerChronological.getAdditionalInformation());
	}
	
	@Test
	public void TestInterestsChronological(){
		managerChronological.setInterests(interestsInfo);
		assertNotNull(managerChronological.getInterests());
	}
	
	@Test
	public void TestCoreStrengthsChronological(){
		managerChronological.setCoreStrengths(coreStrengthsInfo);
		assertNotNull(managerChronological.getCoreStrengths());
	}
	

}
