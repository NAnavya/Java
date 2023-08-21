package org.virtusa.SpringBootMvcDemo.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.virtusa.SpringBootMvcDemo.dao.EmpDao;
import org.virtusa.SpringBootMvcDemo.entities.Emp;
import org.virtusa.SpringBootMvcDemo.exceptions.EmployeeNotFoundException;

@Service
@Transactional
public class EmpServiceImpl implements EmpService{
	@Autowired
	private EmpDao empDao;
	@Override
	public void insertEmployee(Emp e) {
		empDao.insert(e);
	}

	@Override
	public void deleteEmployee(int eno) {
		empDao.delete(eno);
	}

	@Override
	public List<Emp> getEmployees() {
		return empDao.getEmployees();
	}

	@Override
	public Emp getEmmployee(int eno) {
		return empDao.get(eno).orElseThrow(()->new EmployeeNotFoundException("Employee Not Found"));
	}

	@Override
	public void updateEmployee(int eno, Emp e) {
		empDao.update(eno, e);
	}

}
