package com.bitam.services;

import java.util.List;

import com.bitam.pojo.User;

public interface IUserService {

	String insertUser(User user);

	int deleteUserById(int id);

	String updateUser(User user);

	int selectUserCount();

	List<User> selectUserAll();

	User selectUserById(int id);
}
