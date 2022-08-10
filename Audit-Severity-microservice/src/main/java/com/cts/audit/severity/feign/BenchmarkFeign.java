package com.cts.audit.severity.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.cts.audit.severity.pojo.AuditBenchmark;

@FeignClient(name = "benchmark-service", url = "c15-audit-benchmark-lb-49476733.ap-south-1.elb.amazonaws.com/benchmark")
public interface BenchmarkFeign {

	@GetMapping("/AuditBenchmark")
	public List<AuditBenchmark> getBenchmarkMap();
}
