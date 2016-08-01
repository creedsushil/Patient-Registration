package hospitalRegistration;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class loginForm {

	JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginForm window = new loginForm();
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
	public loginForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		textField = new JTextField();
		textField.setBounds(195, 11, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setBounds(93, 17, 92, 14);
		frame.getContentPane().add(lblUserName);

		passwordField = new JPasswordField();
		passwordField.setBounds(195, 42, 87, 20);
		frame.getContentPane().add(passwordField);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(93, 45, 67, 14);
		frame.getContentPane().add(lblPassword);

		final JLabel error = new JLabel("Error : Invalid user name or password");
		error.setVisible(false);
		error.setForeground(Color.RED);
		error.setBounds(93, 73, 232, 14);
		frame.getContentPane().add(error);

		JButton btnLogIn = new JButton("Log In");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				String userName = textField.getText();
				String password = new String(passwordField.getPassword());
				Connection dbCon = new databaseConnection().getConnection();
				try {
					String query = "SELECT * FROM USER WHERE userName='" + userName + "' and password='" + password
							+ "'";
					Statement stat = (Statement) dbCon.createStatement();
					ResultSet result = stat.executeQuery(query);
					if (result.first()) {
						// while(result.next()){
						frame.dispose();
						try {
							registrationForm windowReg = new registrationForm();
							windowReg.frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
						// }
					} else {
						error.setText("Error : Invalid user name or password");
						error.setVisible(true);
					}

				} catch (Exception e) {
					// TODO: handle exception
					// System.out.println(e);
					error.setText("Please Check Server");
					error.setVisible(true);
				}
				try {
					dbCon.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		btnLogIn.setBounds(150, 103, 89, 23);
		frame.getContentPane().add(btnLogIn);
	}
}