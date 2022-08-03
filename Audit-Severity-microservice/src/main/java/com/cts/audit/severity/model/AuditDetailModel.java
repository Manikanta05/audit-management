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
	private int auditid;
	@Column(name = "AuditType")
	private String audittype;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "AuditDate")
	private Date auditdate;
	@OneToOne(mappedBy = "auditdetail")
	private AuditRequestModel auditrequest;

	public int getAuditid() {
		return auditid;
	}

	public String getAudittype() {
		return audittype;
	}

	public void setAudittype(String audittype) {
		this.audittype = audittype;
	}

	public Date getAuditdate() {
		return auditdate;
	}

	@PrePersist
	public void setAuditdate() {
		this.auditdate = new Date();
	}

}