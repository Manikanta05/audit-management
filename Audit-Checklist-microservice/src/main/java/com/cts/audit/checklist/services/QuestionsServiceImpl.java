package com.cts.audit.checklist.services;

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
	public List<QuestionEntity> getQuestions(String auditType) throws IndexOutOfBoundsException {
		if(repo.findByAuditType(auditType).isEmpty()) {
			throw new IndexOutOfBoundsException();
		}
		return repo.findByAuditType(auditType);
	}

	@Override
	@ApiModelProperty(notes = "This function loads saves user's response to the database")
	public List<QuestionEntity> saveResponses(List<QuestionEntity> responses) {
		return repo.saveAll(responses);
	}

}
