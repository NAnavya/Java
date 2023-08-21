package org.virtusa.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.virtusa.dao.StudentDao;
import org.virtusa.entities.Student;
import org.virtusa.exceptions.StudentNotFoundException;

@Service
@Transactional
public class StudentServiceImpl implements StudentService{
	@Autowired
	private StudentDao dao;
	public void insertStudent(Student student) {
		dao.insert(student);
	}

	public void deleteStudent(int sid) {
		dao.delete(sid);
	}

	public List<Student> getStudents() {
		return dao.getAll();
	}

	public Student getStudent(int sid) {
		return dao.get(sid).orElseThrow(()->new StudentNotFoundException("Student Not Found"));
		
	}

	public void updateStudent(int sid, Student student) {
		dao.update(sid, student);
	}
	
}
