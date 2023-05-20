package com.ty.hospital.service;
import com.ty.hospital.dao.ipm.ItemDaoImp;
import com.ty.hospital.dto.Item;

public class ItemService {

	public void saveItem(int mid,Item item) {
		ItemDaoImp itemDaoImp = new ItemDaoImp();
		Item item2 = itemDaoImp.saveItem(mid,item);
		if(item2!=null) {
			System.out.println("Data saved successfully");
		}
		else {
			System.out.println("Sorry,Data cannot be saved");
		}
	}
	
	public void deleteItemById(int iId) {
		ItemDaoImp hospitalDaoImp = new ItemDaoImp();
		boolean flag = hospitalDaoImp.deleteItemById(iId);
		if(flag) {
			System.out.println("data deleted successfully");
		}
		else {
			System.out.println("data not deleted");
		}
	}
	
	public Item getItemById(int iId) {
		ItemDaoImp itemDaoImp = new ItemDaoImp();
		Item item = itemDaoImp.getItemById(iId);
		if(item!=null) {
			return item;
		}
		else {
			return null;
		}
	}
}