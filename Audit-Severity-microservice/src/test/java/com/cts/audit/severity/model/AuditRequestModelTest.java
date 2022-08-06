package com.cts.audit.severity.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;



import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@SpringBootTest
@ApiModel(description = "This Class is used to test AuditRequest Model class")
public class AuditRequestModelTest {


	AuditRequestModel auditRequestModel=new AuditRequestModel();
	
	@Test
	@ApiModelProperty(notes = "This method is used to test all argument constructor")
	public void testAuditRequestModelAllArgsConstructor() {
		assertNotNull(auditRequestModel);
	}
	
	@Test
	@ApiModelProperty(notes = "This method is used to test parameterized constructor")
	public void testAuditRequestModelParameterizedConstructor() {
		AuditRequestModel parameterizedConstructor = new AuditRequestModel(1,new AuditDetailModel(1,"Internal",new Date(2022,8,6),4),"Audit Management","Manish","Manikanta");
		assertEquals("Audit Management",parameterizedConstructor.getProjectname());
	}
	@Test
	@ApiModelProperty(notes = "This method is used to test Getters")
	public void getterTest() {
	auditRequestModel.setOwnername("Manikanta");
	assertEquals("Manikanta",auditRequestModel.getOwnername() );
	}
	@Test
	@ApiModelProperty(notes = "This method is used to test Setters")
	public void setterTest() {
		auditRequestModel.setProjectname("Audit Management");
		assertEquals("Audit Management",auditRequestModel.getProjectname() );	
	}
	
	
	
	
	
}
