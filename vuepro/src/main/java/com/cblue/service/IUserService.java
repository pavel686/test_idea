package com.cblue.service;

import java.util.List;

import com.cblue.pojo.User;

public interface IUserService {
	
	public boolean login(User user);
	
	public List<User> getAll();

	public List<User> getByLike(String key);

	public User getUserById(int id);
	
	public void save(User user);
}
