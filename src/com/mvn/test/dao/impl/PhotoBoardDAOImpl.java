package com.mvn.test.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.mvn.test.controller.InitServlet;
import com.mvn.test.dao.PhotoBoardDAO;
import com.mvn.test.vo.PhotoBoardVO;

public class PhotoBoardDAOImpl implements PhotoBoardDAO {
	private SqlSessionFactory ssf;

	@Override
	public List<PhotoBoardVO> selectPhotoList(SqlSession ss, Map<String, String> photo) {
		return ss.selectList("PhotoBoard.selectPhotoList", photo);
	}

	@Override
	public PhotoBoardVO selectPhoto(SqlSession ss, PhotoBoardVO photo) {
		return ss.selectOne("PhotoBoard.selectPhoto", photo);
	}

	@Override
	public int insertPhoto(SqlSession ss, PhotoBoardVO photo){
		// MyBatis insert method : (namespace.id, parameter)
		return ss.insert("PhotoBoard.insertPhoto", photo);
	}

	@Override
	public int updatePhoto(SqlSession ss, PhotoBoardVO photo) {
		return ss.update("PhotoBoard.updatePhoto", photo);
	}

	@Override
	public int deletePhoto(SqlSession ss, PhotoBoardVO photo) {
		return ss.delete("PhotoBoard.deletePhoto", photo);
	}
	
	public static void main(String[] args) {
		SqlSession ss = InitServlet.getSqlSession();
		PhotoBoardDAO pbdao = new PhotoBoardDAOImpl();
		PhotoBoardVO pb = new PhotoBoardVO();
		pb.setPbTitle("test");
		pb.setPbContent("test content");
		pb.setCreusr(1);
		pbdao.insertPhoto(ss, pb);
		System.out.println(pbdao.insertPhoto(ss, pb));
		System.out.println(pbdao.selectPhoto(ss, pb));
		System.out.println(pbdao.selectPhotoList(ss, null));
		System.out.println(pbdao.updatePhoto(ss, pb));
		System.out.println(pbdao.deletePhoto(ss, pb));
		ss.commit();
	}
}
