package com.ty.hospital.dao.ipm;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;



import com.ty.hospital.dao.ItemDao;
import com.ty.hospital.dto.Branch;
import com.ty.hospital.dto.Hospital;
import com.ty.hospital.dto.Item;
import com.ty.hospital.dto.MedOrder;
import com.ty.hospital.dto.Person;

public class ItemDaoImp  implements ItemDao{

	public Item saveItem(int mid, Item item) {
		// TODO Auto-generated method stub
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		MedOrder medorder=entityManager.find(MedOrder.class, mid);
		if(medorder!=null) {
			entityTransaction.begin();
			entityManager.persist(item);
			entityTransaction.commit();
		}
		return null;
	}

	public boolean deleteItemById(int iid) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Item item=entityManager.find(Item.class,iid);
		if(item!=null) {
			entityTransaction.begin();
			entityManager.remove(item);
			entityTransaction.commit();
			return true;
		}
		
		// TODO Auto-generated method stub
		return false;
	}

	public  Item getItemById(int iid) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		
		Item item =entityManager.find(Item.class, iid);
		
		// TODO Auto-generated method stub
		return null;
	}

	public Item updateItemById(int iid, Item item) {
		// TODO Auto-generated method stub
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Item item1=entityManager.find(Item.class, iid);
		
		if(item1 !=null) {
			item1.setItemname(item.getItemname());
			item1.setCost(item.getCost());
			item1.setOrder(item.getOrder());
			item1.setQuantity(item.getQuantity());
		
			entityTransaction.begin();
			entityManager.merge(item1);
			entityTransaction.commit();
			return item1;
		}
			
			
			
		
		return null;
	}

	public List<Item> getAllItem() {
		// TODO Auto-generated method stub
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		
	Query query=entityManager.createQuery("select u from item u");
	List<Item> item=query.getResultList();
		return item;
	}

}
