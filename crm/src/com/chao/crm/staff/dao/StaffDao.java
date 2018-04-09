package com.chao.crm.staff.dao;

import java.util.List;

import com.chao.crm.staff.domain.CrmStaff;

public interface StaffDao {
	/**
	 * ͨ���û����������ѯ
	 * @param loginName
	 * @param loginPwd
	 * @return
	 */
	public CrmStaff find(String loginName ,String loginPwd);

	/**
	 * ��ѯ����
	 * @return
	 */
	public List<CrmStaff> findAll();
	
	/**
	 * ͨ��id��ѯ
	 * @param staffId
	 * @return
	 */
	public CrmStaff findById(String staffId);
}
