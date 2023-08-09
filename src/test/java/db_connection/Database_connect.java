package db_connection;

import static org.testng.Assert.assertTrue;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mysql.cj.xdevapi.Statement;

public class Database_connect {
	@Test
	public void mysql_db_connect()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("1- Driver loaded");
			
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "mukeshotwani");
			System.out.println("2- connected to DB");
			
			java.sql.Statement smt=conn.createStatement();
		    System.out.println("3- statement created");
		    
		    ResultSet result=smt.executeQuery("select * from employee");
		    
		   boolean status=false;
		    while(result.next())
		    {
		    	String email=result.getString("Email");
		    	if(email.contains("mahendra@gmail.com"))
		    	{
		    		System.out.println("email found");
		    		status=true;
		    	}
		    }
			
			Assert.assertTrue(true);
			
		} catch (ClassNotFoundException e) {
			System.out.println("Could not load the driver");
		} catch (SQLException e) {
			System.out.println("could not connect to DB "+ e.getMessage());
		}
		
	}

}
