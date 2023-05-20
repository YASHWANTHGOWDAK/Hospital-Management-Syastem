package com.ty.hospital.dao.ipm;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.hospital.dao.ObservationDao;
import com.ty.hospital.dto.Encounter;
import com.ty.hospital.dto.Observation;

public class ObservationDaoImp implements ObservationDao{

	public Observation saveObservation(int eid, Observation observation) {
		// TODO Auto-generated method stub
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
	Encounter encounter=entityManager.find(Encounter.class, eid);

		if(encounter!=null) {
			entityTransaction.begin();
			entityManager.persist(observation);
			entityTransaction.commit();
			return observation ;
		}
		return null;
	}

	public boolean deleteObservationById(int oid) {
		// TODO Auto-generated method stub
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Observation observation=entityManager.find(Observation.class,oid);
		if(observation!=null) {
			entityTransaction.begin();
			entityManager.remove(observation);
			entityTransaction.commit();
			return true;
		}
		
		return false;
	}

	public Observation getObsservationById(int oid) {
		// TODO Auto-generated method stub
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		
		Observation observation =entityManager.find(Observation.class, oid);
		
		return observation;
	}

	public Observation updateObservationById(int oid, Observation observation) {
		// TODO Auto-generated method stub
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Observation observation1=entityManager.find(Observation.class, oid);
		
		if(observation1 !=null) {
			
			observation1.setDname(observation.getDname());
			observation1.setR_observation(observation1.getR_observation());
			entityTransaction.begin();
			entityManager.merge(observation1);
			entityTransaction.commit();
			return observation1;
		}
		return null;
	}

	public List<Observation> getObservation() {
		// TODO Auto-generated method stub
		
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		
	Query query=entityManager.createQuery("select u from observation u");
	List<Observation> observation=query.getResultList();
	
		
		return observation;
		
	}

	public Observation getObservationByDoctorName(String dname) {
		// TODO Auto-generated method stub
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		
		Query query=entityManager.createQuery("select dname from observation a where dname=?");
		
		query.setParameter(1, dname);
		List<Observation> observation=query.getResultList();
		if(observation!=null) {
			observation.get(0);
		}
		return null;
	}

}
