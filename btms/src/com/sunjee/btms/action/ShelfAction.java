package com.sunjee.btms.action;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ModelDriven;
import com.sunjee.btms.bean.Shelf;
import com.sunjee.btms.common.DataGird;
import com.sunjee.btms.common.Pager;
import com.sunjee.btms.common.SortType;
import com.sunjee.btms.exception.AppRuntimeException;
import com.sunjee.btms.service.ShelfService;

@Controller("shelfAction")
@Scope("prototype")
public class ShelfAction extends BaseAction implements ModelDriven<Shelf> {

	private static final long serialVersionUID = 1421404850588374579L;

	private ShelfService shelfService;

	private Shelf shelf;
	private DataGird<Shelf> shelfGrid;

	public ShelfService getShelfService() {
		return shelfService;
	}

	@Resource(name = "shelfService")
	public void setShelfService(ShelfService shelfService) {
		this.shelfService = shelfService;
	}

	public Shelf getShelf() {
		return shelf;
	}

	public void setShelf(Shelf shelf) {
		this.shelf = shelf;
	}

	public DataGird<Shelf> getShelfGrid() {
		return shelfGrid;
	}

	public void setShelfGrid(DataGird<Shelf> shelfGrid) {
		this.shelfGrid = shelfGrid;
	}

	@Override
	public String execute() throws Exception {
		return super.execute();
	}

	public String grid() throws Exception {
		Map<String, SortType> sortParams = new HashMap<>();
		sortParams.put("shelfCode", SortType.asc);
		this.shelfGrid = this.shelfService.getShelfGrid(new Pager(page, rows),null, sortParams);
		return SUCCESS;
	}
	
	public String add() throws Exception {
		shelf.createShelfCode();
		this.shelfService.addShelf(shelf);
		doSuccess();
		return SUCCESS;
	}
	
	public String edit() throws Exception {
		shelf.createShelfCode();
		this.shelfService.updateShelf(shelf);
		doSuccess();
		return SUCCESS;
	}

	@Override
	public Shelf getModel() {
		if (this.shelf == null) {
			shelf = new Shelf();
		}
		return shelf;
	}

}
