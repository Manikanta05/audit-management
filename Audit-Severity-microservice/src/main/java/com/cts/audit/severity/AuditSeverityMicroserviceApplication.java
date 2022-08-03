package com.cts.audit.severity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages= {"com.cts.audit.severity.repository"})
@EntityScan(basePackages={"com.cts.audit.severity.model"})
@SpringBootApplication
public class AuditSeverityMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuditSeverityMicroserviceApplication.class, args);
	}

}
