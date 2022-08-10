package com.cts.audit.severity.pojo;

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

	public AuditBenchmark() {
		super();
	}

	public AuditBenchmark(int id, String audittype, Integer accnoanswers) {
		super();
		this.id = id;
		this.audittype = audittype;
		this.accnoanswers = accnoanswers;
	}

}
