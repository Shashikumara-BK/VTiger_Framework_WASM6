package Jdbc.Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class SampleExecuteQuery {
	@Test
	public void sampleExecuteQuery() throws SQLException
	{
		Driver driverRef = new Driver();
		
		//Step 1: Register the driver
		DriverManager.registerDriver(driverRef);
		
		//Step 2: Get the Connection with database
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/wasm6db", "root", "root");
		
		//Step 3: Issue Create statement
		Statement state = con.createStatement();
		
		//Step 4: Execute any query
		ResultSet result = state.executeQuery("select * from wasm6table;");
		while(result.next())
		{
			System.out.println(result.getString(1)+" "+result.getString(2)+" "+result.getInt(3));
		}
		
		//Step 5: close the database
		con.close();
	}


}
