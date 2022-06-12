package com.swamy.json.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.swamy.model.User;

@Service
public class JsonKafkaProducer {

	private static final Logger LOG = LoggerFactory.getLogger(JsonKafkaProducer.class);
	
	@Autowired
	private KafkaTemplate<String, User>kafkaTemplate;

	public void sendMessage(User data) {
		LOG.info(String.format("Message Sent -> %s",  data.toString()));
		Message<User> message = MessageBuilder.withPayload(data)
				.setHeader(KafkaHeaders.TOPIC, "kafka_json")
				.build();

		kafkaTemplate.send(message);
	}
}

