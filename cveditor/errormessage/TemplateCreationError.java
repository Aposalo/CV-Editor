package cveditor.errormessage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TemplateCreationError {

	private JFrame frmError;
	private JTextField txtTemplateSelection;

	/**
	 * Launch the application.
	 */
	public static void getTemplateCreationError() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TemplateCreationError window = new TemplateCreationError();
					window.frmError.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TemplateCreationError() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmError = new JFrame();
		frmError.setTitle("error");
		frmError.setBounds(100, 100, 450, 300);
		frmError.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frmError.getContentPane().add(panel, BorderLayout.SOUTH);
		
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmError.setVisible(false);
			}
		});
		panel.add(btnOk);
		
		txtTemplateSelection = new JTextField();
		txtTemplateSelection.setEditable(false);
		txtTemplateSelection.setBackground(Color.LIGHT_GRAY);
		txtTemplateSelection.setText("\t\tPlease select a template");
		frmError.getContentPane().add(txtTemplateSelection, BorderLayout.CENTER);
		txtTemplateSelection.setColumns(10);
	}

}
