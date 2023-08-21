package org.virtusa.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.virtusa.entities.Student;

@Repository
public class StudentDaoImpl implements StudentDao{
	@Autowired
	private SessionFactory sessionFactory;
	public void insert(Student student) {
		Session session=sessionFactory.getCurrentSession();
		session.save(student);
	}

	public List<Student> getAll() {
		Session session=sessionFactory.getCurrentSession();
		Criteria criteria=session.createCriteria(Student.class);
		return criteria.list();
	}

	public void delete(int sid) {
		Session session=sessionFactory.getCurrentSession();
		Criteria criteria=session.createCriteria(Student.class);
		Criterion criterion=Restrictions.eq("sid", sid);
		criteria.add(criterion);
		Student st=(Student)criteria.uniqueResult();
		session.delete(st);
	}

	public Optional<Student> get(int sid) {
		Session session=sessionFactory.getCurrentSession();
		/*
		 * CriteriaBuilder cb=session.getCriteriaBuilder(); CriteriaQuery<Student>
		 * cq=cb.createQuery(Student.class); Root<Student> root=cq.from(Student.class);
		 * cq.select(root).where(cb.equal(root.get("sid"), sid)); Query
		 * query=session.createQuery(cq); Student student=query.unwrap(Student.class);
		 */
		return Optional.of(session.get(Student.class, sid));
	}

	public void update(int sid, Student student) {
		Session session=sessionFactory.getCurrentSession();
		Student st=session.get(Student.class, sid);
		st.setName(student.getName());
		st.setAddress(student.getAddress());
		st.setDateOfBirth(student.getDateOfBirth());
		session.save(st);
	}

}
