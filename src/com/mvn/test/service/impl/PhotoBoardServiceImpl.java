package com.mvn.test.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.fileupload.FileItem;
import org.apache.ibatis.session.SqlSession;

import com.mvn.test.controller.InitServlet;
import com.mvn.test.dao.PhotoBoardDAO;
import com.mvn.test.dao.impl.PhotoBoardDAOImpl;
import com.mvn.test.service.PhotoBoardService;
import com.mvn.test.vo.PhotoBoardVO;

public class PhotoBoardServiceImpl implements PhotoBoardService {
	private PhotoBoardDAO pbdao = new PhotoBoardDAOImpl();

	@Override
	public List<PhotoBoardVO> getPhotoList(Map<String, String> photo) {
		return pbdao.selectPhotoList(photo);
	}

	@Override
	public PhotoBoardVO getPhoto(PhotoBoardVO photo) {
		return pbdao.selectPhoto(photo);
	}

	@Override
	public Map<String, String> insertPhoto(SqlSession ss, Map<String, Object> photo) {
		
		ss = InitServlet.getSqlSession();
		
		try {
			PhotoBoardVO pb = new PhotoBoardVO();
			
			pb.setPbTitle((String)photo.get("pbTitle"));
			pb.setPbContent((String)photo.get("pbContent"));
			pb.setCreusr(Integer.parseInt((String)photo.get("creusr")));
			if(photo.get("pbImg1") != null) {
				FileItem fi = (FileItem)photo.get("pbImg1");
				pb.setPbImg1(fi.getName());
			}
			if(photo.get("pbImg2") != null) {
				FileItem fi = (FileItem)photo.get("pbImg2");
				pb.setPbImg2(fi.getName());
			}
			
			// DAO로 넘어가기
			int result= pbdao.insertPhoto(ss, photo);
			Map<String, String> pbMap = new HashMap<String, String>();
			if(result == 1) {
				pbMap.put("msg", "등록 SUCCESSSSSS!");
				pbMap.put("result", "true");
			} else {
				pbMap.put("msg", "등록 FAILURE!!!!!");
				pbMap.put("result", "false");
			}
			ss.commit();
			return pbMap;
		} catch(Exception e) {
			ss.rollback();
			e.printStackTrace();
		} finally {
			ss.close();
		}
		return null;
	}

	@Override
	public Map<String, String> updatePhoto(PhotoBoardVO photo) {
		Map<String, String> pbMap = new HashMap<String, String>();
		int result= pbdao.updatePhoto(photo);
		if(result == 1) {
			pbMap.put("msg", "수정 SUCCESSSSSS!");
			pbMap.put("result", "true");
		} else {
			pbMap.put("msg", "수정 FAILURE!!!!!");
			pbMap.put("result", "false");
		}
		return pbMap;
	}

	@Override
	public Map<String, String> deletePhoto(PhotoBoardVO photo) {
		Map<String, String> pbMap = new HashMap<String, String>();
		int result= pbdao.deletePhoto(photo);
		if(result == 1) {
			pbMap.put("msg", "삭제 SUCCESSSSSS!");
			pbMap.put("result", "true");
		} else {
			pbMap.put("msg", "삭제 FAILURE!!!!!");
			pbMap.put("result", "false");
		}
		return pbMap;
	}

}
