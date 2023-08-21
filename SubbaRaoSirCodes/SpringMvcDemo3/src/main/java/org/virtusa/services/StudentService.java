package org.virtusa.services;

import java.util.List;

import org.virtusa.entities.Student;

public interface StudentService {
	void insertStudent(Student student);
	void deleteStudent(int sid);
	List<Student> getStudents();
	Student getStudent(int sid);
	void updateStudent(int sid,Student student);
}
