package com.cts.audit.severity.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Table(name = "auditresponse")
public class AuditResponseModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ResponseId")
	private int responseId;
	@Column(name = "ExecutionStatus")
	private String executionStatus;
	@Column(name = "ActionDuration")
	private String actionDuration;

	public String getExecutionStatus() {
		return executionStatus;
	}

	public void setExecutionStatus(String executionStatus) {
		this.executionStatus = executionStatus;
	}

	public String getActionDuration() {
		return actionDuration;
	}

	public void setActionDuration(String actionDuration) {
		this.actionDuration = actionDuration;
	}

	public int getResponseId() {
		return responseId;
	}

	public AuditResponseModel(String executionStatus, String actionDuration) {
		super();
		this.executionStatus = executionStatus;
		this.actionDuration = actionDuration;
	}

}
