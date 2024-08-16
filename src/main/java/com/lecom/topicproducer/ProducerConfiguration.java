package com.lecom.topicproducer;

import java.util.Arrays;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.boot.autoconfigure.jms.activemq.ActiveMQProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.core.JmsTemplate;

@Configuration
@EnableConfigurationProperties(ActiveMQProperties.class)
public class ProducerConfiguration {
	@Bean
	public ActiveMQConnectionFactory senderActiveMQConnectionFactory(ActiveMQProperties activeMQProperties) {
		final ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(activeMQProperties.getBrokerUrl());
		activeMQConnectionFactory.setTrustedPackages(Arrays.asList("com.lecom"));
		return activeMQConnectionFactory;
	}

	@Bean
	public CachingConnectionFactory cachingConnectionFactory(ActiveMQConnectionFactory senderActiveMQConnectionFactory) {
		return new CachingConnectionFactory(senderActiveMQConnectionFactory);
	}

	@Bean
	public JmsTemplate jmsTemplate(CachingConnectionFactory cachingConnectionFactory) {
		final JmsTemplate jmsTemplate = new JmsTemplate(cachingConnectionFactory);
		jmsTemplate.setPubSubDomain(true);
		return jmsTemplate;
	}
}
