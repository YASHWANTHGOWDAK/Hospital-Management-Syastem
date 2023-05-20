package com.ty.hospital.service;
import com.ty.hospital.dao.ipm.MedOrderDaoImp;
import com.ty.hospital.dto.MedOrder;

public class MedOrderService {

	public void saveMedOrder(int eid,MedOrder medOrder) {
		MedOrderDaoImp medOrderDaoImp = new MedOrderDaoImp();
		MedOrder medOrder2 = medOrderDaoImp.saveMedorder(eid,medOrder);
		if(medOrder2!=null) {
			System.out.println("Data saved successfully");
		}
		else {
			System.out.println("Sorry,Data cannot be saved");
		}
	}

	
	public void deleteMedOrderById(int mid) {
		MedOrderDaoImp medOrderDaoImp = new MedOrderDaoImp();
		boolean flag = medOrderDaoImp.deleteMedOrderById(mid);
		if(flag) {
			System.out.println("data deleted successfully");
		}
		else {
			System.out.println("data not deleted");
		}
	}

	public MedOrder updateMedOrderById(int mid,MedOrder medOrder) {
		MedOrderDaoImp medOrderDaoImp = new MedOrderDaoImp();
		MedOrder medOrder2 = medOrderDaoImp.updateMedOrderById(mid,medOrder);
		if(medOrder2!=null) {
			return medOrder2;
		}
		else {
			return null;
		}
	}
	
	public MedOrder getMedOrderById(int mid) {
		MedOrderDaoImp medOrderDaoImp = new MedOrderDaoImp();
		MedOrder  medOrder = medOrderDaoImp.getMedOrderById(mid);
		if(medOrder!=null) {
			return medOrder;
		}
		else {
			return null;
		}
	}
}