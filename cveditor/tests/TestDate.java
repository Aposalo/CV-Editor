package cveditor.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.junit.Test;
import org.junit.Before;

import cveditor.manager.CheckDate;

public class TestDate {
	
	private JTable tableCareerSummary = new JTable();
	private JTable tableEducationAndTraining = new JTable();
	private JTable tableFurtherCourses = new JTable();
	private DefaultTableModel modelCareerSummary;
	private DefaultTableModel modelEducationAndTraining;
	private DefaultTableModel modelFurtherCourses;

	@Before
	public void SetUpTest(){
		
		tableCareerSummary.setModel(new DefaultTableModel(
				new Object[][] {
						{"Google", "Admin", "14-6-1988"},
						{"Apple", "CEO", "17-9-1925"},
					},
				new String[] {
					"Company", "Job Title", "Date"
				}
			));
		
		modelCareerSummary = (DefaultTableModel) tableCareerSummary.getModel();
		
		tableEducationAndTraining.setModel(new DefaultTableModel(
				new Object[][] {
						{"Programmer", "Google", "Greece","14-6-1988"},
						{"Programmer", "Apple", "Greece","17-9-1925"},
					},
				new String[] {
					"Qualification", "Establishment","Location", "Date"
				}
			));
		
		modelEducationAndTraining = (DefaultTableModel) tableEducationAndTraining.getModel();
		
		tableFurtherCourses.setModel(new DefaultTableModel(
				new Object[][] {
						{"postgraduate", "England", "Arden","14-6-1988"},
						{"postgraduate", "Thessaloniki", "Aristoteleio","17-9-1925"},
					},
				new String[] {
					"Course", "Establishment","Location", "Date"
				}
			));
		
		modelFurtherCourses = (DefaultTableModel) tableFurtherCourses.getModel();
		
	}
	
	
	@Test
	public void TestCorrectDateFurtherCourses(){
		
		assertEquals("14-6-1988",modelFurtherCourses.getValueAt(0, 3) );
		assertEquals("17-9-1925",modelFurtherCourses.getValueAt(1, 3) );
		
	}
	
	@Test
	public void TestFurtherCourses(){
		
		assertTrue(CheckDate.getDate(modelFurtherCourses, 3));
		
	}
	
	@Test
	public void TestCorrectDateEducationAndTraining(){
		
		assertEquals("14-6-1988",modelEducationAndTraining.getValueAt(0, 3) );
		assertEquals("17-9-1925",modelEducationAndTraining.getValueAt(1, 3) );
		
	}
	
	@Test
	public void TestEducationAndTraining(){
		
		assertTrue(CheckDate.getDate(modelEducationAndTraining, 3));
		
	}
	
	@Test
	public void TestCorrectDateCareerSummary(){
		
		assertEquals("14-6-1988",modelCareerSummary.getValueAt(0, 2) );
		assertEquals("17-9-1925",modelCareerSummary.getValueAt(1, 2) );
		
	}
	
	@Test
	public void TestCareerSummary(){
		
		assertTrue(CheckDate.getDate(modelCareerSummary, 2));
		
	}
	
}