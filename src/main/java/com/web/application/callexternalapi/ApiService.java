package com.web.application.callexternalapi;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.http.protocol.HttpRequestExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.core.JsonProcessingException;

@Service
public class ApiService {

	@Autowired
	private ReadPropertyFile readPropertyFile;

	public String getDataFromApi() throws Exception {

		String getApiUrl = readPropertyFile.loadWidgetScriptName("getCallExternalApi" + ".url");
		HttpClient client = HttpClient.newHttpClient();

		HttpRequest request = HttpRequest.newBuilder().uri(new URI(getApiUrl)).build();

		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

		if (response.statusCode() == 200) {
			return response.body();
		} else {
			throw new Exception("API request failed with status code: " + response.statusCode());
		}

	}

	public String fetchDataFromApi(Request requestdata) {

		String postUrl = readPropertyFile.loadWidgetScriptName("postCallExternalApi" + ".url");
		String methodType = readPropertyFile.loadWidgetScriptName("postCallExternalApi"+".method");
		// String postMethod =
		// readPropertyFile.loadWidgetScriptName("postCallExternalApi" + ".method");
		System.out.println(postUrl);
		String requestBody = null;
		if (requestdata != null) {
			Map<String, String> values = new HashMap<String, String>();
			values.put("menu_id", requestdata.getMenu_id());
			values.put("menu_name", requestdata.getMenu_name());
			values.put("menu_price", requestdata.getMenu_price());

			var objectMapper = new ObjectMapper();

			try {

				requestBody = objectMapper.writeValueAsString(values);

			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			new GlobalExceptionHandler();
		}

		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
				.header("Content-Type", "application/json")
				.uri(URI.create(postUrl))
				.POST(HttpRequest.BodyPublishers.ofString(requestBody)).build();

		HttpResponse<String> response = null;
		try {
			response = client.send(request, HttpResponse.BodyHandlers.ofString());
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return response.body();

	}
}
