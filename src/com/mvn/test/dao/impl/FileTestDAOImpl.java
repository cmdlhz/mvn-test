package com.mvn.test.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.mvn.test.controller.InitServlet;
import com.mvn.test.dao.FileTestDAO;
import com.mvn.test.dao.UserInfoDAO;
import com.mvn.test.vo.FileTestVO;
import com.mvn.test.vo.UserInfoVO;

public class FileTestDAOImpl implements FileTestDAO {
	@Override
	public int insertFileTest(SqlSession ss, Map<String, String> fileTest) {
		return ss.insert("FileTest.insertFileTest", fileTest);
	}
	
	public List<FileTestVO> selectFileList(Map<String, String> file){
		SqlSession ss = InitServlet.getSqlSession();
		try {
			return ss.selectList("FileTest.selectFileList");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			ss.close();
		}
		return null;
	}
	
	public static void main(String[] args) {
		FileTestDAO fdao = new FileTestDAOImpl();
//		Map<String, String> pUser = new HashMap<>();
		FileTestVO user = new FileTestVO();
//		System.out.println(fdao.selectFileList(file));
	}
}
