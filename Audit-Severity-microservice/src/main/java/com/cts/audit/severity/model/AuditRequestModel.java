package com.cts.audit.severity.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "auditrequest")
public class AuditRequestModel {

	@Id
	@Column(name = "RequestId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int requestid;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "AuditDetail", referencedColumnName = "AuditId")
	private AuditDetailModel auditdetail;
	@Column(name = "ProjectName")
	private String projectname;
	@Column(name = "ManagerName")
	private String managername;
	@Column(name = "OwnerName")
	private String ownername;

	public int getRequestid() {
		return requestid;
	}

	public AuditDetailModel getAuditdetail() {
		return auditdetail;
	}

	public void setAuditdetail(AuditDetailModel auditdetail) {
		this.auditdetail = auditdetail;
	}

	public String getProjectname() {
		return projectname;
	}

	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}

	public String getManagername() {
		return managername;
	}

	public void setManagername(String managername) {
		this.managername = managername;
	}

	public String getOwnername() {
		return ownername;
	}

	public void setOwnername(String ownername) {
		this.ownername = ownername;
	}

	@Override
	public String toString() {
		return "AuditRequestModel [requestid=" + requestid + ", auditdetail=" + auditdetail + ", projectname="
				+ projectname + ", managername=" + managername + ", ownername=" + ownername + "]";
	}

	public AuditRequestModel() {
		super();
	}

	public AuditRequestModel(int requestid, AuditDetailModel auditdetail, String projectname, String managername,
			String ownername) {
		super();
		this.requestid = requestid;
		this.auditdetail = auditdetail;
		this.projectname = projectname;
		this.managername = managername;
		this.ownername = ownername;
	}

}
