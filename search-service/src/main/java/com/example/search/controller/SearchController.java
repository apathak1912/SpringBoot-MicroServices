package com.example.search.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class SearchController {
	@Autowired
	RestTemplate restTemplate;

	@GetMapping("/getproduct")
	List<String> getProductByRating(@RequestParam double rating) {
		Map<String,List<Integer>> map = restTemplate.getForObject("http://review-service/getrating/", Map.class);
		List<String> list = map.entrySet().stream().filter(x->
		x.getValue().stream().mapToInt(y->y).average().getAsDouble()>=rating).map(x->x.getKey()).collect(Collectors.toList());
		return list;
	}

}
