package cveditor.merge;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.swing.JTextField;



import cveditor.errormessage.MergeError;
import cveditor.main.buttons.CVEditor;
import cveditor.main.buttons.OpeningFile;
import cveditor.manager.CVManager;

public class ComparingFileSelection {

	private JFrame frmMerge;
	private JTextField textField;
	private JTextField textField_1;
	private String filename1;
	private String filename2;
	private CVManager manager1;
	private CVManager manager2;

	/**
	 * Launch the application.
	 */
	public static void getComparingFileSelection() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ComparingFileSelection window = new ComparingFileSelection();
					window.frmMerge.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ComparingFileSelection() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMerge = new JFrame();
		frmMerge.setTitle("Compare");
		frmMerge.setBounds(100, 100, 450, 300);
		frmMerge.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		textField_1 = new JTextField();
		textField = new JTextField();
		
		JPanel panel = new JPanel();
		frmMerge.getContentPane().add(panel, BorderLayout.SOUTH);
		
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(manager1.getTemplate().equals(manager2.getTemplate())){
					if(manager1.getGeneralInformation().equals(manager2.getGeneralInformation())){
						ShowingDifferences differences = new ShowingDifferences(manager1,manager2);
						differences.getShowingDifferences();
						frmMerge.setVisible(false);
					}
					else{
						MergeError.getMergeError();
					}
				}
				else{
					MergeError.getMergeError();
				}
			}
		});
		panel.add(btnOk);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CVEditor.main(null);
				frmMerge.setVisible(false);
				frmMerge.dispose();
			}
		});
		panel.add(btnCancel);
		
		JPanel panel_1 = new JPanel();
		frmMerge.getContentPane().add(panel_1, BorderLayout.CENTER);
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2);
		
		
		textField.setEditable(false);
		panel_2.add(textField);
		textField.setColumns(20);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					OpeningFile open1 = new OpeningFile();
					open1.Open();
					filename1= open1.getName();
					manager1 = open1.getManager();
					textField.setText(filename1);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		panel_2.add(btnAdd);
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3);
		
		
		textField_1.setEditable(false);
		textField_1.setColumns(20);
		panel_3.add(textField_1);
		
		JButton button = new JButton("Add");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					OpeningFile open2 = new OpeningFile();
					open2.Open();
					filename2= open2.getName();
						manager2 = open2.getManager();
						textField_1.setText(filename2);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		panel_3.add(button);
	}

}
