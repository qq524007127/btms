package com.sunjee.btms.service;

import com.sunjee.btms.bean.Area;

public interface AreaService extends SupportService<Area> {
	/**
	 * 初始化一个区域，初始化时添加一个区域同时添加当前区域的福位架和福位
	 * @param area
	 */
	void initArea(Area area);
}
