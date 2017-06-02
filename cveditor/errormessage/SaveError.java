package cveditor.errormessage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SaveError {

	private JFrame frmError;
	private JTextField txtDatesError;
	private JButton btnOk;
	private JPanel panel1;

	/**
	 * Launch the application.
	 */
	public static void getSaveError() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SaveError window = new SaveError();
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
	public SaveError() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmError = new JFrame();
		frmError.getContentPane().setBackground(Color.LIGHT_GRAY);
		
		JPanel panel = new JPanel();
		frmError.getContentPane().add(panel, BorderLayout.SOUTH);
		
		btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmError.setVisible(false);
			}
		});
		panel.add(btnOk);
		
		panel1 = new JPanel();
		panel1.setBackground(Color.LIGHT_GRAY);
		frmError.getContentPane().add(panel1, BorderLayout.CENTER);
		
		txtDatesError = new JTextField();
		panel1.add(txtDatesError);
		txtDatesError.setBackground(Color.LIGHT_GRAY);
		txtDatesError.setEditable(false);
		txtDatesError.setText("Select a save format");
		txtDatesError.setColumns(40);
		frmError.setTitle("error");
		frmError.setBounds(100, 100, 450, 300);
		frmError.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
