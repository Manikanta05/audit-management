package com.cts.audit.checklist.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.cts.audit.checklist.model.QuestionEntity;
import com.cts.audit.checklist.repository.QuestionsRepository;
import com.cts.audit.checklist.services.QuestionsServiceImpl;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "This Class is used to test Question Service")
@SpringBootTest
public class QuestionServiceImplTest {

	@Mock
	QuestionsRepository questionsrepo;
	
	@InjectMocks
	QuestionsServiceImpl questionservice;
	
	@Test
	@ApiModelProperty(notes = "This method is used to test getQuestions()")
	public void getQuestionsTest() {
		List<QuestionEntity> questions = new ArrayList<>();
		questions.add(new QuestionEntity(1,"Internal","Have all Change requests followed SDLC before PROD move?"));
		when(questionsrepo.findByAudittype("Internal")).thenReturn(questions);
		List<String> answer=new ArrayList<>();
		answer.add(questions.get(0).getQuestion());
		assertEquals(answer,questionservice.getQuestions("Internal"));
	}
}
