package com.inexture.ems.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.inexture.ems.model.Address;
import com.inexture.ems.model.User;

@Repository
public class UserDAOImp implements UserDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public User getUserbyEmail(String email) {
		Session session = sessionFactory.getCurrentSession();

			Query q1 = session.createQuery("from User u where u.email = :em");
			
			q1.setParameter("em", email);
			
			try {
				User u = (User)q1.getSingleResult();
				return u;
			}
			catch(NoResultException e) {
				return null;
			}
	}

	@Override
	public int saveUser(User user) {
		Session session = sessionFactory.getCurrentSession();
		Serializable s = session.save(user);
		String i = s.toString();
		return Integer.parseInt(i);
	}

	@Override
	public List<User> getAllUser() {
		Session session = sessionFactory.getCurrentSession();
		Query q1 = session.createQuery("select id,first_name,last_name,date,phone,gender,checkbox,email from User u where u.role='User'");
		
		@SuppressWarnings("unchecked")
		List<User> list = q1.getResultList();
		return list;
	}

	@Override
	public void deleteUser(int id) {
		Session session = sessionFactory.getCurrentSession();
		User u = session.byId(User.class).load(id);
		session.delete(u);
	}

	@Override
	public User getUser(int theId) {
		Session session = sessionFactory.getCurrentSession();
		User user = session.get(User.class, theId);
		return user;
	}

	@Override
	public void updateUser(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(user);
	}

	@Override
	public void deleteAddress(int id) {
		Session session = sessionFactory.getCurrentSession();
		Address a = session.byId(Address.class).load(id);
		session.delete(a);
	}
}
