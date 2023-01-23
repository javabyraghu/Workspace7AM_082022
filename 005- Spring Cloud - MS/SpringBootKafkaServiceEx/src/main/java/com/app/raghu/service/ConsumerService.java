package com.app.raghu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.app.raghu.db.MessageStore;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ConsumerService {
	
	@Autowired
	private MessageStore store;

	@KafkaListener(topics = "${my.topic.name}",groupId = "abcd")
	public void readMessage(String message) {
		log.info("MESSAGE AT CONSUMER : {}", message);
		store.add(message);
	}
}
