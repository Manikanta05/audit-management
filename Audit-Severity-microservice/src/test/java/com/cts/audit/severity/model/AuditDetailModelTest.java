package com.cts.audit.severity.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@SpringBootTest
@ApiModel(description = "This Class is used to test AuditDetail Model class")
public class AuditDetailModelTest {
	AuditDetailModel auditDetailModel=new AuditDetailModel();
	
	@Test
	@ApiModelProperty(notes = "This method is used to test all argument constructor")
	public void testAuditTypeAllArgsConstructor() {
		assertNotNull(auditDetailModel);
	}
	
	@Test
	@ApiModelProperty(notes = "This method is used to test parameterized constructor")
	public void testAuditTypeParameterizedConstructor() {
		AuditDetailModel parameterizedQuestions = new AuditDetailModel(1,"Internal",new Date(2022,8,6),4);
		assertEquals("Internal",parameterizedQuestions.getAudittype());
	}
	
	@Test
	@ApiModelProperty(notes = "This method is used to test audittype")
	public void auditTypeTest() {
		auditDetailModel.setAudittype("Internal");
		assertEquals("Internal",auditDetailModel.getAudittype() );
		
	}
	
	
	@ApiModelProperty(notes = "This method is used to test toString()")
	@Test
	public void toStringTest() {
		String string = auditDetailModel.toString();
		assertEquals(string, auditDetailModel.toString());
	}
}
