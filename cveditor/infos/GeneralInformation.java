package cveditor.infos;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JTextField;
import javax.swing.JButton;

import cveditor.manager.CVManager;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class GeneralInformation {

	private JFrame frmGeneralInformation;
	private JTextField txtName;
	private JTextField textField;
	private JPanel panel2;
	private JTextField txtAddress;
	private JTextField textField1;
	private JPanel panel3;
	private JTextField txtTelephone;
	private JTextField textField2;
	private JTextField textField3;
	private JPanel panel4;
	private JTextField txtEmail;
	private JTextField textField4;
	private JButton btnOk;
	private JPanel panel5;
	private JButton btnCancel;
	
	private String name;
	private String address;
	private String telephone1;
	private String telephone2;
	private String email;
	
	private String infoGeneralInformation;
	
	private CVManager manager;
	
	

	/**
	 * Launch the application.
	 */
	public void getGeneralInformation() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GeneralInformation window = new GeneralInformation(infoGeneralInformation,manager);
					window.frmGeneralInformation.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */

	
	public GeneralInformation(String infoGeneralInformation,CVManager manager) {
		this.infoGeneralInformation = infoGeneralInformation;
		if(infoGeneralInformation!=(null)){
			String [] array = infoGeneralInformation.split("-");//we have them in one string ,so we separate them here
			name = array[0];
			address=array[1];
			telephone1=array[2];
			telephone2=array[3];
			email=array[4];
		}
		this.manager=manager;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGeneralInformation = new JFrame();
		frmGeneralInformation.setTitle("ADDITIONAL INFORMATION");
		frmGeneralInformation.setBounds(100, 100, 400, 250);
		frmGeneralInformation.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		frmGeneralInformation.getContentPane().add(panel, BorderLayout.CENTER);
		
		JPanel panel1 = new JPanel();
		panel.add(panel1);
		
		txtName = new JTextField();
		txtName.setEditable(false);
		txtName.setText("Name");
		panel1.add(txtName);
		txtName.setColumns(10);
		
		textField = new JTextField();
		panel1.add(textField);
		textField.setColumns(10);
		textField.setText(name);
		
		panel2 = new JPanel();
		panel.add(panel2);
		
		txtAddress = new JTextField();
		txtAddress.setEditable(false);
		txtAddress.setText("Address");
		panel2.add(txtAddress);
		txtAddress.setColumns(10);
		
		textField1 = new JTextField();
		panel2.add(textField1);
		textField1.setColumns(10);
		textField1.setText(address);
		
		panel3 = new JPanel();
		panel.add(panel3);
		
		txtTelephone = new JTextField();
		txtTelephone.setEditable(false);
		txtTelephone.setText("Telephone");
		panel3.add(txtTelephone);
		txtTelephone.setColumns(10);
		
		textField2 = new JTextField();
		panel3.add(textField2);
		textField2.setColumns(10);
		textField2.setText(telephone1);
		
		textField3 = new JTextField();
		panel3.add(textField3);
		textField3.setColumns(10);
		textField3.setText(telephone2);
		
		panel4 = new JPanel();
		panel.add(panel4);
		
		txtEmail = new JTextField();
		txtEmail.setEditable(false);
		txtEmail.setText("email");
		panel4.add(txtEmail);
		txtEmail.setColumns(10);
		
		textField4 = new JTextField();
		panel4.add(textField4);
		textField4.setColumns(10);
		textField4.setText(email);
		
		panel5 = new JPanel();
		panel.add(panel5);
		
		btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				name = textField.getText();
				address = textField1.getText();
				telephone1 = textField2.getText();
				telephone2 = textField3.getText();
				email = textField4.getText();
				infoGeneralInformation=name+"-"+address+"-"+telephone1+"-"+telephone2+"-"+email;
				manager.setGeneralInformation(infoGeneralInformation);//we inform the manager so that the items are saved there
				frmGeneralInformation.setVisible(false);
			}
		});
		panel5.add(btnOk);
		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmGeneralInformation.setVisible(false);
			}
		});
		panel5.add(btnCancel);
	}

}
