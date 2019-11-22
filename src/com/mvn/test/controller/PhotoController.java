package com.mvn.test.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.ibatis.session.SqlSession;

import com.google.gson.Gson;
import com.mvn.test.service.PhotoBoardService;
import com.mvn.test.service.impl.PhotoBoardServiceImpl;
import com.mvn.test.vo.PhotoBoardVO;

@WebServlet(name="/PhotoController", urlPatterns= {"/photo/*"})
public class PhotoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private PhotoBoardService pbs = new PhotoBoardServiceImpl();
    private Gson gson = new Gson();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=utf-8");
		
		String cmd = request.getRequestURI().substring(7); // /photo/
		String json = "";
		
		if("list".contentEquals(cmd)) {
			json = gson.toJson(pbs.getPhotoList(null));
		} else if("view".contentEquals(cmd)) {
			System.out.println("Controller 성공");
			int pbNum = Integer.parseInt(request.getParameter("pbNum"));
			PhotoBoardVO photo = new PhotoBoardVO();
			
			photo.setPbNum(pbNum);
			System.out.println("photo set : " + photo); // pbNum 입력
			
			json = gson.toJson(pbs.getPhoto(photo)); // service
			System.out.println("pbs.getPhoto(photo) : " + pbs.getPhoto(photo));
			System.out.println("json : " + json); // 여기서 json 형태로 찍히게 됨
		}
		response.getWriter().print(json);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=utf-8");
		
		BufferedReader br = request.getReader();
		String str = null;
//		StringBuffer json = new StringBuffer();
		String json = "";
		while((str=br.readLine()) != null) {
			// json.append(str);
			json += str;
		}
		
		PhotoBoardVO photo = new PhotoBoardVO();
		String cmd = request.getRequestURI().substring(7); // /photo/
		
		if("insert".contentEquals(cmd)) {
			
			int memSize = 1024 * 1024 * 5;
			int totalSize = 1024 * 1024 * 400;
			int fileSize = 1024 * 1024 * 400;
			
			DiskFileItemFactory dfif = new DiskFileItemFactory();
			dfif.setSizeThreshold(memSize);
			
			dfif.setRepository(new File(System.getProperty("java.io.tmpdir")));
			
			ServletFileUpload sfu = new ServletFileUpload(dfif);
			sfu.setFileSizeMax(fileSize);
			sfu.setSizeMax(totalSize);
			
			if(ServletFileUpload.isMultipartContent(request)) {
				try {
					 List<FileItem> fList = sfu.parseRequest(request);
					 Map<String, Object> param = new HashMap<>();
					 for(FileItem fi:fList) {
						 String key = fi.getFieldName();
						 if(fi.isFormField()) {
							 String value = fi.getString("utf-8");
							 param.put(key, value);
							 System.out.println(key + " : " + value);
						 } else {
							 param.put(key, fi);
						 }
					 }
					 System.out.println("param : " + param);
					 // 여기가 문제인 것 같은데...
					// Service로 넘어가기
					 pbs.insertPhoto(param);
				} catch(Exception e) {
					e.printStackTrace();
				}
			} else {
				throw new ServletException("파일 형식이 잘못되었습니다.");
			}
		} else if("update".contentEquals(cmd)) {
			photo = gson.fromJson(json, PhotoBoardVO.class);
			json = gson.toJson(pbs.updatePhoto(photo));
		} else if("delete".contentEquals(cmd)) {
			photo = gson.fromJson(json, PhotoBoardVO.class);
			json = gson.toJson(pbs.deletePhoto(photo));
		}
		response.getWriter().print(json);
	}
	// 넣어주지 않은 것은 null로 들어감
}













