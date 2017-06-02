package cveditor.infos.professionalexperience;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProfessionalExperienceAchievements {

	private JFrame frmAchievements;
	private JTable table = new JTable();
	private DefaultTableModel achievementsInformation;
	private PageOfProfessionalExperience pageOfProfessionalExp;

	/**
	 * Launch the application.
	 */
	public void getProfessionalExperienceAchievements() {//we add the achievements
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProfessionalExperienceAchievements window = new ProfessionalExperienceAchievements(achievementsInformation,pageOfProfessionalExp);
					window.frmAchievements.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ProfessionalExperienceAchievements(DefaultTableModel achievementsInformation,PageOfProfessionalExperience page) {
		this.achievementsInformation = achievementsInformation;
		table.setModel(this.achievementsInformation);
		this.pageOfProfessionalExp=page;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAchievements = new JFrame();
		frmAchievements.setTitle("Achievements");
		frmAchievements.setBounds(100, 100, 450, 300);
		frmAchievements.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		frmAchievements.getContentPane().add(panel, BorderLayout.SOUTH);
		
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				achievementsInformation = (DefaultTableModel)table.getModel();
				pageOfProfessionalExp.setProfessionalExperienceAchievements(achievementsInformation);
				frmAchievements.setVisible(false);
			}
		});
		panel.add(btnOk);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAchievements.setVisible(false);
			}
		});
		panel.add(btnCancel);
		
		JPanel panel1 = new JPanel();
		frmAchievements.getContentPane().add(panel1, BorderLayout.NORTH);
		
		JButton btnAdd = new JButton("Add Achievement");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				achievementsInformation = (DefaultTableModel)table.getModel();
				achievementsInformation.addRow(new Object[]{});
			}
		});
		panel1.add(btnAdd);
		
		JButton btnRemoveAchievent = new JButton("Remove Achievent");
		btnRemoveAchievent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				achievementsInformation = (DefaultTableModel)table.getModel();
				achievementsInformation.removeRow(achievementsInformation.getRowCount()-1);
			}
		});
		panel1.add(btnRemoveAchievent);
		
		frmAchievements.getContentPane().add(table, BorderLayout.CENTER);
	}

}
