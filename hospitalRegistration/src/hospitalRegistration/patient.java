package hospitalRegistration;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.mysql.fabric.xmlrpc.base.Array;
import com.mysql.jdbc.Statement;

public class patient {
	public patient(int patient_Id, String firstName, String lastName, String address, String contactNo, String guardian,
			String age, String isEmergency) {
		super();
		this.patient_Id = patient_Id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.contactNo = contactNo;
		this.guardian = guardian;
		this.age = age;
		this.isEmergency = isEmergency;
	}




	public int patient_Id = 0;
    public String firstName = "";
    public String lastName = "";
    public String address = "";
    public String contactNo = "";
    public String guardian = "";
    public String age = "";
    public String isEmergency = "";
    
    public patient(int id, String newFirstName, String newLastName, String newAddress,String newContact,String newAge,String newEmergency){
        patient_Id = id;
        firstName = newFirstName;
        lastName = newLastName;
        address = newAddress;
        contactNo = newContact;
        age = newAge;
        isEmergency = newEmergency;
        }

	
	
	
	public static void main(String[] args) {
		loginForm form = new loginForm();
		form.frame.setVisible(true);
	}	
}

