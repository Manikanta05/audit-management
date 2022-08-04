package com.cts.audit.severity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.cts.audit.severity.exceptions.TokenNotValidException;
import com.cts.audit.severity.feign.AuthenticationFeign;
import com.cts.audit.severity.model.AuditRequestModel;
import com.cts.audit.severity.model.AuditResponseModel;
import com.cts.audit.severity.services.SeverityService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@CrossOrigin(origins = "http://localhost:4200")
public class SeverityController {
	@Autowired
	private AuthenticationFeign authFeign;
	@Autowired
	private SeverityService severityService;

	@PostMapping("/ProjectExecutionStatus")
	public AuditResponseModel projectExecution(@RequestHeader(name = "Authorization") String token,
			@RequestBody AuditRequestModel request) {
		log.info("before validation-----------------------------------");
		ResponseEntity<Boolean> validate = authFeign.validate(token);
		log.info("after validation------------------------------------");
		if (validate.getBody()) {
			log.info("validation successful-----------------------");
			return severityService.checkSeverity(request);
		} else
			throw new TokenNotValidException("Invalid Token!");
	}
}
