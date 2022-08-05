package com.cts.audit.benchmark.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.audit.benchmark.pojo.AuditBenchmark;


public interface BenchmarkRepsoitory extends JpaRepository<AuditBenchmark, Integer>{
	//public List<AuditBenchmark> findAll();
}
