package com.cts.audit.benchmark.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import com.cts.audit.benchmark.pojo.AuditBenchmark;
import com.cts.audit.benchmark.repository.BenchmarkRepsoitory;
import com.cts.audit.benchmark.service.BenchmarkService;


@SpringBootTest
class BenchmarkControllerTest {

	/*
	 * @Mock is used to create mocks that are needed to support the testing of the class to be tested. 
	 * @InjectMocks is used to create class instances that need to be tested in the test class.
	 */
	@Mock
	BenchmarkRepsoitory benchmarkRepo;
	@Mock
	BenchmarkService benchmarkService;
	@Mock
	AuditBenchmark auditBenchmark;
	@InjectMocks
	BenchmarkController benchmarkController;
	
	@Test
	public void testGetBenchmark() {
		List<AuditBenchmark> benchmark = new ArrayList<>();
		benchmark.add(new AuditBenchmark(1, "Internal", 3));
		benchmark.add(new AuditBenchmark(2, "SOX", 1));
		assertEquals(HttpStatus.OK, benchmarkController.getBenchmarkMap().getStatusCode());
		//assertEquals(benchmark, benchmarkController.getBenchmarkMap().getBody());
	}
}
