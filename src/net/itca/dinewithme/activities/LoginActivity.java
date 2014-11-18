package net.itca.dinewithme.activities;

import java.io.IOException;
import java.io.Writer;
import java.util.Properties;

import net.itca.dinewithme.R;
import net.itca.dinewithme.R.id;
import net.itca.dinewithme.R.layout;
import net.itca.dinewithme.R.menu;
import net.itca.dinewithme.data.Database;
import net.itca.dinewithme.data.PropertyAccess;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class LoginActivity extends ActionBarActivity
{
	PropertyAccess propertyAccess;
	Database database;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		propertyAccess = new PropertyAccess();
		database = new Database();
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings)
		{
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	private boolean isRemembered()
	{
		return propertyAccess.contains("username");
	}
	
	public void loginClick(View view)
	{
		TextView usernameTV = (TextView) findViewById(R.id.dynUsername);
		TextView passwordTV = (TextView) findViewById(R.id.dynPassword);
		if(database.Login(usernameTV.getText().toString(), passwordTV.getText().toString()))
		{
			// Login succesfull
			CheckBox rememberMeChk = (CheckBox) findViewById(R.id.remembermeCheckbox);
			if(rememberMeChk.isChecked())
			{
				// write username & password, if not yet set.
				propertyAccess.rememberUser(usernameTV.getText().toString());
			}
			// redirect to login
		}
		else
		{
			// Login unsuccesfull - show error messages.
		}
	}
	
	public void redirectCreateUser(View view)
	{
		System.out.println("redirecting");
	}
}
