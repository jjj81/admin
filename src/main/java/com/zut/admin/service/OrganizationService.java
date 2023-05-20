package com.zut.admin.service;

import com.zut.admin.entity.Clazz;
import com.zut.admin.entity.College;
import com.zut.admin.entity.Faculty;
import com.zut.admin.entity.Organization;
import com.zut.admin.entity.TeacherPowerToClass;
import com.zut.admin.mapper.ClazzMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OrganizationService {

	@Autowired
	private ClazzMapper clazzMapper;

	public List<College> addListToList(List<College> college) {

		for (College c : clazzMapper.selectAllCollege()) {
			college.add(c);
		}

		return college;
	}

	public List<Organization> upGetAllInfo(List<Clazz> clazzList) {
		List<Organization> result = new ArrayList<Organization>();

		for (Clazz c : clazzList) {
			Organization o = new Organization();
			o.setClazz(c.getClazz());
			o.setFaculty(clazzMapper.selectFacultyByClazzParentId(c.getParentId()).getFaculty());
			o.setCollege(clazzMapper
					.selectCollegeById2(clazzMapper.selectFacultyByClazzParentId(c.getParentId()).getParentId())
					.getCollege());
			o.setClazzId(c.getId());
			o.setFacultyId(c.getParentId());
			result.add(o);
		}
		return result;

	}

	public List<Organization> upGetAllInfo(List<TeacherPowerToClass> teacherPowerToClasses, String overLoading) {

		List<Organization> result = new ArrayList<Organization>();
		for (TeacherPowerToClass t : teacherPowerToClasses) {
			Organization o = new Organization();
			o.setClazz(clazzMapper.selectClazzById(t.getClazzId()).getClazz());
			o.setClazzId(t.getClazzId());
			o.setFaculty(clazzMapper.selectFacultyById(clazzMapper.selectClazzById(t.getClazzId()).getParentId())
					.getFaculty());
			o.setCollege(clazzMapper
					.selectCollegeById2(clazzMapper
							.selectFacultyById(clazzMapper.selectClazzById(t.getClazzId()).getParentId()).getParentId())
					.getCollege());
			result.add(o);
		}
		return result;
	}

	public List<Organization> facultyUpGetAllInfo(List<Faculty> facultyList) {
		List<Organization> result = new ArrayList<Organization>();

		for (Faculty f : facultyList) {
			Organization o = new Organization();
			o.setFacultyId(f.getId());
			o.setFaculty(f.getFaculty());
			o.setCollege(clazzMapper.selectCollegeById2(f.getParentId()).getCollege());
			result.add(o);
		}

		return result;
	}

}
