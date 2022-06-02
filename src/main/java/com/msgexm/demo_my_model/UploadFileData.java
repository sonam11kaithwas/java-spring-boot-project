package com.msgexm.demo_my_model;

public class UploadFileData {
	private String imgNm;
	  private String imgUrl;
	public String getImgNm() {
		return imgNm;
	}
	public void setImgNm(String imgNm) {
		this.imgNm = imgNm;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public UploadFileData(String imgNm, String imgUrl) {
		super();
		this.imgNm = imgNm;
		this.imgUrl = imgUrl;
	}
}
