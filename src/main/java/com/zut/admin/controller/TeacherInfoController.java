package com.zut.admin.controller;

import com.zut.admin.entity.TeacherInfo;
import com.zut.admin.mapper.TeacherInfoMapper;
import com.zut.admin.mapper.TeacherPowerToClassMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/teacherInfo")
public class TeacherInfoController {
	@Autowired
	private TeacherInfoMapper teacherInfoMapper;

    @Autowired
    private TeacherPowerToClassMapper teacherPowerToClassMapper;

	BCryptPasswordEncoder bcrCryptPasswordEncoder = new BCryptPasswordEncoder();
	@GetMapping("/index")
	String getTeacherIndexPage(Model model) {
		model.addAttribute("teacher", new TeacherInfo());
		model.addAttribute("teacherInfoList", teacherInfoMapper.searchAllTeacher());

		return "teacherInfoIndex";
	}

	@GetMapping("/delete/{teacherId}")
	String deleteTeacherInfoByTeacerhId(Model model, @PathVariable("teacherId") String id) {
		teacherInfoMapper.deleteTeacherInfoByTeacherId(id);
		teacherPowerToClassMapper.deleteTeacherPowerToClassByTeacherId(id);
		model.addAttribute("teacher", new TeacherInfo());
		model.addAttribute("teacherInfoList", teacherInfoMapper.searchAllTeacher());
		return "teacherInfoIndex";
	}

	@PostMapping("/insert")
	String insertTeacherIdAndPassWord(Model model, final TeacherInfo teacherInfo) {
		if (teacherInfoMapper.selectTeacherInfoById(teacherInfo.getTeacherId()) != null)
			return "teacherIdExist";
		teacherInfo.setPassWord(bcrCryptPasswordEncoder.encode(teacherInfo.getTeacherId()));
		teacherInfoMapper.insertTeacherIdAndPassWord(teacherInfo);
		model.addAttribute("teacher", new TeacherInfo());
		model.addAttribute("teacherInfoList", teacherInfoMapper.searchAllTeacher());
		return "teacherInfoIndex";
	}

}
