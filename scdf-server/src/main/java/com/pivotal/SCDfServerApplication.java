package com.pivotal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.dataflow.server.EnableDataFlowServer;

@SpringBootApplication
@EnableDataFlowServer
public class SCDfServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SCDfServerApplication.class, args);
	}
}
