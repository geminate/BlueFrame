package com.blueframe.frame.sys.model;


import com.blueframe.frame.base.model.BaseEntity;

/**
 * 附件管理 对象
 * @author hhLiu
 */
public class SysFile extends BaseEntity<SysFile> {

	private static final long serialVersionUID = 1L;

	private String fileType;// 文件类型
	
	private String foreignId;// 外键ID
	
	private String filePath;// 文件地址
	
	private String fileName;// 文件名
	

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	
	public String getForeignId() {
		return foreignId;
	}

	public void setForeignId(String foreignId) {
		this.foreignId = foreignId;
	}
	
	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
}