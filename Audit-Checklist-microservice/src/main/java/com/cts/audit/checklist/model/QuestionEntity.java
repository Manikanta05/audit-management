package com.cts.audit.checklist.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="auditquestion")
@ApiModel(value="This is a question entity model")
public class QuestionEntity {

	@ApiModelProperty(notes = "Variable questionId acts as an id for questions") 
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer questionid;
	
	@ApiModelProperty(notes = "Variable auditType stores the type of audit")
	@Column
	private String audittype;
	
	@ApiModelProperty(notes="Variable questions stores a questions based on audit type")
	@Column
	private String question;
	
	/*@ApiModelProperty(notes="Variable responses stores the user response of the question")
	@Column
	private String response;
	*/
}
