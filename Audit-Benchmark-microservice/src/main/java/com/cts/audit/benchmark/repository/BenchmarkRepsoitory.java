package com.cts.audit.benchmark.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.audit.benchmark.pojo.AuditBenchmark;
import com.cts.audit.benchmark.pojo.AuditType;

@Repository
public interface BenchmarkRepsoitory extends JpaRepository<AuditBenchmark, Integer>{
	//public List<AuditBenchmark> findAll();
}
