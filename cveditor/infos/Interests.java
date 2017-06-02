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

public class Interests {

	private JFrame frmInterests;
	private JTextField textField;

	private String interestsInfo;
	
	private CVManager manager;
	
	private JPanel panel;
	private JButton btnOk;
	private JButton btnCancel;
	
	/**
	 * Launch the application.
	 */
	public void getInterests() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
						Interests window = new Interests(interestsInfo,manager);
						window.frmInterests.setVisible(true);
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

	public Interests(String interestsInfo,CVManager manager) {
		this.interestsInfo = interestsInfo;
		this.manager = manager;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmInterests = new JFrame();
		frmInterests.setTitle("INTERESTS");
		frmInterests.setBounds(100, 100, 450, 300);
		frmInterests.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel_1 = new JPanel();
		frmInterests.getContentPane().add(panel_1, BorderLayout.SOUTH);
		
		textField = new JTextField();
		textField.setColumns(10);
		frmInterests.getContentPane().add(textField);
		textField.setText(interestsInfo);
		
		panel = new JPanel();
		panel_1.add(panel);
		
		btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				interestsInfo = textField.getText();
				manager.setInterests(interestsInfo);//we store the items in manager for future use
				frmInterests.setVisible(false);
			}
		});
		panel.add(btnOk);
		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmInterests.setVisible(false);
			}
		});
		panel.add(btnCancel);
		//panel.add(table);
	}

}
