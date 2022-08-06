package com.cts.audit.checklist.services;

import java.util.List;

public interface QuestionsService {

	List<String> getQuestions(String auditType);
	
}
