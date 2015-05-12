package com.sunjee.btms.action;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ModelDriven;
import com.sunjee.btms.bean.PreSell;
import com.sunjee.btms.common.SortType;
import com.sunjee.btms.service.PreSellService;

@Controller("presellAction")
@Scope("prototype")
public class PreSellAction extends BaseAction<PreSell> implements
		ModelDriven<PreSell> {

	private static final long serialVersionUID = 7261796923756396859L;

	private PreSellService preSellService;

	private PreSell preSell;
	private String memberId;
	private String enterpriseId;
	private String psIds;
	private String bsIds[];

	public PreSell getPreSell() {
		return preSell;
	}

	public PreSellService getPreSellService() {
		return preSellService;
	}

	@Resource(name = "preSellService")
	public void setPreSellService(PreSellService preSellService) {
		this.preSellService = preSellService;
	}

	public void setPreSell(PreSell preSell) {
		this.preSell = preSell;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getEnterpriseId() {
		return enterpriseId;
	}

	public void setEnterpriseId(String enterpriseId) {
		this.enterpriseId = enterpriseId;
	}

	public String getPsIds() {
		return psIds;
	}

	public void setPsIds(String psIds) {
		this.psIds = psIds;
	}

	public String[] getBsIds() {
		return bsIds;
	}

	public void setBsIds(String[] bsIds) {
		this.bsIds = bsIds;
	}

	@Override
	public String execute() throws Exception {
		return success();
	}

	public String addByMember() throws Exception {
		this.preSellService.addByMember(preSell, memberId, getCurrentUser());
		return success(preSell.getpRecord());
	}

	public String addByEnterprise() throws Exception {
		preSell = this.preSellService.addByEnterprise(preSell, enterpriseId,
				getCurrentUser());
		return success(preSell.getpRecord());
	}

	public String grid() throws Exception {
		Map<String, Object> whereParams = getWhereParams();
		if(!whereParams.containsKey("permit")){
			whereParams.put("permit", true);
		}
		Map<String, SortType> sortParams = getSortParams("cash");
		setDataGrid(this.preSellService.getDataGrid(getPager(), whereParams,sortParams));
		return success();
	}

	/**
	 * 将预定批量设置为无效
	 * @return
	 */
	public String disable(){
		if(!StringUtils.isEmpty(psIds)){
			String ids[] = psIds.split(",");
			this.preSellService.updatePermit(ids, false);
		}
		return success();
	}
	
	/**
	 * 取消预定
	 * @return
	 */
	public String cancel(){
		if(!StringUtils.isEmpty(psIds)){
			String ids[] = psIds.split(",");
			this.preSellService.deleteByIds(ids);
		}
		return success();
	}
	
	public String presellCash(){
		if(bsIds != null){
			this.preSellService.executeCash(preSell.getPsId(),bsIds,getCurrentUser());
		}
		return success();
	}
	
	@Override
	public PreSell getModel() {
		if (this.preSell == null) {
			this.preSell = new PreSell();
		}
		return this.preSell;
	}
}
