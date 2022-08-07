package com.cts.audit.severity.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.cts.audit.severity.feign.BenchmarkFeign;
import com.cts.audit.severity.model.AuditDetailModel;
import com.cts.audit.severity.model.AuditRequestModel;
import com.cts.audit.severity.model.AuditResponseModel;
import com.cts.audit.severity.pojo.AuditBenchmark;
import com.cts.audit.severity.repository.ResponseRepository;
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
	
	@Mock
	ResponseRepository repo;
//	@Mock
//	AuditBenchmark auditBenchmark;
	@Test
	@ApiModelProperty(notes = "This method is used to test CheckSeverityTest()")
	public void checkSeverityForInvalidInternalTest(){
		List<AuditBenchmark> auditBenchmark=new ArrayList<>();
		auditBenchmark.add(new AuditBenchmark(1,"Internal",3));
		when(benchmarkfeign.getBenchmarkMap()).thenReturn(auditBenchmark);
		AuditRequestModel request=new AuditRequestModel(1,new AuditDetailModel(1,"Internal",new Date(),4),"Audit Management","Manish","Manikanta");
		AuditResponseModel checkSeverity = severityService.checkSeverity(request);
		assertEquals("RED", checkSeverity.getExecutionstatus());
	}
	
	@Test
	public void checkSeverityForValidInternalTest(){
		List<AuditBenchmark> auditBenchmark=new ArrayList<>();
		auditBenchmark.add(new AuditBenchmark(1,"Internal",3));
		when(benchmarkfeign.getBenchmarkMap()).thenReturn(auditBenchmark);
		AuditRequestModel request=new AuditRequestModel(1,new AuditDetailModel(1,"Internal",new Date(),2),"Audit Management","Manish","Manikanta");
		AuditResponseModel checkSeverity = severityService.checkSeverity(request);
		assertEquals("GREEN", checkSeverity.getExecutionstatus());
	}
	
	@Test

	public void checkSeverityForInvalidSOXTest(){
		List<AuditBenchmark> auditBenchmark=new ArrayList<>();
		auditBenchmark.add(new AuditBenchmark(1,"Internal",3));
		auditBenchmark.add(new AuditBenchmark(2,"SOX",1));
		when(benchmarkfeign.getBenchmarkMap()).thenReturn(auditBenchmark);
		AuditRequestModel request=new AuditRequestModel(1,new AuditDetailModel(1,"SOX",new Date(),4),"Audit Management","Manish","Manikanta");
		AuditResponseModel checkSeverity = severityService.checkSeverity(request);
		assertEquals("RED", checkSeverity.getExecutionstatus());
	}
	
	@Test
	public void checkSeverityForValidSOXTest(){
		List<AuditBenchmark> auditBenchmark=new ArrayList<>();
		auditBenchmark.add(new AuditBenchmark(1,"Internal",3));
		auditBenchmark.add(new AuditBenchmark(2,"SOX",1));
		when(benchmarkfeign.getBenchmarkMap()).thenReturn(auditBenchmark);
		AuditRequestModel request=new AuditRequestModel(1,new AuditDetailModel(1,"SOX",new Date(),1),"Audit Management","Manish","Manikanta");
		AuditResponseModel checkSeverity = severityService.checkSeverity(request);
		assertEquals("GREEN", checkSeverity.getExecutionstatus());
	}
}
