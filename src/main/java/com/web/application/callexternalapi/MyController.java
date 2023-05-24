package com.web.application.callexternalapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

	private final ApiService apiService;

	@Autowired
	public MyController(ApiService apiService) {
		this.apiService = apiService;
	}

	@GetMapping("/menu")
	public String getDataFromApi() {
		try {
			return apiService.fetchDataFromApi();
		} catch (Exception e) {
			// Handle the exception
			return "Error occurred: " + e.getMessage();
		}
	}


	@PostMapping("/save")
		public ResponseEntity<String> createResource(@RequestBody String payload) {
			return new ResponseEntity<>("Resource created successfully", HttpStatus.CREATED);
			}
	}
	

