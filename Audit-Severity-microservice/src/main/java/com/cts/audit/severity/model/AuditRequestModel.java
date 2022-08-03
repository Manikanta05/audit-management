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

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "auditrequest")
public class AuditRequestModel {
	@Id
	@Column(name = "RequestId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int requestId;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "AuditDetail", referencedColumnName = "AuditId")
	private AuditDetailModel auditDetail;
	@Column(name = "ProjectName")
	private String projectName;
	@Column(name = "ManagerName")
	private String managerName;
	@Column(name = "OwnerName")
	private String ownerName;

	public AuditDetailModel getAuditDetail() {
		return auditDetail;
	}

	public void setAuditDetail(AuditDetailModel auditDetail) {
		this.auditDetail = auditDetail;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public int getRequestId() {
		return requestId;
	}
}
