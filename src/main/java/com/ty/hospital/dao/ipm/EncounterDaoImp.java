package com.ty.hospital.dao.ipm;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.hospital.dao.EncounterDao;
import com.ty.hospital.dto.Branch;
import com.ty.hospital.dto.Encounter;
import com.ty.hospital.dto.Person;

public class EncounterDaoImp implements EncounterDao {

	public Encounter saveEncounter(int bid, int pid, Encounter encounter) {
		
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Branch branch=entityManager.find(Branch.class, bid);
		Person person=entityManager.find(Person.class, pid);
		if(branch!=null&&person !=null) {
			entityTransaction.begin();
			entityManager.persist(encounter);
			entityTransaction.commit();
			return encounter;
		}
		return null;
	}

	public boolean deleteEncounterById(int eid) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Encounter encounter=entityManager.find(Encounter.class,eid);
		if(encounter!=null) {
			entityTransaction.begin();
			entityManager.remove(encounter);
			entityTransaction.commit();
			return true;
		}
		
		return false;
	}

	public Encounter getEncounterById(int eid) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Encounter encounter=entityManager.find(Encounter.class, eid);
		
		return encounter;
	}

	public Encounter updateEncounterById(int eid, Encounter encounter) {
		// TODO Auto-generated method stub
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Encounter encounter1=entityManager.find(Encounter.class, eid);
		
		if(encounter1 !=null) {
			
			encounter1.setDateOfJoin(encounter.getDateOfJoin());
			encounter1.setDateOfDischarge(encounter.getDateOfDischarge());
			encounter1.setBranch(encounter.getBranch());
			entityTransaction.begin();
			entityManager.merge(encounter1);
			entityTransaction.commit();
			return encounter1;
		}
		return null;
	}

	public List<Encounter> getAllEncounter() {
		// TODO Auto-generated method stub
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		
	Query query=entityManager.createQuery("select u from encounter u");
	List<Encounter> encounter=query.getResultList();
	
		
		return encounter ;

	}

}
