package com.mvn.test.vo;

import lombok.Data;

@Data
public class UserInfoVO {
	private Integer uiNum;
	private String uiName;
	private String uiId;
	private String uiPwd;
	private String credat;
	private String cretim;
	private String moddat;
	private String modtim;
	private String active;
}

// 노란색 줄이 없어서 => 다 적용된것으로 확인됨