package com.ty.hospital.dao;

import java.util.List;

import com.ty.hospital.dto.Item;



public interface ItemDao {
	public Item saveItem(int mid,Item item);
	public boolean deleteItemById(int iid);
	public Item getItemById(int iid);
	public Item updateItemById(int iid,Item item);
	public List<Item> getAllItem();

}
