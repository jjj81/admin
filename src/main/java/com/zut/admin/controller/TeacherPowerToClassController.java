package com.zut.admin.controller;

import com.zut.admin.entity.Clazz;
import com.zut.admin.entity.College;
import com.zut.admin.entity.Faculty;
import com.zut.admin.mapper.ClazzMapper;
import com.zut.admin.mapper.TeacherPowerToClassMapper;
import com.zut.admin.service.OrganizationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/teacherPowerToClass")
public class TeacherPowerToClassController {
	@Autowired
	private TeacherPowerToClassMapper teacherPowerToClassMapper;

	@Autowired
	private ClazzMapper clazzMapper;

	@Autowired
	private OrganizationService organizationService;

	@GetMapping("/{teacherId}")
	String getIndex(@PathVariable("teacherId") String teacherId, Model model) {

		model.addAttribute("teacherId", teacherId);
		model.addAttribute("collegeList", clazzMapper.selectAllCollege());
		model.addAttribute("college", new College());
		model.addAttribute("faculty", new Faculty());
		model.addAttribute("clazz", new Clazz());
		model.addAttribute("powerToClassList", organizationService
				.upGetAllInfo(teacherPowerToClassMapper.searchTeacherByTeacherId(teacherId), teacherId));

		return "teacherPowerToClass";
	}

	@PostMapping("/fixTheFaculty")
	String fixTheFaculty(Model model, final College college, @RequestParam("teacherId") String teacherId) {

		model.addAttribute("teacherId", teacherId);
		model.addAttribute("college", new College());
		model.addAttribute("faculty", new Faculty());
		model.addAttribute("clazz", new Clazz());
		model.addAttribute("collegeList", clazzMapper.selectAllCollege());
		model.addAttribute("facultyList", clazzMapper.selectFacultyByParentId(college.getId()));
		model.addAttribute("powerToClassList", organizationService
				.upGetAllInfo(teacherPowerToClassMapper.searchTeacherByTeacherId(teacherId), teacherId));

		return "teacherPowerToClass";
	}

	@PostMapping("/fixTheClazz")
	String fixTheClazz(Model model, final Faculty faculty, @RequestParam("teacherId") String teacherId) {

		model.addAttribute("teacherId", teacherId);
		model.addAttribute("college", new College());
		model.addAttribute("faculty", new Faculty());
		model.addAttribute("clazz", new Clazz());
		model.addAttribute("collegeList", clazzMapper.selectAllCollege());
		model.addAttribute("facultyList",
				clazzMapper.selectFacultyById(faculty.getId()));
		model.addAttribute("clazzList", clazzMapper.selectClazzByFacultyId(faculty.getId()));
		model.addAttribute("powerToClassList", organizationService
				.upGetAllInfo(teacherPowerToClassMapper.searchTeacherByTeacherId(teacherId), teacherId));

		return "teacherPowerToClass";
	}

	@PostMapping("/insert")
	String insertToTable(Model model, final Clazz clazz, @RequestParam("teacherId") String teacherId) {
		if (teacherPowerToClassMapper.selectPowerByIdAndId(teacherId, clazz.getId()) != null) {
			model.addAttribute("teacherId", teacherId);
			model.addAttribute("college", new College());
			model.addAttribute("faculty", new Faculty());
			model.addAttribute("clazz", new Clazz());

			model.addAttribute("collegeList", clazzMapper.selectAllCollege());
			model.addAttribute("powerToClassList", organizationService
					.upGetAllInfo(teacherPowerToClassMapper.searchTeacherByTeacherId(teacherId), teacherId));
			model.addAttribute("duplicate", "该教师已能管理该班级，请勿重复添加!!!!!");
			return "teacherPowerToClass";
		}
		model.addAttribute("teacherId", teacherId);
		model.addAttribute("college", new College());
		model.addAttribute("faculty", new Faculty());
		model.addAttribute("clazz", new Clazz());

		model.addAttribute("collegeList", clazzMapper.selectAllCollege());

		teacherPowerToClassMapper.insertPowerToClass(teacherId, clazz.getId());
		model.addAttribute("powerToClassList", organizationService
				.upGetAllInfo(teacherPowerToClassMapper.searchTeacherByTeacherId(teacherId), teacherId));
		return "teacherPowerToClass";
	}

	@GetMapping("/delete")
	String deletePowerToClass(@RequestParam("teacherId") String teacherId, @RequestParam("clazzId") Integer clazzId,
			Model model) {

		teacherPowerToClassMapper.deletePowerByIdAndId(teacherId, clazzId);
		model.addAttribute("teacherId", teacherId);
		model.addAttribute("college", new College());
		model.addAttribute("faculty", new Faculty());
		model.addAttribute("clazz", new Clazz());

		model.addAttribute("collegeList", clazzMapper.selectAllCollege());

		model.addAttribute("powerToClassList", organizationService
				.upGetAllInfo(teacherPowerToClassMapper.searchTeacherByTeacherId(teacherId), teacherId));

		return "teacherPowerToClass";
	}
}
