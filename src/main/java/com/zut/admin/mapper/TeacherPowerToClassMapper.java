
package com.zut.admin.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.*;

import com.zut.admin.entity.TeacherPowerToClass;

@Mapper
public interface TeacherPowerToClassMapper {

	@Select("select * from teacherLoginInfo")
	List<TeacherPowerToClass> seacherAllTeacherInfo();
}
