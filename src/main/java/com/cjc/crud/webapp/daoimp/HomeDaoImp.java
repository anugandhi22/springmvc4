package com.cjc.crud.webapp.daoimp;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cjc.crud.webapp.dao.HomeDao;
import com.cjc.crud.webapp.model.Student;

@Repository
public class HomeDaoImp implements HomeDao {
	@Autowired
	SessionFactory sf;

	@Override
	public void saveStudent(Student s) {
		Session session = sf.openSession();
		session.save(s);
		session.beginTransaction().commit();
	}

	@Override
	public List<Student> logincheck(String un, String ps) {

		Session session = sf.openSession();
		if (un.equalsIgnoreCase("Admin") && ps.equalsIgnoreCase("Admin")) {
			List<Student> ls = session.createQuery("from Student").getResultList();
			return ls;
		} else {
			Query query = session.createQuery("from Student where uname=?1 and password=?2");
			query.setParameter(1, un);
			query.setParameter(2, ps);
			List<Student> ls = query.getResultList();
			return ls;
		}

	}

	@Override
	public List<Student> deleteData(int rollno) {
		Session session = sf.openSession();
		Query query = session.createQuery("delete from Student where rollno=?1");
		query.setParameter(1, rollno);
		Transaction tx = session.beginTransaction();
		query.executeUpdate();
		tx.commit();
		List<Student> ls = session.createQuery("from Student").getResultList();
		return ls;

	}

	
@Override
	public Student editData(int rollno) {
		Session session = sf.openSession();
		Student s=session.get(Student.class,rollno);
		return s;
	}

	@Override
	public List<Student> updateData(Student s) {
		Session session = sf.openSession();
      session.merge(s);
		Transaction tx = session.beginTransaction();
		tx.commit();
		List<Student> ls = session.createQuery("from Student").getResultList();
		return ls;
	}

	

}
