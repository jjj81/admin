package com.zut.admin.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.*;

import com.zut.admin.entity.TeacherInfo;

@Mapper
public interface TeacherInfoMapper {

	@Select("select * from teacherLoginInfo")
	List<TeacherInfo> searchAllTeacher();

	@Delete("delete from teacherLoginInfo where teacherId=#{teacherId}")
	void deleteTeacherInfoByTeacherId(String teacherId);

	@Insert("insert into teacherLoginInfo(teacherId,passWord) values(#{teacherId},#{passWord})")
	void insertTeacherIdAndPassWord(TeacherInfo teacherInfo);

	@Select("select * from teacherLoginInfo where teacherId=#{teacherId}")
	TeacherInfo selectTeacherInfoById(String teacherId);
}
