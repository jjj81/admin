
package com.zut.admin.mapper;

import org.apache.ibatis.annotations.*;
import java.util.*;

import com.zut.admin.entity.UrlAndPowerInfo;

@Mapper
public interface UrlAndPowerInfoMapper {

	@Select("select * from webSiteUrlAndPower")
	List<UrlAndPowerInfo> selectAll();

	@Select("select * from webSiteUrlAndPower where webSiteUrl=#{url}")
	UrlAndPowerInfo selectByUrl(String url);

	@Insert("insert into webSiteUrlAndPower(webSiteUrl,urlPower) values(#{webSiteUrl},#{urlPower})")
	void insertInfo(UrlAndPowerInfo urlAndPowerInfo);

	@Delete("delete from webSiteUrlAndPower where webSiteUrl=#{webSiteUrl}")
	void delelteInfo(String webSiteUrl);

	@Update("update webSiteUrlAndPower set urlPower=#{power} where webSiteUrl=#{url}")
	int updatePowerByUrl(Float power, String url);

}
