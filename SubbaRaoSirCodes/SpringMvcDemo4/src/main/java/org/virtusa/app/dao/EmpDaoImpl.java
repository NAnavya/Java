package org.virtusa.app.dao;

import java.util.List;
import java.util.Optional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.virtusa.app.entities.Emp;

@Repository
public class EmpDaoImpl implements EmpDao{
	@Autowired
	private SessionFactory sessionFactory;
	public void insert(Emp e) {
		Session session=sessionFactory.getCurrentSession();
		session.save(e);
	}

	public List<Emp> getAll() {
		Session session=sessionFactory.getCurrentSession();
		Criteria criteria=session.createCriteria(Emp.class);
		return criteria.list();
	}

	public void delete(int eno) {
		Session session=sessionFactory.getCurrentSession();
		Criteria criteria=session.createCriteria(Emp.class);
		Criterion criterion=Restrictions.eq("eno", eno);
		criteria.add(criterion);
		Emp st=(Emp)criteria.uniqueResult();
		session.delete(st);
	}

	public Optional<Emp> get(int sid) {
		Session session=sessionFactory.getCurrentSession();
		/*
		 * CriteriaBuilder cb=session.getCriteriaBuilder(); CriteriaQuery<Student>
		 * cq=cb.createQuery(Student.class); Root<Student> root=cq.from(Student.class);
		 * cq.select(root).where(cb.equal(root.get("sid"), sid)); Query
		 * query=session.createQuery(cq); Student student=query.unwrap(Student.class);
		 */
		return Optional.of(session.get(Emp.class, sid));
	}

	public void update(int eno, Emp e) {
		Session session=sessionFactory.getCurrentSession();
		Emp st=session.get(Emp.class, eno);
		st.setName(e.getName());
		st.setAddress(e.getAddress());
		//st.setDateOfBirth(student.getDateOfBirth());
		session.save(st);
	}

}
