package com.cts.audit.benchmark.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.audit.benchmark.pojo.AuditBenchmark;
import com.cts.audit.benchmark.repository.BenchmarkRepsoitory;

@Service
public class BenchmarkServiceImpl implements BenchmarkService{
	@Autowired
	private BenchmarkRepsoitory repo;
	public List<AuditBenchmark> getAllBenchmark(){
		return repo.findAll();
	}
}
