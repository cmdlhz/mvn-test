package com.mvn.test.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.mvn.test.vo.PhotoBoardVO;

public interface PhotoBoardService {
	public List<PhotoBoardVO> getPhotoList(Map<String, String> photo);
	public PhotoBoardVO getPhoto(PhotoBoardVO photo);
	
	public Map<String, String> insertPhoto(Map<String, Object> photo);	
	public Map<String, String> updatePhoto(PhotoBoardVO photo);
	public Map<String, String> deletePhoto(PhotoBoardVO photo);

}
