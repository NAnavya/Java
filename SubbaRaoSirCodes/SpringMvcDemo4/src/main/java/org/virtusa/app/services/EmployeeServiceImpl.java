package org.virtusa.app.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.virtusa.app.dao.EmpDao;
import org.virtusa.app.entities.Emp;
import org.virtusa.app.exceptions.EmployeeNotFoundException;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	private EmpDao dao;
	public void insertEmployee(Emp e) {
		dao.insert(e);
	}

	public void deleteEmployee(int eno) {
		dao.delete(eno);
	}

	public List<Emp> getEmployees() {
		return dao.getAll();
	}

	public Emp getEmployee(int eno) {
		return dao.get(eno).orElseThrow(()->new EmployeeNotFoundException("Student Not Found"));
		
	}

	public void updateEmployee(int eno, Emp e) {
		dao.update(eno, e);
	}
	
}
