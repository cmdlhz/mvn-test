package com.mvn.test.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mvn.test.dao.UserInfoDAO;
import com.mvn.test.dao.impl.UserInfoDAOImpl;
import com.mvn.test.service.UserInfoService;
import com.mvn.test.vo.UserInfoVO;

public class UserInfoServiceImpl implements UserInfoService {
	private UserInfoDAO uidao = new UserInfoDAOImpl();
	
	@Override
	public List<UserInfoVO> getUserList(Map<String, String> user) {
		return uidao.selectUserList(user);
	}

	
	public UserInfoVO getUser(UserInfoVO user){
		return uidao.selectUser(user);
	}
	
	@Override
	public Map<String, String> insertUser(UserInfoVO user) {
		Map<String, String> rMap = new HashMap<String, String>();
		int result = uidao.insertUser(user);
		if(result == 1){
			rMap.put("msg", "등록 SUCCESSSSSSSSS");
			rMap.put("result", "true");
		} else {
			rMap.put("msg", "등록 FAILURE!!!!!");
			rMap.put("result", "false");
		}
		return rMap;
	}

	
	public Map<String, String> updateUser(UserInfoVO user){
		Map<String, String> rMap = new HashMap<String, String>();
		int result = uidao.updateUser(user);
		if(result == 1){
			rMap.put("msg", "수정 SUCCESSSSSSSSS");
			rMap.put("result", "true");
		} else {
			rMap.put("msg", "수정 FAILURE!!!!!");
			rMap.put("result", "false");
		}
		return rMap;
	}
	
	public Map<String, String> deleteUser(UserInfoVO user){
		Map<String, String> rMap = new HashMap<String, String>();
		int result = uidao.deleteUser(user);
		if(result == 1){
			rMap.put("msg", "삭제 SUCCESSSSSSSSS");
			rMap.put("result", "true");
		} else {
			rMap.put("msg", "삭제 FAILURE!!!!!");
			rMap.put("result", "false");
		}
		return rMap;
	}
}
