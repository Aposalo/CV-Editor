package cveditor.main.buttons;

import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;

import cveditor.errormessage.OpenError;
import cveditor.manager.CVManager;
import cveditor.open.OpeningTEXFile;
import cveditor.open.OpeningTXTFile;




public class OpeningFile {
	
	protected static CVManager manager;
	private static String name;
	
	
	public String nameCV(){//opens a window and returns the address of the file you chose
		JFileChooser fc = new JFileChooser();
		fc.setMultiSelectionEnabled(true);
		int ret = fc.showOpenDialog(null);
		String fileName;
		if(ret ==JFileChooser.APPROVE_OPTION)
		{
			File file = fc.getSelectedFile();
			fileName = file.getAbsolutePath();
			name = file.getName();
			return fileName;
		}
		else{
			return null;
		}
	}
	
	
	public void Open() throws IOException{//it checks the file format and opens it
		String path = nameCV();
		File fileObject = new File(path);
		String type = fileObject.getAbsolutePath();
		if(type.endsWith(".txt")){
			OpeningTXTFile txt = new OpeningTXTFile();
			txt.readFile(path);
		}
		else if(type.endsWith(".tex")){
			OpeningTEXFile tex = new OpeningTEXFile();
			tex.readFile(path);
		}
		else{
			OpenError.getOpenError();
		}
	}
	
	public static void getFile(CVManager getManager){
		manager = getManager;
	}
	
	public CVManager getManager(){
		return manager;
	}
	
	public String getName(){
		return name;
	}
	
}
