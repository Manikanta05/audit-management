package com.cts.audit.checklist.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

//@Data

@Entity
@Table(name="auditquestion")
@ApiModel(value="This is a question entity model")
public class QuestionEntity {

	public QuestionEntity() {
		super();
	}

	public QuestionEntity(Integer questionid, String audittype, String question) {
		super();
		this.questionid = questionid;
		this.audittype = audittype;
		this.question = question;
	}

	@ApiModelProperty(notes = "Variable questionId acts as an id for questions") 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer questionid;
	
	@ApiModelProperty(notes = "Variable auditType stores the type of audit")
	@Column
	private String audittype;
	
	@ApiModelProperty(notes="Variable questions stores a questions based on audit type")
	@Column
	private String question;

	@Override
	public String toString() {
		return "QuestionEntity [questionid=" + questionid + ", audittype=" + audittype + ", question=" + question + "]";
	}

	public Integer getQuestionid() {
		return questionid;
	}

	public void setQuestionid(Integer questionid) {
		this.questionid = questionid;
	}

	public String getAudittype() {
		return audittype;
	}

	public void setAudittype(String audittype) {
		this.audittype = audittype;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}
	
	/*@ApiModelProperty(notes="Variable responses stores the user response of the question")
	@Column
	private String response;
	*/
}
