package com.cts.audit.checklist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.cts.audit.checklist.model.QuestionEntity;
import com.cts.audit.checklist.services.QuestionsServiceImpl;

@RestController
public class CheckListController {

	@Autowired
	private QuestionsServiceImpl questionServiceImpl;
	
	@GetMapping("/health-check")
	public ResponseEntity<String> healthCheck() {
		return new ResponseEntity<>("Ok", HttpStatus.OK);
	}
	
	@GetMapping("/AuditCheckListQuestions/{audittype}")
	public ResponseEntity<List<QuestionEntity>> getQuestions(@RequestHeader(name = "Authorization") String token,@PathVariable String audittype){
		return new ResponseEntity<List<QuestionEntity>>( questionServiceImpl.getQuestions(audittype),HttpStatus.OK);
		
	}
}
