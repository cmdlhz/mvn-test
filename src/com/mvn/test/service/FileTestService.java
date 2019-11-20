package com.mvn.test.service;

import java.util.List;
import java.util.Map;

import com.mvn.test.vo.FileTestVO;

public interface FileTestService {
	public Map<String, String> insertFileTest(Map<String, Object> param);
	public List<FileTestVO> getFileList(Map<String, String> file);
}
