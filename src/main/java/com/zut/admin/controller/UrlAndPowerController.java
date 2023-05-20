package com.zut.admin.controller;

import com.zut.admin.entity.UrlAndPowerInfo;
import com.zut.admin.mapper.UrlAndPowerInfoMapper;
import com.zut.admin.service.UrlAndPowerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/urlAndPowerInfo")
public class UrlAndPowerController {

	@Autowired
	private UrlAndPowerInfoMapper urlAndPowerInfoMapper;

	@Autowired
	private UrlAndPowerService urlAndPowerService;

	@GetMapping("/index")
	String getIndex(Model model) {
		if (urlAndPowerService.judgeSumOfPower() == 0) {
			model.addAttribute("sumIsOk", "所有网站的权值之和为1------------OK");
			model.addAttribute("urlList", urlAndPowerInfoMapper.selectAll());
			model.addAttribute("urlAndPower", new UrlAndPowerInfo());
			return "urlAndPowerIndex";
		} else {
			model.addAttribute("sumIsError", "所有网站的权值之和不为1,请调整各个网站的权值!!!");
			model.addAttribute("urlList", urlAndPowerInfoMapper.selectAll());
			model.addAttribute("urlAndPower", new UrlAndPowerInfo());
			return "urlAndPowerIndex";
		}
	}

	@PostMapping("/insert")
	String insertInfo(Model model, final UrlAndPowerInfo urlAndPowerInfo) {
		if (urlAndPowerInfoMapper.selectByUrl(urlAndPowerInfo.getWebSiteUrl()) != null) {
			model.addAttribute("writeError", "请不要输入重复的网站名!!!");
			if (urlAndPowerService.judgeSumOfPower() == 0) {
				model.addAttribute("sumIsOk", "所有网站的权值之和为1------------OK");
				model.addAttribute("urlList", urlAndPowerInfoMapper.selectAll());
				model.addAttribute("urlAndPower", new UrlAndPowerInfo());
				return "urlAndPowerIndex";
			} else {
				model.addAttribute("sumIsError", "所有网站的权值之和不为1,请调整各个网站的权值!!!");
				model.addAttribute("urlList", urlAndPowerInfoMapper.selectAll());
				model.addAttribute("urlAndPower", new UrlAndPowerInfo());
				return "urlAndPowerIndex";
			}

		}
		urlAndPowerInfoMapper.insertInfo(urlAndPowerInfo);
		if (urlAndPowerService.judgeSumOfPower() == 0) {
			model.addAttribute("sumIsOk", "所有网站的权值之和为1------------OK");
			model.addAttribute("urlList", urlAndPowerInfoMapper.selectAll());
			model.addAttribute("urlAndPower", new UrlAndPowerInfo());
			return "urlAndPowerIndex";
		} else {
			model.addAttribute("sumIsError", "所有网站的权值之和不为1,请调整各个网站的权值!!!");
			model.addAttribute("urlList", urlAndPowerInfoMapper.selectAll());
			model.addAttribute("urlAndPower", new UrlAndPowerInfo());
			return "urlAndPowerIndex";
		}
	}

	@GetMapping("/delete/{webSiteUrl}")
	String delete(Model model, @PathVariable("webSiteUrl") String webSiteUrl) {

		urlAndPowerInfoMapper.delelteInfo(webSiteUrl);
		if (urlAndPowerService.judgeSumOfPower() == 0) {
			model.addAttribute("sumIsOk", "所有网站的权值之和为1------------OK");
			model.addAttribute("urlList", urlAndPowerInfoMapper.selectAll());
			model.addAttribute("urlAndPower", new UrlAndPowerInfo());
			return "urlAndPowerIndex";
		} else {
			model.addAttribute("sumIsError", "所有网站的权值之和不为1,请调整各个网站的权值!!!");
			model.addAttribute("urlList", urlAndPowerInfoMapper.selectAll());
			model.addAttribute("urlAndPower", new UrlAndPowerInfo());
			return "urlAndPowerIndex";
		}

	}

	@PostMapping("/updatePower/{url}")
	String updatePower(Model model, @PathVariable("url") String url, final UrlAndPowerInfo urlAndPowerInfo) {

		urlAndPowerInfoMapper.updatePowerByUrl(urlAndPowerInfo.getUrlPower(), url);
		if (urlAndPowerService.judgeSumOfPower() == 0) {
			model.addAttribute("sumIsOk", "所有网站的权值之和为1------------OK");
			model.addAttribute("urlList", urlAndPowerInfoMapper.selectAll());
			model.addAttribute("urlAndPower", new UrlAndPowerInfo());
			return "urlAndPowerIndex";
		} else {
			model.addAttribute("sumIsError", "所有网站的权值之和不为1,请调整各个网站的权值!!!");
			model.addAttribute("urlList", urlAndPowerInfoMapper.selectAll());
			model.addAttribute("urlAndPower", new UrlAndPowerInfo());
			return "urlAndPowerIndex";
		}

	}

}
