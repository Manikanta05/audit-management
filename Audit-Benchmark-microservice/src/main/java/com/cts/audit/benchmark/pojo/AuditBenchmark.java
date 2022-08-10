package com.cts.audit.benchmark.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * THis POJO deals with auditType and acceptable no of questions whose answer is No
 */

@Entity
@Table(name="auditbenchmark")
public class AuditBenchmark {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;	
	@Column
	private String audittype;
	@Column
	private Integer accnoanswers;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
