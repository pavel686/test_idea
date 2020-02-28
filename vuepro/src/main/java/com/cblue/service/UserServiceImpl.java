package com.cblue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cblue.mapper.UserMapper;
import com.cblue.pojo.User;
import com.cblue.pojo.UserExample;
import com.cblue.pojo.UserExample.Criteria;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public boolean login(User user) {
		// TODO Auto-generated method stub
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUsernameEqualTo(user.getUsername());
		criteria.andPasswordEqualTo(user.getPassword());
		List<User> users = userMapper.selectByExample(example);
		return users.size()>0;
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return userMapper.selectByExample(null);
	}

	@Override
	public List<User> getByLike(String key) {
		// TODO Auto-generated method stub
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUsernameLike("%"+key+"%");
		return userMapper.selectByExample(example);
	}

	@Override
	public User getUserById(int id) {
		return userMapper.selectByPrimaryKey(id);
	}

	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		userMapper.insert(user);
	}

}
