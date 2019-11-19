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
		Map<String, String> iMap = new HashMap<String, String>();
		int result = uidao.insertUser(user);
		if(result == 1){
			iMap.put("msg", "등록 SUCCESSSSSSSSS");
			iMap.put("result", "true");
		} else {
			iMap.put("msg", "등록 FAILURE!!!!!");
			iMap.put("result", "false");
		}
		return iMap;
	}

	
	public Map<String, String> updateUser(UserInfoVO user){
		Map<String, String> uMap = new HashMap<String, String>();
		int result = uidao.updateUser(user);
//		System.out.println(result);
		if(result == 1){
			uMap.put("msg", "수정 SUCCESSSSSSSSS");
			uMap.put("result", "true");
		} else {
			uMap.put("msg", "수정 FAILURE!!!!!");
			uMap.put("result", "false");
		}
		return uMap;
	}
	
	public Map<String, String> deleteUser(UserInfoVO user){
		Map<String, String> dMap = new HashMap<String, String>();
		int result = uidao.deleteUser(user);
		if(result == 1){
			dMap.put("msg", "삭제 SUCCESSSSSSSSS");
			dMap.put("result", "true");
		} else {
			dMap.put("msg", "삭제 FAILURE!!!!!");
			dMap.put("result", "false");
		}
		return dMap;
	}
}
