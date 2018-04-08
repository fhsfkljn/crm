package com.chao.crm.staff.dao;

import com.chao.crm.staff.domain.CrmStaff;

public interface StaffDao {
	/**
	 * 通过用户名和密码查询
	 * @param loginName
	 * @param loginPwd
	 * @return
	 */
	public CrmStaff find(String loginName ,String loginPwd);

}
