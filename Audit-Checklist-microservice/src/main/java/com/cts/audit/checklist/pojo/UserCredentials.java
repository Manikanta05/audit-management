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
public class UserCredentials {
	/*This pojo class is used to obtain details from the
	 *  User Interface entered by user
	 */
	private String userId;
	private String password;

}
