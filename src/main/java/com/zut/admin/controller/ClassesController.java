package com.zut.admin.controller;

import com.zut.admin.entity.Classes;
import com.zut.admin.entity.TeacherInfo;
import com.zut.admin.mapper.ClassesInfoMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/class")
public class ClassesController {
	@Autowired
	private ClassesInfoMapper classesInfoMapper;


	@PostMapping("/insert")
	String insertClassesInfo(Model model, Classes classes) {
		if (classesInfoMapper.searchByClassName(classes.getClassName()) != null)
			return "classNameExist";
		classesInfoMapper.insertClassesInfo(classes);
		model.addAttribute("classInfo", new Classes());
		model.addAttribute("classesList", classesInfoMapper.searchAllClasses());
		return "classInfoIndex";
	}

	@GetMapping("/searchAll")
	String searchAllClasses(Model model) {
		model.addAttribute("classInfo", new Classes());
		model.addAttribute("classesList", classesInfoMapper.searchAllClasses());
		return "classInfoIndex";
	}

	@GetMapping("/delete/{className}")
	public String deleteClassInfoByFlagBit(@PathVariable("className") String className, Model model) {

		classesInfoMapper.deleteClassInfoByClassName(className);
		model.addAttribute("classInfo", new Classes());
		model.addAttribute("classesList", classesInfoMapper.searchAllClasses());
		return "classInfoIndex";
	}

}
