package com.jskaleel.jsweatherapp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	private EditText locationBox;
	private Button button1;
	private String city, cityURL;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		locationBox = (EditText) findViewById(R.id.editText1);
		button1 = (Button) findViewById(R.id.button1);
		
		button1.setOnClickListener(new OnClickListener(){
			public void onClick(View v)
			{
				
				city = locationBox.getText().toString();
				if(!isValidCity(city) || city.length() <= 0)
				{
					locationBox.setError("Field is empty");
					//Toast.makeText(getBaseContext(), "Error : Field is empty", Toast.LENGTH_SHORT).show();
				}
				else
				{
					locationBox.setError(null);
					Intent i = new Intent(MainActivity.this,ResultActivity.class);
					i.putExtra("area", city);
					startActivity(i);
				}				
				Log.d("CITYURL", cityURL);
			}

			private boolean isValidCity(String city) {
				// TODO Auto-generated method stub
				String NAME = "^[a-zA-Z][a-zA-Z\\s]+$";
				Pattern city_pattern = Pattern.compile(NAME);
				Matcher match = city_pattern.matcher(city);
				return match.matches();
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}


}
