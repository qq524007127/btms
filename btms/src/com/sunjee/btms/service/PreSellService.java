package com.sunjee.btms.service;

import com.sunjee.btms.bean.PreSell;
import com.sunjee.component.bean.User;

public interface PreSellService extends SupportService<PreSell> {

	/**
	 * 会员预售
	 * @param preSell
	 * @param memberId	会员ID
	 * @param	收费员
	 * @return
	 */
	public PreSell addByMember(PreSell preSell, String memberId, User user);
	/**
	 * 企业预售
	 * @param preSell
	 * @param enterpriseId	企业ID
	 * @param	收费员
	 * @return
	 */
	public PreSell addByEnterprise(PreSell preSell, String enterpriseId, User user);
	
	/**
	 * 批量更新预售纪录的有效性
	 * @param ids
	 * @param permit
	 */
	public void updatePermit(String ids[], boolean permit);
	/**
	 * 批量删除订单
	 * @param ids
	 */
	public void deleteByIds(String[] ids);
}
