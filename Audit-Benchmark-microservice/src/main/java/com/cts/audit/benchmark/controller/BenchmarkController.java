package com.cts.audit.benchmark.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.audit.benchmark.pojo.AuditBenchmark;
import com.cts.audit.benchmark.service.BenchmarkService;

/*
 * The end point "/AuditBenchmark" returns List of AuditBenchmark
 */
@RestController
@CrossOrigin(origins = "*")
public class BenchmarkController {
	@Autowired
	private BenchmarkService auditService;

	@GetMapping("/benchmark/AuditBenchmark")
	public ResponseEntity<List<AuditBenchmark>> getBenchmarkMap(){
		//List<AuditBenchmark> auditBenchmarkList = new ArrayList<AuditBenchmark>();
		
//		ResponseEntity<?> responseEntity = null;
//		
//		auditBenchmarkList.add(new AuditBenchmark("Internal", 3));
//		auditBenchmarkList.add(new AuditBenchmark("SOX", 1));
		
		/*
		 * Creates a new ResponseEntity with given body and status code 
		 * Parameters : body and status code
		 */
		//responseEntity = new ResponseEntity<List<AuditBenchmark>>(auditBenchmarkList, HttpStatus.OK);
		
		return new ResponseEntity<List<AuditBenchmark>>(auditService.getAllBenchmark(), HttpStatus.OK);
		
	}
}
