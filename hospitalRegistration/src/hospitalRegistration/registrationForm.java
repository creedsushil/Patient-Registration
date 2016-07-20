package hospitalRegistration;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
//import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.awt.event.ActionEvent;

public class registrationForm {
	
	public JFrame frame;
	private JTextField date;
	private JTextField lName;
	private JTextField fName;
	private JTextField address;
	private JTextField contactNo;
	private JTextField occupation;

	public registrationForm(JFrame frame, JTextField date, JTextField lName, JTextField fName, JTextField address,
			JTextField contactNo, JTextField occupation) {
		super();
		this.frame = frame;
		this.date = date;
		this.lName = lName;
		this.fName = fName;
		this.address = address;
		this.contactNo = contactNo;
		this.occupation = occupation;
	}
	
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
		frame.setBounds(100, 100, 497, 378);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Registration Form");
		JLabel lblName = new JLabel("First Name  :");
		lblName.setBounds(10, 50, 89, 14);
		frame.getContentPane().add(lblName);
		
		date = new JTextField();
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Calendar cal = Calendar.getInstance();
		date.setText(dateFormat.format(cal.getTime()).toString());
		date.setBounds(88, 11, 107, 20);
		frame.getContentPane().add(date);
		date.setColumns(10);
		date.setEditable(false);
		
		
		
		
		JLabel lblLastname = new JLabel("Last Name :");
		lblLastname.setBounds(223, 50, 74, 14);
		frame.getContentPane().add(lblLastname);
		
		lName = new JTextField();
		lName.setBounds(308, 44, 126, 20);
		frame.getContentPane().add(lName);
		lName.setColumns(10);
		
		JLabel lblDate = new JLabel("Date :");
		lblDate.setBounds(10, 14, 46, 14);
		frame.getContentPane().add(lblDate);
		
		fName = new JTextField();
		fName.setBounds(109, 42, 107, 20);
		frame.getContentPane().add(fName);
		fName.setColumns(10);
		fName.setFocusable(true);		
		JComboBox gender = new JComboBox();
		gender.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female", "Others"}));
		gender.setBounds(109, 73, 107, 20);
		frame.getContentPane().add(gender);
		
		JLabel lblGender = new JLabel("Gender        :");
		lblGender.setBounds(10, 81, 68, 14);
		frame.getContentPane().add(lblGender);
		
		JLabel lblAddress = new JLabel("Address     :");
		lblAddress.setBounds(222, 78, 75, 14);
		frame.getContentPane().add(lblAddress);
		
		address = new JTextField();
		address.setBounds(308, 75, 126, 20);
		frame.getContentPane().add(address);
		address.setColumns(10);
		
		JLabel lblContactNo = new JLabel("Contact No. :");
		lblContactNo.setBounds(10, 119, 68, 14);
		frame.getContentPane().add(lblContactNo);
		
		contactNo = new JTextField();
		contactNo.setBounds(109, 116, 107, 20);
		frame.getContentPane().add(contactNo);
		contactNo.setColumns(10);
		
		JLabel lblOccupation = new JLabel("occupation :");
		lblOccupation.setBounds(223, 119, 74, 14);
		frame.getContentPane().add(lblOccupation);
		
		occupation = new JTextField();
		occupation.setBounds(308, 116, 126, 20);
		frame.getContentPane().add(occupation);
		occupation.setColumns(10);
		
		JButton btnSubmit = new JButton("SUBMIT");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			System.out.println("----------++++++++++++------------------+++++++++++++-------------------");
			}
		});
		btnSubmit.setBounds(172, 235, 89, 23);
		frame.getContentPane().add(btnSubmit);
	}
}
