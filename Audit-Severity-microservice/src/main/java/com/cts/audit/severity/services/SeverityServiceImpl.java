package com.cts.audit.severity.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.audit.severity.feign.BenchmarkFeign;
import com.cts.audit.severity.model.AuditRequestModel;
import com.cts.audit.severity.model.AuditResponseModel;
import com.cts.audit.severity.pojo.AuditBenchmark;
import com.cts.audit.severity.repository.ResponseRepository;

@Service
public class SeverityServiceImpl implements SeverityService {
	@Autowired
	private ResponseRepository repo;
	@Autowired
	private BenchmarkFeign benchmarkfeign;

	@Override
	public AuditResponseModel checkSeverity(AuditRequestModel request) {
		int count = request.getAuditdetail().getCountofno();
		AuditResponseModel response;
		List<AuditBenchmark> benchmarkMap = benchmarkfeign.getBenchmarkMap();
		String auditType = request.getAuditdetail().getAudittype();
		int threshold;
		if (auditType.equalsIgnoreCase("Internal")) {
			threshold = benchmarkMap.get(0).getAccnoanswers();
			if (count > threshold) {
				response = new AuditResponseModel("RED", "Action to be taken in 2 weeks");
			} else {
				response = new AuditResponseModel("GREEN", "No action needed");
			}
			repo.save(response);
		} else {
			threshold = benchmarkMap.get(1).getAccnoanswers();
			if (count > threshold) {
				response = new AuditResponseModel("RED", "Action to be taken in 1 weeks");
			} else {
				response = new AuditResponseModel("GREEN", "No action needed");
			}
			repo.save(response);
		}
		return response;
	}

}
