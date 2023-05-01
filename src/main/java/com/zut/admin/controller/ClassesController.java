package com.zut.admin.controller;

import com.zut.admin.entity.Classes;
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

	// c
	@GetMapping("/getInsertPage")
	String getInsertPate(Model model) {
		model.addAttribute("classInfo", new Classes());
		return "insertClassInfo";
	}

	@PostMapping("/insert")
	String insertClassesInfo(Model model, Classes classes) {
		if (classesInfoMapper.searchByFlagBit(classes.getFlagBit()) != null)
			return "flagBitExist";
		if (classesInfoMapper.searchByClassName(classes.getClassName()) != null)
			return "classNameExist";
		classesInfoMapper.insertClassesInfo(classes);
		model.addAttribute("classesList", classesInfoMapper.searchAllClasses());
		return "searchAllClasses";
	}

	// r
	@GetMapping("/searchAll")
	String searchAllClasses(Model model) {
		model.addAttribute("classesList", classesInfoMapper.searchAllClasses());
		return "searchAllClasses";
	}

	// u
	@PostMapping("/update/{flagBit}")
	String updateClassInfoByFlagBit(@PathVariable("flagBit") String flagBit, Model model, final Classes classes) {
		classes.setFlagBit(flagBit);
		classesInfoMapper.updateClassInfoByFlagBit(classes);
		model.addAttribute("classesList", classesInfoMapper.searchAllClasses());
		return "searchAllClasses";
	}

	@GetMapping("/getUpdatePage/{flagBit}")
	String getUpdatePage(@PathVariable("flagBit") String flagBit, Model model) {
		Classes classes = new Classes();
		classes.setFlagBit(flagBit);
		model.addAttribute("classInfo", classes);
		return "updateClassInfo";
	}

	// d
	@GetMapping("/delete/{flagBit}")
	public String deleteClassInfoByFlagBit(@PathVariable("flagBit") String flagBit, Model model) {

		classesInfoMapper.deleteClassInfoByFlagBit(flagBit);

		model.addAttribute("classesList", classesInfoMapper.searchAllClasses());
		return "searchAllClasses";
	}

}
