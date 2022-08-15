package com.cts.audit.severity.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "auth-service", url = "http://localhost:8081/auth")
public interface AuthenticationFeign {

	@GetMapping("/validate")
	public Boolean validate(@RequestHeader(name = "Authorization") String token1);
}
