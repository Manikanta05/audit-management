package com.cts.audit.severity.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "auditresponse")
public class AuditResponseModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ResponseId")
	private int responseid;
	@Column(name = "ExecutionStatus")
	private String executionstatus;
	@Column(name = "ActionDuration")
	private String actionduration;

	public void setResponseid(int responseid) {
		this.responseid = responseid;
	}

	public String getExecutionstatus() {
		return executionstatus;
	}

	public void setExecutionstatus(String executionstatus) {
		this.executionstatus = executionstatus;
	}

	public String getActionduration() {
		return actionduration;
	}

	public void setActionduration(String actionduration) {
		this.actionduration = actionduration;
	}

	public AuditResponseModel() {
		super();
	}

	public AuditResponseModel(String executionstatus, String actionduration) {
		super();
		this.executionstatus = executionstatus;
		this.actionduration = actionduration;
	}

}
