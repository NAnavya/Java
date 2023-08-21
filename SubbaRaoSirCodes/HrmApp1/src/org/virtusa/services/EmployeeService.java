package org.virtusa.services;

import java.util.List;

import org.virtusa.entities.Emp;
import org.virtusa.exceptions.EmployeeNotFoundException;

public interface EmployeeService {
	void insertEmployee(Emp e);
	List<Emp> getEmployees();
	Emp getEmployee(int eno) throws EmployeeNotFoundException;
	void deleteEmployee(int eno);
	void updateEmployee(int eno,Emp e) throws EmployeeNotFoundException;

}
