package com.zut.admin.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.*;

import com.zut.admin.entity.TeacherPowerToClass;

@Mapper
public interface TeacherPowerToClassMapper {

	@Select("select * from teacherPowerToClass ")
	List<TeacherPowerToClass> searchAllTeacherInfo();

	@Select("select * from teacherPowerToClass where teacherId=#{teacherId}")
	List<TeacherPowerToClass> searchTeacherByTeacherId(String teacherId);

	@Insert("insert into teacherPowerToClass(teacherId,className) values(#{teacherId},#{className})")
	void insertPowerToClass(TeacherPowerToClass teacherPowerToClass);

	@Delete("delete from teacherPowerToClass where className=#{className}")
	void deleteTeacherPowerToClassByClassName(String className);

	@Delete("delete from teacherPowerToClass where teacherId=#{teacherId}")
	void deleteTeacherPowerToClassByTeacherId(String teacherId);

}
