package com.cts.audit.severity.pojo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@SpringBootTest
@ApiModel(description = "This class is used to test AuditBenchmark Pojo class")
public class AuditBenchmarkTest {

	
	AuditBenchmark auditBenchMark=new AuditBenchmark();
	
	@Test
	@ApiModelProperty(notes = "This method is used to test All argument constructor")
	public void auditBenchMarkCredentialsAllConstructorTest() {
		auditBenchMark = new AuditBenchmark(1,"Internal",3);
		assertEquals("Internal", auditBenchMark.getAudittype());
	}

	@Test
	@ApiModelProperty(notes = "This method is used to test Getters")
	public void gettersTest() {
		auditBenchMark.setAccnoanswers(3);
		assertEquals(3, auditBenchMark.getAccnoanswers());
	}

	@Test
	@ApiModelProperty(notes = "This method is used to test Setters")
	public void settersTest() {
		auditBenchMark.setAudittype("Internal");
		assertEquals("Internal", auditBenchMark.getAudittype());
	}

	@Test
	@ApiModelProperty(notes = "This method is used to test toString()")
	public void toStringTest() {
		String string = auditBenchMark.toString();
		assertEquals(string, auditBenchMark.toString());
	}

	@Test
	@ApiModelProperty(notes = "This method is used to test equal method")
	public void testEqualsMethod() {
		boolean equals = auditBenchMark.equals(auditBenchMark);
		assertTrue(equals);
	}

	@Test
	@ApiModelProperty(notes = "This method is used to test hash code method")
	public void testHashCodeMethod() {
		int hashCode = auditBenchMark.hashCode();
		assertEquals(hashCode, auditBenchMark.hashCode());
	}
}
