package com.cts.audit.severity.pojo;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class AuditBenchmark {
	private int id;

	private String audittype;

	private Integer accnoanswers;

	public String getAudittype() {
		return audittype;
	}

	public void setAudittype(String audittype) {
		this.audittype = audittype;
	}

	public Integer getAccnoanswers() {
		return accnoanswers;
	}

	public void setAccnoanswers(Integer accnoanswers) {
		this.accnoanswers = accnoanswers;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
