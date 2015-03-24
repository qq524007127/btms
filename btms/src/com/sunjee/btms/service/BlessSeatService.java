package com.sunjee.btms.service;

import com.sunjee.btms.bean.BlessSeat;
import com.sunjee.btms.bean.Level;

public interface BlessSeatService extends SupportService<BlessSeat> {
	void addBlessSeat(BlessSeat bs);

	int updateBlessSeatLeve(String bsIds[], Level level);

	void updatePermitByShelfId(String shelfId, boolean b);
}
