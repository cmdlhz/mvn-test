package com.mvn.test.service.impl;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.fileupload.FileItem;
import org.apache.ibatis.session.SqlSession;

import com.mvn.test.controller.InitServlet;
import com.mvn.test.dao.FileTestDAO;
import com.mvn.test.dao.impl.FileTestDAOImpl;
import com.mvn.test.service.FileTestService;
import com.mvn.test.vo.FileTestVO;

public class FileTestServiceImpl implements FileTestService {
	private FileTestDAO ftdao = new FileTestDAOImpl();
	private String path = "C:\\Users\\Administrator\\eclipse-workspace\\mvn-test\\WebContent\\img";
	
	public List<FileTestVO> getFileList(Map<String, String> file){
		return ftdao.selectFileList(file);
	}
	
	@Override
	public Map<String, String> insertFileTest(Map<String, Object> param) {
		SqlSession ss = InitServlet.getSqlSession();
		try {
			String ftName = (String)param.get("ftName");
			String ftId = (String)param.get("ftId");
			FileItem fi = (FileItem)param.get("ftFile");
			Map<String, String> fileTest = new HashMap<>();
			fileTest.put("ftName", ftName);
			fileTest.put("ftId", ftId);
			fileTest.put("ftFile", "/img/" + fi.getName());
			int cnt = ftdao.insertFileTest(ss, fileTest);
			if(cnt != 1) {
				throw new Exception("Not saved!");
			}
			File targetFile = new File(path + fi.getName());
			fi.write(targetFile); // throws exception 포함 // 그래서 exception 발생하면 다음 line 실행안 됨 ==> 그럼 rollback됨
			ss.commit();
		} catch(Exception e) {
			ss.rollback();
			e.printStackTrace();
		} finally {
			ss.close();
		}
		return null;
	}
}
