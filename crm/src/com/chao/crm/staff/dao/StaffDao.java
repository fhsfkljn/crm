package com.chao.crm.staff.dao;

import java.util.List;

import com.chao.crm.staff.domain.CrmStaff;

public interface StaffDao {
	/**
	 * 通过用户名和密码查询
	 * @param loginName
	 * @param loginPwd
	 * @return
	 */
	public CrmStaff find(String loginName ,String loginPwd);

	/**
	 * 查询所有
	 * @return
	 */
	public List<CrmStaff> findAll();
	
	/**
	 * 通过id查询
	 * @param staffId
	 * @return
	 */
	public CrmStaff findById(String staffId);
}
