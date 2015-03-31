package com.sunjee.btms.dao.impl;

import java.util.HashMap;
import java.util.List;





import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.sunjee.btms.bean.BSRecord;
import com.sunjee.btms.bean.Enterprise;
import com.sunjee.btms.bean.Member;
import com.sunjee.btms.dao.BSRecordDao;

@Repository("bsRecordDao")
public class BSRecordDaoImpl extends SupportDaoImpl<BSRecord> implements BSRecordDao {

	private static final long serialVersionUID = -2487281350094630378L;

	@SuppressWarnings("unchecked")
	@Override
	public List<BSRecord> getUnPayedRSRecodes(String memberId) {
		String hql = "from BSRecord where mem.memberId = :memberId and payed = false order by donatType";
		Query query = createQuery(null, hql, null);
		query.setParameter("memberId", memberId);
		List<BSRecord> brsList =  query.list();
		for(BSRecord bsr : brsList){
			bsr.setBsRecUser(null);
			bsr.setEnterprise(null);
			bsr.setMem(null);
			bsr.setPayRecord(null);
		}
		return brsList;
	}

	@Override
	public int deleteUnPayedByMember(String id, Member member) {
		String hql = "delete BSRecord where bsRecId = :id and mem.memberId = :memberId and payed = false";
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		param.put("memberId", member.getMemberId());
		return createQuery(null,hql,param).executeUpdate();
	}

	@Override
	public void saveOrUpdate(BSRecord t) {
		getSession().saveOrUpdate(t);
	}

	@Override
	public int deleteUnPayedByEnterprise(String id, Enterprise enterprise) {
		String hql = "delete BSRecord where bsRecId = :id and enterprise.enterId = :enterId and payed = false";
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		param.put("enterId", enterprise.getEnterId());
		return createQuery(null,hql,param).executeUpdate();
	}

}
