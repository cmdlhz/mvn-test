package com.mvn.test.controller;

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

import com.google.gson.Gson;
import com.mvn.test.service.FileTestService;
import com.mvn.test.service.impl.FileTestServiceImpl;

@WebServlet(name="/FileServlet2", urlPatterns= {"/file/*"})
public class FileServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FileTestService fts = new FileTestServiceImpl();
	private Gson gson = new Gson();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=utf-8");
		
		String cmd = request.getRequestURI().substring(6); // /file/
		String json = "";
		
		if("list".equals(cmd)) {
			json = gson.toJson(fts.getFileList(null));
		}
		response.getWriter().print(json);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int memSize = 1024 * 1024 * 5;
		int totalSize = 1024 * 1024 * 50;
		int fileSize = 1024 * 1024 * 10;
		
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
						 // 파일 자체가 담기는 것 ==> 그래서 Object로 넘김
						 param.put(key, fi);
//						 String path = "C:\\Users\\Administrator\\eclipse-workspace\\mvn-test\\WebContent\\img";
//						 String fileName = fi.getName();
//						 File targetFile = new File(path + "\\" + fileName);
//						 fi.write(targetFile);
					 }
				 }
				 fts.insertFileTest(param);
				 // {fileField=
				 //		name=Koala.jpg, StoreLocation=null, size=780831 bytes, isFormField=false, FieldName=fileField, 
				 // id=
				 //		jlim33}
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else {
			throw new ServletException("파일 형식이 잘못되었습니다.");
		}
	}

}
