package com.ty.hospital.dao.ipm;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.border.EtchedBorder;

import com.ty.hospital.dao.UserDao;
import com.ty.hospital.dto.User;

public class UserDaoImp  implements UserDao{

	public User saveUser(User user) {
		// TODO Auto-generated method stub
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		User user1=entityManager.find(User.class, 101);
		if(user1!=null) {
			entityTransaction.begin();
			entityManager.persist(user1);
			entityTransaction.commit();
		}
		
		return null;
	}

	public boolean deletUserById(int uid) {
		// TODO Auto-generated method stub
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager  entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		User user=entityManager.find(User.class, uid);
		if(user!=null) {
			entityTransaction.begin();
			entityManager.remove(user);
			entityTransaction.commit();
			return true;
		}
		return false;
	}

	public User getUserById(int uid) {
		// TODO Auto-generated method stub
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
	
		User user=entityManager.find(User.class, uid);
		
		
		return user;
	}

	public User updateUserById(int uid, User user) {
		// TODO Auto-generated method stub
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		User user1=entityManager.find(User.class, uid);
		
		if(user1!=null) {
			user1.setName(user.getName());
			user1.setRole(user.getRole());
			user1.setEmail(user.getEmail());
			user1.setPhno(user.getPhno());
			user1.setPassword(user.getPassword());
			
			entityTransaction.begin();
			entityManager.merge(user1);
			entityTransaction.commit();
			return user1;
			
		}
		return null;
	}

	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		
		Query query=entityManager.createQuery("selet a from user a");
		List<User> user=query.getResultList();
		return user;
		
	}

	public List<User> getUserByName(String name) {
		// TODO Auto-generated method stub
		
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		
		Query query=entityManager.createQuery("selet name from user a where name=?1");
		query.setParameter(1,name);
		List<User>user=query.getResultList();
		
		
		return user;
	}

	public List<User> getUserByRole(String role) {
		// TODO Auto-generated method stub
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		Query query=entityManager.createQuery("select role from user a where role=?1");
		query.setParameter(1,role);
		List<User> user=query.getResultList();
		
		return user;
	}

}
