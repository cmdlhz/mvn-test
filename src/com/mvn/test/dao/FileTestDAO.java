package com.mvn.test.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.mvn.test.vo.FileTestVO;

public interface FileTestDAO {
	public int insertFileTest(SqlSession ss, Map<String, String> fileTest);
	public List<FileTestVO> selectFileList(Map<String, String> file);
}
