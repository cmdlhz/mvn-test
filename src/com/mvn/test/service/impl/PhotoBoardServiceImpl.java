package com.mvn.test.service.impl;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.fileupload.FileItem;
import org.apache.ibatis.session.SqlSession;

import com.mvn.test.common.ServletFileUtil;
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
	public Map<String, String> insertPhoto(Map<String, Object> photo) {
	
		PhotoBoardVO pb = new PhotoBoardVO();
		pb.setPbTitle((String)photo.get("pbTitle"));
		pb.setPbContent((String)photo.get("pbContent"));
		pb.setCreusr(Integer.parseInt((String)photo.get("creusr")));
		String path = "C:\\Users\\Administrator\\eclipse-workspace\\mvn-test\\WebContent\\img";
		
		// DAO로 넘어가기
		Map<String, String> pbMap = new HashMap<>();
		pbMap.put("msg", "등록 FAILURE!!!!!");
		pbMap.put("result", "false");
		SqlSession ss = InitServlet.getSqlSession();
		
		try {
			if(photo.get("pbImg1") != null) {
				FileItem fi = (FileItem)photo.get("pbImg1");
				String fileName = ServletFileUtil.saveFile(fi);
				pb.setPbImg1(fileName);
			}
			if(photo.get("pbImg2") != null) {
				FileItem fi = (FileItem)photo.get("pbImg2");
				String fileName = ServletFileUtil.saveFile(fi);
				// 앞에 "/img/" 추가?! 난 되는뎅
				pb.setPbImg2(fileName);
			}
			System.out.println(pb);
			
			int cnt = pbdao.insertPhoto(ss, pb);
			if(cnt == 1) {
				pbMap.put("msg", "등록 SUCCESSSSSS!");
				pbMap.put("result", "true");
			}
			ss.commit();
		} catch(Exception e) {
			ss.rollback();
			// file delete가 있어야 함. 혹시나 저장이 되었을 수도 있어서 
			e.printStackTrace();
		} finally {
			ss.close();
		}
		return pbMap;
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

	public static void main(String[] args) {
		String fileName = "img.jpg";
		int index = fileName.lastIndexOf(".");
		System.out.println(index); // 3
		fileName = fileName.substring(index);
		System.out.println(fileName); // .jpg
		fileName = System.nanoTime() + fileName;
		System.out.println(fileName); // 13268832707810.jpg
	}
}
