package org.virtusa.app.dao;

import java.util.List;
import java.util.Optional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.virtusa.app.config.HibConfig;
import org.virtusa.app.entities.Emp;

public class EmpDaoImpl implements EmpDao{
	SessionFactory factory=null;
	public EmpDaoImpl() {
		factory=HibConfig.getSessionFactory();
	}
	@Override
	public void insert(Emp e) {
		Transaction tx=null;
		Session session=factory.openSession();
		try
		{
			tx=session.beginTransaction();
			session.save(e);
			tx.commit();
		}
		catch(Exception e1) {
			tx.rollback();
		}
		session.close();
	}

	@Override
	public List<Emp> getAll() {
		Session session=factory.openSession();
		Transaction tx=null;
		List<Emp> employees=null;
		try {
			tx=session.beginTransaction();
			Query<Emp> query=session.createQuery("select e from org.virtusa.app.entities.Emp e");
			//select e from org.virtusa.app.entities.Emp e where e.eno=1
			employees=query.list();
		} catch (Exception e) {
			tx.rollback();
		}
		session.close();
		return employees;
	}

	@Override
	public void delete(int eno) {
		Transaction tx=null;
		Session session=factory.openSession();
		try {
			tx=session.beginTransaction();
			Emp e=session.get(Emp.class, eno);
			session.delete(e);
			tx.commit();
		} catch (Exception e1) {
			tx.rollback();
		}
		session.close();
	}

	@Override
	public Optional<Emp> get(int eno) {
		Session session=factory.openSession();
		Emp e=session.get(Emp.class, eno);
		session.close();
		return Optional.ofNullable(e);
	}

	@Override
	public void update(int eno, Emp e) {
		Session session=factory.openSession();
		Transaction tx=null;
		try {
			tx=session.beginTransaction();
			Emp e1=session.get(Emp.class, eno);
			e1.setName(e.getName());
			e1.setAddress(e.getAddress());
			e1.setDateOfJoin(e.getDateOfJoin());
			session.save(e1);
			tx.commit();
			session.close();
		} catch (Exception e2) {
			tx.rollback();
		}
	}

}
