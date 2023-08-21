package org.virtusa.SpringBootMvcDemo.dao;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.virtusa.SpringBootMvcDemo.entities.Emp;

@Repository
public class EmpDaoImpl implements EmpDao{
	@Autowired
	private SessionFactory factory;
	@Override
	public void insert(Emp e) {
		Session session=factory.getCurrentSession();
		session.save(e);
	}

	@Override
	public void delete(int eno) {
		Session session=factory.getCurrentSession();
		Emp e=session.get(Emp.class, eno);
		session.delete(e);
	}

	@Override
	public List<Emp> getEmployees() {
		Session session=factory.getCurrentSession();
		Criteria criteria=session.createCriteria(Emp.class);
		return criteria.list();
	}

	@Override
	public Optional<Emp> get(int eno) {
		Session session=factory.getCurrentSession();
		Emp e=session.get(Emp.class, eno);
		return Optional.of(e);
	}

	@Override
	public void update(int eno, Emp e) {
		Session session=factory.getCurrentSession();
		Emp e1=session.get(Emp.class, eno);
		e1.setName(e.getName());
		e1.setAddress(e.getAddress());
		e1.setAge(e.getAge());
		session.save(e1);
	}

}
