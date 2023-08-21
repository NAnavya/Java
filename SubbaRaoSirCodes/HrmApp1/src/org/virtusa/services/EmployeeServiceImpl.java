package org.virtusa.services;

import java.util.List;

import org.virtusa.dao.EmpDao;
import org.virtusa.dao.EmpDaoImpl;
import org.virtusa.entities.Emp;
import org.virtusa.exceptions.EmployeeNotFoundException;

public class EmployeeServiceImpl implements EmployeeService{
	EmpDao dao=new EmpDaoImpl();
	@Override
	public void insertEmployee(Emp e) {
		dao.insert(e);
	}

	@Override
	public List<Emp> getEmployees() {
		return dao.getEmployees();
	}

	@Override
	public Emp getEmployee(int eno) throws EmployeeNotFoundException {
		return dao.getEmployee(eno).orElseThrow(()->new EmployeeNotFoundException("Employee Not Found"));
	}

	@Override
	public void deleteEmployee(int eno) {
		dao.delete(eno);
	}

	@Override
	public void updateEmployee(int eno, Emp e) throws EmployeeNotFoundException {
		dao.update(eno, e);
	}

}
