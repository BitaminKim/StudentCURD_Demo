package com.bitam.dao.impl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bitam.dao.IUserDao;
import com.bitam.pojo.User;
import com.bitam.util.DBUtil;

public class UserDao implements IUserDao {

	@Override
	public int insertUser(User user) {
		// TODO Auto-generated method stub
		DBUtil db = new DBUtil();
		Connection con = db.getConnection();
		PreparedStatement preparedstatement = null;
		String sql;
		int count = 0;
		sql = "INSERT INTO student_user(name,sex,birthday,pic,likesome,phone,address,aboutme) VALUES(?,?,?,?,?,?,?,?)";
		try {
			preparedstatement = con.prepareStatement(sql);
			preparedstatement.setString(1, user.getName());
			preparedstatement.setString(2, user.getSex());
			preparedstatement.setDate(3, user.getBirthday());
			preparedstatement.setString(4, user.getPic());
			preparedstatement.setString(5, user.getLikesome());
			preparedstatement.setString(6, user.getPhone());
			preparedstatement.setString(7, user.getAddress());
			preparedstatement.setString(8, user.getAboutme());
			count = preparedstatement.executeUpdate();
			return count;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("sql语句有问题");
		}finally{
			if(con!=null){
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(preparedstatement != null){
				try {
					preparedstatement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return count;
	}

	@SuppressWarnings("unused")
	@Override
	public int deleteUserById(int id) {
		DBUtil db = new DBUtil();
		Connection con = db.getConnection();
		PreparedStatement preparedstatement = null;
		String sql;
		int count = 0;
		sql = "DELETE FROM `student_user` WHERE id=?";
		try {
			preparedstatement = con.prepareStatement(sql);
			preparedstatement.setInt(1, id);
			return count = preparedstatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("sql语句有问题");
		}finally{
			if(con!=null){
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(preparedstatement != null){
				try {
					preparedstatement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return 0;
	}

	@Override
	public int updateUserById(User user) {
		DBUtil db = new DBUtil();
		Connection con = db.getConnection();
		PreparedStatement preparedstatement = null;
		String sql;
		@SuppressWarnings("unused")
		int count = 0;
		sql = "UPDATE student_user SET name=?,sex=?,birthday=?,pic=?,likesome=?,phone=?,address=?,aboutme=? WHERE id=?";
		try {
			preparedstatement = con.prepareStatement(sql);
			preparedstatement.setString(1, user.getName());
			preparedstatement.setString(2, user.getSex());
			preparedstatement.setDate(3, user.getBirthday());
			preparedstatement.setString(4, user.getPic());
			preparedstatement.setString(5, user.getLikesome());
			preparedstatement.setString(6, user.getPhone());
			preparedstatement.setString(7, user.getAddress());
			preparedstatement.setString(8, user.getAboutme());
			preparedstatement.setInt(9, user.getId());
			return count = preparedstatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("sql语句有问题");
		}finally{
			if(con!=null){
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(preparedstatement != null){
				try {
					preparedstatement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return 0;
	}

	@Override
	public int selectUserCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<User> selectUserAll() {
		DBUtil db = new DBUtil();
		Connection con = db.getConnection();
		Statement statement =null;
		String sql;
		ResultSet  rs = null;
		List<User> list = new ArrayList<User>();
		sql = "SELECT * FROM `student_user`";
		try {
			statement = con.createStatement();
			rs = statement.executeQuery(sql);
			while(rs.next()){
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setSex(rs.getString("sex"));
				user.setPhone(rs.getString("phone"));
				user.setBirthday(rs.getDate("birthday"));
				user.setPic(rs.getString("pic"));
				user.setLikesome(rs.getString("likesome"));
				user.setAddress(rs.getString("address"));
				user.setAboutme(rs.getString("aboutme"));
				list.add(user);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(con!=null){
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(statement != null){
				try {
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	@Override
	public User selectUserById(int id) {
		DBUtil db = new DBUtil();
		Connection con = db.getConnection();
		PreparedStatement preparedStatement =null;
		String sql;
		ResultSet  rs = null;
		User user = new User();
		sql = "SELECT * FROM `student_user` WHERE id=?";
		try {
			preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			rs = preparedStatement.executeQuery();
			while(rs.next()){
				user.setId(id);
				user.setName(rs.getString("name"));
				user.setSex(rs.getString("sex"));
				user.setPhone(rs.getString("phone"));
				user.setBirthday(rs.getDate("birthday"));
				user.setPic(rs.getString("pic"));
				user.setLikesome(rs.getString("likesome"));
				user.setAddress(rs.getString("address"));
				user.setAboutme(rs.getString("aboutme"));
			}
			return user;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(con!=null){
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(preparedStatement != null){
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return null;
	}


}
