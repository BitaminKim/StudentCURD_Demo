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
		Connection con = null;
		PreparedStatement preparedStatement = null;
		String sql;
		int Count = 0;
		
		con = db.getConnection();
		sql = "INSERT INTO user_ssm(Username,Password,Age,Sex) VALUES(?,?,?,?)";
		try {
			preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, user.getUsername());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setInt(3, user.getAge());
			preparedStatement.setString(4, user.getSex());
			Count = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Sql语法有问题,插入数据失败");
		} finally {
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return Count;
	}

	@Override
	public int deleteUserById(int id) {
		// TODO Auto-generated method stub
		DBUtil db = new DBUtil();
		Connection con = null;
		PreparedStatement preparedStatement = null;
		String sql;
		int Count = 0;
		
		con = db.getConnection();
		sql = "DELETE FROM user_ssm WHERE id = ?";
		try {
			preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			Count = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Sql语法有问题,删除数据失败");
		} finally {
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return Count;
	}

	@Override
	public int updateUserById(User user) {
		// TODO Auto-generated method stub
		DBUtil db = new DBUtil();
		Connection con = null;
		PreparedStatement preparedStatement = null;
		String sql;
		int Count = 0;
		
		con = db.getConnection();
		sql = "UPDATE user_ssm SET Username=?,Password=?,Age=?,Sex=? WHERE id = ?";
		try {
			preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, user.getUsername());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setInt(3, user.getAge());
			preparedStatement.setString(4, user.getSex());
			preparedStatement.setInt(5, user.getId());
			Count = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Sql语法有问题，更新数据失败");
		} finally {
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return Count;
	}

	@Override
	public int selectUserCount() {
		// TODO Auto-generated method stub
		DBUtil db = new DBUtil();
		Connection con = null;
		String sql;
		ResultSet rs ;
		con = db.getConnection();
		Statement statement = null;
		int Count =0;
		try {
			try {
				statement = con.createStatement();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				System.out.println("创建提交事务失败，可能是数据库连接问题");
				throw e;
			}
			sql = "SELECT COUNT(*) FROM user_ssm";
			rs = statement.executeQuery(sql);
			while(rs.next()) {
				Count = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Sql语法有问题，查询数据共几条失败");
		} finally {
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return Count;
	}

	@Override
	public List<User> selectUserAll() {
		// TODO Auto-generated method stub
		DBUtil db = new DBUtil();
		Connection con = null;
		String sql;
		ResultSet rs ;
		con = db.getConnection();
		Statement statement = null;
		List<User> list = new ArrayList<User>() ;
		User user;
		try {
			try {
				statement = con.createStatement();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				System.out.println("创建提交事务失败，可能是数据库连接问题");
				throw e;
			}
			sql = "SELECT Id,Username,Password,Age,Sex FROM user_ssm";
			rs = statement.executeQuery(sql);
			while(rs.next()) {
				user = new User();
				user.setId(rs.getInt("Id"));
				user.setUsername(rs.getString("Username"));
				user.setPassword(rs.getString("Password"));
				user.setAge(rs.getInt("Age"));
				user.setSex(rs.getString("Sex"));
				list.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Sql语法有问题，查询数据失败");
		} finally {
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return list;
	}

	@Override
	public User selectUserById(int id) {
		// TODO Auto-generated method stub
		DBUtil db = new DBUtil();
		Connection con = null;
		String sql;
		ResultSet rs ;
		con = db.getConnection();
		PreparedStatement preparedStatement = null;
		User user = new User();
		try {
			sql = "SELECT Id,Username,Password,Age,Sex FROM user_ssm WHERE id = ?";
			preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			rs = preparedStatement.executeQuery();
			while(rs.next()) {
				user = new User();
				user.setId(id);
				user.setUsername(rs.getString("Username"));
				user.setPassword(rs.getString("Password"));
				user.setAge(rs.getInt("Age"));
				user.setSex(rs.getString("Sex"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Sql语法有问题，查询数据失败");
		} finally {
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return user;
	}

}
