package com.cts.audit.checklist.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@SpringBootTest
@ApiModel(description = "This Class is used to test QuestionEntity Model class")
public class QuestionEntityTest {

	
	QuestionEntity questionentity=new QuestionEntity();
	
	@Test
	@ApiModelProperty(notes = "This method is used to test all argument constructor")
	public void testQuestionsEntityAllArgsConstructor() {
		assertNotNull(questionentity);
	}
	
	@Test
	@ApiModelProperty(notes = "This method is used to test parameterized constructor")
	public void testQuestionsEntityParameterizedConstructor() {
		QuestionEntity parameterizedQuestions = new QuestionEntity(1,"Internal","Is data deleted with permission of user?");
		assertEquals("Internal",parameterizedQuestions.getAudittype());
	}
	//@Test
	//public void questionIdTest() {
	//questionentity.setQuestionid(1);
	//assertEquals("1",questionentity.getQuestionid() );
	//}
	@Test
	@ApiModelProperty(notes = "This method is used to test audittype")
	public void auditTypeTest() {
		questionentity.setAudittype("Internal");
		assertEquals("Internal",questionentity.getAudittype() );
		
	}
	
	@Test
	@ApiModelProperty(notes = "This method is used to test question")
	public void questionTest() {
		questionentity.setQuestion("Have all Change requests followed SDLC before PROD move?");
		assertEquals("Have all Change requests followed SDLC before PROD move?",questionentity.getQuestion() );
	}
	
	@ApiModelProperty(notes = "This method is used to test toString()")
	@Test
	public void toStringTest() {
		String string = questionentity.toString();
		assertEquals(string, questionentity.toString());
	}
	
	
}
