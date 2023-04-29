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
	@Insert("insert into classes(flagBit,className) values(#{flagBit},#{className})")
	void insertClassesInfo(Classes classes);

	@Select("select * from classes")
	List<Classes> searchAllClasses();

	@Select("select * from classes where flagBit=#{flagBit}")
	Classes searchByFlagBit(String flagBit);

	@Select("select * from classes where className=#{className}")
	Classes searchByClassName(String className);

	@Delete("delete from classes where flagBit=#{flagBit}")
	void deleteClassInfoByFlagBit(String flagBit);

	@Update("update classes set flagBit=#{flagBit} , className=#{className} where flagBit=#{flagBit}")
	void updateClassInfoByFlagBit(Classes classes);

}
