package com.bitam.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bitam.pojo.User;
import com.bitam.services.IUserService;
import com.bitam.services.impl.UserService;

public class UpdateForward extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		IUserService iUserService = new UserService();
		int id = Integer.valueOf(req.getParameter("id")).intValue();
		User user = iUserService.selectUserById(id);
		req.setAttribute("user", user);
//		String[] like = user.getLikesome().split(",");
//		req.setAttribute("likesome",like );
		req.getRequestDispatcher("update.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
