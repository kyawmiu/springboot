package net.javaguides.springbootrestapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springbootrestapi.bean.Student;

@RestController
public class StudentController {
	
	//localhost:8080/student
	@GetMapping("student")
	public ResponseEntity<Student> getStudent() {
		Student student= new Student(
				1,"Kyaw","Thiha");
		return new ResponseEntity<>(student,HttpStatus.OK);
	}
	
	//localhost:8080/students
	@GetMapping("students")
	public List<Student> getStudents(){
		List<Student> students= new ArrayList<>();
		students.add(new Student(1, "Kyaw", "Thiha"));
		students.add(new Student(2, "Zay", "Thiha"));
		students.add(new Student(3, "Htin", "Thiha"));
		return students;
	}
	
	//localhost:8080/students/1
	@GetMapping("students/{id}/{firstName}/{lastName}")
	public Student studentPathVariable(@PathVariable("id") int studentId,@PathVariable("firstName") String studentFirstName,@PathVariable("lastName") String studentLastName) {
		return new Student(studentId, studentFirstName, studentLastName);
	}
	
	//localhost:8080/students/query?id=1&firstName=Kyaw&lastName=Thiha
	@GetMapping("students/query")
	public Student studentRequestVariable(@RequestParam int id, @RequestParam String firstName,@RequestParam String lastName) {
		return new Student (id,firstName,lastName);
	}
	
	@PostMapping("students/create")	
	@ResponseStatus(HttpStatus.CREATED)
	public Student createStudent(@RequestBody Student student) {
		System.out.println(student.getId());
		System.out.println(student.getFirstName());
		System.out.println(student.getLastName());
		return student;
	}
	
	//localhost:8080/students/3/update
	@PutMapping("students/{id}/update")
	public Student updateStudent(@RequestBody Student student,@PathVariable("id") int studentId) {
		student.setId(studentId);
		System.out.println(student.getId());
		System.out.println(student.getFirstName());
		System.out.println(student.getLastName());
		return student;
	}
	
	@DeleteMapping("students/{id}/delete")
	public String deleteStudent(@PathVariable("id") int studentId) {
		System.out.println(studentId);
		return "Delete";
	}
	
}
