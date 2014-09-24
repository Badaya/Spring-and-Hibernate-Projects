package com.hiber.example1.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.hiber.example1.util.HibernateUtil;

public class Main {

	public static void main(String[] args) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();

			Set<Course> courses = new HashSet<Course>();
			courses.add(new Course("Maths"));
			courses.add(new Course("Computer Science"));

			Student student1 = new Student("Eswar", courses);
			Student student2 = new Student("Joe", courses);
			session.save(student1);
			session.save(student2);
			transaction.commit();
			  Criteria criteria = session.createCriteria(Student.class);
			   criteria.add(Restrictions.like("studentName", "E%"));
			 List studentList = criteria.list();
			   
			   for (int i=0; i < studentList.size(); i++ ) {
			    Student studt = (Student)studentList.get(i);
			    System.out.println(String.format("student id : %s Student name : %s", studt.getStudentId(), studt.getStudentName()));
			   }
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

	}
}
