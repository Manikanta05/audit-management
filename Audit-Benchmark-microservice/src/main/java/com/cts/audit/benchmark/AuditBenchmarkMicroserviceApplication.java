package com.cts.audit.benchmark;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

//@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
@SpringBootApplication
public class AuditBenchmarkMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuditBenchmarkMicroserviceApplication.class, args);
	}

}
