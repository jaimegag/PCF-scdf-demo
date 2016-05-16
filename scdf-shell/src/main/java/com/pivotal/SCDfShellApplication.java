package com.pivotal;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.dataflow.shell.EnableDataFlowShell;

@SpringBootApplication
@EnableDataFlowShell
public class SCDfShellApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(SCDfShellApplication.class)
				.bannerMode(Banner.Mode.OFF)
				.run(args);
	}
}
