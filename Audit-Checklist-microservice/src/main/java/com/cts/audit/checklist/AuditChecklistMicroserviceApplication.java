package com.cts.audit.checklist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
@EnableFeignClients
@SpringBootApplication
public class AuditChecklistMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuditChecklistMicroserviceApplication.class, args);
	}

}
