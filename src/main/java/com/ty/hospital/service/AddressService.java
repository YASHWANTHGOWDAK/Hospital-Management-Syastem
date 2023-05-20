package com.ty.hospital.service;

import com.ty.hospital.dao.ipm.AddressDaoImp;
import com.ty.hospital.dto.Address;

public class AddressService {
	
	public void saveAddress(int bid,Address address) {
		AddressDaoImp addressDaoImp=new AddressDaoImp();
		Address address1=addressDaoImp.saveAddress(bid, address);
		if(address1!=null) {
			System.out.println("Data Saved Sucessfulluy");
		}
		else {
			System.out.println("Sorry,Data can't be saved");
		}
	}
	public void deletAddressById(int aid) {
		
		AddressDaoImp addressDaoImp=new AddressDaoImp();
		boolean flag=addressDaoImp.deleteAddressById(aid);
		if(flag) {
			System.out.println(("data Deleted sucessfully"));
			
		}
		else
		{
			System.out.println("Data can't be Deleted");
		}
	}	
	public Address updDateAddressById(int aid,Address address) {
		AddressDaoImp addressDaoImp=new AddressDaoImp();
		Address address2=addressDaoImp.updateAddressById(aid, address);
		if(address2!=null) {
			return address2;
		}
		else {
			return null;
		}
	}
	public Address getAddressById ( int aid) {
		AddressDaoImp addressDaoImp=new AddressDaoImp();
		Address address=addressDaoImp.getAddressById(aid);
		if(address!=null) {
			return address;
		}
		else {
			return null;		
	   }
	}
}
