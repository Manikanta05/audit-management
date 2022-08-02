package com.cts.audit.checklist.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.audit.checklist.model.QuestionEntity;

public interface QuestionsRepository extends JpaRepository<QuestionEntity, Integer> {
	List <QuestionEntity> findByAuditType(String i);

}
