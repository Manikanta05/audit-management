package com.cts.audit.benchmark.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import com.cts.audit.benchmark.pojo.AuditBenchmark;

public class AuditBenchmarkTest {
	
	@Mock
	private AuditBenchmark benchmark;
	
	@BeforeEach
	public void setUp() {
		benchmark = new AuditBenchmark(1, "Internal", 3);
	}
	
	@Test
	public void testGetAudittype() {
		//AuditBenchmark benchmark = new AuditBenchmark(1, "Internal", 3);
		assertEquals("Internal", benchmark.getAudittype());
//		benchmark.setAudittype("SOX");
//		assertEquals("SOX", benchmark.getAudittype());
	}
	
	@Test
	public void testSetAuditType() {
		benchmark.setAudittype("SOX");
		assertEquals("SOX", benchmark.getAudittype());
	}
	@Test
	public void testGetAccNoAnswers() {
		assertEquals(3, benchmark.getAccnoanswers());
	}
	@Test
	public void testSetAccNoAnswers() {
		benchmark.setAccnoanswers(1);
		assertEquals(1, benchmark.getAccnoanswers());
	}
}
