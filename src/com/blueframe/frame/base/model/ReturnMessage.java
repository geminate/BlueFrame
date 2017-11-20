package com.blueframe.frame.base.model;

/**
 * Ajax 返回对象
 */
public class ReturnMessage {

	// 信息内容
	private String message;

	// 信息标识符
	private String flag;

	public ReturnMessage() {

	}

	public ReturnMessage(String message, String flag) {
		this.message = message;
		this.flag = flag;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}
}
