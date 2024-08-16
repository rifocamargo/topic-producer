package com.lecom.topicproducer;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class Producer {
	private static final Logger LOGGER = LoggerFactory.getLogger(Producer.class);

	@Autowired
	private JmsTemplate jmsTemplate;

	@Autowired
	private TopicProducerProperties topicProducerProperties;

	public void send(Map<Object, String> message) {
		LOGGER.info("sending message='{}' to destination='{}'", message, topicProducerProperties.getTopic());
		jmsTemplate.convertAndSend(topicProducerProperties.getTopic(), message);
	}
}
