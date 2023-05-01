package com.zut.admin.controller;

import com.zut.admin.mapper.TeacherPowerToClassMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/teacherPowerToClass")
public class TeacherPowerToClassController {
	@Autowired
	private TeacherPowerToClassMapper teacherPowerToClassMapper;

	@GetMapping("/searchAll")
	String searchAllTeacher(Model model) {
		model.addAttribute("teacherInfoList", teacherPowerToClassMapper.seacherAllTeacherInfo());
		return "searchAllTeacherPowerToClass";
	}

}
