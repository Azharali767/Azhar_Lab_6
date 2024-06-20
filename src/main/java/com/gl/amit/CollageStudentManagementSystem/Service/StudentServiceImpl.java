package com.gl.amit.CollageStudentManagementSystem.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.amit.CollageStudentManagementSystem.Entity.Student;
import com.gl.amit.CollageStudentManagementSystem.Repository.StudentRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class StudentServiceImpl {
	
	@Autowired
	StudentRepository studentRepository;
	
	public List<Student> findAllStudents(){
		log.info("Running StudentServiceImpl findAllStudents method");
		return studentRepository.findAll() ;
	}
	
	public void deleteStudentById(Integer id) {
		log.info("Running StudentServiceImpl deleteStudentById method");
		studentRepository.deleteById(id);
	}
	
	public Student findEmployeeById(Integer id) {
		log.info("Running StudentServiceImpl findEmployeeById method");
		return studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Student ID"));
	}
	
	public void saveStudent(Student student) {
		log.info("Running StudentServiceImpl saveStudent method");
		studentRepository.save(student);

		log.info("Completed StudentServiceImpl saveStudent method");
	}
	
//	public void updateStudent(Student student,Integer id) {
//		log.info("Running StudentServiceImpl saveStudent method");
//		Student oldStudent = studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Student ID"));
//		oldStudent.setFirstName(student.firstName);
//		oldStudent.setLastName(student.lastName);
//		oldStudent.setCountry(student.country);
//		oldStudent.setCourse(student.course);
//		studentRepository.save(oldStudent);
//
//	}
}
