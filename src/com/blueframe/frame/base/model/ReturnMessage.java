package com.blueframe.frame.base.model;

/**
 * AJAX 返回信息对象
 * @author hhLiu
 */
public class ReturnMessage {

	/**
	 * 返回信息类型<br>
	 * "success","info","warning","error"
	 */
	private String type;

	/**
	 * 返回信息标题
	 */
	private String title;

	/**
	 * 返回信息内容
	 */
	private String message;

	public ReturnMessage() {
	}

	/**
	 * 构造方法
	 * @param type 返回信息类型
	 * @param title 返回信息标题
	 * @param message 返回信息内容
	 */
	public ReturnMessage(String type, String title, String message) {
		this.type = type;
		this.title = title;
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}