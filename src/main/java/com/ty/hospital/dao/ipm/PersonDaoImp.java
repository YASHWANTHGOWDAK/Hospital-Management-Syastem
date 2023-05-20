package com.ty.hospital.dao.ipm;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.hospital.dao.PersonDao;
import com.ty.hospital.dto.Encounter;
import com.ty.hospital.dto.Person;

public class PersonDaoImp implements PersonDao {

	public Person savePerson(int eid, Person person) {
		// TODO Auto-generated method stub
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
    Encounter encounter=entityManager.find(Encounter.class, eid);

		if(encounter!=null) {
			entityTransaction.begin();
			entityManager.persist(person);
			entityTransaction.commit();
			return person;
		}
		return null;
	}

	public boolean deletePersonById(int pid) {
		// TODO Auto-generated method stub
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Person person=entityManager.find(Person.class,pid);
		if(person!=null) {
			entityTransaction.begin();
			entityManager.remove(person);
			entityTransaction.commit();
			return true;
		}
		
		return false;
	}

	public Person getPersonById(int pid) {
		// TODO Auto-generated method stub
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		
		Person person =entityManager.find(Person.class, pid);
		
		return null;
	}

	public Person updatePersonById(int pid, Person person) {
		// TODO Auto-generated method stub
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Person person1=entityManager.find(Person.class, pid);
		
		if(person1 !=null) {
			
			person1.setPname(person.getPname());
			person1.setAge(person.getAge());
			person1.setAge(person.getAge());
			person1.setDob(person.getDob());
			person1.setEmail(person.getEmail());
			person1.setGender(person.getGender());
			person1.setPhno(person.getPhno());
			
			
			entityTransaction.begin();
			entityManager.merge(person1);
			entityTransaction.commit();
			return person1;
		}
		return null;
	}

	public List<Person> getAllPerson() {
		// TODO Auto-generated method stub
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		
	Query query=entityManager.createQuery("select u from person u");
	List<Person> person=query.getResultList();
	
		
		return person;
	}

	public List<Person> getPersonByGender(String gender) {
		// TODO Auto-generated method stub
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		
		Query query=entityManager.createQuery("select gender from person a where gender=?");
		
		query.setParameter(1, gender);
		List<Person> person=query.getResultList();
		if(person!=null) {
			person.get(0);
		
		}
		return null;
	}

	public List<Person> getPersonByAge(int age) {
		// TODO Auto-generated method stub
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		
		Query query=entityManager.createQuery("select age from person a where age=?");
		
		query.setParameter(1, age);
		List<Person> person=query.getResultList();
		if(person!=null) {
			person.get(0);
		
		}
		return null;
	}

	public List<Person> getPersonByphno(long phno) {
		// TODO Auto-generated method stub
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		
		Query query=entityManager.createQuery("select phno from person a where phno=?");
		
		query.setParameter(1, phno);
		List<Person> person=query.getResultList();
		if(person!=null) {
			person.get(0);
		}
		return null;
	}

}
