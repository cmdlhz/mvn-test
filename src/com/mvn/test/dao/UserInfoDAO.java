package com.mvn.test.dao;

import java.util.List;
import java.util.Map;

public interface UserInfoDAO {
	public List<Map<String, String>> selectUserList(Map<String, String> pUser);
}
