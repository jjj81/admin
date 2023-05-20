package com.zut.admin.controller;

import com.zut.admin.entity.College;
import com.zut.admin.entity.TeacherInfo;
import com.zut.admin.mapper.ClazzMapper;
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

	@Autowired
	private ClazzMapper clazzMapper;

	BCryptPasswordEncoder bcrCryptPasswordEncoder = new BCryptPasswordEncoder();

	@GetMapping("/index")
	String getTeacherIndexPage(Model model) {

		model.addAttribute("teacherInfoList", teacherInfoMapper.searchAllTeacher());
		model.addAttribute("collegeList", clazzMapper.selectAllCollege());
		model.addAttribute("college", new College());
		model.addAttribute("facultyList", null);
		model.addAttribute("teacher", new TeacherInfo());
		return "teacherInfoIndex";
	}

	@GetMapping("/delete/{teacherId}")
	String deleteTeacherInfoByTeacerhId(Model model, @PathVariable("teacherId") String id) {
		if (teacherPowerToClassMapper.searchTeacherByTeacherId(id).isEmpty() == false) {
			model.addAttribute("powerExist", "该老师仍有能管理的班级，请清除这些班级后再来进行删除操作！！！");
			model.addAttribute("collegeList", clazzMapper.selectAllCollege());
			model.addAttribute("college", new College());
			model.addAttribute("facultyList", null);
			model.addAttribute("teacher", new TeacherInfo());
			model.addAttribute("teacherInfoList", teacherInfoMapper.searchAllTeacher());
			return "teacherInfoIndex";
		}
		teacherInfoMapper.deleteTeacherInfoByTeacherId(id);
		model.addAttribute("collegeList", clazzMapper.selectAllCollege());
		model.addAttribute("college", new College());
		model.addAttribute("facultyList", null);
		model.addAttribute("teacher", new TeacherInfo());
		model.addAttribute("teacherInfoList", teacherInfoMapper.searchAllTeacher());
		return "teacherInfoIndex";
	}

	@PostMapping("/insert/{collegeId}")
	String insertTeacherIdAndPassWord(Model model, TeacherInfo teacherInfo,
			@PathVariable("collegeId") Integer collegeId) {
		if (teacherInfoMapper.selectTeacherInfoById(teacherInfo.getTeacherId()) != null) {
			model.addAttribute("userExist", "该工号已有实例！！！！");
			model.addAttribute("facultyList", null);
			model.addAttribute("collegeList", clazzMapper.selectAllCollege());
			model.addAttribute("teacher", new TeacherInfo());
			model.addAttribute("college", new College());
			model.addAttribute("teacherInfoList", teacherInfoMapper.searchAllTeacher());
			return "teacherInfoIndex";

		}

		teacherInfo.setPassWord(bcrCryptPasswordEncoder.encode(teacherInfo.getTeacherId()));
		teacherInfo.setCollege(clazzMapper.selectCollegeById2(collegeId).getCollege());
		teacherInfoMapper.insertTeacherInfo(teacherInfo);

		model.addAttribute("facultyList", null);
		model.addAttribute("collegeList", clazzMapper.selectAllCollege());
		model.addAttribute("teacher", new TeacherInfo());
		model.addAttribute("college", new College());
		model.addAttribute("teacherInfoList", teacherInfoMapper.searchAllTeacher());
		return "teacherInfoIndex";

	}

	@PostMapping("/fixTheFaculty")
	String fixTheFaculty(Model model, final College college) {

		model.addAttribute("teacherInfoList", teacherInfoMapper.searchAllTeacher());
		model.addAttribute("facultyList", clazzMapper.selectFacultyByParentId(college.getId()));
		model.addAttribute("collegeList", clazzMapper.selectAllCollege());
		model.addAttribute("college", new College());
		model.addAttribute("collegeId", college.getId());
		model.addAttribute("teacher", new TeacherInfo());
		return "teacherInfoIndex";

	}
}
