package com.zut.admin.entity;

public class TeacherInfo {
	private String teacherId;
	private String passWord;
	private String wantToManageClass;
	private String teacherName;
	private String college;
	private String faculty;

	public String getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getWantToManageClass() {
		return wantToManageClass;
	}

	public void setWantToManageClass(String wantToManageClass) {
		this.wantToManageClass = wantToManageClass;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public String getFaculty() {
		return faculty;
	}

	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}

}
