package cveditor.infos.skillsandexperience;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JTable;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.table.DefaultTableModel;

import cveditor.infos.SkillsAndExperience;

public class PageOfSkillAndExperience {

	private JFrame frame;
	
	String title;
	private JTable table = new JTable();
	private String choice;
	private DefaultTableModel model;
	private int modelChosen;
	
	private SkillsAndExperience skill;
	

	/**
	 * Launch the application.
	 */
	public void getPageOfSkillAndExperience() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PageOfSkillAndExperience window = new PageOfSkillAndExperience(model,title,skill,choice,modelChosen);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	/**
	 * @wbp.parser.constructor
	 */

	
	public PageOfSkillAndExperience(DefaultTableModel model,String title,SkillsAndExperience skill,String choice,int modelChosen) {
		this.title = title;
		this.model=model;
		this.skill=skill;
		this.choice=choice;
		this.modelChosen=modelChosen;
		table.setModel(model);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle(title);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.SOUTH);
		
		JButton btnOk = new JButton("Ok");//we go back to the main skillsAndExperience
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				skill.setPageOfSkillAndExperience(model,title,choice,modelChosen);
			}
		});
		panel.add(btnOk);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		panel.add(btnCancel);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.NORTH);
		
		JButton btnAddExperience = new JButton("Add Experience");
		btnAddExperience.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(new Object[]{});
			}
		});
		panel_1.add(btnAddExperience);
		
		JButton btnDeleteExperience = new JButton("Delete Experience");//delete the last experience
		btnDeleteExperience.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.removeRow(model.getRowCount()-1);
			}
		});
		panel_1.add(btnDeleteExperience);
		frame.getContentPane().add(table, BorderLayout.CENTER);
	}

}
