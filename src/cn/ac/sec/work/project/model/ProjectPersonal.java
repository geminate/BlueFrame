package cn.ac.sec.work.project.model;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import com.blueframe.frame.base.model.BaseEntity;

/**
 * 人员管理 对象
 * @author hhLiu
 */
public class ProjectPersonal extends BaseEntity<ProjectPersonal> {

	private static final long serialVersionUID = 1L;

	private String name;// 姓名
	
	private Long age;// 年龄
	
	private Long ageBegin;// 年龄-查询起始值
			
	private Long ageEnd;// 年龄-查询结束值
	
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthday;// 生日
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthdayBegin;// 生日-查询起始值
			
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthdayEnd;// 生日-查询结束值
	
	private String introduction;// 个人简介
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Long getAge() {
		return age;
	}

	public void setAge(Long age) {
		this.age = age;
	}
	
	public Long getAgeBegin() {
		return ageBegin;
	}

	public void setAgeBegin(Long ageBegin) {
		this.ageBegin = ageBegin;
	}
	
	public Long getAgeEnd() {
		return ageEnd;
	}
	
	public void setAgeEnd(Long ageEnd) {
		this.ageEnd = ageEnd;
	}
				
	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	public Date getBirthdayBegin() {
		return birthdayBegin;
	}

	public void setBirthdayBegin(Date birthdayBegin) {
		this.birthdayBegin = birthdayBegin;
	}
	
	public Date getBirthdayEnd() {
		if (birthdayEnd != null) {
			return new Date(birthdayEnd.getTime() + (1000 * 60 * 60 * 24 - 1));
		} else {
			return null;
		}
	}
	
	public void setBirthdayEnd(Date birthdayEnd) {
		this.birthdayEnd = birthdayEnd;
	}
				
	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	
}