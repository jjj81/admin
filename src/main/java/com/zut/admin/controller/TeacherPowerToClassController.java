package com.zut.admin.controller;

import com.zut.admin.mapper.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zut.admin.entity.*;

@Controller
@RequestMapping("/teacherPowerToClass")
public class TeacherPowerToClassController {
	@Autowired
	private TeacherPowerToClassMapper teacherPowerToClassMapper;
	@Autowired
	private TeacherInfoMapper teacherInfoMapper;
	@Autowired
	private ClassesInfoMapper classesInfoMapper;

	@GetMapping("/index")
	String searchAllTeacher(Model model) {
		model.addAttribute("teacherInfoList", teacherInfoMapper.searchAllTeacher());
		return "searchAllTeacherInfo";
	}

	@GetMapping("/{teacherId}")
	String searchTeacherPowerToClass(Model model, @PathVariable("teacherId") String teacherId) {

		model.addAttribute("powerToClass", new TeacherPowerToClass());
		model.addAttribute("classList", classesInfoMapper.searchAllClasses());
		model.addAttribute("powerToClassList", teacherPowerToClassMapper.searchTeacherByTeacherId(teacherId));
		model.addAttribute("teacherId", teacherId);
		return "teacherPowerToClassPersonalIndex";
	}

	@PostMapping("/insert")
	String insertPowerToClass(final TeacherPowerToClass teacherPowerToClass, Model model,
			@RequestParam("teacherId") String teacherId) {
		model.addAttribute("powerToClass", new TeacherPowerToClass());
		model.addAttribute("classList", classesInfoMapper.searchAllClasses());
		model.addAttribute("powerToClassList", teacherPowerToClassMapper.searchTeacherByTeacherId(teacherId));
		model.addAttribute("teacherId", teacherId);


		teacherPowerToClass.setTeacherId(teacherId);
		teacherPowerToClassMapper.insertPowerToClass(teacherPowerToClass);

		return "teacherPowerToClassPersonalIndex";

	}

	@GetMapping("/delete")
	String deleteTeacherPowerToClass(Model model,
			@RequestParam("className") String className, @RequestParam("teacherId") String teacherId) {
		teacherPowerToClassMapper.deleteTeacherPowerToClassByClassName(className);

		model.addAttribute("powerToClass", new TeacherPowerToClass());
		model.addAttribute("classList", classesInfoMapper.searchAllClasses());
		model.addAttribute("powerToClassList", teacherPowerToClassMapper.searchTeacherByTeacherId(teacherId));
		model.addAttribute("teacherId", teacherId);
		return "teacherPowerToClassPersonalIndex";

	}

}
