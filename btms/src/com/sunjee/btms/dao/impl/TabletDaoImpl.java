package com.sunjee.btms.dao.impl;


import org.springframework.stereotype.Repository;

import com.sunjee.btms.bean.Tablet;
import com.sunjee.btms.dao.TabletDao;

@Repository("tabletDao")
public class TabletDaoImpl extends SupportDaoImpl<Tablet> implements TabletDao {

	private static final long serialVersionUID = 2258411968037497171L;

}
