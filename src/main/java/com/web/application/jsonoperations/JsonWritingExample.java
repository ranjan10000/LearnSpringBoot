package com.web.application.jsonoperations;

import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JsonWritingExample {

	public static void main(String[] args) throws IOException {
		// add json simple dependency
		// other json dependency - GSON or Jackson
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("Name", "Ranjith Kumar");
		jsonObject.put("Role", "SoftWare Engineer");

		// ["cricket",kabaddi]

		JSONArray array = new JSONArray();
		array.add("cricket");
		array.add("kabaddi");

		jsonObject.put("hobby", array);

		FileWriter fileWriter = new FileWriter("JsonWriter.json");
		fileWriter.write(jsonObject.toJSONString());
		fileWriter.close();

	}
}
