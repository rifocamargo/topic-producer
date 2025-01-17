package com.lecom.topicproducer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@EnableJms
@SpringBootApplication
public class TopicProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TopicProducerApplication.class, args);
	}

}
