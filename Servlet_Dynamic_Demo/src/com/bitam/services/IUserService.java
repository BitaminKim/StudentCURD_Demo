package com.bitam.services;

import java.util.List;

import com.bitam.pojo.User;

public interface IUserService {

	int insertUser(User user);

	int deleteUserById(int id);

	int updateUserById(int id, User user);

	int selectUserCount();

	List<User> selectUserAll();

	User selectUserById(int id);
}
