package com.zut.admin.service;


import com.zut.admin.entity.UrlAndPowerInfo;
import com.zut.admin.mapper.UrlAndPowerInfoMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UrlAndPowerService {

	@Autowired
	private UrlAndPowerInfoMapper urlAndPowerInfoMapper;

	public int judgeSumOfPower() {

		float sum = 0;

		for (UrlAndPowerInfo up : urlAndPowerInfoMapper.selectAll()) {
			sum += up.getUrlPower();
		}
		if (sum == 1)
			return 0;
		else
			return 1;
	}
}
