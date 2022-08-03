package com.cts.audit.severity.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "auditdetail")
public class AuditDetailModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "AuditId")
	private int auditId;
	@Column(name = "AuditType")
	private String auditType;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "AuditDate")
	private Date auditDate;
	@OneToOne(mappedBy = "auditdetail")
	private AuditRequestModel auditrequest;

	@PrePersist
	protected void onCreate() {
		auditDate = new Date();
	}

	public int getAuditId() {
		return auditId;
	}

	public String getAuditType() {
		return auditType;
	}

	public void setAuditType(String auditType) {
		this.auditType = auditType;
	}

	public Date getAuditDate() {
		return auditDate;
	}

	public void setAuditDate(Date auditDate) {
		this.auditDate = auditDate;
	}

}
