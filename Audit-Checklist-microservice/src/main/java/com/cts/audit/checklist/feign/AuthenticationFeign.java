package com.cts.audit.checklist.feign;

import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

//${AUTH_SERVICE:http://localhost:8081/auth}

@FeignClient(name="auth-service",url="cde015-pod1-audit-auth-lb-875635810.ap-south-1.elb.amazonaws.com/auth")
public interface AuthenticationFeign {

	
	@GetMapping("/validate")
	public ResponseEntity<Boolean> validate(@RequestHeader(name = "Authorization") String token1);
}
