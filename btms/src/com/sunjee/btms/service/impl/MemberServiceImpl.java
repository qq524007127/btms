package com.sunjee.btms.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sunjee.btms.bean.Member;
import com.sunjee.btms.common.DataGrid;
import com.sunjee.btms.common.Pager;
import com.sunjee.btms.common.SortType;
import com.sunjee.btms.dao.MemberDao;
import com.sunjee.btms.service.MemberService;

@Service("memberService")
public class MemberServiceImpl implements MemberService {
	private MemberDao memberDao;

	public MemberDao getMemberDao() {
		return memberDao;
	}

	@Resource(name = "memberDao")
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	@Override
	public DataGrid<Member> getDataGrid(Pager page,
			Map<String, Object> whereParams, Map<String, SortType> sortParams) {
		return this.memberDao.getDataGrid(page, whereParams, sortParams);
	}

	@Override
	public Member add(Member t) {
		return this.memberDao.saveEntity(t);
	}

	@Override
	public void update(Member t) {
		this.memberDao.updateEntity(t);
	}

	@Override
	public List<Member> getAllByParams(Pager page,
			Map<String, Object> whereParams, Map<String, SortType> sortParams) {
		return this.memberDao.getEntitys(page, whereParams, sortParams);
	}

	@Override
	public Member getById(String id) {
		return this.memberDao.getEntityById(id);
	}

	@Override
	public void delete(Member t) {
		this.memberDao.deletEntity(t);
	}

}
