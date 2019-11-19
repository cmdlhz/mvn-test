package com.mvn.test.dao;

import java.util.List;
import java.util.Map;

import com.mvn.test.vo.UserInfoVO;

public interface UserInfoDAO {
	public List<UserInfoVO> selectUserList(Map<String, String> pUser);
	public int insertUser(UserInfoVO user);
//	public int updateUser(Map<String,String> board);
//	public int deleteUser(Map<String,String> board);
}
