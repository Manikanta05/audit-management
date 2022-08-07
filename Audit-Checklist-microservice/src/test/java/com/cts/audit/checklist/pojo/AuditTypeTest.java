package com.cts.audit.checklist.pojo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(description = "This Class is used to test AuditType Pojo class")
@SpringBootTest
public class AuditTypeTest {
	AuditType audittype=new AuditType();
	
	@Test
	@ApiModelProperty(notes = "This method is used to test all argument constructor")
	public void allArgumentConstructorTest() {
		assertNotNull(audittype);
	}

	@Test
	@ApiModelProperty(notes = "This method is used to test parameterized constructor")
	public void testQuestionsEntityParameterizedConstructor() {
		AuditType parameterizedAuditType=new AuditType("Internal");
		assertEquals("Internal",parameterizedAuditType.getAuditType());
	}
	
	@Test
	@ApiModelProperty(notes = "This method is used to test setter method")
	public void auditTypeSetterTest() {
		audittype.setAuditType("Internal");
		assertEquals("Internal",audittype.getAuditType() );
		
	}
	
	@Test
	@ApiModelProperty(notes = "This method is used to test getter method")
	public void auditTypeGetterTest() {
		audittype.setAuditType("SOX");
		assertEquals("SOX",audittype.getAuditType() );
		
	}
	
	
	
	@Test
	@ApiModelProperty(notes = "This method is used to test toString()")
	public void toStringTest() {
		String string = audittype.toString();
		assertEquals(string, audittype.toString());
	}
	
	
}
