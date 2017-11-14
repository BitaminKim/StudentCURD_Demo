package com.bitam.services.impl;

import java.util.List;

import com.bitam.dao.IUserDao;
import com.bitam.dao.impl.UserDao;
import com.bitam.pojo.User;
import com.bitam.services.IUserService;

public class UserService implements IUserService {

	IUserDao iUserDao = new UserDao();
	
	@Override
	public String insertUser(User user) {
		int count = iUserDao.insertUser(user);
		if(count==1) {
			return "保存成功";
		}
		return "保存失败";
		
	}

	@Override
	public int deleteUserById(int id) {
		return iUserDao.deleteUserById(id);
	}

	@Override
	public String updateUser(User user) {
		if(iUserDao.updateUserById(user)==1) {
			return "修改成功";
		}
		return "修改失败";
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
