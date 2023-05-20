package com.zut.admin.mapper;

import org.apache.ibatis.annotations.*;
import java.util.*;

import com.zut.admin.entity.Clazz;
import com.zut.admin.entity.College;
import com.zut.admin.entity.Faculty;

@Mapper
public interface ClazzMapper {

	@Select("select * from college")
	List<College> selectAllCollege();

	@Select("select * from college where college=#{collegeName}")
	College selectCollegeByName(String collegeName);

	@Select("select * from faculty where parentId=#{parentId}")
	List<Faculty> selectFacultyByParentId(Integer parentId);

	@Select("select * from college where id=#{id}")
	List<College> selectCollegeById(Integer id);

	@Select("select * from college where id=#{id}")
	College selectCollegeById2(Integer id);

	@Select("select * from faculty where id=#{clazzParentId}")
	Faculty selectFacultyByClazzParentId(Integer clazzParentId);

	@Select("select * from clazz")
	List<Clazz> selectAllClazz();

	@Select("select * from faculty")
	List<Faculty> selectAllFaculty();

	@Select("select * from clazz where parentId=#{facultyId}")
	List<Clazz> selectClazzByFacultyId(Integer facultyId);

	@Select("select * from faculty where id=#{id}")
	Faculty selectFacultyById(Integer id);

	@Select("select * from clazz where id=#{id}")
	Clazz selectClazzById(Integer id);

	@Insert("insert into faculty(faculty,parentId) values(#{faculty},#{parentId})")
	int insertFaculty(Faculty faculty);

	@Insert("insert into clazz(clazz,parentId) values(#{clazz},#{parentId})")
	int insertClazz(Clazz clazz);

	@Delete("delete from clazz where id=#{clazzId}")
	void deleteClazzByClazz(Integer clazzId);

	@Delete("delete from faculty where id=#{facultyId}")
	void deleteFacultyById(Integer facultyId);

	@Update("update faculty set faculty=#{faculty} where id=#{facultyId}")
	int updateFacultyById(String faculty, Integer facultyId);

}
