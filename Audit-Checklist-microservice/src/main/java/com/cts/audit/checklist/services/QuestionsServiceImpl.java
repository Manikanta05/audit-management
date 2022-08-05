package com.cts.audit.checklist.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.audit.checklist.model.QuestionEntity;
import com.cts.audit.checklist.repository.QuestionsRepository;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@Service
@ApiModel(value="This class load questions from database based on audit type otherwise return exception ")
public class QuestionsServiceImpl implements QuestionsService {

	@Autowired
	private QuestionsRepository repo;
	@Override
	@ApiModelProperty(notes = "This function loads question from database based on audit type ")
	public List<String> getQuestions(String auditType)  {
		List<QuestionEntity> list = repo.findByAudittype(auditType);
		List<String> questions=new ArrayList<>();
		for(QuestionEntity question:list) {
			questions.add(question.getQuestion());
		}
		return questions;
	}

	

}
