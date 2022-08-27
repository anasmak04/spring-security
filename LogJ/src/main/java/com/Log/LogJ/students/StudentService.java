package com.Log.LogJ.students;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class StudentService implements StudentGeneric<Student> {

	@Autowired
	private StudentdInterface studentjpa;

	@Override
	public List<Student> getall() {
		return studentjpa.findAll();
	}

	@Override
	public Student getById(Integer id) {
		return studentjpa.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource Not found"));
	}

	@Override
	public Student save(Student student) {
		return studentjpa.save(student);
	}

	@Override
	public void update(Integer id, Student student) {
			
	}

	@Override
	public void delete(Integer id) {
		studentjpa.deleteById(id);
	}

}
