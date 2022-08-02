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
public class ProjectManager {

	//This pojo class is used to store authentication details
	private String userId;
	private String password;
	private String authToken;
}
