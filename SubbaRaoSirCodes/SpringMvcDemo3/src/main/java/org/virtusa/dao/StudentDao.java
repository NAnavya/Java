package org.virtusa.dao;

import java.util.List;
import java.util.Optional;

import org.virtusa.entities.Student;

public interface StudentDao {
	void insert(Student student);
	List<Student> getAll();
	void delete(int sid);
	Optional<Student> get(int sid);
	void update(int sid,Student student);
}
