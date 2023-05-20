package com.ty.hospital.dao;

import java.util.List;

import com.ty.hospital.dto.User;

public interface UserDao {

	public  User saveUser(User user);
	public boolean deletUserById(int uid);
	public User getUserById(int uid);
	public User updateUserById(int uid,User user);
	public List<User> getAllUser();
	public List<User> getUserByName(String name);
	public List<User> getUserByRole(String role);
	
}
