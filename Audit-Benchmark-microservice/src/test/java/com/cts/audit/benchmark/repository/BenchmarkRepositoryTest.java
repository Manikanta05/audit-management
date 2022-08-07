package com.cts.audit.benchmark.repository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.cts.audit.benchmark.pojo.AuditBenchmark;

/*
 * @DataJpaTest only scan @Entity and spring-data-jpa repository
 * i.e only tests persistence layer and repository layer.
 */

@DataJpaTest
class BenchmarkRepositoryTest {
	@Autowired
	private BenchmarkRepsoitory benchmarkRepo;
	
	
	@Test
	public void getAllBechmark() {
		List<AuditBenchmark> details = benchmarkRepo.findAll();
		Assertions.assertThat(details.size()).isEqualTo(2);
	}
//	@Test
//	public void getBenchmarkValue() {
//		List<AuditBenchmark> details = benchmarkRepo.findAll();
//		
//		for(AuditBenchmark benchmark: details) {
//			assertEquals("Internal",benchmark.getAudittype());
//		}
//		
//		//assertEquals(new AuditBenchmark(1, "Internal", 3), details.get(0));
//		
//	}
	
	
	
	
}
