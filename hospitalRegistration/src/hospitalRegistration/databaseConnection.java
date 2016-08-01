package hospitalRegistration;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class databaseConnection {
public static void main(String[] args) throws SQLException{
	/*Connection conn = null;
	try {
		conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/patientReg", "root", "");
		//System.out.println("Connected");
		String query = "SELECT * FROM USER";
		Statement stat = (Statement) conn.createStatement();
		ResultSet result = stat.executeQuery(query);
		while(result.next()){
			System.out.println("userName :"+result.getString("userName"));
		}
	} catch (Exception e) {
		// TODO: handle exception
		System.err.println(e);
	}*/
	//conn.close();
}

public Connection getConnection(){
	Connection conn = null;
	try {
		conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/patientReg", "root", "");
	} catch (Exception e) {
		// TODO: handle exception
		System.err.println(e);
	}
	return conn;
}
}
