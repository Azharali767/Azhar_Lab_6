package com.gl.amit.CollageStudentManagementSystem.Controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gl.amit.CollageStudentManagementSystem.Entity.Student;
import com.gl.amit.CollageStudentManagementSystem.Service.StudentServiceImpl;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class StudentController {
	
	@Autowired
	StudentServiceImpl studentServiceImpl;
	
	@GetMapping("/student/studentList")
	public String findAllStudents(Model theModel) {
		log.info("Running StudentController findAllStudents method");
		List<Student> theStudent= studentServiceImpl.findAllStudents();
		theModel.addAttribute("Student", theStudent);
		return "list-students";
	}
	
	@GetMapping("/student/showFormForAdd")
	public String saveStudent(Model theModel) {
		log.info("Running StudentController showFormForAdd method");
		Student newStudent = new Student();
		theModel.addAttribute("Student",newStudent);
		studentServiceImpl.saveStudent(newStudent);
		return "Student-form";
	}
	
	@PostMapping("/student/save")
	public String saveStudent(@RequestParam("id") int id, @RequestParam("firstName") String firstName,@RequestParam("lastName") String lastName,
			@RequestParam("country") String country,@RequestParam("course") String course) {
		log.info("Running StudentController save method");
		Student newStudent;
		if(id!=0) {
			newStudent = studentServiceImpl.findEmployeeById(id);
			newStudent.setFirstName(firstName);
			newStudent.setLastName(lastName);
			newStudent.setCourse(course);
			newStudent.setCountry(country);
		}
		else {
			newStudent = new Student(firstName,lastName,country,course);
		}
		studentServiceImpl.saveStudent(newStudent);
		return "redirect:/student/studentList";
	}
	
	@GetMapping("/student/delete")
	public String deleteStudents(@RequestParam("studentId") int id) {
		log.info("Running StudentController deleteStudents method");
		studentServiceImpl.deleteStudentById(id);
		return "redirect:/student/studentList";
	}
	
	@GetMapping("/student/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("studentId") int id,Model theModel) {
		log.info("Running StudentController showFormForUpdate method");
		Student student = studentServiceImpl.findEmployeeById(id);
		theModel.addAttribute("Student", student);
		return "Student-form";
	}
	
	
	@RequestMapping("/403")
	public ModelAndView accessDenied(Principal user) {
		log.info("Running StudentController accessDenied method");
		
		ModelAndView model = new ModelAndView();
		
		if(user != null) {
			model.addObject("msg", "Hi "+user.getName()+", you do not have permission on this page!");
		}
		else {
			model.addObject("msg", "you do not have access to this page!");
		}
			
		model.setViewName("403");
		return model;
	}

}
