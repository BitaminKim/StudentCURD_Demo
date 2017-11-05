package com.bitam.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bitam.services.IUserService;
import com.bitam.services.impl.UserService;

public class DeleteUserById extends HttpServlet{

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
		StringBuilder sb = new StringBuilder();
		String ln = "\r\n";
		sb.append("<!DOCTYPE html>"+ln);
		sb.append("<html lang=\"zh_cn\">"+ln);
		sb.append("<head><meta charset=\"utf-8\" /></head>"+ln);
		sb.append("<body>"+ln);
		//sb.append("<table align='center' border='1' cellspacing='0'>\r\n""+ln);
		//sb.append("<tr><td>id</td><td>username</td><td>password</td><td>age</td><td>sex</td></tr>"+ln);
		//String formatstr = "<tr><td>%d</td><td>%s</td><td>%s</td><td>%d</td><td>%s</td></tr>"+ln;		
		sb.append("<h1>删除了"+iUserService.deleteUserById(Integer.valueOf(req.getParameter("Id")).intValue())+"条记录</1>"+ln);
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
