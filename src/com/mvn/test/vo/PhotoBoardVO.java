package com.mvn.test.vo;

import org.apache.commons.fileupload.FileItem;

import lombok.Data;

@Data
public class PhotoBoardVO {
	private Integer pbNum;
	private String pbTitle;
	private String pbContent;
	private String pbImg1 = ""; // 이름
	private String pbImg2 = "";
	private FileItem pbImgFile1; // 임시 저장 파일
	private FileItem pbImgFile2;
	private String credat;
	private String cretim;
	private Integer creusr;
	private String moddat;
	private String modtim;
	private Integer modusr;
	private Integer pbCnt;
}
