package com.chao.crm.staff.service.impl;

import com.chao.crm.staff.dao.StaffDao;
import com.chao.crm.staff.domain.CrmStaff;
import com.chao.crm.staff.service.StaffService;
import com.chao.crm.utils.MyStringUtils;

public class StaffServiceImpl implements StaffService {
	private StaffDao staffDao;
	
	public void setStaffDao(StaffDao staffDao) {
		this.staffDao = staffDao;
	}
	
	@Override
	public CrmStaff login(CrmStaff staff) {
		// MD5���� ����
		String logginPwd = MyStringUtils.getMD5Value(staff.getLoginPwd());
		return staffDao.find(staff.getLoginName(), logginPwd);
	}

}
