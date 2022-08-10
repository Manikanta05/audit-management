package com.cts.audit.checklist.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;

import com.cts.audit.checklist.exceptions.TokenExpiredException;
import com.cts.audit.checklist.feign.AuthenticationFeign;
import com.cts.audit.checklist.pojo.AuditType;
import com.cts.audit.checklist.repository.QuestionsRepository;
import com.cts.audit.checklist.services.QuestionsServiceImpl;


@ContextConfiguration
@SpringBootTest
public class CheckListControllerTest {

	@Mock
	AuthenticationFeign authClient;

	@Mock
	AuditType auditType;

	@Mock
	QuestionsServiceImpl questionsService;

	@Mock
	Environment env;

	@InjectMocks
	CheckListController auditCheckListController;

	@Mock
	QuestionsRepository questionsRepository;

	@Mock
	TokenExpiredException tokenexp;

	@Test
	public void contextLoads() {
		assertNotNull(auditCheckListController);
	}

	/**
	 * To test testGetCheckList method
	 */
	@Test
	public void testGetQuestions() {
		ResponseEntity<?> responseEntity = null;
		ResponseEntity<Boolean> valid = new ResponseEntity<Boolean>(true, HttpStatus.OK);
		List<String> questionsList = new ArrayList<String>();
		questionsList.add("How are you");
		when(authClient.validate("token")).thenReturn(valid);
		when(questionsService.getQuestions("Internal")).thenReturn(questionsList);
		responseEntity = auditCheckListController.getQuestions("token", "Internal");
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		//log.info(responseEntity.getBody().toString());
		assertEquals("[How are you]", responseEntity.getBody().toString());

	}

	@Test
	public void testGetQuestionsTokenInvalid() {
		Exception exception = assertThrows(TokenExpiredException.class, () -> {
			ResponseEntity<Boolean> valid = new ResponseEntity<Boolean>(false, HttpStatus.BAD_REQUEST);
			List<String> questionsList = new ArrayList<String>();
			questionsList.add("How are you");
			when(authClient.validate("token")).thenReturn(valid);
			when(questionsService.getQuestions("Internal")).thenReturn(questionsList);
			auditCheckListController.getQuestions("token", "Internal");
		});

		String expectedMessage = "Token is expired or Invalid token, please login again!";
		String actualMessage = exception.getMessage();

		assertTrue(actualMessage.contains(expectedMessage));

	}
}
