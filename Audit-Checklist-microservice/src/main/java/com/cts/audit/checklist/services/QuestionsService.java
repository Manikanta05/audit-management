package com.cts.audit.checklist.services;

import java.util.List;

import com.cts.audit.checklist.model.QuestionEntity;

public interface QuestionsService {

	List<QuestionEntity> getQuestions(String auditType);
	
}
