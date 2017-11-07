package com.bitam.services.impl;

import java.util.List;

import com.bitam.dao.IUserDao;
import com.bitam.dao.impl.UserDao;
import com.bitam.pojo.User;
import com.bitam.services.IUserService;

public class UserService implements IUserService {

	IUserDao iUserDao = new UserDao();
	
	@Override
	public int insertUser(User user) {
		if(user != null) {
			return iUserDao.insertUser(user);
		}else {
			return 0;
		}
	}

	@Override
	public int deleteUserById(int id) {
		return iUserDao.deleteUserById(id);
	}

	@Override
	public int updateUser(User user) {
		return iUserDao.updateUserById(user);
	}

	@Override
	public int selectUserCount() {
		return iUserDao.selectUserCount();
	}

	@Override
	public List<User> selectUserAll() {
		return iUserDao.selectUserAll();
	}

	@Override
	public User selectUserById(int id) {
		return iUserDao.selectUserById(id);
	}

}
