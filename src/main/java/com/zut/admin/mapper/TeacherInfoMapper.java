package com.zut.admin.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.*;

import com.zut.admin.entity.TeacherInfo;

@Mapper
public interface TeacherInfoMapper {

	@Select("select * from teacherLoginInfo")
	List<TeacherInfo> searchAllTeacher();

	@Delete("delete from teacherLoginInfo where teacherId=#{teacherId}")
	void deleteTeacherInfoByTeacherId(String teacherId);

	@Insert("insert into teacherLoginInfo(teacherId,passWord,teacherName,college,faculty) values(#{teacherId},#{passWord},#{teacherName},#{college},#{faculty})")
	void insertTeacherInfo(TeacherInfo teacherInfo);

	@Select("select * from teacherLoginInfo where teacherId=#{teacherId}")
	TeacherInfo selectTeacherInfoById(String teacherId);

	@Update("update teacherLoginInfo set adminMessage=#{message} where teacherId=#{teacherId}")
	int updateAdminMessage(String message, String teacherId);

}
