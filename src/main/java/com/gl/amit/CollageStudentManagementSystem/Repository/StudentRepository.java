package com.gl.amit.CollageStudentManagementSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gl.amit.CollageStudentManagementSystem.Entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
