package org.virtusa.dao;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.virtusa.entities.Emp;

import com.sun.xml.bind.v2.runtime.Name;

@Transactional
@Repository(value="empDaoImpl")
public class EmpDaoImpl implements EmpDao{
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void insert(Emp e) {
		Session session=sessionFactory.getCurrentSession();
		session.save(e);
	}

	@Override
	public void delete(int eno) {
		Session session=sessionFactory.getCurrentSession();
		Emp e=session.get(Emp.class, eno);
		session.delete(e);
	}

	@Override
	public List<Emp> getAll() {
		Session session=sessionFactory.getCurrentSession();
		Query<Emp> query=session.createQuery("select e from org.virtusa.entities.Emp e");
		return query.list();
	}

	@Override
	public Optional<Emp> get(int eno) {
		Session session=sessionFactory.getCurrentSession();
		Emp e=session.get(Emp.class, eno);
		return Optional.of(e);
	}

}
