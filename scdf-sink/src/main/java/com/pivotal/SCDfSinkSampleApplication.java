package com.pivotal
		;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;

import java.util.Map;

@SpringBootApplication
@EnableBinding(Sink.class)
public class SCDfSinkSampleApplication {

	public static Logger LOG = LoggerFactory.getLogger(SCDfSinkSampleApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SCDfSinkSampleApplication.class, args);
	}

	@MessageEndpoint
	public static class SampleLoggingEndpoint {

		@ServiceActivator(inputChannel = Sink.INPUT)
		public void handleMessage(@Payload String message, @Headers Map<String, Object> headers) {
			LOG.info(message);
			for(Map.Entry e : headers.entrySet()) {
				LOG.info('\t' + e.getKey().toString()  + '=' + e.getValue());
			}
		}

	}
}
