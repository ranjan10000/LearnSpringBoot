package com.web.application.callexternalapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

	@Autowired
	private ApiService apiService;

	@GetMapping("/postCallExternalApi")
	public String getDataFromApi() {
		try {

			String getAllUsers = apiService.getDataFromApi();

			return getAllUsers;

		} catch (Exception e) {
			// Handle the exception
			return "Error occurred: " + e.getMessage();
		}
	}

	@PostMapping("/postCallExternalApi")
	public String postCallExternalApi(@RequestBody Request requestdata) throws Exception {

		return apiService.fetchDataFromApi(requestdata);

//		var values = new HashMap<String, String>() {
//			{
//				put("menu_name", "External api success");
//				put("menu_price","External api success");
//			}
//		};

	}

//	@GetMapping("/getRestTemplate")
//	public ResponseEntity<Request> createResource() {
//		RestTemplate restTemplate = new RestTemplate();
//		String url = "https://reqres.in/api/users?page=2";
//		ResponseEntity<Request> req = restTemplate.getForEntity(url, Request.class);
//
//		System.out.println(req.getBody());
//		return new ResponseEntity<Request>(HttpStatus.CREATED);
//
//	}

}
