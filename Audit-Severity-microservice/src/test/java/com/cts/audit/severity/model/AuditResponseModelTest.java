package com.cts.audit.severity.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@SpringBootTest
@ApiModel(description = "This Class is used to test AuditResponse Model class")
public class AuditResponseModelTest {

	AuditResponseModel auditResponseModel=new AuditResponseModel();
	@Test
	@ApiModelProperty(notes = "This method is used to test all argument constructor")
	public void testAuditResponseModelAllArgsConstructor() {
		assertNotNull(auditResponseModel);
	}
	
	@Test
	@ApiModelProperty(notes = "This method is used to test parameterized constructor")
	public void testAuditResponseModelParameterizedConstructor() {
		AuditResponseModel parameterizedConstructor = new AuditResponseModel("Red","Action to be taken in two weeks");
		assertEquals("Red",parameterizedConstructor.getExecutionstatus());
	}
	
	@Test
	@ApiModelProperty(notes = "This method is used to test Getters")
	public void getterTest() {
	auditResponseModel.setActionduration("Action to be taken in two weeks");
	assertEquals("Action to be taken in two weeks",auditResponseModel.getActionduration() );
	}
	@Test
	@ApiModelProperty(notes = "This method is used to test Setters")
	public void setterTest() {
		auditResponseModel.setExecutionstatus("Green");
		assertEquals("Green",auditResponseModel.getExecutionstatus() );	
	}
	@ApiModelProperty(notes = "This method is used to test toString()")
	@Test
	public void toStringTest() {
		String string = auditResponseModel.toString();
		assertEquals(string, auditResponseModel.toString());
	}
}
