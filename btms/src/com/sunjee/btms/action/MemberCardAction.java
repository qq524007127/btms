package com.sunjee.btms.action;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ModelDriven;
import com.sunjee.btms.bean.MemberCard;
import com.sunjee.btms.common.SortType;
import com.sunjee.btms.service.MemberCardService;

@Controller("memberCardAction")
@Scope("prototype")
public class MemberCardAction extends BaseAction<MemberCard> implements
		ModelDriven<MemberCard> {

	private static final long serialVersionUID = -6494127007303550746L;

	private MemberCardService memberCardService;
	
	private MemberCard memberCard;
	
	public MemberCardService getMemberCardService() {
		return memberCardService;
	}
	
	@Resource(name="memberCardService")
	public void setMemberCardService(MemberCardService memberCardService) {
		this.memberCardService = memberCardService;
	}

	public MemberCard getMemberCard() {
		return memberCard;
	}

	public void setMemberCard(MemberCard memberCard) {
		this.memberCard = memberCard;
	}

	public String grid(){
		Map<String, Object> whereParams = getWhereParams();
		
		Map<String, SortType> sortParams = getSortParams();
		if(!sortParams.containsKey("permit")){
			sortParams.put("permit", SortType.desc);
		}
		setDataGrid(this.memberCardService.getDataGrid(getPager(), whereParams, sortParams));
		return success();
	}
	
	@Override
	public MemberCard getModel() {
		return null;
	}

}
