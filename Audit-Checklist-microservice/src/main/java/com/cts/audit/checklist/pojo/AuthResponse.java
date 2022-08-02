package com.cts.audit.checklist.pojo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponse {
	
	//This pojo class is used for validation of token for authorization purpose
	private String userId;
	private boolean isValid;

}
