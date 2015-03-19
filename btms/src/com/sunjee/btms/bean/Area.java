package com.sunjee.btms.bean;

import com.sunjee.component.bean.BaseBean;

public class Area extends BaseBean {

	private static final long serialVersionUID = 4479188539719326734L;

	private String areaName;
	private int areaRow;
	private int areaColumn;
	private int shelfRow;
	private int shelfColumn;

	public Area() {
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public int getAreaRow() {
		return areaRow;
	}

	public void setAreaRow(int areaRow) {
		this.areaRow = areaRow;
	}

	public int getAreaColumn() {
		return areaColumn;
	}

	public void setAreaColumn(int areaColumn) {
		this.areaColumn = areaColumn;
	}

	public int getShelfRow() {
		return shelfRow;
	}

	public void setShelfRow(int shelfRow) {
		this.shelfRow = shelfRow;
	}

	public int getShelfColumn() {
		return shelfColumn;
	}

	public void setShelfColumn(int shelfColumn) {
		this.shelfColumn = shelfColumn;
	}

}
