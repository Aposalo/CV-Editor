package cveditor.main.buttons;


import cveditor.manager.CVManager;

public class TemplateInitializitation{
	


	public static void initialize(CVManager manager){
		CVEditor cv = new CVEditor();
		cv.setManager(manager);
		if(manager.getTemplate().equals("Functional")){
			cv.FunctionalCVTemplate();
		}
		else if(manager.getTemplate().equals("Chronological")){
			cv.ChronologicalCVTemplate();
			
		}
		else if(manager.getTemplate().equals("Combined")){
			cv.CombinedCVTemplate();
		}
	}
}
