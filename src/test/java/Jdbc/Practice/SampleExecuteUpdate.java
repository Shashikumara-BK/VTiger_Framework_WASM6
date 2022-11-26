package Jdbc.Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class SampleExecuteUpdate {
	@Test
	public void sampleExecuteUpdate() throws SQLException
	{
        Driver driverRef = new Driver();
		
		//Step 1: Register the driver
		DriverManager.registerDriver(driverRef);
		
		//Step 2: Get the Connection with database
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/wasm6db", "root", "root");
		
		//Step 3: Issue Create statement
		Statement state = con.createStatement();
		
		//Step 4: Execute any query
		String query = "insert into wasm6table values('Batman','Newyork',20)";
		int result = state.executeUpdate(query);
		//Assert.assertEquals(result, 1);
		if(result==1)
		{
			System.out.println("Data added succssfully");
		}
		else
		{
			System.out.println("data not added");
		}
		
		//Step 5: close the database
		con.close();
	}

}
