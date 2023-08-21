package org.virtusa.app;

import org.virtusa.app.dao.EmpDao;
import org.virtusa.app.dao.EmpDaoImpl;

public class Test {

	public static void main(String[] args) {
		EmpDao dao=new EmpDaoImpl();
		dao.getAll().forEach(emp->System.out.println(emp.getEno()+"\t"+emp.getName()+"\t"+emp.getAddress()+"\t"+emp.getDateOfJoin()));
	}

}
