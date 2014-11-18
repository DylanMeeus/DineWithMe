package net.itca.dinewithme.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database
{
	/**
	 * ReadUsers
	 * WriteUser
	 * ReadEvents
	 * WriteEvent
	 * Login
	 */
	String url;
	Connection connection;
	public Database()
	{
	}
	
	private void connect()
	{
		try
		{
		url  = "jdbc:postgresql://gegevensbanken.khleuven.be:51415/probeer?sslfactory=org.postgresql.ssl.NonValidatingFactory&ssl=true";
		Class.forName("org.postgresql.Driver");
		
		connection = DriverManager.getConnection(url, "***",
				"***");
		
		}
		catch(Exception ex)
		{
			
		}
		finally
		{
			if(connection != null)
			{
				try
				{
					connection.close();
				} catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
		}
	}
	
	public boolean Login(String username, String password)
	{
		System.out.println("Logging in: " + username + " " + password);
		return true;
	}
}
