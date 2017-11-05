package com.bitam.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bitam.pojo.User;
import com.bitam.services.IUserService;
import com.bitam.services.impl.UserService;

public class SelectUserAll extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		IUserService iUserService = new UserService();
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");
		List<User> list = iUserService.selectUserAll();
		StringBuilder sb = new StringBuilder();
		String ln = "\r\n";
		String str;
		sb.append("<!DOCTYPE html>"+ln);
		sb.append("<html lang=\"zh_cn\">"+ln);
		sb.append("<head><meta charset=\"utf-8\" /></head>"+ln);
		sb.append("<body>"+ln);
		sb.append("<table align='center' border='1' cellspacing='0'>");
		sb.append("<tr><td>id</td><td>username</td><td>password</td><td>age</td><td>sex</td></tr>"+ln);
		String formatstr = "<tr><td>%d</td><td>%s</td><td>%s</td><td>%d</td><td>%s</td></tr>\t\n";	
		for(User user : list) {
			str = String.format(formatstr, user.getId(),user.getUsername(),user.getPassword(),user.getAge(),user.getSex());
			sb.append(str);
		}
		sb.append("</table>");
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
