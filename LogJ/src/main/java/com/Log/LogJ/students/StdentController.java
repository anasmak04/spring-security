package com.Log.LogJ.students;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/students")
public class StdentController {
		private static final List<Student> students = Arrays.asList(
				new Student(1,"anas"),
				new Student(2,"bilal"),
				new Student(3,"marwane")
				);
				
	@GetMapping("{studentId}")
	public Student getStudents(@PathVariable("studentId") Integer studentId) {
		return students.stream()
				.filter(student -> studentId.equals(student.getStudentId()))
				.findFirst()
				.orElseThrow(() -> new IllegalStateException("student"+  studentId+ "does not exist"));
		
	}
}
