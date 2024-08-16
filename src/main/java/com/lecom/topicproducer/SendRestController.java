package com.lecom.topicproducer;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SendRestController {

	@Autowired
	private Producer producer;

	@PostMapping("/send")
	@ResponseStatus(code = HttpStatus.OK)
	public void sendMessage() {
		new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 750_000; i++) {
					producer.send(Map.of("teste", "teste" + i));
				}
			}
		}).start();
	}
}
