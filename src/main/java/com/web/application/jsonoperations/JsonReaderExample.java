package com.web.application.jsonoperations;

import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonReaderExample {

	public static void main(String[] args) throws IOException, ParseException {

		JSONParser jsonParser = new JSONParser();

		FileReader fileReader = new FileReader("JsonWriter.json");

		Object parsedobj = jsonParser.parse(fileReader);
		JSONObject jsonObj = (JSONObject) parsedobj;
		String name = (String) jsonObj.get("Name");
		System.out.println(name);
		String role = (String) jsonObj.get("Role");
		System.out.println(role);
		JSONArray array = (JSONArray) jsonObj.get("hobby");
		Iterator iterator = array.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}

	}

}
