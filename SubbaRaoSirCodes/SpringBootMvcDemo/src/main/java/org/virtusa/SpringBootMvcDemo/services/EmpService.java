package org.virtusa.SpringBootMvcDemo.services;

import java.util.List;

import org.virtusa.SpringBootMvcDemo.entities.Emp;

public interface EmpService {
	void insertEmployee(Emp e);
	void deleteEmployee(int eno);
	List<Emp> getEmployees();
	Emp getEmmployee(int eno);
	void updateEmployee(int eno,Emp e);
}
