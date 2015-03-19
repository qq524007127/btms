package com.sunjee.btms.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ModelDriven;
import com.sunjee.btms.bean.Level;
import com.sunjee.btms.common.DataGrid;
import com.sunjee.btms.common.Pager;
import com.sunjee.btms.service.LevelServcie;

@Controller("levelAction")
@Scope("prototype")
public class LevelAction extends BaseAction implements ModelDriven<Level> {

	private static final long serialVersionUID = -7922273402647103059L;

	private LevelServcie levelService;

	private Level level;
	private DataGrid<Level> levelGrid;

	public LevelServcie getLevelService() {
		return levelService;
	}

	@Resource(name = "levelService")
	public void setLevelService(LevelServcie levelService) {
		this.levelService = levelService;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	public DataGrid<Level> getLevelGrid() {
		return levelGrid;
	}

	public void setLevelGrid(DataGrid<Level> levelGrid) {
		this.levelGrid = levelGrid;
	}

	@Override
	public String execute() throws Exception {
		return super.execute();
	}

	public String grid() throws Exception {
		this.levelGrid = this.levelService.getLevelGrid(new Pager(page, rows), null, getSortParams());
		return success();
	}
	
	public String add() throws Exception {
		this.levelService.addLevel(level);
		return success();
	}
	
	public String edit() throws Exception {
		this.levelService.updateLevel(level);
		return success();
	}

	@Override
	public Level getModel() {
		if (this.level == null) {
			this.level = new Level();
		}
		return this.level;
	}

}
