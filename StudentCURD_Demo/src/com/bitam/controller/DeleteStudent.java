package com.bitam.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bitam.services.IUserService;
import com.bitam.services.impl.UserService;

public class DeleteStudent extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=utf-8");
		IUserService iUserService = new UserService();
		int id =Integer.valueOf(req.getParameter("id")).intValue();
		iUserService.deleteUserById(id);
		
		PrintWriter out=resp.getWriter();
		out.print("<script language='javascript'>alert('删除成功');"
				+ "window.location.href='SelectStudent';</script>");
		out.close();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
}
