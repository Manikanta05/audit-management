package com.cts.audit.severity.services;

import com.cts.audit.severity.model.AuditRequestModel;
import com.cts.audit.severity.model.AuditResponseModel;

public interface SeverityService {
	public AuditResponseModel checkSeverity(AuditRequestModel request);
}
