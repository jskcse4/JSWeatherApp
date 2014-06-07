package com.jskaleel.jsweatherapp;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

public class ResultActivity extends Activity {
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result);
		
		Bundle extra = this.getIntent().getExtras();;
		String area = extra.getString("area");
		String url = "http://xml.weather.yahoo.com/forecastrss?q=" + area +"&u=c";
		
		new TaskAsync(url).execute();
	}
	
	class TaskAsync extends AsyncTask<Void, Void, Void> {
		XMLHelper helper;
		String cityurl;
		ProgressDialog pd;

		public TaskAsync(String url) {
			cityurl = url;
		}

		@Override
		protected Void doInBackground(Void... params) {
			helper = new XMLHelper(cityurl);
			helper.get();
			return null;
		}
		
		protected void onPreExecute(Void... arg)
		{
			pd = new ProgressDialog(ResultActivity.this);
			return;
		}
		protected void onPostExecute(Void result) {
			
			Log.d("TEST",helper.item.getTitle());
			Log.d("TEST",helper.item.getCtext());
			Log.d("TEST",helper.item.getTemp());
			Log.d("TEST",helper.item.getFText());
			Log.d("TEST",helper.item.getDay());
			Log.d("TEST",helper.item.getLow());
			Log.d("TEST",helper.item.getHigh());
			
			
			/*StringBuilder builder = new StringBuilder();
			for (PostValue post : helper.channels) {
				builder.append("\nPost: " + post.getTitle());
				builder.append("\nPublish Date: " + post.getDate());
				builder.append("\nGuid: " + post.getGuid() + "\n");
			}
			tvResponse.setText(builder.toString());*/
		}
	}
}
