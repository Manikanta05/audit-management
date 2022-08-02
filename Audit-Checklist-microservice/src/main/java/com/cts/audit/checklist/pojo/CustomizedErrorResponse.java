package com.cts.audit.checklist.pojo;
import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

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
public class CustomizedErrorResponse {

	//This pojo class is used as a response for exceptions
	//Variable timestamp is used to store the time when exception has occurred
	private LocalDateTime timestamp;
	
	//Variable status stores the http status code
	private HttpStatus status;
	
	//Variable reason stores the reason why the exception is encountered
	private String reason;
	
	/*Variable message stores the message whicg is recieved
	 *  from the constructor of the exception class
	 */
	private String message;
}
