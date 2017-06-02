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

public class AdditionalInformation {

	private JFrame frmAdditionalInformation;
	private JTextField textField;

	private String additionalInformationInfo;
	
	private CVManager manager;
	
	private JPanel panel;
	private JButton btnOk;
	private JButton btnCancel;
	
	/**
	 * Launch the application.
	 */
	public void getAdditionalInformation() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdditionalInformation window = new AdditionalInformation(additionalInformationInfo,manager);
					window.frmAdditionalInformation.setVisible(true);
					
					
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
	public AdditionalInformation(String additionalInformationInfo,CVManager manager) {
		this.additionalInformationInfo = additionalInformationInfo;
		this.manager = manager;
		initialize();
	}
	


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAdditionalInformation = new JFrame();
		frmAdditionalInformation.setTitle("ADDITIONAL INFORMATION");
		frmAdditionalInformation.setBounds(100, 100, 450, 300);
		frmAdditionalInformation.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel_1 = new JPanel();
		frmAdditionalInformation.getContentPane().add(panel_1, BorderLayout.SOUTH);
		
		textField = new JTextField();
		frmAdditionalInformation.add(textField);
		textField.setColumns(30);
		textField.setText(additionalInformationInfo);
		
		panel = new JPanel();
		panel_1.add(panel);
		
		btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				additionalInformationInfo = textField.getText();
				manager.setAdditionalInformation(additionalInformationInfo);//we store the items in manager for future use
				frmAdditionalInformation.setVisible(false);
			}
		});
		panel.add(btnOk);
		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAdditionalInformation.setVisible(false);
			}
		});
		panel.add(btnCancel);
		//panel.add(table);
	}

}
