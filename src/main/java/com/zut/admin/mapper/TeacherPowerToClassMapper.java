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

	@Select("select * from teacherPowerToClass where teacherId=#{teacherId} and clazzId=#{clazzId}")
	TeacherPowerToClass selectPowerByIdAndId(String teacherId, Integer clazzId);

	@Insert("insert into teacherPowerToClass(teacherId,clazzId) values(#{teacherId},#{clazzId})")
	void insertPowerToClass(String teacherId, Integer clazzId);


	@Delete("delete from teacherPowerToClass where teacherId=#{teacherId} and clazzId=#{clazzId}")
	int deletePowerByIdAndId(String teacherId, Integer clazzId);

}
