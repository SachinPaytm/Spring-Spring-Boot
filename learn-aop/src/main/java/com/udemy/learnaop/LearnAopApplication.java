package com.udemy.learnaop;

import com.udemy.learnaop.business.BusinessService1;
import com.udemy.learnaop.business.BusinessService2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LearnAopApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(getClass());

	private BusinessService1 businessService1;
	private BusinessService2 businessService2;

	public LearnAopApplication(BusinessService2 businessService2
			,BusinessService1 businessService1
	)
	{
		this.businessService2 = businessService2;
		this.businessService1 = businessService1;
	}

	public static void main(String[] args) {
		SpringApplication.run(LearnAopApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("DataService1	: {}",businessService1);
		logger.info("DataService2	: {}",businessService2);
	}
}
