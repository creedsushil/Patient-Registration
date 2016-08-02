package hospitalRegistration;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class databaseConnection {
public static void main(String[] args) throws SQLException{
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
