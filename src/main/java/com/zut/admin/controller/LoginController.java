package com.zut.admin.controller;

import com.zut.admin.entity.Classes;
import com.zut.admin.entity.PassWord;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

	BCryptPasswordEncoder endEncoder = new BCryptPasswordEncoder();

	@GetMapping("/login")
	String returnLogin(Model model) {
		model.addAttribute("passWordInfo", new PassWord());
		return "login";
	}

	@PostMapping("/login/confirm")
	String loginInfoConfirm( PassWord loginInfo, Model model) {
		PassWord p1 = new PassWord();
		if ((endEncoder.matches(loginInfo.getPassWord(),
				(p1.getPassWord())) == false)) {
			return "passWordError";
		}

		model.addAttribute("classInfo", new Classes());
		return "adminIndex";
	}

}
