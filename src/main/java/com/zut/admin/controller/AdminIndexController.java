package com.zut.admin.controller;

import com.zut.admin.entity.Classes;
import com.zut.admin.mapper.ClassesInfoMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminIndexController {
	@Autowired
	private ClassesInfoMapper classesInfoMapper;

	@GetMapping("/index")
	String returnIndex(Model model) {
		Classes classes = new Classes();
		model.addAttribute("classInfo", classes);
		return "adminIndex.html";
	}

}
