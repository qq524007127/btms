package com.sunjee.btms.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;
import com.sunjee.btms.bean.Area;
import com.sunjee.btms.bean.BlessSeat;
import com.sunjee.btms.bean.Level;
import com.sunjee.btms.common.DataGrid;
import com.sunjee.btms.common.SortType;
import com.sunjee.btms.service.BlessSeatService;
import com.sunjee.btms.service.ShelfService;

@Controller("blessSeatAction")
@Scope("prototype")
public class BlessSeatAction extends BaseAction implements
		ModelDriven<BlessSeat> {

	private static final long serialVersionUID = 3053794916587390844L;

	private BlessSeatService blessSeatService;
	private ShelfService shelfService;

	private BlessSeat blessSeat;
	private DataGrid<BlessSeat> blessSeatGrid;
	private List<Area> areaList;
	
	private String ids;
	private String levelId;

	public BlessSeatService getBlessSeatService() {
		return blessSeatService;
	}

	@Resource(name = "blessSeatService")
	public void setBlessSeatService(BlessSeatService blessSeatService) {
		this.blessSeatService = blessSeatService;
	}

	public ShelfService getShelfService() {
		return shelfService;
	}

	@Resource(name = "shelfService")
	public void setShelfService(ShelfService shelfService) {
		this.shelfService = shelfService;
	}

	public BlessSeat getBlessSeat() {
		return blessSeat;
	}

	public void setBlessSeat(BlessSeat blessSeat) {
		this.blessSeat = blessSeat;
	}

	public DataGrid<BlessSeat> getBlessSeatGrid() {
		return blessSeatGrid;
	}

	public void setBlessSeatGrid(DataGrid<BlessSeat> blessSeatGrid) {
		this.blessSeatGrid = blessSeatGrid;
	}

	public List<Area> getAreaList() {
		return areaList;
	}

	public void setAreaList(List<Area> areaList) {
		this.areaList = areaList;
	}
	

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public String getLevelId() {
		return levelId;
	}

	public void setLevelId(String levelId) {
		this.levelId = levelId;
	}

	@Override
	public String execute() throws Exception {
		return super.execute();
	}

	public String grid() {
		Map<String, Object> whereParams = new HashMap<String, Object>();
		whereParams.put("permit", true);
		ValueStack vs = ActionContext.getContext().getValueStack();
		System.out.println(vs);
		//System.out.println(queryParams.getClass().getName());
		if(!StringUtils.isEmpty(this.searchKey)){
			whereParams.put("bsCode", searchKey);
		}
		Map<String, SortType> sortParams = getSortParams();
		this.blessSeatGrid = this.blessSeatService.getBlessSeatGrid(getPager(), whereParams, sortParams);
		return SUCCESS;
	}
	
	/**
	 * 设置福位的级别
	 * @return
	 * @throws Exception
	 */
	public String updateBSLevel() throws Exception {
		if(!StringUtils.isEmpty(ids) && !StringUtils.isEmpty(levelId)){
			String bsIds[] = ids.split(",");
			Level level = new Level(levelId);
			this.blessSeatService.updateBlessSeatLeve(bsIds, level);
		}
		return success();
	}

	public String getAreas() throws Exception {
		this.areaList = shelfService.getAreaList();
		return success();
	}

	@Override
	public BlessSeat getModel() {
		if (blessSeat == null) {
			blessSeat = new BlessSeat();
		}
		return null;
	}

}
