package cveditor.infos.professionalexperience;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProfessionalExperienceParagraph {

	private JFrame frmResponsibilities;
	private JTextField textField;
	
	private String responsibilitiesInformation;
	private PageOfProfessionalExperience pageOfProfessionalExp;

	/**
	 * Launch the application.
	 */
	public void getProfessionalExperienceParagraph() {//we write a paragraph here
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProfessionalExperienceParagraph window = new ProfessionalExperienceParagraph(responsibilitiesInformation,pageOfProfessionalExp);
					window.frmResponsibilities.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ProfessionalExperienceParagraph(String responsibilitiesInformation,PageOfProfessionalExperience page) {
		this.responsibilitiesInformation = responsibilitiesInformation;
		this.pageOfProfessionalExp=page;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmResponsibilities = new JFrame();
		frmResponsibilities.setTitle("Responsibilities");
		frmResponsibilities.setBounds(100, 100, 450, 300);
		frmResponsibilities.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frmResponsibilities.getContentPane().add(panel, BorderLayout.SOUTH);
		
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				responsibilitiesInformation= textField.getText();
				pageOfProfessionalExp.setProfessionalExperienceParagraph(responsibilitiesInformation);
				frmResponsibilities.setVisible(false);
			}
		});
		panel.add(btnOk);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmResponsibilities.setVisible(false);
				
			}
		});
		panel.add(btnCancel);
		
		textField = new JTextField();
		textField.setText(responsibilitiesInformation);
		frmResponsibilities.getContentPane().add(textField, BorderLayout.CENTER);
		textField.setColumns(10);
	}

}
