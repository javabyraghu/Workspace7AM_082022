package com.app.raghu.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.raghu.entity.Student;
import com.app.raghu.exception.StudentNotFoundException;
import com.app.raghu.service.IStudentService;

@RestController
/*@CrossOrigin({
	"http://localhost:3000/",
	"http://localhost:4200/"
	})*/
@RequestMapping("/v1/api/student")
public class StudentRestController {

	@Autowired
	private IStudentService service;
	
	//1. create one student
	@PostMapping("/create")
	public ResponseEntity<String> createStudent(
			@RequestBody @Valid Student student
			)
	{
		Integer id = service.saveStudent(student);
		String message = "STUDENT '"+id+"' CREATED";
		
		//return new ResponseEntity<String>(message, HttpStatus.OK);
		return new ResponseEntity<String>(message, HttpStatus.CREATED);//201
	}
	
	//2. fetch all students
	@GetMapping("/all")
	public ResponseEntity<List<Student>> getAllStudents() {
		List<Student> list = service.getAllStudents();
		//return new ResponseEntity<List<Student>>(list, HttpStatus.OK);
		return ResponseEntity.ok(list);
	}
	
	//3. fetch one by id
	@GetMapping("/find/{id}")
	public ResponseEntity<Student> getOneStudent(
			@PathVariable("id") Integer id
			) 
	{
		ResponseEntity<Student> response = null;
		try {
			Student s = service.getOneStudent(id);
			response = ResponseEntity.ok(s);
		} catch (StudentNotFoundException e) {
			e.printStackTrace();
			throw e;
		}
		return response;
	}
	
	//4. remove one by id
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<String> deleteStudent(
			@PathVariable("id") Integer id
			) 
	{
		ResponseEntity<String> response = null;
		try {
			service.deleteStudent(id);
			response = ResponseEntity.ok("STUDENT '"+id+"' REMOVED");
		} catch (StudentNotFoundException e) {
			e.printStackTrace();
			throw e;
		}
		return response;
	}
	
	//5. update student
	@PutMapping("/modify")
	public ResponseEntity<String> updateStudent(
			@RequestBody Student student
			)
	{
		ResponseEntity<String> response = null;
		try {
			service.updateStudent(student);
			response = ResponseEntity.ok("STUDENT '"+student.getStdId()+"' UPDATED");
		} catch (StudentNotFoundException e) {
			e.printStackTrace();
			throw e;
		}
		return response;
	}
}
