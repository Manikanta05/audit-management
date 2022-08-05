package com.cts.audit.checklist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.cts.audit.checklist.exceptions.TokenExpiredException;
import com.cts.audit.checklist.feign.AuthenticationFeign;
import com.cts.audit.checklist.model.QuestionEntity;
import com.cts.audit.checklist.services.QuestionsServiceImpl;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CheckListController {

	@Autowired
	private QuestionsServiceImpl questionServiceImpl;
	@Autowired
	private AuthenticationFeign authFeign;
	
	@GetMapping("/health-check")
	public ResponseEntity<String> healthCheck() {
		return new ResponseEntity<>("Ok", HttpStatus.OK);
	}
	
	@GetMapping("/AuditCheckListQuestions/{audittype}")
	public ResponseEntity<List<String>> getQuestions(@RequestHeader(value="Authorization") String token,@PathVariable String audittype){
		ResponseEntity<Boolean> validate = authFeign.validate(token);
		if(validate.getBody())
		return new ResponseEntity<>(questionServiceImpl.getQuestions(audittype),HttpStatus.OK);
		else
			throw new TokenExpiredException("Token is expired or Invalid token, please login again!");
		
	}
}
