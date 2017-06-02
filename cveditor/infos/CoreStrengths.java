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

public class CoreStrengths {

	private JFrame frmCoreStrengths;
	private JTextField textField;

	private String coreStrengthsInfo;
	
	private CVManager manager;
	
	private JPanel panel;
	private JButton btnOk;
	private JButton btnCancel;
	
	/**
	 * Launch the application.
	 */
	public void getCoreStrengths() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CoreStrengths window = new CoreStrengths(coreStrengthsInfo,manager);
					window.frmCoreStrengths.setVisible(true);
					
					
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
	public CoreStrengths(String coreStrengthsInfo,CVManager manager) {
		this.coreStrengthsInfo = coreStrengthsInfo;
		this.manager = manager;
		initialize();
	}
	


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCoreStrengths = new JFrame();
		frmCoreStrengths.setTitle("CORE STRENGTHS");
		frmCoreStrengths.setBounds(100, 100, 450, 300);
		frmCoreStrengths.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel_1 = new JPanel();
		frmCoreStrengths.getContentPane().add(panel_1, BorderLayout.SOUTH);
		
		textField = new JTextField();
		frmCoreStrengths.add(textField);
		textField.setColumns(30);
		textField.setText(coreStrengthsInfo);
		
		panel = new JPanel();
		panel_1.add(panel);
		
		btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				coreStrengthsInfo = textField.getText();
				manager.setCoreStrengths(coreStrengthsInfo);//we store the items in manager for future use
				frmCoreStrengths.setVisible(false);
			}
		});
		panel.add(btnOk);
		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmCoreStrengths.setVisible(false);
			}
		});
		panel.add(btnCancel);
		//panel.add(table);
	}

}
