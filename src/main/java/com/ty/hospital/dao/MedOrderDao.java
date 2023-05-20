package com.ty.hospital.dao;

import java.util.List;

import com.ty.hospital.dto.MedOrder;

public interface MedOrderDao {
	public MedOrder saveMedorder(int eid,MedOrder medorder);
	public boolean deleteMedOrderById(int mid);
	public MedOrder getMedOrderById(int mid);
	public MedOrder updateMedOrderById(int mid,MedOrder medorder);
	public List<MedOrder> getAllMedorderById();
	public MedOrder getAllMedOrderByDoctorName(String dname);
	public MedOrder getAllMedOrderByDate(String orderdate);

}
