package com.bitam.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bitam.pojo.User;
import com.bitam.services.IUserService;
import com.bitam.services.impl.UserService;

public class SaveStudent1 extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=utf-8");
		User user = new User();
		PrintWriter out=resp.getWriter();
		user.setName(req.getParameter("name"));
		user.setSex(req.getParameter("sex"));
		user.setPic(req.getParameter("pic"));
		try {
			user.setBirthday(new Date(new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("birthday")).getTime()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		String[] str = req.getParameterValues("likesome");
		StringBuilder sb = new StringBuilder();
		if(str!=null){
			for(int i=0;i<str.length;i++){
				if(i==str.length-1){
					sb.append(str[i]);
				}else{
					sb.append(str[i]+",");
				}
			}
		}
		user.setLikesome(sb.toString());
		user.setPhone(req.getParameter("phone"));
		user.setAddress(req.getParameter("address"));
		user.setAboutme(req.getParameter("aboutme"));
		
		System.out.println(user);
		IUserService userService = new UserService();
		String message = userService.insertUser(user);
		if(message =="保存成功") {
			out.print("<script language='javascript'>alert('"+message+"');"
					+ "window.location.href='SelectStudent';</script>");
		}else {
			out.print("<script language='javascript'>alert('"+message+"');"
					+ "window.location.href='index.jsp';</script>");
		}
		
		out.close();

		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
}
