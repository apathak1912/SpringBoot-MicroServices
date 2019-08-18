package com.example.review.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReviewController {
	@GetMapping("/getrating")
	Map<String,List<Integer>> getAllReviews(){
		Map<String,List<Integer>> productReview = new HashMap<>();
		List<Integer> nikeShoeRatingList = Arrays.asList(3,3,5);
		List<Integer> woodlandShoeRatingList = Arrays.asList(3,4,5);
		List<Integer> reebokShoeRatingList = Arrays.asList(3,5,5);
		productReview.put("Nike shoe", nikeShoeRatingList);
		productReview.put("Woodland shoe", woodlandShoeRatingList);
		productReview.put("Reebok shoes", reebokShoeRatingList);
		return productReview;
	}

}
