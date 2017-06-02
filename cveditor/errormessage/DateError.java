package cveditor.errormessage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DateError {

	private JFrame frmError;
	private JTextField txtDatesError;
	private JButton btnOk;
	private JPanel panel1;

	/**
	 * Launch the application.
	 */
	public void getDateError() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DateError window = new DateError();
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
	public DateError() {
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
		txtDatesError.setText("Dates are not in correct order please change them");
		txtDatesError.setColumns(40);
		frmError.setTitle("error");
		frmError.setBounds(100, 100, 450, 300);
		frmError.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
