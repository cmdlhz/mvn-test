package com.mvn.test.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.mvn.test.vo.PhotoBoardVO;

public interface PhotoBoardDAO {
	public List<PhotoBoardVO> selectPhotoList(Map<String, String> photo);
	public PhotoBoardVO selectPhoto(PhotoBoardVO photo);
	
	public int insertPhoto(SqlSession ss, Map<String, Object> photo);
	public int updatePhoto(PhotoBoardVO photo);
	public int deletePhoto(PhotoBoardVO photo);
}
