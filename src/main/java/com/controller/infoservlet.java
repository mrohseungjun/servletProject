package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class infoservlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String name = req.getParameter("name");
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		String phone = req.getParameter("phone");
		String address = req.getParameter("address");
		
		// 객채를 직접 만들어서 상ㅇ한 예시
//		req.setAttribute("name", name);
//		req.setAttribute("id", id);
//		req.setAttribute("pwd", pwd);
//		req.setAttribute("phone", phone);
//		req.setAttribute("address", address);
		
		//set을 사용한 예시
//		info info = new info();
//		info.setName(name);
//		info.setAddress(address);
//		info.setId(id);
//		info.setPhone(phone);
		
		info info = new info(name, id, pwd, phone, address);
		req.setAttribute("info", info);		
		
		RequestDispatcher rd = req.getRequestDispatcher("inforResult.jsp");
		rd.forward(req,resp);

	}
	

}
