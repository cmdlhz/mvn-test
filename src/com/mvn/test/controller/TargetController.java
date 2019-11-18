package com.mvn.test.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/target")
public class TargetController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] as = request.getParameterValues("a");
		List<String> strList = new ArrayList<>();
		for(String a:as) {
			strList.add(a);
			System.out.println(a);
		}
		request.setAttribute("list", strList);
		
//		List<String> strList = new ArrayList<>();
//		strList.add("Jen");
//		strList.add("Kyle");
//		strList.add("Jo");

		// request.setAttribute("list", strList);
		// sesson.setAttribute("list", strList);
//		RequestDispatcher rd = request.getRequestDispatcher("/target");
		// target controller를 타게 됨 (만들어야 함!)
		// "/target.jsp"라고 하면 컨트롤러를 안 탐 
//		rd.forward(request, response);
		
//		String path = "/final.jsp";
//		String path = "/WEB-INF/views/final.jsp";
		String path = "/views/final"; // views controller를 추가적으로 타면 됨
		// 한 class는 한 가지 일만 한다!
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
