package com.burntcity.jms.sender;

import java.util.UUID;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.burntcity.jms.config.JmsConfig;
import com.burntcity.jms.model.HelloWorldMessage;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor  // Lombok will create a constructor for the required args.
public class HelloSender {
	
	private final JmsTemplate JmsTemplate;

	@Scheduled(fixedRate = 2000) // every 2 seconds
	public void sendMessage() {
		
		System.out.println("I'm sending a message");
		
		HelloWorldMessage message = HelloWorldMessage
				.builder()
				.id(UUID.randomUUID())
				.message("Hello World!")
				.build();
		
		JmsTemplate.convertAndSend(JmsConfig.MY_QUEUE, message);
		
		System.out.println("Message sent!");
	}
}
