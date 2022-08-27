package com.Log.LogJ.students;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
@Table(name="students")
@AllArgsConstructor 
public class Student {
			@Id 
		 	private final Integer studentId;
		 	private final String studentName;
}

