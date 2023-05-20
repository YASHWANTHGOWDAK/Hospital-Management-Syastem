
package com.ty.hospital.service;
import com.ty.hospital.dao.ipm.UserDaoImp;
import com.ty.hospital.dto.User;

public class UserService {

	public void saveUser(User user) {
		UserDaoImp userDaoImp = new UserDaoImp();
		User user2 = userDaoImp.saveUser(user);
		if(user2!=null) {
			System.out.println("Data saved successfully");
		}
		else {
			System.out.println("Sorry,Data cannot be saved");
		}
	}
	
	public void deleteUserById(int uid) {
		UserDaoImp userDaoImp = new UserDaoImp();
		boolean flag = userDaoImp.deletUserById(uid);
		if(flag) {
			System.out.println("data deleted successfully");
		}
		else {
			System.out.println("data not deleted");
		}
	}
	
	public User getUserById(int uid) {
		UserDaoImp observationDaoImp = new UserDaoImp();
		User user = observationDaoImp.getUserById(uid);
		if(user!=null) {
			return user;
		}
		else {
			return null;
		}
	}
}