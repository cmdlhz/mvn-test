package com.mvn.test.common;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class ServletFileUtil {
	private static final String path= "C:\\Users\\Administrator\\eclipse-workspace\\mvn-test\\WebContent\\img\\";
	private static final int memSize = 1024 * 1024 * 5;
	private static final int totalSize = 1024 * 1024 * 400;
	private static final int fileSize = 1024 * 1024 * 400;
	
	// 원래는 final이면 다 대문자로 적어줘야 함
	private static final DiskFileItemFactory dfif = new DiskFileItemFactory();
	private static final ServletFileUpload sfu;
	
	static {
		dfif.setSizeThreshold(memSize);
		dfif.setRepository(new File(System.getProperty("java.io.tmpdir")));
		sfu = new ServletFileUpload(dfif);
		sfu.setFileSizeMax(fileSize);
		sfu.setSizeMax(totalSize);	
	}
	
	public static Map<String, Object> parseRequest(HttpServletRequest request) throws ServletException{
		Map<String, Object> param = new HashMap<>();
		
		if(ServletFileUpload.isMultipartContent(request)) {
			try {
				 List<FileItem> fList = sfu.parseRequest(request);
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
//				 Map<String, String> rMap = pbs.insertPhoto(param);
//				 json = gson.toJson(rMap);
//				 response.getWriter().print(json);
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else {
			throw new ServletException("파일 형식이 잘못되었습니다.");
		}
		
		return param;
	}
	public static String saveFile(FileItem fi) throws Exception {
		String fileName = fi.getName();
		fileName = System.nanoTime() + fileName.substring(fileName.lastIndexOf("."));
		// . 앞에 파일명을 nanoTime을 바꾸기 위해
		File f = new File(path + fileName);
		fi.write(f);
		return fileName;
	}
}
