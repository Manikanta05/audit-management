package com.cts.audit.severity.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.audit.severity.model.AuditRequestModel;
import com.cts.audit.severity.model.AuditResponseModel;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class SeverityController {
	@PostMapping("/ProjectExecutionStatus")
	public AuditResponseModel projectExecution(AuditRequestModel request) {
		return null;
	}
}
