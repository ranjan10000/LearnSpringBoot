package com.web.application.callexternalapi;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class MyController {

	private final ApiService apiService;

	@Autowired
	public MyController(ApiService apiService) {
		this.apiService = apiService;
	}

	@GetMapping("/getHttpClient")
	public String getDataFromApi() {
		try {
			return apiService.fetchDataFromApi();
		} catch (Exception e) {
			// Handle the exception
			return "Error occurred: " + e.getMessage();
		}
	}

	@GetMapping("/getRestTemplate")
	public ResponseEntity<Request> createResource() {
		RestTemplate restTemplate = new RestTemplate();
		String url = "https://reqres.in/api/users?page=2";
		ResponseEntity<Request> req = restTemplate.getForEntity(url, Request.class);

		System.out.println(req.getBody());
		return new ResponseEntity<Request>(HttpStatus.CREATED);

	}

	@PostMapping("/post")
	public void post(@RequestBody Request requestdata) throws Exception {
//		var values = new HashMap<String, String>() {
//			{
//				put("menu_name", "External api success");
//				put("menu_price","External api success");
//			}
//		};

		Map<String, String> values = new HashMap<String, String>();
		values.put("menu_id", requestdata.getMenu_id());
		values.put("menu_name", requestdata.getMenu_name());
		values.put("menu_price", requestdata.getMenu_price());

		var objectMapper = new ObjectMapper();
		String requestBody = objectMapper.writeValueAsString(values);

		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
				.header("Content-Type", "application/json")
				.uri(URI.create("http://172.16.11.109:8080/api/save"))
				.POST(HttpRequest.BodyPublishers.ofString(requestBody)).build();

		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

		System.out.println(response.body());

	}

}
