package com.zut.admin.mapper;

import java.util.List;

import com.zut.admin.entity.Classes;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ClassesInfoMapper {
	@Insert("insert into classes(flagBit,className) values(#{flagBit},#{className})")
	void insertClassesInfo(Classes classes);

	@Select("select * from classes")
	List<Classes> searchAllClasses();

	@Delete("delete from classes where flagBit=#{flagBit}")
	void deleteClassInfoByFlagBit(String flagBit);
}
