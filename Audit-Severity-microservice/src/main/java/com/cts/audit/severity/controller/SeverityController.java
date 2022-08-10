package com.cts.audit.severity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.audit.severity.exceptions.TokenNotValidException;
import com.cts.audit.severity.feign.AuthenticationFeign;
import com.cts.audit.severity.model.AuditRequestModel;
import com.cts.audit.severity.model.AuditResponseModel;
import com.cts.audit.severity.services.SeverityService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/severity")
public class SeverityController {
	@Autowired
	private AuthenticationFeign authFeign;
	@Autowired
	private SeverityService severityService;

	@PostMapping("/ProjectExecutionStatus")
	public AuditResponseModel projectExecution(@RequestHeader(name = "Authorization") String token,
			@RequestBody AuditRequestModel request) {

		Boolean validate = authFeign.validate(token);

		if (validate) {
			return severityService.checkSeverity(request);
		} else
			throw new TokenNotValidException("Invalid Token!");
	}
}
