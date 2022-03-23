package practicehome;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class Test0 {

	public static void main(String[] args) throws Throwable {
		
		Driver driveref=new Driver();
		DriverManager.registerDriver(driveref);
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testyantra", "root", "root");
		
		Statement stat = conn.createStatement();
		String query="select * from students_info";
		
		 ResultSet result = stat.executeQuery(query);
		 
		 while(result.next())
		 {
			 System.out.println(result.getInt(1)+"\t"+result.getString(2)+"\t"+result.getString(3));
		 }
		 conn.close();
		

	}

}
