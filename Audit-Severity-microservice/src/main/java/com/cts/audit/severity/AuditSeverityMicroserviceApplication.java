package com.cts.audit.severity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class AuditSeverityMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuditSeverityMicroserviceApplication.class, args);
	}

}
