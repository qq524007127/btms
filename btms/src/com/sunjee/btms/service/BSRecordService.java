package com.sunjee.btms.service;

import com.sunjee.btms.bean.BSRecord;

public interface BSRecordService extends SupportService<BSRecord> {
	/**
	 *	通过福位ID查看此福位是否已被捐赠，如果已捐赠则返回:true,否则返回：false
	 * @param bsr
	 * @return	以捐赠：true；未捐赠：false
	 */
	boolean getIsSelled(java.io.Serializable blessSeatId);
}
