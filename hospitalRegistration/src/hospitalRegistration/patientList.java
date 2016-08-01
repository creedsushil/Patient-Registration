package hospitalRegistration;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JToolBar;

import com.mysql.fabric.xmlrpc.base.Array;
import com.mysql.jdbc.Statement;

import java.awt.BorderLayout;

public class patientList {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					patientList window = new patientList();
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
	public patientList() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public ArrayList<patient> getPatient(String patientName) throws SQLException {
		Connection dbCon = new databaseConnection().getConnection();
		String query = "SELECT * FROM PATIENT";
		Statement stat = (Statement) dbCon.createStatement();
		ResultSet result = stat.executeQuery(query);
		String[] arr = null;
		ArrayList<patient> patArray = new ArrayList<patient>();
		while (result.next()) {
           /*patientInfo.add("id", result.getString("patient_id"));
           patientInfo.put("firstName", result.getString("firstName"));
			patientInfo.put("lastName", result.getString("lastName"));
			//patientInfo.put("regDate", result.getString("lastName"));
			patientInfo.put("address", result.getString("address"));
			patientInfo.put("contactNo", result.getString("contactNo"));
			//patientInfo.put("occupation", result.getString("lastName"));
			patientInfo.put("guardian", result.getString("guardian"));
			patientInfo.put("age", result.getString("age"));
			patientInfo.put("emergencyContact", result.getString("emergencyContact"));
			patientInfo.put("isEmergency", result.getString("isEmergency"));
			patientList.add(patientInfo);*/
			 patient patientList = new patient(result.getInt("patient_Id"),result.getString("firstName"),result.getString("lastName"),result.getString("address"),result.getString("contactNo"),result.getString("age"),result.getString("isEmergency"));
			 patArray.add(patientList);
        }
		return patArray;
	}
	
}
