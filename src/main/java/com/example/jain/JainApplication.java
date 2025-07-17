package com.example.jain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class JainApplication {

	Sample sample;

	@Autowired
	void setSample(Sample sample) {
		this.sample = sample;
	}
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(JainApplication.class, args);
		JainApplication app = context.getBean(JainApplication.class);
		app.sample.printMessage();
	}
}
