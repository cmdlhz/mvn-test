package com.mvn.test.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.mvn.test.controller.InitServlet;
import com.mvn.test.dao.UserInfoDAO;

public class UserInfoDAOImpl implements UserInfoDAO {
	
	// sql session은 여러 개일 수 있지만 공장은 하나만 있으면 됨 => 고로, DAO 있을 필요 없음
	private SqlSessionFactory ssf;
	
	@Override
	public List<Map<String, String>> selectUserList(Map<String, String> pUser) {
		
		SqlSession ss = InitServlet.getSqlSession();
		try {
			return ss.selectList("UserInfo.selectUserList");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			ss.close();
		}
		return null;
	}
	
	public static void main(String[] args) {
		UserInfoDAO udao = new UserInfoDAOImpl();
		Map<String, String> pUser = new HashMap<>();
		System.out.println(udao.selectUserList(pUser));
	}
}