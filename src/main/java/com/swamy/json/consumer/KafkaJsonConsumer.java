package com.swamy.json.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.swamy.model.User;

@Service
public class KafkaJsonConsumer {
	
	private static final Logger LOG = LoggerFactory.getLogger(KafkaJsonConsumer.class);

	@KafkaListener(topics = "kafka_json" , groupId = "latestGroup")
	public void consume(User user) {
		LOG.info(String.format("JSON Data Received -> %s", user.toString()));
	}
}
