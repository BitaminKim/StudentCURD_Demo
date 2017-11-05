package com.bitam.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bitam.pojo.User;
import com.bitam.services.IUserService;
import com.bitam.services.impl.UserService;

public class InsertUser extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User user = new User();
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");
		IUserService iUserService = new UserService();
		user.setId(0);
		user.setUsername(req.getParameter("Username"));
		user.setPassword(req.getParameter("Password"));
		user.setAge(Integer.valueOf(req.getParameter("Age")).intValue());
		user.setSex(req.getParameter("Sex"));
		
		StringBuilder sb = new StringBuilder();
		String ln = "\r\n";
		sb.append("<!DOCTYPE html>"+ln);
		sb.append("<html lang=\"zh_cn\">"+ln);
		sb.append("<head><meta charset=\"utf-8\" /></head>"+ln);
		sb.append("<body>"+ln);
		//sb.append("<tr><td>id</td><td>username</td><td>password</td><td>age</td><td>sex</td></tr>"+ln);
		//String formatstr = "<tr><td>%d</td><td>%s</td><td>%s</td><td>%d</td><td>%s</td></tr>"+ln;	
		sb.append("<h1>插入了"+iUserService.insertUser(user)+"条记录</1>"+ln);
		sb.append("</body>"+ln);
		sb.append("</html>");
		resp.getWriter().println(sb);
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
}
