package com.mvn.test.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.mvn.test.controller.InitServlet;
import com.mvn.test.dao.UserInfoDAO;
import com.mvn.test.vo.UserInfoVO;

public class UserInfoDAOImpl implements UserInfoDAO {
	// sql session은 여러 개일 수 있지만 공장은 하나만 있으면 됨 => 고로, DAO 있을 필요 없음
	private SqlSessionFactory ssf;
	
	/* 
	methods ==> com.mvn.test > config > mapper > UserInfo.xml
	*/
	
	@Override // Select
	public List<UserInfoVO> selectUserList(Map<String, String> pUser) {
		SqlSession ss = InitServlet.getSqlSession(); // InitServlet (in "controller" folder) // 연결한 준비만 하는 것
		try {
			return ss.selectList("UserInfo.selectUserList"); // 실제로 연결되는 곳
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			// 잊지 말고 끊어주기!
			ss.close();
		}
		return null;
	}
	
	public UserInfoVO selectUser(UserInfoVO user) {
		SqlSession ss = InitServlet.getSqlSession();
		try {
			return ss.selectOne("UserInfo.selectUser", user);
			// selectOne(String statement, Object parameter)
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			ss.close();
		}
		return null;
	}
	
	// Insert // insertUser
	public int insertUser(UserInfoVO user){
		SqlSession ss = InitServlet.getSqlSession();
		try {
			int cnt = ss.insert("UserInfo.insertUser", user); // 실제로 연결되는 곳
			ss.commit(); // default가 false
			return cnt;
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			// 잊지 말고 끊어주기!
			ss.close();
		}
		return 0;
	}
	
	public int updateUser(UserInfoVO user) {
		SqlSession ss = InitServlet.getSqlSession();
		try {
			int cnt = ss.update("UserInfo.deleteUser", user); // 실제로 연결되는 곳
			ss.commit(); // default가 false
			return cnt;
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			// 잊지 말고 끊어주기!
			ss.close();
		}
		return 0;
	}
	public int deleteUser(UserInfoVO user) {
		SqlSession ss = InitServlet.getSqlSession();
		try {
			int cnt = ss.delete("UserInfo.updateUser", user); // 실제로 연결되는 곳
			ss.commit(); // default가 false
			return cnt;
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			// 잊지 말고 끊어주기!
			ss.close();
		}
		return 0;
	}
	
	public static void main(String[] args) {
		UserInfoDAO udao = new UserInfoDAOImpl();
		Map<String, String> pUser = new HashMap<>();
		System.out.println(udao.selectUserList(pUser));
//		UserInfoVO pUser = new UserInfoVO<>();
//		user.setUiNum(21);
//		System.out.println(uidao.selectUser(pUser));
	}
}