package com.bitam.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.bitam.pojo.User;
import com.bitam.services.IUserService;
import com.bitam.services.impl.UserService;

public class SaveStudent extends HttpServlet {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=utf-8");
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=utf-8");
		User user = new User();
		PrintWriter out=resp.getWriter();
		
	    String path = getServletContext().getRealPath("/upload");
	    String tmpPath = getServletContext().getRealPath("/tmp");
	    DiskFileItemFactory dfif = new DiskFileItemFactory();
	    dfif.setSizeThreshold(1024*1024*10);
	    dfif.setRepository(new File(tmpPath));
	    ServletFileUpload up = new ServletFileUpload(dfif);
	    try {
	    	String fileName;
	        List<FileItem> list = up.parseRequest(req);
	        for (FileItem fileItem : list) {
	        	if (!fileItem.isFormField()) {
		        	fileName = fileItem.getName();
		        	InputStream input = fileItem.getInputStream();
		        	OutputStream output = new FileOutputStream(path+"/"+fileName);
			        //文件copy
			        byte[] b = new byte[1024];
			        int len = 0;
			        while((len=input.read(b))!=-1){
			            output.write(b, 0, len);
			        }
			        user.setPic(fileName);
			        output.flush(); 
			        output.close();
	        	}else{
	        		if ("name".equals(fileItem.getFieldName())) {
	        			user.setName(fileItem.getString("UTF-8"));
                    }
	        		if ("sex".equals(fileItem.getFieldName())) {
	        			user.setSex(fileItem.getString("UTF-8"));
                    }
	        		if ("birthday".equals(fileItem.getFieldName())) {
	        			try {
							user.setBirthday(new Date(new SimpleDateFormat("yyyy-MM-dd").parse(fileItem.getString("UTF-8")).getTime()));
						} catch (ParseException e) {
							e.printStackTrace();
						}
                    }
	        		if ("likesome".equals(fileItem.getFieldName())) {
	        			String str = fileItem.getString("UTF-8");
//	        			StringBuilder sb = new StringBuilder();
//	        			if(str!=null){
//	        				for(int i=0;i<str.length;i++){
//	        					if(i==str.length-1){
//	        						sb.append(str[i]);
//	        					}else{
//	        						sb.append(str[i]+",");
//	        					}
//	        				}
//	        			}
//	        			user.setLikesome(sb.toString());
	        			user.setLikesome(str);
                    }
	        		if ("phone".equals(fileItem.getFieldName())) {
	        			user.setPhone(fileItem.getString("UTF-8"));
                    }
	        		if ("address".equals(fileItem.getFieldName())) {
	        			user.setAddress(fileItem.getString("UTF-8"));
                    }
	        		if ("aboutme".equals(fileItem.getFieldName())) {
	        			user.setAboutme(fileItem.getString("UTF-8"));
                    }
	        	}
			}
	        
	    } catch (FileUploadException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
		
		
//		user.setName(req.getParameter("name"));
//	    user.setSex(req.getParameter("sex"));
//		user.setPic(req.getParameter("pic"));
//		try {
//			user.setBirthday(new Date(new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("birthday")).getTime()));
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
		
//		String[] str = req.getParameterValues("likesome");
//		StringBuilder sb = new StringBuilder();
//		if(str!=null){
//			for(int i=0;i<str.length;i++){
//				if(i==str.length-1){
//					sb.append(str[i]);
//				}else{
//					sb.append(str[i]+",");
//				}
//			}
//		}
//		user.setLikesome(sb.toString());
//		user.setPhone(req.getParameter("phone"));
//		user.setAddress(req.getParameter("address"));
//		user.setAboutme(req.getParameter("aboutme"));
		
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
}
