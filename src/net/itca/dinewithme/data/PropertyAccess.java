package net.itca.dinewithme.data;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Properties;

public class PropertyAccess
{
	Properties properties;
	OutputStream output;
	public PropertyAccess()
	{	
		properties = new Properties();
	}
	
	// Always maximum one remembered user. (auto-login, only one person uses the phone)
	// Don't need to store password locally?
	public void rememberUser(String username)
	{
		try
		{
			output = new FileOutputStream("config.properties");
			properties.setProperty("username", username);
			properties.store(output, null);
		}
		catch(Exception ex)
		{
			
		}
		finally
		{
			if(output != null)
			{
				try
				{
				output.close();
				}
				catch(Exception ex)
				{
					
				}
			}
		}
	}
	
	public boolean contains(String property)
	{
		return properties.contains(property);
	}
}
