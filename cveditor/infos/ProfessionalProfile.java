package cveditor.infos;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JTextField;

import cveditor.manager.CVManager;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProfessionalProfile {

	private JFrame frmProfessionalProfile;
	private JTextField textField;

	private String professionalProfileInfo;
	
	private CVManager manager;
	
	private JPanel panel;
	private JButton btnOk;
	private JButton btnCancel;
	
	/**
	 * Launch the application.
	 */
	public void getProfessionalProfile() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
						ProfessionalProfile window = new ProfessionalProfile(professionalProfileInfo,manager);
						window.frmProfessionalProfile.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ProfessionalProfile(String professionalProfileInfo,CVManager manager) {
		this.professionalProfileInfo = professionalProfileInfo;
		this.manager = manager;
		initialize();
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmProfessionalProfile = new JFrame();
		frmProfessionalProfile.setTitle("PROFESSIONAL PROFILE");
		frmProfessionalProfile.setBounds(100, 100, 450, 300);
		frmProfessionalProfile.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel_1 = new JPanel();
		frmProfessionalProfile.getContentPane().add(panel_1, BorderLayout.SOUTH);
		
		textField = new JTextField();
		frmProfessionalProfile.add(textField);
		textField.setColumns(30);
		textField.setText(professionalProfileInfo);
		
		panel = new JPanel();
		panel_1.add(panel);
		
		btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				professionalProfileInfo = textField.getText();
				manager.setProfessionalProfile(professionalProfileInfo);//we store the items in manager for future use
				frmProfessionalProfile.setVisible(false);
			}
		});
		panel.add(btnOk);
		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmProfessionalProfile.setVisible(false);
			}
		});
		panel.add(btnCancel);
		//panel.add(table);
	}

}
