package com.Log.LogJ.students;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/students")
public class StdentController {
//		private static final List<Student> students = Arrays.asList(
//				new Student(1,"anas"),
//				new Student(2,"bilal"),
//				new Student(3,"marwane")
//				);
	
	@Autowired
	StudentService stdServ;
				
	@GetMapping("/{id}")
	public Student getAdmin(@PathVariable Integer id) {
		Student st = stdServ.getById(id);
		return st;
	}

	@GetMapping()
	public List<Student> getallAdmin() {
		return stdServ.getall();
	}

	@PostMapping()
	public Student InsertAdmin(@RequestBody Student student) {
		System.out.println(student.getStudentId());
		return stdServ.save(student);
	}

	@DeleteMapping("/{id}")
	public void DeleteAdmin(@PathVariable Integer id) {
		stdServ.delete(id);
	}
}
