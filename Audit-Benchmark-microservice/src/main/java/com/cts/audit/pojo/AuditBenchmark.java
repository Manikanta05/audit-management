package com.cts.audit.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
 * THis POJO deals with auditType and acceptable no of questions whose answer is No
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuditBenchmark {
	private String auditType;
	private Integer accNoAnswers;
}
