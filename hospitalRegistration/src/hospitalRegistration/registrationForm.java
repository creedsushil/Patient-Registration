package hospitalRegistration;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

import com.mysql.fabric.xmlrpc.base.Array;
import com.mysql.jdbc.Statement;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.Color;

public class registrationForm {

	public JFrame frame;
	private JTextField fName;
	private JTextField lName;
	private JTextField date;
	private JTextField address;
	private JTextField contactNo;
	private JTextField occupation;
	private JTextField guardian;
	private JTextField age;
	private JTextField emeContact;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registrationForm window = new registrationForm();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public registrationForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */

	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(Color.BLACK);
		frame.setBounds(100, 100, 585, 378);
		frame.setUndecorated(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Registration Form");
		JLabel lblName = new JLabel("First Name  :");
		lblName.setBounds(10, 50, 89, 14);
		frame.getContentPane().add(lblName);

		fName = new JTextField();
		fName.setBounds(126, 42, 107, 20);
		frame.getContentPane().add(fName);
		fName.setColumns(10);

		JLabel lblLastname = new JLabel("Last Name :");
		lblLastname.setBounds(243, 50, 74, 14);
		frame.getContentPane().add(lblLastname);

		lName = new JTextField();
		lName.setBounds(346, 44, 126, 20);
		frame.getContentPane().add(lName);
		lName.setColumns(10);

		JLabel lblDate = new JLabel("Date :");
		lblDate.setBounds(10, 14, 46, 14);
		frame.getContentPane().add(lblDate);

		date = new JTextField();
		date.setEditable(false);
		date.setBounds(76, 11, 107, 20);
		frame.getContentPane().add(date);
		date.setColumns(10);
		date.setFocusable(false);
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Calendar cal = Calendar.getInstance();
		date.setText(dateFormat.format(cal.getTime()).toString());
		JComboBox gender = new JComboBox();
		gender.setModel(new DefaultComboBoxModel(new String[] { "Male", "Female", "Others" }));
		gender.setBounds(126, 73, 107, 20);
		frame.getContentPane().add(gender);

		JLabel lblGender = new JLabel("Gender        :");
		lblGender.setBounds(10, 81, 68, 14);
		frame.getContentPane().add(lblGender);

		JLabel lblAddress = new JLabel("Address     :");
		lblAddress.setBounds(243, 76, 75, 14);
		frame.getContentPane().add(lblAddress);

		address = new JTextField();
		address.setBounds(346, 75, 126, 20);
		frame.getContentPane().add(address);
		address.setColumns(10);

		JLabel lblContactNo = new JLabel("Contact No. :");
		lblContactNo.setBounds(10, 119, 89, 14);
		frame.getContentPane().add(lblContactNo);

		contactNo = new JTextField();
		contactNo.setBounds(126, 116, 107, 20);
		frame.getContentPane().add(contactNo);
		contactNo.setColumns(10);

		JLabel lblOccupation = new JLabel("occupation :");
		lblOccupation.setBounds(244, 119, 74, 14);
		frame.getContentPane().add(lblOccupation);

		occupation = new JTextField();
		occupation.setBounds(346, 116, 126, 20);
		frame.getContentPane().add(occupation);
		occupation.setColumns(10);

		JLabel lblGuardian = new JLabel("Guardian      :");
		lblGuardian.setBounds(11, 155, 88, 14);
		frame.getContentPane().add(lblGuardian);

		guardian = new JTextField();
		guardian.setBounds(126, 152, 107, 20);
		frame.getContentPane().add(guardian);
		guardian.setColumns(10);

		JLabel lblAge = new JLabel("Age            :");
		lblAge.setBounds(243, 155, 74, 14);
		frame.getContentPane().add(lblAge);

		final JLabel error = new JLabel("Please fill all the fields.");
		error.setForeground(Color.RED);
		error.setVisible(false);
		error.setBounds(211, 238, 181, 14);
		frame.getContentPane().add(error);

		age = new JTextField();
		age.setBounds(346, 152, 126, 20);
		frame.getContentPane().add(age);
		age.setColumns(10);

		final JCheckBox isEmergency = new JCheckBox("Is Emergency?");
		isEmergency.setBounds(2, 219, 145, 23);
		frame.getContentPane().add(isEmergency);

		JLabel lblEmergencyCont = new JLabel("Eme. Cont.  :");
		lblEmergencyCont.setBounds(10, 185, 89, 14);
		frame.getContentPane().add(lblEmergencyCont);

		emeContact = new JTextField();
		emeContact.setBounds(126, 182, 107, 20);
		frame.getContentPane().add(emeContact);
		emeContact.setColumns(10);

		JButton btnSubmit = new JButton("REGISTER");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Map<String, String> patientInfo = new HashMap<String, String>();
				patientInfo.put("firstName", fName.getText());
				patientInfo.put("lastName", lName.getText());
				patientInfo.put("regDate", date.getText());
				patientInfo.put("address", address.getText());
				patientInfo.put("contactNo", contactNo.getText());
				patientInfo.put("occupation", occupation.getText());
				patientInfo.put("guardian", guardian.getText());
				patientInfo.put("age", age.getText());
				patientInfo.put("emergencyContact", emeContact.getText());
				patientInfo.put("isEmergency", isEmergency.isSelected() ? "Yes" : "No");
				boolean isError = false;
				for (int i = 0; i < patientInfo.size(); i++) {
					if (patientInfo.values().toArray()[i].toString().isEmpty()) {
						isError = true;
					}
				}

				if (!isError) {
					try {
						boolean savePatient = savePatient(patientInfo);
						if (savePatient == true) {
							error.setVisible(true);
							error.setForeground(Color.BLUE);
							error.setText("Patient Saved");
						} else {
							error.setText("Something went wrong !");
							error.setForeground(Color.RED);
							error.setVisible(true);
						}
					} catch (SQLException e) {
						error.setText("Couldn't save the patient !");
						error.setForeground(Color.RED);
						error.setVisible(true);
					}
				} else {
					error.setText(("Please fill all the fields."));
					error.setForeground(Color.RED);
					error.setVisible(true);
				}

			}
		});
		btnSubmit.setBounds(210, 263, 107, 23);
		frame.getContentPane().add(btnSubmit);

	}
	
	public boolean savePatient(Map<String, String> patientInfo) throws SQLException {
		Connection dbCon = new databaseConnection().getConnection();
		String buildingRoughQuery = "Insert into patient(";
		for (int i = 0; i < patientInfo.size(); i++) {
			buildingRoughQuery = buildingRoughQuery + (patientInfo.keySet().toArray())[i];
			if (patientInfo.size() - 1 != i) {
				buildingRoughQuery = buildingRoughQuery + ",";
			} else {
				buildingRoughQuery = buildingRoughQuery + ") values(";
			}
		}

		for (int i = 0; i < patientInfo.size(); i++) {
			buildingRoughQuery = buildingRoughQuery + "'" + (patientInfo.values().toArray())[i];
			if (patientInfo.size() - 1 != i) {
				buildingRoughQuery = buildingRoughQuery + "',";
			} else {
				buildingRoughQuery = buildingRoughQuery + "');";
			}
		}
		Statement stat = (Statement) dbCon.createStatement();
		int result = stat.executeUpdate(buildingRoughQuery);
		if (result > 0) {
			return true;
		} else {
			return false;
		}

	}

	
}
