package cveditor.manager;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

public class CheckDate {

	
	public static boolean getDate(DefaultTableModel model,int columns){
			String value = (String)model.getValueAt(0, columns);
			String[] date = value.split("-");
			int day = Integer.parseInt(date[0]);
			int month = Integer.parseInt(date[1]);
			int year = Integer.parseInt(date[2]);
			for(int i=1;i<model.getRowCount();i++){
				value = (String)model.getValueAt(i, columns);
				date = value.split("-");
				if(year<Integer.parseInt(date[2])){
					return false;
				}
				else if(year==Integer.parseInt(date[2])){
					if(month<Integer.parseInt(date[1])){
						return false;
					}
					else if(month==Integer.parseInt(date[1])){
						if(day<Integer.parseInt(date[0])){
							return false;
						}
					}
				}
				year = Integer.parseInt(date[2]);
				month = Integer.parseInt(date[1]);
				day = Integer.parseInt(date[0]);
			}
		return true;
	}
	
	public static boolean getDate(ArrayList<String>titleList){
		String value = titleList.get(0);
		String[]title = value.split(",");
		String value2=title[title.length-1];
		String[]date=value2.split("-");
		int day = Integer.parseInt(date[0]);
		int month = Integer.parseInt(date[1]);
		int year = Integer.parseInt(date[2]);
		for(int i=1;i<titleList.size();i++){
			value = titleList.get(i);
			title = value.split(" ");
			value2=title[title.length-1];
			date=value2.split("-");
			if(year<Integer.parseInt(date[2])){
				return false;
			}
			else if(year==Integer.parseInt(date[2])){
				if(month<Integer.parseInt(date[1])){
					return false;
				}
				else if(month==Integer.parseInt(date[1])){
					if(day<Integer.parseInt(date[0])){
						return false;
					}
				}
			}
			year = Integer.parseInt(date[2]);
			month = Integer.parseInt(date[1]);
			day = Integer.parseInt(date[0]);
		}
	return true;
	}
	
}
