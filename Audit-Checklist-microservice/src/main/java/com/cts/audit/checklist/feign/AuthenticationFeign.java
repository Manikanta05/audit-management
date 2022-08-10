package com.cts.audit.checklist.feign;

import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

//${AUTH_SERVICE:http://localhost:8081/auth}

@FeignClient(name="auth-service",url="CDE015-POD1-audit-auth-lb-2030192275.ap-south-1.elb.amazonaws.com/auth")
public interface AuthenticationFeign {

	
	@GetMapping("/validate")
	public ResponseEntity<Boolean> validate(@RequestHeader(name = "Authorization") String token1);
}
