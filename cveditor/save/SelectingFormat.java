package cveditor.save;

import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JRadioButton;

import cveditor.errormessage.SaveError;
import cveditor.main.buttons.SavingTemplate;

public class SelectingFormat{

	private JFrame frmFormat;

	/**
	 * Launch the application.
	 */
	public static void setSelectingFormat() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelectingFormat window = new SelectingFormat();
					window.frmFormat.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SelectingFormat() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmFormat = new JFrame();
		frmFormat.setTitle("Format");
		frmFormat.setBounds(100, 100, 450, 300);
		frmFormat.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ButtonGroup group = new ButtonGroup();
		
		JPanel panel_1 = new JPanel();
		frmFormat.getContentPane().add(panel_1, BorderLayout.CENTER);
		
		final JRadioButton rdbtnTxt = new JRadioButton("txt");
		panel_1.add(rdbtnTxt);
		group.add(rdbtnTxt);
		
		final JRadioButton rdbtnTex = new JRadioButton("tex");
		panel_1.add(rdbtnTex);
		group.add(rdbtnTex);
		
		JPanel panel = new JPanel();
		frmFormat.getContentPane().add(panel, BorderLayout.SOUTH);
		
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnTex.isSelected()){
					SavingTemplate.selectSaveFormat("tex");
					frmFormat.setVisible(false);
					SavingTemplate.saveTemplate();
				}
				else if(rdbtnTxt.isSelected()){
					SavingTemplate.selectSaveFormat("txt");
					frmFormat.setVisible(false);
					SavingTemplate.saveTemplate();
				}
				else{
					SaveError.getSaveError();
				}
				
			}
		});
		panel.add(btnOk);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmFormat.setVisible(false);
			}
		});
		panel.add(btnCancel);
		
	}

}
