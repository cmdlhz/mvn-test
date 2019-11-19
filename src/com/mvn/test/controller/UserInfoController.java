package com.mvn.test.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.mvn.test.service.UserInfoService;
import com.mvn.test.service.impl.UserInfoServiceImpl;
import com.mvn.test.vo.UserInfoVO;

/**
 * Servlet implementation class UserInfoController
 */
@WebServlet(name="/UserInfoController", urlPatterns= {"/user/*"})
public class UserInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserInfoService uis = new UserInfoServiceImpl();
	private Gson gson = new Gson();
       
    public UserInfoController() {
//    	System.out.println("난 저 위에 url을 만족해야 실행됨!");
//    	System.out.println("난 해당 메모리가 사라지기 전 1번만 실행됨!");;
    }
    
    public void init() {
//    	System.out.println("난 InitServlet() 실행 후에 실행됨!");;
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=utf-8");
		
//		System.out.println("2.doGet() @ UserInfoController");
//		System.out.println(request.getCharacterEncoding());
		List<UserInfoVO> uiList = uis.getUserList(null); // [com.mvn.test] service pkg => dao pkg =====> [config] mybatis-config.xml
		response.getWriter().print(gson.toJson(uiList));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=utf-8");
		
		List<UserInfoVO> iUser = uis.insertUser(null); // [com.mvn.test] service pkg => dao pkg =====> [config] mybatis-config.xml
		response.getWriter().print(gson.toJson(iUser));
	}

}



















