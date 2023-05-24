package com.web.application.callexternalapi;

import java.io.File;
import java.io.FileInputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Properties;

import org.springframework.stereotype.Service;

@Service
public class ApiService {

	public String fetchDataFromApi() throws Exception {
		Properties p = new Properties();
		// for (int i = 1; i < 19; i++) {
		File file = new File("D:\\Downloads\\LearningJava\\src\\main\\resources\\url.properties");
		FileInputStream fileInputStream = new FileInputStream(file);
		System.out.println(fileInputStream);

		p.load(fileInputStream);
		HttpClient client = HttpClient.newHttpClient();

		HttpRequest request = HttpRequest.newBuilder().uri(new URI(p.getProperty("url"))).build();

		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

		if (response.statusCode() == 200) {
			return response.body();
		} else {
			throw new Exception("API request failed with status code: " + response.statusCode());
		}
		// }
	}
}
