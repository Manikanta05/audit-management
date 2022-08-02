package com.cts.audit.checklist.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="AuditQuestions")
public class QuestionEntity {

	//Variable questionId acts as an id for questions
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer questionId;
	
	//Variable auditType stores the type of audit 
	@Column
	private String auditType;
	
	//Variable questions stores a list of questions based on auditType
	@Column
	private String questions;
	
	//Variable responses stores the user response of the question
	@Column
	private String responses;
	
}
