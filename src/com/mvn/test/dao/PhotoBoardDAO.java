package com.mvn.test.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.mvn.test.vo.PhotoBoardVO;

public interface PhotoBoardDAO {
	public List<PhotoBoardVO> selectPhotoList(SqlSession ss, Map<String, String> photo);
	public PhotoBoardVO selectPhoto(SqlSession ss, PhotoBoardVO photo);
	public int insertPhoto(SqlSession ss, PhotoBoardVO photo);
	public int updatePhoto(SqlSession ss, PhotoBoardVO photo);
	public int deletePhoto(SqlSession ss, PhotoBoardVO photo);
}
