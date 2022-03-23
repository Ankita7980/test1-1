package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class InsertqueryTest {

	public static void main(String[] args) throws Throwable {
		
		Driver driverref=new Driver();
		DriverManager.registerDriver(driverref);
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testyantra", "root", "root");
		    Statement stat = conn.createStatement();
		    String query="insert into students_info values('8','deepak','gowda','h')";
		    int result=stat.executeUpdate(query);
		    if(result==1)
		    {
		    	System.out.println("inserted sucussfully=====pass");
		    }
		    else
		    {
		    	System.out.println("failed to create=======fail");
		    }
		    conn.close();

	}

}
