package com.jawad.accBackendRestArray;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import org.springframework.stereotype.Component;



@Component
public class UserDao {
	
private ArrayList<User> userInfo = new ArrayList<>();
	
	public UserDao() {
		addPreData();
	}
	
	
	
	public void addPreData() {
		User predata1 = new User("Test","Print",123456,"adad@deep.com","badpassword","01/10/1954", "male");
		userInfo.add(predata1);
		User predata2 = new User("Bill","Happy",45624,"hellpwd@deep.com","good?password","11/14/1994", "male");
		userInfo.add(predata1);
	
	}
	
	public ArrayList<User> displayStudents(){
		return userInfo;
	}
	
	public User addNewStudent(User newStudent) {
		
		userInfo.add(newStudent);
		return newStudent;
		
	}
	
	
	
	
	
	
	//*** For some reason, I found it really difficult to add the SQL database with my code even though it works just fine in the other one.
	//*** I'm going to use the arraylist for now since its been taking too long to troubleshoot

	
	
	
	private static final String USERNAME = "javatest";
	private static final String PASSWORD = "1234";
	private static final String CONN_STRING = "jdbc:mysql://localhost:3306/hello_java";
	

	public static void addContact(String firstName, String lastName, int phoneNumber, String emailAddress, String password, String birthdate, String gender) {
		//contactList.add(contact);
		Connection conn = null;
	    
	    try {
	      // Class.forName("com.mysql.jdbc.Driver");
	        conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/hello_java","javatest","1234");
	        System.out.println("Connected");
	        
	     // create the java statement
	        Statement st = (Statement) conn.createStatement();
	        
      
	       
	       // String values = " values (" + firstName+","+lastName+","+phoneNumber+","+emailAddress+","+password+","+birthdate+","+gender+")";
	        
	        String sql = "INSERT INTO contacts_tbl " 
	        + "(contact_name, contact_lastname, contact_phoneNume, contact_email, contact_pass, contact_birth, contact_gender)"
	        		+ "VALUES (?, ?, ?, ?, ?, ?, ?)";
	        
	        PreparedStatement statement = conn.prepareStatement(sql);
	        statement.setString(1, firstName);
	        statement.setString(2, lastName);
	        statement.setInt(3, phoneNumber);
	        statement.setString(4, emailAddress);
	        statement.setString(5, password);
	        statement.setString(6, birthdate);
	        statement.setString(7, gender);
	         
	        int rowsInserted = statement.executeUpdate();
	        if (rowsInserted > 0) {
	            System.out.println("The new user was inserted successfully!");
	        }
	        // execute the query, and get a java resultset
	       // String testy = "hello";
	       // ResultSet rs = st.executeQuery(sq1);
	        
	   
	        st.close();
	        
	    }catch (SQLException e){
	    System.err.println(e);
	    }		
	
		
		
	}
	
	
	
	
	public static void removeContact(String namedelete) {
		
Connection conn = null;
	    
	    try {
	      // Class.forName("com.mysql.jdbc.Driver");
	        conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/hello_java","javatest","1234");
	        System.out.println("Connected");
	        
	     // create the java statement
	        Statement st = (Statement) conn.createStatement();
	        
  
	        String sql = "DELETE FROM contacts_tbl WHERE contact_name=?";
	        
	        PreparedStatement statement = conn.prepareStatement(sql);
	        statement.setString(1, namedelete);
	         
	        int rowsDeleted = statement.executeUpdate();
	        if (rowsDeleted > 0) {
	            System.out.println("A user was deleted successfully!");
	        }
	        
	   
	        st.close();
	        
	    }catch (SQLException e){
	    System.err.println(e);
	    }
	    
	}
		
		
		

	
	
	
	
	public static void updateContact(String nameupdate, String firstName, String lastName, int phoneNumber, String emailAddress, String password, String birthdate, String gender) {
		//contactList.add(contact);
		Connection conn = null;
	    
	    try {
	      // Class.forName("com.mysql.jdbc.Driver");
	        conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/hello_java","javatest","1234");
	        System.out.println("Connected");
	        
	     // create the java statement
	        Statement st = (Statement) conn.createStatement();
	        
    
	       // String values = " values (" + firstName+","+lastName+","+phoneNumber+","+emailAddress+","+password+","+birthdate+","+gender+")";
	        
	        String sql = "UPDATE contacts_tbl SET contact_name=?, contact_lastname=?, contact_phoneNume=?, contact_email=?, contact_pass=?, contact_birth=?, contact_gender=? WHERE contact_name=?"; 
	        
	        		
	        
	        PreparedStatement statement = conn.prepareStatement(sql);
	        statement.setString(1, firstName);
	        statement.setString(2, lastName);
	        statement.setInt(3, phoneNumber);
	        statement.setString(4, emailAddress);
	        statement.setString(5, password);
	        statement.setString(6, birthdate);
	        statement.setString(7, gender);
	        statement.setString(8, nameupdate);
	         
	        int rowsInserted = statement.executeUpdate();
	        if (rowsInserted > 0) {
	            System.out.println("The user was updated successfully!");
	        }
	        // execute the query, and get a java resultset
	       // String testy = "hello";
	       // ResultSet rs = st.executeQuery(sq1);
	        
	   
	        st.close();
	        
	    }catch (SQLException e){
	    System.err.println(e);
	    }		
	
		
		
	}
	
	
	public static void printContacts(){
		Connection conn = null;
	    
	    try {
	      // Class.forName("com.mysql.jdbc.Driver");
	        conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/hello_java","javatest","1234");
	        System.out.println("Connected");
	        
	     // create the java statement
	        Statement st = (Statement) conn.createStatement();
	        
      
	        // execute the query, and get a java resultset
	        ResultSet rs = st.executeQuery("SELECT * FROM contacts_tbl");
	        
	        // iterate through the java resultset
	        while (rs.next())
	        {
	          int id = rs.getInt("contact_ID");
	          String firstName = rs.getString("contact_name");
	          String lastName = rs.getString("contact_lastname");
	          int phoneNum = rs.getInt("contact_phoneNume");
	          String emailAdd = rs.getString("contact_email");
			  String password = rs.getString("contact_pass");
			  String birthdate = rs.getString("contact_birth");
			  String gender = rs.getString("contact_gender");


	          // print the results
	          System.out.format("%s, %s, %s, %s, %s, %s, %s, %s\n", id, firstName, lastName, phoneNum, emailAdd, password, birthdate, gender);
	        }
	        st.close();
	        
	    }catch (SQLException e){
	    System.err.println(e);
	    }		
	}
	
	
}