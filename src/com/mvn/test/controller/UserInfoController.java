package com.mvn.test.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;

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
		
		String cmd = request.getRequestURI().substring(6);  // /user/
		String json = "";
		
		if("list".contentEquals(cmd)) {
			List<UserInfoVO> uiList = uis.getUserList(null);
			json = gson.toJson(uiList);
			
		}else if("view".contentEquals(cmd)) {
			int uiNum = Integer.parseInt(request.getParameter("uiNum"));
			// System.out.println(uiNum); // 61
			UserInfoVO user = new UserInfoVO();
//			System.out.println("user : " + user);
			user.setUiNum(uiNum);
			System.out.println("user set : " + user);
			json = gson.toJson(user);
		}
		response.getWriter().print(json);
		
//		System.out.println("2.doGet() @ UserInfoController");
//		System.out.println(request.getCharacterEncoding());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=utf-8");
		
		BufferedReader br = request.getReader();
		String str = null;
//		StringBuffer json = new StringBuffer();
		String json = "";
		while((str=br.readLine()) != null) {
//			json.append(str);
			json += str;
		}
		UserInfoVO user = gson.fromJson(json, UserInfoVO.class);
		
		Map<String,String> rMap = uis.insertUser(user);
		json = gson.toJson(rMap);
		response.getWriter().print(json);
	}
	// 넣어주지 않은 것은 null로 들어감
}



















