package com.cts.audit.severity.Controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.cts.audit.severity.controller.SeverityController;
import com.cts.audit.severity.exceptions.TokenNotValidException;
import com.cts.audit.severity.feign.AuthenticationFeign;
import com.cts.audit.severity.model.AuditDetailModel;
import com.cts.audit.severity.model.AuditRequestModel;
import com.cts.audit.severity.model.AuditResponseModel;
import com.cts.audit.severity.services.SeverityService;

@SpringBootTest
class SeverityControllerTest {

	@InjectMocks
	SeverityController severityController;
	
	@Mock
	AuthenticationFeign authFeign;
	
	@Mock
	SeverityService severityService;
	
	@Test
	public void projectExecutionValidTest(){
		when(authFeign.validate("token")).thenReturn(true);
		AuditDetailModel auditdetails = new AuditDetailModel(1,"Internal",new Date(),4);
		AuditRequestModel auditRequestModel = new AuditRequestModel(1,auditdetails,"Audit Management","Manikanta","Manish");
		when(severityService.checkSeverity(auditRequestModel)).thenReturn(new AuditResponseModel("RED","Action to be taken in 2 weeks"));
		
		AuditResponseModel responseModel = severityController.projectExecution("token", auditRequestModel);
	
		assertEquals("RED",responseModel.getExecutionstatus());
	}
	
	
	@Test
	public void projectExecutionInValidTest(){
		when(authFeign.validate("token")).thenReturn(false);
		AuditDetailModel auditdetails = new AuditDetailModel(1,"Internal",new Date(),4);
		AuditRequestModel auditRequestModel = new AuditRequestModel(1,auditdetails,"Audit Management","Manikanta","Manish");
		when(severityService.checkSeverity(auditRequestModel)).thenReturn(new AuditResponseModel("RED","Action to be taken in 2 weeks"));
		Exception exception = assertThrows(TokenNotValidException.class,()->{
			AuditResponseModel responseModel = severityController.projectExecution("token", auditRequestModel);
			
		});
		
		String actualMessage = exception.getMessage();
		String expectedMessage = "Invalid Token!"; 
	
		assertEquals(expectedMessage,actualMessage);
	}

}
