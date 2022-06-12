package com.swamy.json.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swamy.json.producer.JsonKafkaProducer;
import com.swamy.model.User;

@RestController
@RequestMapping("/kafka/json")
public class JsonMessageRestController {

	@Autowired
	private JsonKafkaProducer kafkaProducer;
	
	@PostMapping("/publish")
	public ResponseEntity<String>publish(@RequestBody User user){
		kafkaProducer.sendMessage(user);
		return ResponseEntity.ok("Json Message Sent to Kafka Topic");
	}//		http://localhost:9090/kafka/json/publish
}









