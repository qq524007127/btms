package com.sunjee.btms.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sunjee.btms.bean.MemberCard;
import com.sunjee.btms.common.DataGrid;
import com.sunjee.btms.common.Pager;
import com.sunjee.btms.common.SortType;
import com.sunjee.btms.dao.MemberCardDao;
import com.sunjee.btms.exception.AppRuntimeException;
import com.sunjee.btms.service.MemberCardService;

@Service("memberCardService")
public class MemberCardServiceImpl implements MemberCardService {
	
	private MemberCardDao memberCardDao;
	
	
	public MemberCardDao getMemberCardDao() {
		return memberCardDao;
	}

	@Resource(name="memberCardDao")
	public void setMemberCardDao(MemberCardDao memberCardDao) {
		this.memberCardDao = memberCardDao;
	}

	@Override
	public DataGrid<MemberCard> getDataGrid(Pager page,
			Map<String, Object> whereParams, Map<String, SortType> sortParams) {
		return this.memberCardDao.getDataGrid(page, whereParams, sortParams);
	}

	@Override
	public MemberCard add(MemberCard t) {
		String maxCardCode = this.memberCardDao.getMaxCardCode();
		createCardCode(maxCardCode);
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("cardCode", maxCardCode);
		List<MemberCard> list = this.memberCardDao.getEntitys(null, param, null);
		while(list != null && list.size() > 0){
			maxCardCode = this.memberCardDao.getMaxCardCode();
			createCardCode(maxCardCode);
			param.put("cardCode", maxCardCode);
			list = this.memberCardDao.getEntitys(null, param, null);
		}
		t.setCardCode(maxCardCode);
		return this.memberCardDao.saveEntity(t);
	}

	@Override
	public void update(MemberCard t) {
		this.memberCardDao.updateEntity(t);
	}

	@Override
	public List<MemberCard> getAllByParams(Pager page,
			Map<String, Object> whereParams, Map<String, SortType> sortParams) {
		return this.memberCardDao.getEntitys(page, whereParams, sortParams);
	}

	@Override
	public MemberCard getById(String id) {
		return this.memberCardDao.getEntityById(id);
	}

	@Override
	public void delete(MemberCard t) {
		this.memberCardDao.deletEntity(t);
	}
	
	/**
	 * 增加会员证编号
	 * @param cardCode
	 */
	private void createCardCode(String cardCode){
		try {
			int index = Integer.parseInt(cardCode) + 1;
			cardCode = String.valueOf(index);
			while(cardCode.length() < 6){
				cardCode = "0" + cardCode;
			}
		} catch (Exception e) {
			throw new AppRuntimeException("会员证编号只能为数字");
		}
	}
	
}
