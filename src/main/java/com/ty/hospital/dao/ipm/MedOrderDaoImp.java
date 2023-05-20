package com.ty.hospital.dao.ipm;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.hospital.dao.MedOrderDao;
import com.ty.hospital.dto.Encounter;
import com.ty.hospital.dto.MedOrder;

public class MedOrderDaoImp implements MedOrderDao {

	public MedOrder saveMedorder(int eid, MedOrder medorder) {
		// TODO Auto-generated method stub
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Encounter encounter=entityManager.find(Encounter.class, eid);
		
		if(encounter!=null) {
			entityTransaction.begin();
			entityManager.persist(medorder);
			entityTransaction.commit();
		}
		return null;
	}

	public boolean deleteMedOrderById(int mid) {
		// TODO Auto-generated method stub
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		MedOrder medorder=entityManager.find(MedOrder.class, mid);
		if(medorder!=null) {
			entityTransaction.begin();
			entityManager.remove(medorder);
			entityTransaction.commit();
			return true;
		}
		return false;
	}

	public MedOrder getMedOrderById(int mid) {
		// TODO Auto-generated method stub
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		
		MedOrder medorder=entityManager.find(MedOrder.class, mid);
		
		return null;
	}

	public MedOrder updateMedOrderById(int mid, MedOrder medorder) {
		// TODO Auto-generated method stub
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		MedOrder medorder2=entityManager.find(MedOrder.class, mid);
		if(medorder2!=null) {
			medorder2.setDname(medorder.getDname());
			medorder2.setOrderDate(medorder.getOrderDate());
			medorder2.setTotal(medorder.getTotal());
			
			entityTransaction.begin();
			entityManager.merge(medorder2);
			entityTransaction.commit();
			return medorder2;
			
		}
		return null;
	}

	public List<MedOrder> getAllMedorderById() {
		// TODO Auto-generated method stub
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		
		Query query=entityManager.createQuery("select a from medorder a");
		
		List<MedOrder> medorder=query.getResultList();
		
		return null;
	}

	public MedOrder getAllMedOrderByDoctorName(String dname) {
		// TODO Auto-generated method stub
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		
		Query query=entityManager.createQuery("select dname from medorder a where dname=?");
		
		query.setParameter(1, dname);
		List<MedOrder> medorder =query.getResultList();
		if(medorder!=null) {
			medorder.get(0);
			
		}
		return null;
	}

	public MedOrder getAllMedOrderByDate(String orderdate) {
		// TODO Auto-generated method stub
		
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		
		Query query=entityManager.createQuery("select orderDate from medorder a where orderDate=?");
		List<MedOrder> medOrder=query.getResultList();
		if(medOrder!=null) {
			medOrder.get(0);
		}
		return null;
	}

}
