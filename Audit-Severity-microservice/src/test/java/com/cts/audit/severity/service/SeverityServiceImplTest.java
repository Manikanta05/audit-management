package com.cts.audit.severity.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;
import com.cts.audit.severity.feign.BenchmarkFeign;
import com.cts.audit.severity.model.AuditDetailModel;
import com.cts.audit.severity.model.AuditRequestModel;
import com.cts.audit.severity.model.AuditResponseModel;
import com.cts.audit.severity.pojo.AuditBenchmark;
import com.cts.audit.severity.services.SeverityServiceImpl;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@SpringBootTest
@ApiModel(description = "This Class is used to test SeverityServiceImpl Model class")
public class SeverityServiceImplTest {

	
	@InjectMocks
	SeverityServiceImpl severityService;
	@Mock
	BenchmarkFeign benchmarkfeign;
//	@Mock
//	AuditBenchmark auditBenchmark;
	@Test
	@ApiModelProperty(notes = "This method is used to test getQuestions()")
	public void checkSeverityTest(){
		List<AuditBenchmark> auditBenchmark=new ArrayList<>();
		auditBenchmark.add(new AuditBenchmark(1,"Internal",3));
		when(benchmarkfeign.getBenchmarkMap()).thenReturn(auditBenchmark);
		AuditRequestModel request=new AuditRequestModel(1,new AuditDetailModel(1,"Internal",new Date(2022,8,6),4),"Audit Management","Manish","Manikanta");
		AuditResponseModel response=severityService.checkSeverity(request);
		AuditResponseModel expected=new AuditResponseModel("Red","Action to be taken in two weeks");
		assertEquals(expected,response);
	}
}
