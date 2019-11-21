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
	public List<PhotoBoardVO> selectPhotoList(Map<String, String> photo) {
		SqlSession ss = InitServlet.getSqlSession();
		try {
			// "selectList" : iBatis method
			return ss.selectList("PhotoBoard.selectPhotoList");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			ss.close();
		}
		return null;
	}

	@Override
	public PhotoBoardVO selectPhoto(PhotoBoardVO photo) {
		SqlSession ss = InitServlet.getSqlSession();
		try {
			return ss.selectOne("PhotoBoard.selectPhoto", photo);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			ss.close();
		}
		return null;
	}

	@Override
	public int insertPhoto(SqlSession ss, Map<String, Object> photo){
		return ss.insert("PhotoBoard.insertPhoto", photo);
	}

	@Override
	public int updatePhoto(PhotoBoardVO photo) {
		SqlSession ss = InitServlet.getSqlSession();
		try {
			int cnt = ss.update("PhotoBoard.updatePhoto", photo);
			ss.commit();
			return cnt;
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			ss.close();
		}
		return 0;
	}

	@Override
	public int deletePhoto(PhotoBoardVO photo) {
		SqlSession ss = InitServlet.getSqlSession();
		try {
			int cnt = ss.delete("PhotoBoard.deletePhoto", photo);
			ss.commit();
			return cnt;
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			ss.close();
		}
		return 0;
	}
	
	public static void main(String[] args) {
		SqlSession ss = InitServlet.getSqlSession();
		PhotoBoardDAO pbdao = new PhotoBoardDAOImpl();
		PhotoBoardVO pb = new PhotoBoardVO();
		pb.setPbTitle("test");
		pb.setCreusr(1);
		pb.setPbImg1("1");
		pb.setPbImg2("2");
	}
}
