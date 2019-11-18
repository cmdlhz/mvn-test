package com.mvn.test.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvn.test.service.UserInfoService;
import com.mvn.test.service.impl.UserInfoServiceImpl;

/**
 * Servlet implementation class UserInfoController
 */
@WebServlet(name="/UserInfoController", urlPatterns= {"/user/*"})
public class UserInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserInfoService uis = new UserInfoServiceImpl();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Map<String, String>> uiList = uis.getUserList(null);
		response.getWriter().print(uiList);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
