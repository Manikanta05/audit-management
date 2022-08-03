package com.cts.audit.benchmark.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import com.cts.audit.benchmark.pojo.AuditBenchmark;

/*
 * The end point "/AuditBenchmark" returns List of AuditBenchmark
 */
public class BenchmarkController {
	@GetMapping("/AuditBenchmark")
	public ResponseEntity<?> getBenchmarkMap(){
		List<AuditBenchmark> auditBenchmarkList = new ArrayList<AuditBenchmark>();
		
		ResponseEntity<?> responseEntity = null;
		
		auditBenchmarkList.add(new AuditBenchmark("Internal", 3));
		auditBenchmarkList.add(new AuditBenchmark("SOX", 1));
		
		/*
		 * Creates a new ResponseEntity with given body and status code 
		 * Parameters : body and status code
		 */
		responseEntity = new ResponseEntity<List<AuditBenchmark>>(auditBenchmarkList, HttpStatus.OK);
		
		return responseEntity;
		
	}
}
