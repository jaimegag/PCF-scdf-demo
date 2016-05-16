package com.pivotal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@SpringBootApplication
@RestController
@EnableBinding(Source.class)
public class SCDfSourceSampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SCDfSourceSampleApplication.class, args);
	}

	protected final Logger LOG = LoggerFactory.getLogger(SCDfSourceSampleApplication.class);

	@Autowired
	private Source channels;

	@RequestMapping("/event")
	public String event(String msg) {
		process(msg);  //invoke data microservice stream
		return "event[" + msg + "] placed on streaming bus";
	}

	private void process(String event) {
		LOG.info("processed message");
		channels.output().send(MessageBuilder.createMessage(
				event,
				new MessageHeaders(Collections.singletonMap("Header1", "Sent from data microservice")))
		);
		return;
	}
}
