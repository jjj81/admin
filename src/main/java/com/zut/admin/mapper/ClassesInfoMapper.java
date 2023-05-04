package com.zut.admin.mapper;

import java.util.List;

import com.zut.admin.entity.Classes;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface ClassesInfoMapper {
	@Insert("insert into classes(className) values(#{className})")
	void insertClassesInfo(Classes classes);

	@Select("select * from classes")
	List<Classes> searchAllClasses();

	@Select("select * from classes where className=#{className}")
	Classes searchByClassName(String className);

	@Delete("delete from classes where className=#{className}")
	void deleteClassInfoByClassName(String className);

}
