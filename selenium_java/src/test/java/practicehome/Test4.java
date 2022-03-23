package practicehome;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class Test4 {

	public static void main(String[] args) throws Throwable {
		
		Driver driver=new Driver();
		
		DriverManager.registerDriver(driver);
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testyantra", "root", "root");
		
	Statement stat = conn.createStatement();
	String query="insert into students_info values('16','deepak','gowda','h')";
		int result=stat.executeUpdate(query);
		if(result==1)
		{
			System.out.println("================pass=======");
		}
		else
			System.out.println("===========fail");
		
		conn.close();
		

	}

}
