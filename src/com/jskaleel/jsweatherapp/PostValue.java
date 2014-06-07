/**
 * 
 */
package com.jskaleel.jsweatherapp;

import java.util.ArrayList;
import java.util.List;

/**
 * @author JSK
 *
 */
public class PostValue {
String title, Ctext, temp;

String FText, Low, High, Day;

List<String> forecast;

public PostValue()
{
	forecast = new ArrayList<String>();
}

	public String getFText() {
		return FText;
	}
	
	public void setFText(String fText) {
		FText = fText;
	}

	public String getTemp() {
		return temp;
	}
	
	public void setTemp(String temp) {
		this.temp = temp;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getCtext() {
		return Ctext;
	}
	
	public String getLow() {
		return Low;
	}

	public void setLow(String low) {
		this.Low = low;
	}

	public String getHigh() {
		return High;
	}

	public void setHigh(String high) {
		this.High = high;
	}

	public String getDay() {
		return Day;
	}

	public void setDay(String day) {
		this.Day = day;
	}

	public void setCtext(String ctext) {
		this.Ctext = ctext;
	}
	
}
