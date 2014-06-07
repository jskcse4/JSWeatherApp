/**
 * 
 */
package com.jskaleel.jsweatherapp;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import android.util.Log;

/**
 * @author JSK
 *
 */
public class XMLHelper extends DefaultHandler {

	Boolean currTag = false;
	String currTagVal = "";
	public PostValue item = null;
	public ArrayList<PostValue> channels = new ArrayList<PostValue>();
	String areaURL;
	public XMLHelper(String url) {
		// TODO Auto-generated constructor stub
		areaURL = url;
		
		Log.d("AREAURL",areaURL);
	}

	public void get() {
		try {
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser parser = factory.newSAXParser();
			XMLReader reader = parser.getXMLReader();
			reader.setContentHandler(this);
			InputStream inputStream = new URL(areaURL).openStream();
			reader.parse(new InputSource(inputStream));
		} catch (Exception e) {
			Log.e("Exception: ", e.getMessage());
		}
	}
	
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {

		Log.i("TAG: " , localName);
		
		currTag = true;
		currTagVal = "";
		if (localName.equalsIgnoreCase("item")) {
			item = new PostValue();
			item.setTitle(attributes.getValue("title"));
			Log.d("TITLE",attributes.getValue("title"));
			
		}
		/*if (localName.equalsIgnoreCase("title"))
		{
			
		}*/
		if(localName.equalsIgnoreCase("condition"))
		{
			item = new PostValue();
			item.setCtext(attributes.getValue("text"));
			item.setTemp(attributes.getValue("temp"));
		}
		if(localName.equalsIgnoreCase("forecast"))
		{
			item = new PostValue();
			item.setDay(attributes.getValue("day"));
			item.setFText(attributes.getValue("text"));
			item.setHigh(attributes.getValue("high"));
			item.setLow(attributes.getValue("low"));
			
		}
				
	}
	
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {

		currTag = false;
		
		if (localName.equalsIgnoreCase("title"))
		{
			item.setTitle(currTagVal);
		}
		else if(localName.equalsIgnoreCase("condition"))
		{
			item.setCtext(currTagVal);
		}
		else if(localName.equalsIgnoreCase("condition"))
		{
			item.setTemp(currTagVal);
		}
		else if (localName.equalsIgnoreCase("forecast"))
		{
			item.setFText(currTagVal);
		}
		else if (localName.equalsIgnoreCase("forecast"))
		{
			item.setDay(currTagVal);
		}
		else if (localName.equalsIgnoreCase("forecast"))
		{
			item.setLow(currTagVal);
		}
		else if (localName.equalsIgnoreCase("forecast"))
		{
			item.setHigh(currTagVal);
		}
		else if (localName.equalsIgnoreCase("item"))
		{
			channels.add(item);
		}

	}

}
