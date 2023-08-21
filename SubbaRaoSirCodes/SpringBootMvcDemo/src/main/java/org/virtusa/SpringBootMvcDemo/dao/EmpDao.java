package org.virtusa.SpringBootMvcDemo.dao;

import java.util.List;
import java.util.Optional;

import org.virtusa.SpringBootMvcDemo.entities.Emp;

public interface EmpDao {
	void insert(Emp e);
	void delete(int eno);
	List<Emp> getEmployees();
	Optional<Emp> get(int eno);
	void update(int eno,Emp e);
}
