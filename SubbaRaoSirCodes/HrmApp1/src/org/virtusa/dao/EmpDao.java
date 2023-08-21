package org.virtusa.dao;

import java.util.List;
import java.util.Optional;

import org.virtusa.entities.Emp;
import org.virtusa.exceptions.EmployeeNotFoundException;

public interface EmpDao {
	void insert(Emp e);
	List<Emp> getEmployees();
	Optional<Emp> getEmployee(int eno);
	void delete(int eno);
	void update(int eno,Emp e) throws EmployeeNotFoundException;
}
