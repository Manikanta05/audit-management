package com.cts.audit.checklist.pojo;

public class AuditType {
	
	//This pojo class is used to store the audit type
	private String auditType;
	
	public String getAuditType() {
		return this.auditType;
	}
	
	public void setAuditType(String auditType) {
		this.auditType=auditType;
	}

	public AuditType() {
		super();
	}

	public AuditType(String auditType) {
		super();
		this.auditType = auditType;
	}

	@Override
	public String toString() {
		return "AuditType [auditType=" + auditType + "]";
	}

}
