package com.mvn.test.controller;

import java.io.BufferedReader;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PostFormServlet
 */
@WebServlet("/postForm")
public class PostFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=utf-8");
		String name = request.getParameter("name");
		System.out.println("before BR name : " + name);
		if(name == null) {
			BufferedReader br = request.getReader();
			name = br.readLine(); // 한 줄 밖에 안 되서 그냥 대입해줌 
			System.out.println("after BR name : " + name);
		}
		response.getWriter().println("Your name : " + name);
	}
}
