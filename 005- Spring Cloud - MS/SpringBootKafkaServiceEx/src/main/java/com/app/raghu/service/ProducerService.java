package com.app.raghu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ProducerService {

	@Autowired
	private KafkaTemplate<String, String> template;
	
	@Value("${my.topic.name}")
	private String topicName;
	
	public void sendMessage(String message) {
		log.info("MESSAGE IS AT PRODUCER SERVICE");
		template.send(topicName, message);
	}
}
