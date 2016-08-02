package hospitalRegistration;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JToolBar;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.awt.event.ActionEvent;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JScrollPane;

import java.awt.List;
import java.awt.ScrollPane;

import javax.swing.JTable;

public class mainWindow {

	JFrame frame;
	private JTextField fName;
	private JTextField lName;
	private JTextField date;
	private JTextField address;
	private JTextField contactNo;
	private JTextField occupation;
	private JTextField guardian;
	private JTextField age;
	private JTextField emeContact;
	private JTable table;
	private JTextField searchField;
	private JTextField search;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainWindow window = new mainWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * 
	 * @throws SQLException
	 */
	public mainWindow() throws SQLException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws SQLException
	 */
	private void initialize() throws SQLException {
		frame = new JFrame();
		frame.setBounds(100, 100, 713, 424);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));

		JToolBar toolBar = new JToolBar();
		frame.getContentPane().add(toolBar, BorderLayout.NORTH);

		final JInternalFrame internalFrame = new JInternalFrame("Register");
		frame.getContentPane().add(internalFrame, BorderLayout.CENTER);
		internalFrame.getContentPane().setLayout(null);
		internalFrame.setTitle("Registration Form");
		JLabel lblName = new JLabel("First Name  :");
		lblName.setBounds(10, 50, 89, 14);
		internalFrame.getContentPane().add(lblName);

		fName = new JTextField();
		fName.setBounds(126, 42, 107, 20);
		internalFrame.getContentPane().add(fName);
		fName.setColumns(10);

		JLabel lblLastname = new JLabel("Last Name :");
		lblLastname.setBounds(243, 50, 74, 14);
		internalFrame.getContentPane().add(lblLastname);

		lName = new JTextField();
		lName.setBounds(346, 44, 126, 20);
		internalFrame.getContentPane().add(lName);
		lName.setColumns(10);

		JLabel lblDate = new JLabel("Date :");
		lblDate.setBounds(10, 14, 46, 14);
		internalFrame.getContentPane().add(lblDate);

		date = new JTextField();
		date.setEditable(false);
		date.setBounds(76, 11, 107, 20);
		internalFrame.getContentPane().add(date);
		date.setColumns(10);
		date.setFocusable(false);
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Calendar cal = Calendar.getInstance();
		date.setText(dateFormat.format(cal.getTime()).toString());
		JComboBox gender = new JComboBox();
		gender.setModel(new DefaultComboBoxModel(new String[] { "Male", "Female", "Others" }));
		gender.setBounds(126, 73, 107, 20);
		internalFrame.getContentPane().add(gender);

		JLabel lblGender = new JLabel("Gender        :");
		lblGender.setBounds(10, 81, 68, 14);
		internalFrame.getContentPane().add(lblGender);

		JLabel lblAddress = new JLabel("Address     :");
		lblAddress.setBounds(243, 76, 75, 14);
		internalFrame.getContentPane().add(lblAddress);

		address = new JTextField();
		address.setBounds(346, 75, 126, 20);
		internalFrame.getContentPane().add(address);
		address.setColumns(10);

		JLabel lblContactNo = new JLabel("Contact No. :");
		lblContactNo.setBounds(10, 119, 89, 14);
		internalFrame.getContentPane().add(lblContactNo);

		contactNo = new JTextField();
		contactNo.setBounds(126, 116, 107, 20);
		internalFrame.getContentPane().add(contactNo);
		contactNo.setColumns(10);

		JLabel lblOccupation = new JLabel("occupation :");
		lblOccupation.setBounds(244, 119, 74, 14);
		internalFrame.getContentPane().add(lblOccupation);

		occupation = new JTextField();
		occupation.setBounds(346, 116, 126, 20);
		internalFrame.getContentPane().add(occupation);
		occupation.setColumns(10);

		JLabel lblGuardian = new JLabel("Guardian      :");
		lblGuardian.setBounds(11, 155, 88, 14);
		internalFrame.getContentPane().add(lblGuardian);

		guardian = new JTextField();
		guardian.setBounds(126, 152, 107, 20);
		internalFrame.getContentPane().add(guardian);
		guardian.setColumns(10);

		JLabel lblAge = new JLabel("Age            :");
		lblAge.setBounds(243, 155, 74, 14);
		internalFrame.getContentPane().add(lblAge);

		final JLabel error = new JLabel("Please fill all the fields.");
		error.setForeground(Color.RED);
		error.setVisible(false);
		error.setBounds(211, 238, 181, 14);
		internalFrame.getContentPane().add(error);

		age = new JTextField();
		age.setBounds(346, 152, 126, 20);
		internalFrame.getContentPane().add(age);
		age.setColumns(10);

		final JCheckBox isEmergency = new JCheckBox("Is Emergency?");
		isEmergency.setBounds(2, 219, 145, 23);
		internalFrame.getContentPane().add(isEmergency);

		JLabel lblEmergencyCont = new JLabel("Eme. Cont.  :");
		lblEmergencyCont.setBounds(10, 185, 89, 14);
		internalFrame.getContentPane().add(lblEmergencyCont);

		emeContact = new JTextField();
		emeContact.setBounds(126, 182, 107, 20);
		internalFrame.getContentPane().add(emeContact);
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
						boolean savePatient = new registrationForm().savePatient(patientInfo);
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
		internalFrame.getContentPane().add(btnSubmit);

		internalFrame.setVisible(true);
		/*
		 * searchField = new JTextField(); searchField.setBounds(402, 11, 150,
		 * 20); internalFrame.getContentPane().add(searchField);
		 * searchField.setColumns(10);
		 * 
		 * JButton btnNewButton = new JButton("Search");
		 * btnNewButton.addActionListener(new ActionListener() { public void
		 * actionPerformed(ActionEvent arg0) { } }); btnNewButton.setBounds(293,
		 * 10, 89, 23); internalFrame.getContentPane().add(btnNewButton);
		 */
		final JScrollPane scrollPane = new JScrollPane();
		JButton list = new JButton("Patient List");
		list.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<patient> patientList = null;
				try {
					patientList = new patientList().getPatient(null);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Object[][] rowData = new Object[patientList.size()][2];
				for (int i = 0; i < patientList.size(); i++) {
					rowData[i] = new Object[] { patientList.get(i).patient_Id, patientList.get(i).firstName,
							patientList.get(i).lastName, patientList.get(i).address, patientList.get(i).contactNo,
							patientList.get(i).age, patientList.get(i).isEmergency };
				}
				// patientList.toArray();
				Object columnNames[] = { "Patient ID", "First Name", "Last Name", "address", "Contact No.", "Age",
						"Emergency" };

				frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
				table = new JTable(rowData, columnNames);

				/*search = new JTextField();
				search.setBounds(505, 0, 89, 20);
				scrollPane.add(search);
				search.setColumns(10);

				JButton btnSearch = new JButton("Search");
				btnSearch.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				btnSearch.setBounds(592, -1, 89, 23);
				scrollPane.add(btnSearch);*/
				scrollPane.setViewportView(table);
				scrollPane.setVisible(true);
				internalFrame.dispose();
			}
		});
		JButton register = new JButton("Register");
		toolBar.add(register);
		toolBar.add(list);
		register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				scrollPane.setVisible(false);
				internalFrame.setVisible(true);
			}
		});

	}
}
