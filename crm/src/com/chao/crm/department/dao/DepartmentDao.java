package com.chao.crm.department.dao;

import java.util.List;

import com.chao.crm.department.domain.CrmDepartment;

public interface DepartmentDao {

	/**
	 * ��ѯ���в���
	 * 
	 * @return
	 */
	public List<CrmDepartment> findAll();
}
